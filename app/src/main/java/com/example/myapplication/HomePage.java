package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.home.SearchProduct;
import com.example.myapplication.model.Brand;
import com.example.myapplication.model.Category;
import com.example.myapplication.model.Product;
import com.example.myapplication.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rcvProduct;
    private Button btnPhone,btnLaptop,btnFurniture,btnAdd;
    private GridLayoutManager grid;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);


        searchBar = findViewById(R.id.searchBar);

        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearchPage();
            }
        });
        

        btnPhone = findViewById(R.id.phoneBtn);
        btnLaptop = findViewById(R.id.laptopBtn);
        btnFurniture = findViewById(R.id.furniBtn);
        btnAdd = findViewById(R.id.btnAdd);
        rcvProduct = findViewById(R.id.rcv_product);

        grid = new GridLayoutManager(this, 2);
        rcvProduct.setLayoutManager(grid);
        ProductListViewAdapter productListViewAdapter = new ProductListViewAdapter(getProductList());
        rcvProduct.setAdapter(productListViewAdapter);

        btnPhone.setOnClickListener(this);
        btnLaptop.setOnClickListener(this);
        btnFurniture.setOnClickListener(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCart();
            }
        });
    }

    public void openCart() {
        Intent intent = new Intent(this,ViewCart.class );
        startActivity(intent);
    }

    public void openSearchPage(){
        Intent intent = new Intent(HomePage.this, SearchProduct.class);
        startActivity(intent);
    }

    private List<Product> getProductList() {
        return ((GlobalVariables) this.getApplication()).getProducts();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.phoneBtn:
                scrollToItem(0);
                break;
            case R.id.laptopBtn:
                scrollToItem(7);
                break;
            case R.id.furniBtn:
                scrollToItem(14);
                break;
            case R.id.btnAdd:

                break;
        }
    }

    private void scrollToItem(int index) {
        if (grid == null){
            return;
        }
        grid.scrollToPositionWithOffset(index,0);
    }

    private void getProductListFromAPI() {
        Call<List<Product>> call = RetrofitClient.getInstance().getApi().getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> list = response.body();
                for (Product p : list) {
                    setupProduct(p);
                }
                updateProductList(list);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateProductList(List<Product> list) {
        ((GlobalVariables) this.getApplication()).setProducts(list);
    }

    private void setupProduct(Product product) {
        product.setImages(String.valueOf(R.drawable.chair));
        product.setBrand(new Brand(1, "Cong thai hoc"));
        product.setCategory(new Category(1, "Furniture"));
    }
}