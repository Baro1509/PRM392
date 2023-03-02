package com.example.myapplication.order;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.model.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class OrderActivity extends AppCompatActivity {
    RecyclerView orderListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setupUI();
    }

    private void setupUI() {
        orderListView = findViewById(R.id.orderListView);
        orderListView.setAdapter(new OrderListAdapter(this, mockOrderList()));
        orderListView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<Order> mockOrderList() {
        List<Order> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(mockOrder());
        }
        return list;
    }

    private Order mockOrder() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return new Order(ThreadLocalRandom.current().nextInt(0, 10),
                    null,
                    null,
                    null,
                    "Arrived",
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    100f,
                    10);
        }
        return null;
    }
}