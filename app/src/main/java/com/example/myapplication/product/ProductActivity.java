package com.example.myapplication.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;

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
        int abc = R.drawable.image5;
        product = mockProduct();
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

    //TODO Remove this after get product from another source is implemented
    private Product mockProduct() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            image1: 2131165296
//            image2: 2131165297
//            image3: 2131165298
//            image4: 2131165299
//            image5: 2131165345
            return new Product(1,
                    "Product 1",
                    15f,
                    "2131165345_2131165297_2131165298_2131165299",
                    LocalDateTime.now(),
                    "This is the product\n" +
                            "you have always wanted",
                    100,
                    new Brand(1, "Gucci"),
                    new Category(1, "Meme"));
        }
        return null;
    }
}