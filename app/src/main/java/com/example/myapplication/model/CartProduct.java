package com.example.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CartProduct implements Parcelable {
    private Integer cartProductId;
    private String cartProductName;
    private Float price;
    private Integer amount;
    private Store store;

    public CartProduct(Integer cartProductId, String cartProductName, Float price, Integer amount, Store store) {
        this.cartProductId = cartProductId;
        this.cartProductName = cartProductName;
        this.price = price;
        this.amount = amount;
        this.store = store;
    }

    protected CartProduct(Parcel in) {
        if (in.readByte() == 0) {
            cartProductId = null;
        } else {
            cartProductId = in.readInt();
        }
        cartProductName = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readFloat();
        }
        if (in.readByte() == 0) {
            amount = null;
        } else {
            amount = in.readInt();
        }
        store = in.readParcelable(Store.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (cartProductId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cartProductId);
        }
        dest.writeString(cartProductName);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(price);
        }
        if (amount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(amount);
        }
        dest.writeParcelable(store, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CartProduct> CREATOR = new Creator<CartProduct>() {
        @Override
        public CartProduct createFromParcel(Parcel in) {
            return new CartProduct(in);
        }

        @Override
        public CartProduct[] newArray(int size) {
            return new CartProduct[size];
        }
    };

    public Integer getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(Integer cartProductId) {
        this.cartProductId = cartProductId;
    }

    public String getCartProductName() {
        return cartProductName;
    }

    public void setCartProductName(String cartProductName) {
        this.cartProductName = cartProductName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
