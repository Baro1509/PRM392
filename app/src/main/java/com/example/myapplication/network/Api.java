package com.example.myapplication.network;

import com.example.myapplication.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://63e21cf8ad0093bf29c7f516.mockapi.io/baro/v1/";
    @GET("Product")
    Call<List<Product>> getProducts();
}
