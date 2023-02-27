package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductListViewAdapter extends RecyclerView.Adapter<ProductListViewAdapter.ProductViewHolder>
{
    private List<Product> productList;

    public ProductListViewAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        if (product == null){
            return;
        }

        holder.img.setImageResource(product.getImage());
        holder.productName.setText(product.getProductName());
        holder.productPrice.setText(product.getPrice().toString());
    }

    @Override
    public int getItemCount() {
        if (productList != null){
            return productList.size();
        }
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView productName;
        private TextView productPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.itemImage);
            productName = itemView.findViewById(R.id.itemName);
            productPrice = itemView.findViewById(R.id.itemPrice);
        }
    }
}
