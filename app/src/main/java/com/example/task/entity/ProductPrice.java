
package com.example.task.entity;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ProductPrice {

    @SerializedName("product_price_id")
    @Expose
    private String productPriceId;
    @SerializedName("product_variation")
    @Expose
    private String productVariation;
    @SerializedName("product_unit")
    @Expose
    private String productUnit;
    @SerializedName("product_price")
    @Expose
    private String productPrice;

    public String getProductPriceId() {
        return productPriceId;
    }

    public void setProductPriceId(String productPriceId) {
        this.productPriceId = productPriceId;
    }

    public String getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(String productVariation) {
        this.productVariation = productVariation;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

}
