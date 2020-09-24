package com.emilgelman.housetrack.housetrack.services.yad2;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@JsonDeserialize(using = Yad2Response.Deserializer.class)
@RequiredArgsConstructor
public class Yad2Response {
    @Getter
    private final List<FeedItem> items;

    @Getter
    @Builder
    public static class FeedItem {
        private String id;
        private Long price;
        private String city;
        private String neighborhood;
        private String street;

    }

    protected static class Deserializer extends StdDeserializer<Yad2Response> {

        public Deserializer() {
            this(null);
        }

        public Deserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Yad2Response deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            JsonNode jsonNode = node.get("feed").get("feed_items");

            List<FeedItem> feedItems = StreamSupport.stream(jsonNode.spliterator(), false)
                    .filter(x -> x.get("type").asText().equals("ad"))
                    .map(this::createFeedItem)
                    .collect(Collectors.toList());
            return new Yad2Response(feedItems);
        }

        private FeedItem createFeedItem(JsonNode x) {
            return FeedItem.builder()
                    .id(x.get("id").asText())
                    .city(x.get("city").asText())
                    .neighborhood(x.get("neighborhood").asText())
                    .street(x.get("street").asText())
                    .price(Long.valueOf(x.get("price").asText().replaceAll("[^\\d.]","")))
                    .build();
        }
    }
}
