package ro.utcluj.dbassignment.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wine")
public class Wine {

    private ObjectId id;

    private String country;

    private String description;

    private String designation;

    private Integer points;

    private Double price;

    private String province;

    private String region_1;

    private String region_2;

    private String taster_name;

    private String taster_twitter_handle;

    private String title;

    private String variety;

    private String winery;

    public Wine() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegion_1() {
        return region_1;
    }

    public void setRegion_1(String region_1) {
        this.region_1 = region_1;
    }

    public String getRegion_2() {
        return region_2;
    }

    public void setRegion_2(String region_2) {
        this.region_2 = region_2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getWinery() {
        return winery;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }

    public String getTaster_name() {
        return taster_name;
    }

    public void setTaster_name(String taster_name) {
        this.taster_name = taster_name;
    }

    public String getTaster_twitter_handle() {
        return taster_twitter_handle;
    }

    public void setTaster_twitter_handle(String taster_twitter_handle) {
        this.taster_twitter_handle = taster_twitter_handle;
    }
}
