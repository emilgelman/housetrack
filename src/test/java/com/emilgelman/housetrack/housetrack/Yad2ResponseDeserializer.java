package com.emilgelman.housetrack.housetrack;

import com.emilgelman.housetrack.housetrack.services.yad2.Yad2Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class Yad2ResponseDeserializer extends AbstractIntegTestBase {

	@Test
	void deserialize() throws Exception{
		String data = "{\n" +
				"    \"feed\": {\n" +
				"        \"cat_id\": 2,\n" +
				"        \"subcat_id\": 1,\n" +
				"        \"title_text\": \"דירות למכירה  בסביוני הכרמל, חיפה | נדל\\\"ן יד2\",\n" +
				"        \"sort_values\": [\n" +
				"            {\n" +
				"                \"title\": \"לפי תאריך\",\n" +
				"                \"value\": 1,\n" +
				"                \"selected\": 1\n" +
				"            },\n" +
				"            {\n" +
				"                \"title\": \"מחיר - מהזול ליקר\",\n" +
				"                \"value\": 3,\n" +
				"                \"selected\": 0\n" +
				"            },\n" +
				"            {\n" +
				"                \"title\": \"מחיר - מהיקר לזול\",\n" +
				"                \"value\": 4,\n" +
				"                \"selected\": 0\n" +
				"            }\n" +
				"        ],\n" +
				"        \"feed_items\": [\n" +
				"            {\n" +
				"                \"type\": \"title\",\n" +
				"                \"title\": \"דירות למכירה\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"order_type_id\": 1,\n" +
				"                \"background_color\": \"f0f0f0\",\n" +
				"                \"coordinates\": {\n" +
				"                    \"latitude\": \"32.766007\",\n" +
				"                    \"longitude\": \"35.012868\"\n" +
				"                },\n" +
				"                \"row_1\": \"שדרות אבא חושי 143\",\n" +
				"                \"title_1\": \"שדרות אבא חושי 143\",\n" +
				"                \"title_2\": \"דירה\",\n" +
				"                \"row_2\": \"דירה, סביוני הכרמל, חיפה\",\n" +
				"                \"row_3\": [\n" +
				"                    \"3 חדרים\",\n" +
				"                    \"103 מ\\\"ר\",\n" +
				"                    \"2\"\n" +
				"                ],\n" +
				"                \"row_4\": [\n" +
				"                    {\n" +
				"                        \"key\": \"rooms\",\n" +
				"                        \"label\": \"חדרים\",\n" +
				"                        \"value\": 3\n" +
				"                    },\n" +
				"                    {\n" +
				"                        \"key\": \"floor\",\n" +
				"                        \"label\": \"קומה\",\n" +
				"                        \"value\": 2\n" +
				"                    },\n" +
				"                    {\n" +
				"                        \"key\": \"SquareMeter\",\n" +
				"                        \"label\": \"מ\\\"ר\",\n" +
				"                        \"value\": \"103 \"\n" +
				"                    }\n" +
				"                ],\n" +
				"                \"line_1\": \"3 חדרים\",\n" +
				"                \"line_2\": \"2\",\n" +
				"                \"external\": [],\n" +
				"                \"promotional_ad\": 0,\n" +
				"                \"ad_type\": \"ad\",\n" +
				"                \"type\": \"ad\",\n" +
				"                \"can_hide\": 0,\n" +
				"                \"is_hidden\": 0,\n" +
				"                \"img_url\": \"//img.yad2.co.il/Pic/202006/05/2_1/o/y2_1_06069_20200605120659.jpeg\",\n" +
				"                \"images\": {\n" +
				"                    \"Image1\": {\n" +
				"                        \"src\": \"https://img.yad2.co.il/Pic/202006/05/2_1/o/y2_1_06069_20200605120659.jpeg\"\n" +
				"                    },\n" +
				"                    \"Image2\": {\n" +
				"                        \"src\": \"https://img.yad2.co.il/Pic/202006/05/2_1/o/y2_2_01050_20200605120655.jpeg\"\n" +
				"                    },\n" +
				"                    \"Image3\": {\n" +
				"                        \"src\": \"https://img.yad2.co.il/Pic/202006/05/2_1/o/o2_1_3_02202_20200605130641.jpg\"\n" +
				"                    },\n" +
				"                    \"Image4\": {\n" +
				"                        \"src\": \"https://img.yad2.co.il/Pic/202006/05/2_1/o/y2_4_06640_20200605120606.jpeg\"\n" +
				"                    },\n" +
				"                    \"Image5\": {\n" +
				"                        \"src\": \"https://img.yad2.co.il/Pic/202006/05/2_1/o/y2_5_04036_20200605120602.jpeg\"\n" +
				"                    }\n" +
				"                },\n" +
				"                \"images_count\": 5,\n" +
				"                \"merchant\": false,\n" +
				"                \"link_token\": \"dmg68h\",\n" +
				"                \"ad_highlight_type\": \"none\",\n" +
				"                \"highlight_text\": \"\",\n" +
				"                \"is_liked\": 0,\n" +
				"                \"like_count\": 0,\n" +
				"                \"line_1_text_color\": \"\",\n" +
				"                \"line_2_text_color\": \"808080\",\n" +
				"                \"can_change_layout\": 1,\n" +
				"                \"default_layout\": \"system\",\n" +
				"                \"remove_on_unlike\": false,\n" +
				"                \"video_url\": null,\n" +
				"                \"mp4_video_url\": null,\n" +
				"                \"updated_at\": \"עודכן ב 23/09/2020\",\n" +
				"                \"price\": \"1,800,000 ₪\",\n" +
				"                \"currency\": \"₪\",\n" +
				"                \"uid\": \"GI3nayeBzCe66MOUwuvPhw==\",\n" +
				"                \"city_code\": \"4000\",\n" +
				"                \"street\": \"שדרות אבא חושי\",\n" +
				"                \"id\": \"dmg68h\",\n" +
				"                \"Immediate_text\": \"מיידי\",\n" +
				"                \"city\": \"חיפה\",\n" +
				"                \"date_added\": \"2020-06-05 12:02:19\",\n" +
				"                \"AirConditioner_text\": \"מיזוג\",\n" +
				"                \"customer_id\": 2543224,\n" +
				"                \"mamad_text\": \"ממ\\\"ד\",\n" +
				"                \"Furniture_text\": \"ריהוט\",\n" +
				"                \"Tadiran_text\": \"\",\n" +
				"                \"topAreaID_text\": \"צפון\",\n" +
				"                \"sunpatio_text\": \"\",\n" +
				"                \"address_home_number\": \"143\",\n" +
				"                \"Amudim_text\": \"\",\n" +
				"                \"subcat_id\": \"1\",\n" +
				"                \"storeroom_text\": \"מחסן\",\n" +
				"                \"handicapped_text\": \"גישה לנכים\",\n" +
				"                \"record_id\": 1928361,\n" +
				"                \"show_home_text\": \"הצג מספר בית\",\n" +
				"                \"Parking_text\": \"חניה\",\n" +
				"                \"currency_text\": \"₪\",\n" +
				"                \"Grating_text\": \"\",\n" +
				"                \"cat_id\": \"2\",\n" +
				"                \"date\": \"2020-09-23 09:56:41\",\n" +
				"                \"show_street_text\": \"הצג רחוב\",\n" +
				"                \"Elevator_text\": \"מעלית\",\n" +
				"                \"neighborhood\": \"סביוני הכרמל\",\n" +
				"                \"HomeTypeID_text\": \"דירה\",\n" +
				"                \"yehidatdiur_text\": \"\",\n" +
				"                \"AreaID_text\": \"חיפה והסביבה\",\n" +
				"                \"Rooms_text\": 3,\n" +
				"                \"date_of_entry\": \"2020-07-25 00:00:00\",\n" +
				"                \"patio_text\": \"מרפסת\",\n" +
				"                \"contact_name\": \"תומר\",\n" +
				"                \"AssetClassificationID_text\": \"חדש (גרו בנכס)\",\n" +
				"                \"Meshupatz_text\": \"\",\n" +
				"                \"Porch_text\": \"\",\n" +
				"                \"ad_number\": 64410744,\n" +
				"                \"PandorDoors_text\": \"דלתות פנדור\",\n" +
				"                \"area_id\": 5,\n" +
				"                \"square_meters\": 103,\n" +
				"                \"line_3\": \"103 מ\\\"ר\",\n" +
				"                \"hood_id\": 634\n" +
				"            },\n" +
				"            {\n" +
				"                \"order_type_id\": 1,\n" +
				"                \"background_color\": \"f0f0f0\",\n" +
				"                \"coordinates\": {\n" +
				"                    \"latitude\": \"32.766007\",\n" +
				"                    \"longitude\": \"35.012868\"\n" +
				"                },\n" +
				"                \"row_1\": \"שדרות אבא חושי 143\",\n" +
				"                \"title_1\": \"שדרות אבא חושי 143\",\n" +
				"                \"title_2\": \"דירה\",\n" +
				"                \"row_2\": \"דירה, סביוני הכרמל, חיפה\",\n" +
				"                \"row_3\": [\n" +
				"                    \"3 חדרים\",\n" +
				"                    \"95 מ\\\"ר\",\n" +
				"                    \"2\"\n" +
				"                ],\n" +
				"                \"row_4\": [\n" +
				"                    {\n" +
				"                        \"key\": \"rooms\",\n" +
				"                        \"label\": \"חדרים\",\n" +
				"                        \"value\": 3\n" +
				"                    },\n" +
				"                    {\n" +
				"                        \"key\": \"floor\",\n" +
				"                        \"label\": \"קומה\",\n" +
				"                        \"value\": 2\n" +
				"                    },\n" +
				"                    {\n" +
				"                        \"key\": \"SquareMeter\",\n" +
				"                        \"label\": \"מ\\\"ר\",\n" +
				"                        \"value\": \"95 \"\n" +
				"                    }\n" +
				"                ],\n" +
				"                \"line_1\": \"3 חדרים\",\n" +
				"                \"line_2\": \"2\",\n" +
				"                \"external\": [],\n" +
				"                \"promotional_ad\": 0,\n" +
				"                \"ad_type\": \"ad\",\n" +
				"                \"type\": \"ad\",\n" +
				"                \"can_hide\": 0,\n" +
				"                \"is_hidden\": 0,\n" +
				"                \"img_url\": \"//img.yad2.co.il/Pic/202008/15/2_1/o/y2_1_03678_20200815110809.jpeg\",\n" +
				"                \"images\": {\n" +
				"                    \"Image1\": {\n" +
				"                        \"src\": \"https://img.yad2.co.il/Pic/202008/15/2_1/o/y2_1_03678_20200815110809.jpeg\"\n" +
				"                    },\n" +
				"                    \"Image2\": {\n" +
				"                        \"src\": \"https://img.yad2.co.il/Pic/202008/15/2_1/o/y2_2_01047_20200815110814.jpeg\"\n" +
				"                    },\n" +
				"                    \"Image3\": {\n" +
				"                        \"src\": \"https://img.yad2.co.il/Pic/202008/15/2_1/o/y2_3_01990_20200815110823.jpeg\"\n" +
				"                    },\n" +
				"                    \"Image4\": {\n" +
				"                        \"src\": \"https://img.yad2.co.il/Pic/202008/15/2_1/o/y2_4_09978_20200815110818.jpeg\"\n" +
				"                    },\n" +
				"                    \"Image5\": {\n" +
				"                        \"src\": \"https://img.yad2.co.il/Pic/202008/15/2_1/o/y2_5_07707_20200815110827.jpeg\"\n" +
				"                    }\n" +
				"                },\n" +
				"                \"images_count\": 5,\n" +
				"                \"merchant\": false,\n" +
				"                \"link_token\": \"rrkdqzp0\",\n" +
				"                \"ad_highlight_type\": \"none\",\n" +
				"                \"highlight_text\": \"\",\n" +
				"                \"is_liked\": 0,\n" +
				"                \"like_count\": 0,\n" +
				"                \"line_1_text_color\": \"\",\n" +
				"                \"line_2_text_color\": \"808080\",\n" +
				"                \"can_change_layout\": 1,\n" +
				"                \"default_layout\": \"system\",\n" +
				"                \"remove_on_unlike\": false,\n" +
				"                \"video_url\": null,\n" +
				"                \"mp4_video_url\": null,\n" +
				"                \"updated_at\": \"עודכן ב 23/09/2020\",\n" +
				"                \"price\": \"1,750,000 ₪\",\n" +
				"                \"currency\": \"₪\",\n" +
				"                \"uid\": \"xheT9GwNlbrOVsu+2jAdxA+3bDOpALGjv4borj7xPok=\",\n" +
				"                \"city_code\": \"4000\",\n" +
				"                \"street\": \"שדרות אבא חושי\",\n" +
				"                \"id\": \"rrkdqzp0\",\n" +
				"                \"Immediate_text\": \"מיידי\",\n" +
				"                \"city\": \"חיפה\",\n" +
				"                \"date_added\": \"2020-08-15 11:25:45\",\n" +
				"                \"AirConditioner_text\": \"מיזוג\",\n" +
				"                \"customer_id\": 2543224,\n" +
				"                \"mamad_text\": \"ממ\\\"ד\",\n" +
				"                \"Furniture_text\": \"\",\n" +
				"                \"Tadiran_text\": \"\",\n" +
				"                \"topAreaID_text\": \"צפון\",\n" +
				"                \"sunpatio_text\": \"\",\n" +
				"                \"address_home_number\": \"143\",\n" +
				"                \"Amudim_text\": \"\",\n" +
				"                \"subcat_id\": \"1\",\n" +
				"                \"storeroom_text\": \"מחסן\",\n" +
				"                \"handicapped_text\": \"גישה לנכים\",\n" +
				"                \"record_id\": 1953129,\n" +
				"                \"show_home_text\": \"הצג מספר בית\",\n" +
				"                \"Parking_text\": \"חניה\",\n" +
				"                \"currency_text\": \"₪\",\n" +
				"                \"Grating_text\": \"\",\n" +
				"                \"cat_id\": \"2\",\n" +
				"                \"date\": \"2020-09-23 09:56:23\",\n" +
				"                \"show_street_text\": \"הצג רחוב\",\n" +
				"                \"Elevator_text\": \"מעלית\",\n" +
				"                \"neighborhood\": \"סביוני הכרמל\",\n" +
				"                \"HomeTypeID_text\": \"דירה\",\n" +
				"                \"yehidatdiur_text\": \"\",\n" +
				"                \"AreaID_text\": \"חיפה והסביבה\",\n" +
				"                \"Rooms_text\": 3,\n" +
				"                \"date_of_entry\": \"2020-08-15 00:00:00\",\n" +
				"                \"patio_text\": \"מרפסת\",\n" +
				"                \"contact_name\": \"תומר\",\n" +
				"                \"AssetClassificationID_text\": \"חדש (גרו בנכס)\",\n" +
				"                \"Meshupatz_text\": \"\",\n" +
				"                \"Porch_text\": \"\",\n" +
				"                \"ad_number\": 99481381,\n" +
				"                \"PandorDoors_text\": \"דלתות פנדור\",\n" +
				"                \"area_id\": 5,\n" +
				"                \"square_meters\": 95,\n" +
				"                \"line_3\": \"95 מ\\\"ר\",\n" +
				"                \"hood_id\": 634\n" +
				"            },\n" +
				"            {\n" +
				"                \"type\": \"message\",\n" +
				"                \"text\": \"לא נמצאו תוצאות\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"type\": \"agency_buttons\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"feed_imp\": [\n" +
				"            \"64410744&00101L001\",\n" +
				"            \"99481381&00101L002\"\n" +
				"        ],\n" +
				"        \"current_page\": 1,\n" +
				"        \"page_size\": 40,\n" +
				"        \"total_pages\": 1,\n" +
				"        \"total_items\": 2,\n" +
				"        \"favorites_userid\": \"iba258122583\",\n" +
				"        \"can_filter_results\": true,\n" +
				"        \"search_params\": {\n" +
				"            \"address_auto_complete\": {\n" +
				"                \"city\": \"4000\",\n" +
				"                \"neighborhood\": \"634\"\n" +
				"            },\n" +
				"            \"city\": \"4000\",\n" +
				"            \"city_label\": \"חיפה\",\n" +
				"            \"neighborhood\": \"634\",\n" +
				"            \"neighborhood_label\": \"סביוני הכרמל\",\n" +
				"            \"toRooms\": \"3\",\n" +
				"            \"fromPrice\": \"1400000\",\n" +
				"            \"fromRooms\": \"2\",\n" +
				"            \"toPrice\": \"2000000\"\n" +
				"        },\n" +
				"        \"isCached\": false,\n" +
				"        \"server_number\": 99,\n" +
				"        \"cacheKey\": \"feedItemMemcache_1aeb64f293ef375042438e97a7d1a4ed\",\n" +
				"        \"media\": {\n" +
				"            \"zone\": \"desktop/realestate/sale\",\n" +
				"            \"layout\": \"my15\",\n" +
				"            \"params\": {\n" +
				"                \"CityID\": \"4000\",\n" +
				"                \"yad1City\": \"4000\",\n" +
				"                \"fromRooms\": 2,\n" +
				"                \"untilRooms\": 3,\n" +
				"                \"fromPrice\": 1400000,\n" +
				"                \"untilPrice\": 2000000,\n" +
				"                \"SecondaryAreaID\": 5,\n" +
				"                \"PrimaryAreaID\": 25,\n" +
				"                \"SecondaryArea\": \"haifa\",\n" +
				"                \"PrimaryArea\": \"north\",\n" +
				"                \"searchB144FromYad2\": \"2_C_1734\",\n" +
				"                \"tivuch\": \"no\",\n" +
				"                \"artiMedia_iscroll_group\": \"yad2.iscroll.realestate.north\",\n" +
				"                \"abovePrice\": \"1300000\",\n" +
				"                \"AppType\": \"desktop\",\n" +
				"                \"mainpage\": \"yes\",\n" +
				"                \"measurements\": \"realestate\",\n" +
				"                \"merchant\": \"no\",\n" +
				"                \"catID\": 2,\n" +
				"                \"subCatID\": 1,\n" +
				"                \"current_zone\": \"search_results\",\n" +
				"                \"location\": \"search_results\",\n" +
				"                \"pageType\": \"search_results\",\n" +
				"                \"mainCategoryZones\": {\n" +
				"                    \"1\": \"vehicles\",\n" +
				"                    \"2\": \"realestate\",\n" +
				"                    \"3\": \"second_hand\",\n" +
				"                    \"5\": \"pets\",\n" +
				"                    \"6\": \"studies\",\n" +
				"                    \"10\": \"tourism\",\n" +
				"                    \"11\": \"alternative\",\n" +
				"                    \"12\": \"hospitality\",\n" +
				"                    \"14\": \"maids_and_nannies\",\n" +
				"                    \"15\": \"commercial\"\n" +
				"                },\n" +
				"                \"zonePrefix\": \"desktop/\",\n" +
				"                \"version\": \"guru\",\n" +
				"                \"Cohort\": \"Desktop_32\",\n" +
				"                \"userid\": \"iba258122583\",\n" +
				"                \"isOffice\": 1\n" +
				"            },\n" +
				"            \"artiMedia_iscroll_group\": \"yad2.iscroll.realestate.north\",\n" +
				"            \"locations\": [],\n" +
				"            \"lightboxLocations\": null\n" +
				"        },\n" +
				"        \"footer\": {\n" +
				"            \"links\": [\n" +
				"                \"https://www.yad2.co.il/realestate/rent\",\n" +
				"                \"https://www.yad2.co.il/realestate/forsale\",\n" +
				"                \"http://my.yad2.co.il/newOrder/\",\n" +
				"                \"https://www.yad2.co.il/contactus\",\n" +
				"                \"http://jobs.yad2.co.il/\",\n" +
				"                \"https://www.yad2.co.il//TellAFriend.php\",\n" +
				"                \"https://www.yad2.co.il/Pirsum/index.php\",\n" +
				"                \"https://www.yad2.co.il/eula\",\n" +
				"                \"https://www.yad2.co.il/sitemap\"\n" +
				"            ]\n" +
				"        },\n" +
				"        \"breadCrumbs\": [\n" +
				"            {\n" +
				"                \"title\": \"ראשי\",\n" +
				"                \"link\": \"//www.yad2.co.il\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"title\": \"דירות למכירה\",\n" +
				"                \"link\": \"/realestate/forsale\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"title\": \"חיפה\",\n" +
				"                \"link\": \"/realestate/forsale/flats-in-haifa?city=4000\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"title\": \"סביוני הכרמל\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"associated_links\": [\n" +
				"            {\n" +
				"                \"title_text\": \"דירה למכירה,  בסביוני הכרמל, חיפה\",\n" +
				"                \"url\": \"/realestate/forsale/apartment-savyonei-hakarmel-in-haifa?city=4000&neighborhood=634&rooms=3--1&property=1\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"title_text\": \"דירה למכירה בסביוני הכרמל, חיפה\",\n" +
				"                \"url\": \"/realestate/forsale/apartment-savyonei-hakarmel-in-haifa?city=4000&neighborhood=634&property=1\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"title_text\": \"מכירה בקרית חיים מזרחית, חיפה\",\n" +
				"                \"url\": \"/realestate/forsale/flats-kiryat-haim-east-in-haifa?city=4000&neighborhood=650\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"title_text\": \"מכירה בקרית שמואל, חיפה\",\n" +
				"                \"url\": \"/realestate/forsale/flats-kiryat-shmuel-in-haifa?city=4000&neighborhood=649\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"title_text\": \"מכירה באחוזה, חיפה\",\n" +
				"                \"url\": \"/realestate/forsale/flats-achuza-in-haifa?city=4000&neighborhood=613\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"title_text\": \"מכירה ביל\\\"ג, חיפה\",\n" +
				"                \"url\": \"/realestate/forsale/flats-ylg-in-haifa?city=4000&neighborhood=1685\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"title_text\": \"מכירה בהדר מרכז, חיפה\",\n" +
				"                \"url\": \"/realestate/forsale/flats-hadar-merkaz-in-haifa?city=4000&neighborhood=1671\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"title_text\": \"מכירה בהדר עליון, חיפה\",\n" +
				"                \"url\": \"/realestate/forsale/flats-hadar-elyon-in-haifa?city=4000&neighborhood=1684\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"title_text\": \"מכירה ביזרעאליה, חיפה\",\n" +
				"                \"url\": \"/realestate/forsale/flats-izraelia-in-haifa?city=4000&neighborhood=641\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"aggs\": {\n" +
				"            \"2_1\": {\n" +
				"                \"associated_links\": [\n" +
				"                    {\n" +
				"                        \"text\": {\n" +
				"                            \"CityNeighborhood\": \"חיפה\",\n" +
				"                            \"Neighborhood\": \"סביוני הכרמל\",\n" +
				"                            \"HomeTypeID_text\": \"דירה\",\n" +
				"                            \"Rooms\": 3\n" +
				"                        },\n" +
				"                        \"params\": {\n" +
				"                            \"city\": \"4000\",\n" +
				"                            \"neighborhood\": 634,\n" +
				"                            \"HomeTypeID\": 1,\n" +
				"                            \"rooms\": 3\n" +
				"                        }\n" +
				"                    },\n" +
				"                    {\n" +
				"                        \"text\": {\n" +
				"                            \"CityNeighborhood\": \"חיפה\",\n" +
				"                            \"Neighborhood\": \"סביוני הכרמל\",\n" +
				"                            \"HomeTypeID_text\": \"דירה\"\n" +
				"                        },\n" +
				"                        \"params\": {\n" +
				"                            \"city\": \"4000\",\n" +
				"                            \"neighborhood\": 634,\n" +
				"                            \"HomeTypeID\": 1\n" +
				"                        }\n" +
				"                    },\n" +
				"                    {\n" +
				"                        \"text\": {\n" +
				"                            \"CityNeighborhood\": \"חיפה\",\n" +
				"                            \"Neighborhood\": \"קרית חיים מזרחית\"\n" +
				"                        },\n" +
				"                        \"params\": {\n" +
				"                            \"city\": \"4000\",\n" +
				"                            \"neighborhood\": 650\n" +
				"                        }\n" +
				"                    },\n" +
				"                    {\n" +
				"                        \"text\": {\n" +
				"                            \"CityNeighborhood\": \"חיפה\",\n" +
				"                            \"Neighborhood\": \"קרית שמואל\"\n" +
				"                        },\n" +
				"                        \"params\": {\n" +
				"                            \"city\": \"4000\",\n" +
				"                            \"neighborhood\": 649\n" +
				"                        }\n" +
				"                    },\n" +
				"                    {\n" +
				"                        \"text\": {\n" +
				"                            \"CityNeighborhood\": \"חיפה\",\n" +
				"                            \"Neighborhood\": \"אחוזה\"\n" +
				"                        },\n" +
				"                        \"params\": {\n" +
				"                            \"city\": \"4000\",\n" +
				"                            \"neighborhood\": 613\n" +
				"                        }\n" +
				"                    },\n" +
				"                    {\n" +
				"                        \"text\": {\n" +
				"                            \"CityNeighborhood\": \"חיפה\",\n" +
				"                            \"Neighborhood\": \"יל\\\"ג\"\n" +
				"                        },\n" +
				"                        \"params\": {\n" +
				"                            \"city\": \"4000\",\n" +
				"                            \"neighborhood\": 1685\n" +
				"                        }\n" +
				"                    },\n" +
				"                    {\n" +
				"                        \"text\": {\n" +
				"                            \"CityNeighborhood\": \"חיפה\",\n" +
				"                            \"Neighborhood\": \"הדר מרכז\"\n" +
				"                        },\n" +
				"                        \"params\": {\n" +
				"                            \"city\": \"4000\",\n" +
				"                            \"neighborhood\": 1671\n" +
				"                        }\n" +
				"                    },\n" +
				"                    {\n" +
				"                        \"text\": {\n" +
				"                            \"CityNeighborhood\": \"חיפה\",\n" +
				"                            \"Neighborhood\": \"הדר עליון\"\n" +
				"                        },\n" +
				"                        \"params\": {\n" +
				"                            \"city\": \"4000\",\n" +
				"                            \"neighborhood\": 1684\n" +
				"                        }\n" +
				"                    },\n" +
				"                    {\n" +
				"                        \"text\": {\n" +
				"                            \"CityNeighborhood\": \"חיפה\",\n" +
				"                            \"Neighborhood\": \"יזרעאליה\"\n" +
				"                        },\n" +
				"                        \"params\": {\n" +
				"                            \"city\": \"4000\",\n" +
				"                            \"neighborhood\": 641\n" +
				"                        }\n" +
				"                    }\n" +
				"                ]\n" +
				"            }\n" +
				"        },\n" +
				"        \"header_text\": \"\",\n" +
				"        \"seo_follow\": true,\n" +
				"        \"seo_index\": true,\n" +
				"        \"canonical\": \"//www.yad2.co.il/realestate/forsale/flats-savyonei-hakarmel-in-haifa?city=4000&neighborhood=634&rooms=2-3\",\n" +
				"        \"meta_title\": \" | מכירה | נדל\\\"ן יד2\",\n" +
				"        \"seo_text\": \"דירת החלומות שלכם נמצאת ממש כאן! לוח דירות למכירה של יד2 מביא לכם מאגר ענק ועדכני של דירות המוצעות למכירה בכל רחבי הארץ. ערכו חיפוש יעיל ומהיר באמצעות מנוע החיפוש המתקדם שלנו, המאפשר לכם להגדיר במדויק את סוג הדירה שאתם מחפשים ? החל מהאזור בארץ ועד לשטח במ\\\"ר. תוכלו גם לבחור ב\\\"תצוגה על גבי מפה\\\" כדי לצפות בדירות על פי מיקום גיאוגרפי. מצאתם דירה שמעניינת אתכם? הוסיפו אותה למודעות המסומנות שלכם להמשך מעקב או צרו קשר עם המוכר טלפונית או בהודעה דרך האתר. \",\n" +
				"        \"left_column\": [],\n" +
				"        \"hot_pics\": []\n" +
				"    },\n" +
				"    \"filters\": [\n" +
				"        {\n" +
				"            \"title\": \"לפי תאריך\",\n" +
				"            \"value\": 1,\n" +
				"            \"selected\": 1\n" +
				"        },\n" +
				"        {\n" +
				"            \"title\": \"מחיר - מהזול ליקר\",\n" +
				"            \"value\": 3,\n" +
				"            \"selected\": 0\n" +
				"        },\n" +
				"        {\n" +
				"            \"title\": \"מחיר - מהיקר לזול\",\n" +
				"            \"value\": 4,\n" +
				"            \"selected\": 0\n" +
				"        }\n" +
				"    ],\n" +
				"    \"categoriesData\": [],\n" +
				"    \"media\": {\n" +
				"        \"zone\": \"desktop/realestate/sale\",\n" +
				"        \"layout\": \"my15\",\n" +
				"        \"params\": {\n" +
				"            \"CityID\": \"4000\",\n" +
				"            \"yad1City\": \"4000\",\n" +
				"            \"fromRooms\": 2,\n" +
				"            \"untilRooms\": 3,\n" +
				"            \"fromPrice\": 1400000,\n" +
				"            \"untilPrice\": 2000000,\n" +
				"            \"SecondaryAreaID\": 5,\n" +
				"            \"PrimaryAreaID\": 25,\n" +
				"            \"SecondaryArea\": \"haifa\",\n" +
				"            \"PrimaryArea\": \"north\",\n" +
				"            \"searchB144FromYad2\": \"2_C_1734\",\n" +
				"            \"tivuch\": \"no\",\n" +
				"            \"artiMedia_iscroll_group\": \"yad2.iscroll.realestate.north\",\n" +
				"            \"abovePrice\": \"1300000\",\n" +
				"            \"AppType\": \"desktop\",\n" +
				"            \"mainpage\": \"yes\",\n" +
				"            \"measurements\": \"realestate\",\n" +
				"            \"merchant\": \"no\",\n" +
				"            \"catID\": 2,\n" +
				"            \"subCatID\": 1,\n" +
				"            \"current_zone\": \"search_results\",\n" +
				"            \"location\": \"search_results\",\n" +
				"            \"pageType\": \"search_results\",\n" +
				"            \"mainCategoryZones\": {\n" +
				"                \"1\": \"vehicles\",\n" +
				"                \"2\": \"realestate\",\n" +
				"                \"3\": \"second_hand\",\n" +
				"                \"5\": \"pets\",\n" +
				"                \"6\": \"studies\",\n" +
				"                \"10\": \"tourism\",\n" +
				"                \"11\": \"alternative\",\n" +
				"                \"12\": \"hospitality\",\n" +
				"                \"14\": \"maids_and_nannies\",\n" +
				"                \"15\": \"commercial\"\n" +
				"            },\n" +
				"            \"zonePrefix\": \"desktop/\",\n" +
				"            \"version\": \"guru\",\n" +
				"            \"Cohort\": \"Desktop_32\",\n" +
				"            \"userid\": \"iba258122583\",\n" +
				"            \"isOffice\": 1\n" +
				"        },\n" +
				"        \"artiMedia_iscroll_group\": \"yad2.iscroll.realestate.north\",\n" +
				"        \"locations\": [],\n" +
				"        \"lightboxLocations\": null\n" +
				"    },\n" +
				"    \"pagination\": {\n" +
				"        \"current_page\": 1,\n" +
				"        \"items_in_current_page\": 2,\n" +
				"        \"max_items_per_page\": 40,\n" +
				"        \"last_page\": 1,\n" +
				"        \"total_items\": 2\n" +
				"    },\n" +
				"    \"canonicalUrl\": \"http://www.yad2.co.il/api/pre-load/getFeedIndex/realestate/forsale?neighborhood=634&city=4000&rooms=2-3\",\n" +
				"    \"seoFooterText\": \" מחפשים דירה למכירה במחוז צפון? בלוח נכסים למכירה של יד2 תמצאו בקלות ובמהירות. מאגר הנכסים למכירה הענק והעדכני שלנו עומד לרשותכם - \\n                כל שעליכם לעשות הוא להקליד את פרטי הנכס שמעניין אתכם (מחוז, אזור, ישוב, סוג נכס, מספר חדרים וכו')\\n                 ומנוע החיפוש שלנו יסנן עבורכם את המודעות הרלוונטיות ביותר. מחפשים \\n                 דירה למכירה באזור ספציפי? לחצו על \\\"הצג על גבי מפה\\\" ובחרו באזור הגיאוגרפי שבו אתם מעוניינים למצוא מחפשים דירה למכירה.\\n                 המערכת תסמן עבורכם את מיקומי הדירות הזמינות, ותוכלו להקליק על כל סימון כדי לצפות במודעה ובפרטי ההתקשרות עם המוכר.\",\n" +
				"    \"address\": {\n" +
				"        \"topArea\": {\n" +
				"            \"level\": \"topArea\",\n" +
				"            \"id\": \"25\",\n" +
				"            \"name\": \"צפון\"\n" +
				"        },\n" +
				"        \"area\": {\n" +
				"            \"level\": \"area\",\n" +
				"            \"id\": \"5\",\n" +
				"            \"name\": \"חיפה והסביבה\"\n" +
				"        },\n" +
				"        \"city\": {\n" +
				"            \"level\": \"city\",\n" +
				"            \"id\": \"4000\",\n" +
				"            \"name\": \"חיפה\"\n" +
				"        },\n" +
				"        \"neighborhood\": {\n" +
				"            \"level\": \"neighborhood\",\n" +
				"            \"id\": \"634\",\n" +
				"            \"name\": \"סביוני הכרמל\"\n" +
				"        },\n" +
				"        \"street\": {\n" +
				"            \"level\": \"street\",\n" +
				"            \"id\": \"\",\n" +
				"            \"name\": null\n" +
				"        }\n" +
				"    },\n" +
				"    \"catTitle\": \"איפה היית רוצה לגור?\",\n" +
				"    \"title\": \"דירות למכירה  בסביוני הכרמל, חיפה | נדל\\\"ן יד2\",\n" +
				"    \"left_column\": false,\n" +
				"    \"yad1Listing\": [\n" +
				"        {\n" +
				"            \"MaxFloor\": null,\n" +
				"            \"images\": [\n" +
				"                \"https://pics.yad2.co.il/Pics/2018/11/20181128100602-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/06/20200625141350625-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/06/20200625141439696-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/06/20200625141403901-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/06/20200625141415299-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/06/20200625141427596-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2018/11/20181128113026-b.jpg\"\n" +
				"            ],\n" +
				"            \"CityNeighborhood\": \"חיפה\",\n" +
				"            \"geo_location\": {\n" +
				"                \"lon\": \"35.0027961730957\",\n" +
				"                \"lat\": \"32.81233596801758\"\n" +
				"            },\n" +
				"            \"C1_Title\": \"גולדן ארט נדל\\\"ן \",\n" +
				"            \"Image\": \"20181128100602-b.jpg\",\n" +
				"            \"OrderID\": \"4036\",\n" +
				"            \"Info\": \"בנוסף – תנאי מימון ייחודיים למשכנתאות והטבות נוספות מהבנק המלווה(בנק לאומי)\\r\\n*בכפוף לאישור הלקוח על ידי הבנק\\r\\n\\r\\nמוזמנים לסיור בדירה לדוגמה\\r\\n\\r\\nאל מול נוף נמל וים, בין פארק עירוני ירוק ומבני אבן לשימור, בלב ההיסטורי והמתחדש של חיפה, הוקם קומפלקס מגורים חדשני וייחודי – הרובע.\\r\\n\\r\\nהפרויקט, המשלב ארכיטקטורה מודרנית בעלת אלמנטים עיצוביים וחומריים המשמרים את העבר, מורכב מ- 3 מבני מגורים בני 9 קומות וכולל חזית מסחרית בקומת הקרקע המלווה את הרחוב. \\r\\n\\r\\nפרויקט הרובע מכיל 198 יחידות דיור, הבניין הראשון (המיועד לשכירות ארוכת טווח) אוכלס וב-2 הבניינים הנוספים מגוון רחב של דירות בגדלים: 3,4,5 חדרים, דירות גן ופנטהאוזים. \\r\\n\\r\\nהדירות ממוקמות בחזית הפונה לפארק חדש בן 12 דונם ולנוף המפרץ וחלקן צופות אל נוף הים והנמל. בנוסף, לרווחת הדיירים - מתחם ירוק ופרטי, בתוך הקומפלקס, בשטח של 700 מר. \\r\\nהפרויקט נותן מענה מגוון ורחב לצרכי הדיור של אוכלוסייה איכותית ונבנה בסטנדרט בנייה גבוה ומפרט עשיר ועכשווי. \\r\\n\\r\\nהרובע – יש מקום כזה. כאן ועכשיו.\",\n" +
				"            \"Rooms\": 3,\n" +
				"            \"Neighborhood\": \"העיר התחתית, ואדי סאליב\",\n" +
				"            \"Logo\": \"//pics.yad2.co.il/Pics/2018/11/20181128095649.jpg\",\n" +
				"            \"SalePic\": \"\",\n" +
				"            \"MinFloor\": null,\n" +
				"            \"Price\": 1580000,\n" +
				"            \"vPhoneYad2\": \"0534293195\",\n" +
				"            \"MaxSqm\": null,\n" +
				"            \"DisplayAddress\": \"ואדי סאליב 10, העיר התחתית, ואדי סאליב, חיפה\",\n" +
				"            \"project_products\": [\n" +
				"                \"3\",\n" +
				"                \"4\",\n" +
				"                \"8\",\n" +
				"                \"9\",\n" +
				"                \"10\",\n" +
				"                \"11\",\n" +
				"                \"12\",\n" +
				"                \"13\",\n" +
				"                \"14\",\n" +
				"                \"16\",\n" +
				"                \"18\",\n" +
				"                \"19\",\n" +
				"                \"20\",\n" +
				"                \"21\",\n" +
				"                \"22\",\n" +
				"                \"23\",\n" +
				"                \"1\",\n" +
				"                \"5\",\n" +
				"                \"8\",\n" +
				"                \"10\",\n" +
				"                \"13\",\n" +
				"                \"14\",\n" +
				"                \"15\",\n" +
				"                \"17\",\n" +
				"                \"18\",\n" +
				"                \"19\",\n" +
				"                \"20\",\n" +
				"                \"21\",\n" +
				"                \"22\",\n" +
				"                \"23\"\n" +
				"            ],\n" +
				"            \"project_section\": \"sales\",\n" +
				"            \"projectName\": \"הרובע\",\n" +
				"            \"projectID\": \"3310\",\n" +
				"            \"MinSqm\": null,\n" +
				"            \"SubTitle\": \"הרובע – עכשיו זה קורה! לאחר ההצלחה באכלוס הבניין הראשון, הדירות בבניין השני מוכנות והכניסה מידית.\\r\\nועכשיו במבצע אכלוס: משלמים על דירת 4 חדרים החל מ 1,180,000 ₪ בעת האכלוס ואת היתרה בסך 400,000 ₪ בעוד 5 שנים ללא ריבית וללא הצמדה*\",\n" +
				"            \"promotion_text\": \"עכשיו במבצע אכלוס!\",\n" +
				"            \"listing_product_id\": 5\n" +
				"        },\n" +
				"        {\n" +
				"            \"MaxFloor\": null,\n" +
				"            \"images\": [\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/09/2020091714250350-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/09/20200917142529159-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/09/20200917142512427-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/09/20200917142521793-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/09/20200917142538360-b.jpg\"\n" +
				"            ],\n" +
				"            \"CityNeighborhood\": \"חיפה\",\n" +
				"            \"geo_location\": {\n" +
				"                \"lon\": \"34.96478271484375\",\n" +
				"                \"lat\": \"32.8304443359375\"\n" +
				"            },\n" +
				"            \"C1_Title\": \"אחים עזורי\",\n" +
				"            \"Image\": \"2020091714250350-b.jpg\",\n" +
				"            \"OrderID\": \"5295\",\n" +
				"            \"Info\": \"פרויקט המגורים ”על הים“ הנבנה בשכונת בת גלים הפסטורלית בחיפה, כ-50 מטרים בלבד מקו החוף, מציע חווית מגורים ייחודית לצד הטבע, עם נוף עוצר נשימה אל חוף ימה המרהיב של בת גלים.\\r\\nבמסגרת הפרויקט, ייבנה בניין בוטיק איכותי בן 4 קומות המציע 11 דירות בלבד בתמהיל מגוון:\\r\\nדירות יוקרתיות בנות 2, 3 , 4 ו 5 חדרים ודירות גן בנות 5 חדרים,  \\r\\nבכל קומה 3 דירות בלבד ובקומת הקרקע 2 דירות גן מרווחות.\\r\\n\\r\\nפרויקט ״על הים״ מעוצב בקפידה, מתוך מחשבה פרקטית וכולל מפרט טכני עשיר.\\r\\nהדירות בפרויקט בעלות חדרים מרווחים ומוארים הודות לחלונות גדולים ששולבו בתכנונן.\\r\\n\\r\\nהפרויקט נהנה ממיקום אטרקטיבי ומבוקש בסמוך למרכזי חינוך, תרבות ובילוי ובקרבה לצירי תחבורה ראשיים. תחנת הרכת הקרובה ממוקמת במרחק של כ-4 דקות רכיבה באופניים בלבד. עוד סמוך הפרויקט לטיילת יוברט המפרי הכוללת פינות ישיבה שביל אופניים, מדשאות, תאורה וגישה לחוף ייחודי המשמש לגלישת קייטסרפינג.\",\n" +
				"            \"Rooms\": 3,\n" +
				"            \"Neighborhood\": \"עין הים\",\n" +
				"            \"Logo\": \"//pics.yad2.co.il/Pics/2020/09/20200917142124.jpg\",\n" +
				"            \"SalePic\": \"\",\n" +
				"            \"MinFloor\": null,\n" +
				"            \"Price\": 0,\n" +
				"            \"vPhoneYad2\": \"0535983642\",\n" +
				"            \"MaxSqm\": null,\n" +
				"            \"DisplayAddress\": \"בת גלים, חיפה\",\n" +
				"            \"project_products\": [\n" +
				"                \"1\",\n" +
				"                \"5\",\n" +
				"                \"8\",\n" +
				"                \"10\",\n" +
				"                \"13\",\n" +
				"                \"14\",\n" +
				"                \"15\",\n" +
				"                \"17\",\n" +
				"                \"18\",\n" +
				"                \"19\",\n" +
				"                \"20\",\n" +
				"                \"21\",\n" +
				"                \"22\",\n" +
				"                \"23\"\n" +
				"            ],\n" +
				"            \"project_section\": \"sales\",\n" +
				"            \"projectName\": \"על הים\",\n" +
				"            \"projectID\": \"19815\",\n" +
				"            \"MinSqm\": null,\n" +
				"            \"SubTitle\": \"”על הים“ - בת גלים – לבנות את החיים מול הים\\r\\nחווית מגורים ייחודית על חוף ימה המרהיב של בת גלים\",\n" +
				"            \"promotion_text\": \"בת גלים - חיים מול הים\",\n" +
				"            \"listing_product_id\": 5\n" +
				"        },\n" +
				"        {\n" +
				"            \"MaxFloor\": null,\n" +
				"            \"images\": [\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/07/20170730125315-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/07/20170730125317-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/07/20170730125313-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/07/20170720172625-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/07/20170720172215-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/07/20170720172213-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/07/20170720172218-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/07/20170720172211-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/07/20170720172216-b.jpg\"\n" +
				"            ],\n" +
				"            \"CityNeighborhood\": \"חיפה\",\n" +
				"            \"geo_location\": {\n" +
				"                \"lon\": \"34.95885848999023\",\n" +
				"                \"lat\": \"32.8193244934082\"\n" +
				"            },\n" +
				"            \"C1_Title\": \"מחאמיד תאופיק\",\n" +
				"            \"Image\": \"20170730125315-b.jpg\",\n" +
				"            \"OrderID\": \"3495\",\n" +
				"            \"Info\": \"מבצעים מיוחדים לרוכשי דירות 4 חד' + תנאי תשלום נוחים \\r\\nהטבות מיוחדות לעובדי מתם ובתי החולים\\r\\n\\r\\nEURO TOWER  - המגדל שכל העיר מדברת עליו – ממוקם 5 דקות נסיעה ממרכזית ותחנת הרכבת חוף הכרמל, \\r\\nובמרחק הליכה קצר מפארק הכט הכולל עשרות דונמים של מרחבים ירוקים,  מתקני משחק ופנאי, מגרשי ספורט וכושר וטיילת מרהיבה \\r\\nעל קו החוף המדהים של חיפה. \\r\\nבמגדל החדש 22 קומות של יוקרה, דירות מעוצבות עם מרפסות מרווחות, חניון תת קרקעי, לובי מפואר,מפרט עשיר.\\r\\n\\r\\nהמגדל החדש יאפשר לכם נגישות גבוהה לכל מקום בעיר – למרכז הכרמל ולעורק החיים התוסס של העיר, לפארק מתמ המאוכלס \\r\\nבחברות ההיי-טק המובילות בישראל ובעולם, ממרכזי חינוך דוגמת ליאו בק ובית הספר רמות, ממרכז רמת הנשיא , מקניון קסטרא, מרכז הקונגרסים ועזריאלי חיפה . \\r\\n\\r\\nלבחירתכם דירות 3 4 ו-5 חד' , דירות גן ודופלקסים מפוארים\",\n" +
				"            \"Rooms\": 3,\n" +
				"            \"Neighborhood\": \"קרית שפרינצק\",\n" +
				"            \"Logo\": \"//pics.yad2.co.il/Pics/2017/04/20170426083503.jpg\",\n" +
				"            \"SalePic\": \"\",\n" +
				"            \"MinFloor\": null,\n" +
				"            \"Price\": 0,\n" +
				"            \"vPhoneYad2\": \"0539382644\",\n" +
				"            \"MaxSqm\": null,\n" +
				"            \"DisplayAddress\": \"יציאת אירופה תש\\\"ז 4, קרית שפרינצק, חיפה\",\n" +
				"            \"project_products\": [\n" +
				"                \"1\",\n" +
				"                \"5\",\n" +
				"                \"8\",\n" +
				"                \"10\",\n" +
				"                \"13\",\n" +
				"                \"14\",\n" +
				"                \"15\",\n" +
				"                \"17\",\n" +
				"                \"18\",\n" +
				"                \"19\",\n" +
				"                \"20\",\n" +
				"                \"21\",\n" +
				"                \"22\",\n" +
				"                \"23\"\n" +
				"            ],\n" +
				"            \"project_section\": \"sales\",\n" +
				"            \"projectName\": \"EURO TOWER\",\n" +
				"            \"projectID\": \"2967\",\n" +
				"            \"MinSqm\": null,\n" +
				"            \"SubTitle\": \"על הים, מול הפארק – בדיוק כמו שרציתם! \\r\\nמגדל יורו טאוור חיפה – זה הזמן ליהנות ממיקום מנצח, \\r\\n5  דקות בלבד נסיעה מפארק ההיי-טק מת\\\"ם.\\r\\nהבניה בעיצומה!\",\n" +
				"            \"promotion_text\": \"מבצע מיוחד!\",\n" +
				"            \"listing_product_id\": 5\n" +
				"        },\n" +
				"        {\n" +
				"            \"MaxFloor\": null,\n" +
				"            \"images\": [\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/09/2020091712553276-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/09/20200917125512317-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/09/20200917125522473-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/09/20200917125542331-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2020/09/20200917125551332-b.jpg\"\n" +
				"            ],\n" +
				"            \"CityNeighborhood\": \"חיפה\",\n" +
				"            \"geo_location\": {\n" +
				"                \"lon\": \"35.00435256958008\",\n" +
				"                \"lat\": \"32.78164672851562\"\n" +
				"            },\n" +
				"            \"C1_Title\": \"גילעם\",\n" +
				"            \"Image\": \"2020091712553276-b.jpg\",\n" +
				"            \"OrderID\": \"5287\",\n" +
				"            \"Info\": \"בפרויקט ייבנו 3 בנייני בוטיק מדורגים בני 5 קומות כל אחד עם נוף ירוק לטבע מצד אחד\\r\\nורכס הכרמל והים מהצד השני. הפרויקט מתוכנן בעיצוב אדריכלי וסטנדרט מוקפד תוך\\r\\nירידה לפרטים הקטנים של חברת גילעם.\\r\\nסביבת מגורים פסטורלית ונגישות למרכז וצרכי היום יום, 3 דק׳ מהטכניון, 5 דק׳\\r\\nמהגרנד קניון, 10 דק׳ מאוניברסיטת חיפה, מנהרות הכרמל והיציאה לעוקף קריות,\\r\\nמוסדות חינוך ומתחמי ספורט, בילוי ותרבות.\\r\\nכל אלו הופכים את פרויקט ״דו.רה.מי״ לסימפוניה של איכות חיים שכולם ידברו עליה.\\r\\nהחל מ - 1,750,000 ₪ \",\n" +
				"            \"Rooms\": 3,\n" +
				"            \"Neighborhood\": \"גבעת זמר\",\n" +
				"            \"Logo\": \"//pics.yad2.co.il/Pics/2020/09/20200915142729.jpg\",\n" +
				"            \"SalePic\": \"20200916090531.jpg\",\n" +
				"            \"MinFloor\": null,\n" +
				"            \"Price\": 0,\n" +
				"            \"vPhoneYad2\": \"0534877821\",\n" +
				"            \"MaxSqm\": null,\n" +
				"            \"DisplayAddress\": \"גבעת זמר, הדודאים 3, חיפה\",\n" +
				"            \"project_products\": [\n" +
				"                \"1\",\n" +
				"                \"5\",\n" +
				"                \"10\",\n" +
				"                \"14\",\n" +
				"                \"15\",\n" +
				"                \"18\",\n" +
				"                \"20\",\n" +
				"                \"21\",\n" +
				"                \"22\",\n" +
				"                \"23\"\n" +
				"            ],\n" +
				"            \"project_section\": \"sales\",\n" +
				"            \"projectName\": \"DO.RE.MI\",\n" +
				"            \"projectID\": \"17791\",\n" +
				"            \"MinSqm\": null,\n" +
				"            \"SubTitle\": \"פרויקט דו רה מי מדורגי בוטיק בגבעת זמר\\r\\nהטבות ענק ל- 7 רוכשים הראשונים\\r\\nגילעם חברה לבניה ופיתוח בע״מ גאה להשיק את פרויקט המגורים הייחודי ״דו.רה.מי״\\r\\nבשכונה החדשה של חיפה בגבעת זמר, בסמיכות לשכונה הוותיקה אחוזה ובצמידות\\r\\nלשכונת אלמוגי.\",\n" +
				"            \"promotion_text\": \"הטבות ענק לרוכשים הראשונים\",\n" +
				"            \"listing_product_id\": 5\n" +
				"        },\n" +
				"        {\n" +
				"            \"MaxFloor\": null,\n" +
				"            \"images\": [\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/01/20170102104427-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/01/20170102104425-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/01/20170102104348-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/02/20170209092800-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/01/20170102104423-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/01/20170102104351-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/01/20170102104354-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/01/20170102104358-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/01/20170102104400-b.jpg\",\n" +
				"                \"https://pics.yad2.co.il/Pics/2017/01/20170102104421-b.jpg\"\n" +
				"            ],\n" +
				"            \"CityNeighborhood\": \"חיפה\",\n" +
				"            \"geo_location\": {\n" +
				"                \"lon\": \"35.01206588745117\",\n" +
				"                \"lat\": \"32.78594207763672\"\n" +
				"            },\n" +
				"            \"C1_Title\": \"פרשקובסקי\",\n" +
				"            \"Image\": \"20170102104425-b.jpg\",\n" +
				"            \"OrderID\": \"1924\",\n" +
				"            \"Info\": \"השלב השלישי והאחרון יוצא לדרך - זה הזמן לגלות את פרשקובסקי בחיפה מתחם המגורים הנחשק של העיר הנבנה בימים אלו בצמוד למרכז זיו, דקות נסיעה ממנהרות הכרמל, מעוקף קריות, מהגרנד קניון, מבתי ספר, גני ילדים ומוקדי קהילה, תרבות ופנאי.\\r\\n\\r\\nלבחירתכם: דירות 2, 3, 4, 5, 6 חד', דירות גן, דופלקסים, מיני פנטהאוזים ופנטהאוזים עם נוף פתוח לכרמל הירוק, לאופק הים ולהרי הגליל.  \\r\\nהבניה בעיצומה!\\r\\n\\r\\n\\r\\n**** לרוכשי פנטהאוז דו מפלסי בלבד. בכפוף לתקנון החברה. ט.ל.ח. *****\",\n" +
				"            \"Rooms\": 2,\n" +
				"            \"Neighborhood\": \"זיו\",\n" +
				"            \"Logo\": \"//pics.yad2.co.il/Pics/2019/01/20190102102828.jpg\",\n" +
				"            \"SalePic\": \"\",\n" +
				"            \"MinFloor\": null,\n" +
				"            \"Price\": 0,\n" +
				"            \"vPhoneYad2\": \"0539415638\",\n" +
				"            \"MaxSqm\": null,\n" +
				"            \"DisplayAddress\": \"ברל 43, זיו, חיפה\",\n" +
				"            \"project_products\": [\n" +
				"                \"1\",\n" +
				"                \"2\",\n" +
				"                \"3\",\n" +
				"                \"4\",\n" +
				"                \"5\",\n" +
				"                \"8\",\n" +
				"                \"9\",\n" +
				"                \"10\",\n" +
				"                \"11\",\n" +
				"                \"12\",\n" +
				"                \"13\",\n" +
				"                \"14\",\n" +
				"                \"16\",\n" +
				"                \"18\",\n" +
				"                \"19\",\n" +
				"                \"20\",\n" +
				"                \"21\",\n" +
				"                \"22\",\n" +
				"                \"23\"\n" +
				"            ],\n" +
				"            \"project_section\": \"sales\",\n" +
				"            \"projectName\": \"פרשקובסקי בחיפה\",\n" +
				"            \"projectID\": \"2852\",\n" +
				"            \"MinSqm\": null,\n" +
				"            \"SubTitle\": \"ALL IN ONE – הדירות המיוחדות של פרשקובסקי בחיפה\\r\\nפנטהאוז דו מפלסי מעוצב ומאובזר במטבח משודרג, במפרט פרימיום \\r\\nומרפסת נוף חלומית ! \\r\\nהבניה בעיצומה, בואו לראות את סיפור ההצלחה של חיפה מקרוב!\",\n" +
				"            \"promotion_text\": \"שכונת המחר של חיפה\",\n" +
				"            \"listing_product_id\": 5\n" +
				"        }\n" +
				"    ],\n" +
				"    \"yad1Ads\": {\n" +
				"        \"top_gallery\": [\n" +
				"            {\n" +
				"                \"CityNeighborhood\": \"חיפה\",\n" +
				"                \"Image\": \"//pics.yad2.co.il/Pics/2020/08/20200817095753398-b.jpg\",\n" +
				"                \"projectName\": \"אלמוגי סלקטד- רמת אלמוגי\",\n" +
				"                \"projectID\": \"3425\",\n" +
				"                \"promotion_text\": \"אל תפספסו את ההזדמנות לשדרג\",\n" +
				"                \"Neighborhood\": \"אחוזה\",\n" +
				"                \"SalePic\": \"\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"CityNeighborhood\": \"חיפה\",\n" +
				"                \"Image\": \"//pics.yad2.co.il/Pics/2018/11/20181128100602-b.jpg\",\n" +
				"                \"projectName\": \"הרובע\",\n" +
				"                \"projectID\": \"3310\",\n" +
				"                \"promotion_text\": \"עכשיו במבצע אכלוס!\",\n" +
				"                \"Neighborhood\": \"העיר התחתית, ואדי סאליב\",\n" +
				"                \"SalePic\": \"\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"CityNeighborhood\": \"חיפה\",\n" +
				"                \"Image\": \"//pics.yad2.co.il/Pics/2019/12/20191204104554-b.jpg\",\n" +
				"                \"projectName\": \"הכרמל הירוק\",\n" +
				"                \"projectID\": \"2491\",\n" +
				"                \"promotion_text\": \"דירת אחרוה, אכלוס מיידי!\",\n" +
				"                \"Neighborhood\": \"נעמ\\\"ת\",\n" +
				"                \"SalePic\": \"\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"CityNeighborhood\": \"חיפה\",\n" +
				"                \"Image\": \"//pics.yad2.co.il/Pics/2017/01/20170102104425-b.jpg\",\n" +
				"                \"projectName\": \"פרשקובסקי בחיפה\",\n" +
				"                \"projectID\": \"2852\",\n" +
				"                \"promotion_text\": \"שכונת המחר של חיפה\",\n" +
				"                \"Neighborhood\": \"זיו\",\n" +
				"                \"SalePic\": \"\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"bottom_gallery\": [\n" +
				"            {\n" +
				"                \"CityNeighborhood\": \"חיפה\",\n" +
				"                \"Image\": \"//pics.yad2.co.il/Pics/2020/08/20200817095753398-b.jpg\",\n" +
				"                \"projectName\": \"אלמוגי סלקטד- רמת אלמוגי\",\n" +
				"                \"projectID\": \"3425\",\n" +
				"                \"promotion_text\": \"אל תפספסו את ההזדמנות לשדרג\",\n" +
				"                \"Neighborhood\": \"אחוזה\",\n" +
				"                \"SalePic\": \"\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"CityNeighborhood\": \"חיפה\",\n" +
				"                \"Image\": \"//pics.yad2.co.il/Pics/2018/11/20181128100602-b.jpg\",\n" +
				"                \"projectName\": \"הרובע\",\n" +
				"                \"projectID\": \"3310\",\n" +
				"                \"promotion_text\": \"עכשיו במבצע אכלוס!\",\n" +
				"                \"Neighborhood\": \"העיר התחתית, ואדי סאליב\",\n" +
				"                \"SalePic\": \"\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"CityNeighborhood\": \"חיפה\",\n" +
				"                \"Image\": \"//pics.yad2.co.il/Pics/2019/12/20191204104554-b.jpg\",\n" +
				"                \"projectName\": \"הכרמל הירוק\",\n" +
				"                \"projectID\": \"2491\",\n" +
				"                \"promotion_text\": \"דירת אחרוה, אכלוס מיידי!\",\n" +
				"                \"Neighborhood\": \"נעמ\\\"ת\",\n" +
				"                \"SalePic\": \"\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"CityNeighborhood\": \"חיפה\",\n" +
				"                \"Image\": \"//pics.yad2.co.il/Pics/2017/01/20170102104425-b.jpg\",\n" +
				"                \"projectName\": \"פרשקובסקי בחיפה\",\n" +
				"                \"projectID\": \"2852\",\n" +
				"                \"promotion_text\": \"שכונת המחר של חיפה\",\n" +
				"                \"Neighborhood\": \"זיו\",\n" +
				"                \"SalePic\": \"\"\n" +
				"            }\n" +
				"        ]\n" +
				"    }\n" +
				"}";
		ObjectMapper objectMapper = new ObjectMapper();
		Yad2Response yad2Response = objectMapper.readValue(data, Yad2Response.class);
		Set<Yad2Response.FeedItem> items = yad2Response.getItems();
		assertThat(items.size()).isEqualTo(2);
	}

}
