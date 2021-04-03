package com.example.task.Response;

import android.database.Observable;

import com.example.task.entity.GTS;
import com.example.task.entity.Product;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("user/get_all_products.php")
    Call<GTS> getMovieDetails();
}