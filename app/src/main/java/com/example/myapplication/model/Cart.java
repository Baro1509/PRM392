package com.example.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Cart implements Parcelable {
    private List<CartProduct> list;
    private Float totalPrice;
    private Integer totalProducts;

    public Cart() {
        list = new ArrayList<>();
        totalPrice = 0f;
        totalProducts = 0;
    }

    protected Cart(Parcel in) {
        list = in.createTypedArrayList(CartProduct.CREATOR);
        if (in.readByte() == 0) {
            totalPrice = null;
        } else {
            totalPrice = in.readFloat();
        }
        if (in.readByte() == 0) {
            totalProducts = null;
        } else {
            totalProducts = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(list);
        if (totalPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(totalPrice);
        }
        if (totalProducts == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(totalProducts);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Cart> CREATOR = new Creator<Cart>() {
        @Override
        public Cart createFromParcel(Parcel in) {
            return new Cart(in);
        }

        @Override
        public Cart[] newArray(int size) {
            return new Cart[size];
        }
    };

    public List<CartProduct> getList() {
        return list;
    }

    public void setList(List<CartProduct> list) {
        this.list = list;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }
}
