
package com.example.task.entity;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Product {

    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("product_image")
    @Expose
    private String productImage;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("product_price")
    @Expose
    private List<ProductPrice> productPrice = null;
    @SerializedName("product_recommended")
    @Expose
    private String productRecommended;
    @SerializedName("is_favorite")
    @Expose
    private Integer isFavorite;
    @SerializedName("product_type")
    @Expose
    private String productType;
    @SerializedName("eggless")
    @Expose
    private String eggless;
    @SerializedName("timeslot")
    @Expose
    private String timeslot;
    @SerializedName("product_offer")
    @Expose
    private String productOffer;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductPrice> getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(List<ProductPrice> productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductRecommended() {
        return productRecommended;
    }

    public void setProductRecommended(String productRecommended) {
        this.productRecommended = productRecommended;
    }

    public Integer getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getEggless() {
        return eggless;
    }

    public void setEggless(String eggless) {
        this.eggless = eggless;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getProductOffer() {
        return productOffer;
    }

    public void setProductOffer(String productOffer) {
        this.productOffer = productOffer;
    }

}
