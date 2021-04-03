package com.example.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.task.Response.ApiInterface;
import com.example.task.Retrofit.ApiClient;
import com.example.task.entity.GTS;
import com.example.task.entity.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProductAdapter mProductAdapter;
    private List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.productList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        LoadProducts();
    }

    private void LoadProducts() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<GTS> call = apiService.getMovieDetails();
        call.enqueue(new Callback<GTS>() {
            @Override
            public void onResponse(Call<GTS> call, Response<GTS> response) {
                if(!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                GTS productReponse = response.body();
                assert productReponse != null;
                products = productReponse.getProducts();

                mProductAdapter = new ProductAdapter(MainActivity.this, products);
                mRecyclerView.setAdapter(mProductAdapter);
            }

            @Override
            public void onFailure(Call<GTS> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}