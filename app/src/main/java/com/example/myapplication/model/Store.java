package com.example.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Store implements Parcelable {
    private Integer storeId;
    private String storeName;
    private String storePhone;
    private String storeEmail;
    private String storeStreet;
    private String storeCity;
    private String storeState;
    private String storeZipCode;

    public Store(Integer storeId, String storeName, String storePhone, String storeEmail, String storeStreet, String storeCity, String storeState, String storeZipCode) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storePhone = storePhone;
        this.storeEmail = storeEmail;
        this.storeStreet = storeStreet;
        this.storeCity = storeCity;
        this.storeState = storeState;
        this.storeZipCode = storeZipCode;
    }

    protected Store(Parcel in) {
        if (in.readByte() == 0) {
            storeId = null;
        } else {
            storeId = in.readInt();
        }
        storeName = in.readString();
        storePhone = in.readString();
        storeEmail = in.readString();
        storeStreet = in.readString();
        storeCity = in.readString();
        storeState = in.readString();
        storeZipCode = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (storeId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(storeId);
        }
        dest.writeString(storeName);
        dest.writeString(storePhone);
        dest.writeString(storeEmail);
        dest.writeString(storeStreet);
        dest.writeString(storeCity);
        dest.writeString(storeState);
        dest.writeString(storeZipCode);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    public String getStoreStreet() {
        return storeStreet;
    }

    public void setStoreStreet(String storeStreet) {
        this.storeStreet = storeStreet;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }

    public String getStoreState() {
        return storeState;
    }

    public void setStoreState(String storeState) {
        this.storeState = storeState;
    }

    public String getStoreZipCode() {
        return storeZipCode;
    }

    public void setStoreZipCode(String storeZipCode) {
        this.storeZipCode = storeZipCode;
    }
}
