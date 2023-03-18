package com.example.myapplication.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.myapplication.GlobalVariables;
import com.example.myapplication.R;
import com.example.myapplication.model.Brand;
import com.example.myapplication.model.Category;
import com.example.myapplication.model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    List<Integer> listImages;
    Product product;

    ViewPager2 productImageContainer;
    ProductImageAdapter productImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupComponent();
        setupUI();
        setupProductImageContainer();
    }

    private void setupComponent() {
        if (listImages == null) {
            listImages = new ArrayList<>();
        }
        product = getProductFromIntent();
    }

    private void setupUI() {
        productImageContainer = (ViewPager2) findViewById(R.id.productImageContainer);
        productImageAdapter = new ProductImageAdapter(ProductActivity.this, product.getImages());
        productImageContainer.setAdapter(productImageAdapter);
    }

    private void setupProductImageContainer() {
        productImageContainer.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private Product getProductFromIntent() {
        Intent intent = getIntent();
        int productId = intent.getIntExtra("productId", 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            product = ((GlobalVariables) this.getApplication()).getProducts().stream().filter(p -> p.getProductId() == productId).findAny().orElse(product = null);
        }
        return product;
    }
}