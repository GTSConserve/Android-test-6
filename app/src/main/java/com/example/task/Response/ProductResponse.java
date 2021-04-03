package com.example.task.Response;

import com.example.task.entity.Product;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductResponse {

    @SerializedName("GTS")
    @Expose
    private ArrayList<Product> results;

    public ArrayList<Product> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return results.toString();
    }
}