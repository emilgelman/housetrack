package com.emilgelman.housetrack.housetrack.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Data
@Builder
public class House {
    @Id
    private String id;
    private Long price;
    private String city;
    private String neighborhood;
    private String street;
    private Long rooms;
    private SellerType sellerType;

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof House))
        {
            return false;
        }
        return this.id.equals(((House) other).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
