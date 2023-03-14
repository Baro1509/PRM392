package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ViewCart extends AppCompatActivity {
    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);
        recyclerView = findViewById(R.id.rcv_product);
        CartAdapter cartAdapter = new CartAdapter(this, getProductList());
        recyclerView.setAdapter(cartAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
//        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
//        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
//        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
//        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
//        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
//        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
//        productList.add(new Product(R.drawable.iphone1,"Iphone",1000.0f,Product.TYPE_PHONE));
//
//        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
//        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
//        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
//        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
//        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
//        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
//        productList.add(new Product(R.drawable.mac,"Macbook Air",9999.0f,Product.TYPE_LAPTOP));
//
//        productList.add(new Product(R.drawable.chair,"Nice chair",200.0f,Product.TYPE_FURNITURE));
//        productList.add(new Product(R.drawable.chair,"Nice chair",200.0f,Product.TYPE_FURNITURE));
//        productList.add(new Product(R.drawable.chair,"Nice chair",200.0f,Product.TYPE_FURNITURE));
//        productList.add(new Product(R.drawable.chair,"Nice chair",200.0f,Product.TYPE_FURNITURE));
//        productList.add(new Product(R.drawable.chair,"Nice chair",200.0f,Product.TYPE_FURNITURE));
//        productList.add(new Product(R.drawable.chair,"Nice chair",200.0f,Product.TYPE_FURNITURE));

        return productList;
    }

}