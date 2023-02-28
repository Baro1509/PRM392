package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.home.SearchProduct;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements View.OnClickListener {

    private  RecyclerView rcvProduct;
    private Button btnPhone,btnLaptop,btnFurniture;
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
        rcvProduct = findViewById(R.id.rcv_product);

        grid = new GridLayoutManager(this, 2);
        rcvProduct.setLayoutManager(grid);
        ProductListViewAdapter productListViewAdapter = new ProductListViewAdapter(getProductList());
        rcvProduct.setAdapter(productListViewAdapter);


        btnPhone.setOnClickListener(this);
        btnLaptop.setOnClickListener(this);
        btnFurniture.setOnClickListener(this);
    }

    public void openSearchPage(){
        Intent intent = new Intent(HomePage.this, SearchProduct.class);
        startActivity(intent);
    }

    private List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));

        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));

        productList.add(new Product(R.drawable.chair,"Nice chair",200.0f,Product.TYPE_FURNITURE));
        productList.add(new Product(R.drawable.chair,"Nice chair",200.0f,Product.TYPE_FURNITURE));
        productList.add(new Product(R.drawable.chair,"Nice chair",200.0f,Product.TYPE_FURNITURE));
        productList.add(new Product(R.drawable.chair,"Nice chair",200.0f,Product.TYPE_FURNITURE));
        productList.add(new Product(R.drawable.chair,"Nice chair",200.0f,Product.TYPE_FURNITURE));
        productList.add(new Product(R.drawable.chair,"Nice chair",200.0f,Product.TYPE_FURNITURE));

        return productList;
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
        }
    }

    private void scrollToItem(int index) {
        if (grid == null){
            return;
        }
        grid.scrollToPositionWithOffset(index,0);
    }
}