package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    Context context;
    String[] productName;
    int[] price;
    int[] image;

    public GridAdapter(Context context, int[] image, String[] productName, int[] price) {
        this.context = context;
        this.productName = productName;
        this.price = price;
        this.image = image;
    }

    LayoutInflater inflater;

    @Override
    public int getCount() {
        return productName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_card, null);
        }
        ImageView imgView = convertView.findViewById(R.id.itemImage);
        TextView textView =(TextView) convertView.findViewById(R.id.itemName);
        TextView txtPrice = (TextView) convertView.findViewById(R.id.itemPrice);

        imgView.setImageResource(image[position]);
        textView.setText(productName[position]);
        String asd = "" + price[position];
        txtPrice.setText(asd);

        return convertView;
    }
}
