package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.HomePageBinding;

public class HomePage extends AppCompatActivity {


    HomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] productImg = {R.drawable.chair, R.drawable.couch, R.drawable.dining_table, R.drawable.iphone1, R.drawable.mac};

        String[] productName = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        int[] productPrice = {1000,2000,3000,4000,5000};

        GridAdapter gridAdapter;
        gridAdapter = new GridAdapter(HomePage.this, productImg, productName, productPrice);

        binding.productList.setAdapter(gridAdapter);


        binding.productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long l) {
                Toast.makeText(HomePage.this,"Clicked on " + productName[position],Toast.LENGTH_SHORT).show();
            }
        });

    }
}