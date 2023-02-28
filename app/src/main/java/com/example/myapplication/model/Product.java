package com.example.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDateTime;

public class Product implements Parcelable {
    private Integer productId;
    private String productName;
    private Float price;
    private String images;
    private LocalDateTime modelYear;
    private String description;
    private Integer stock;
    private Brand brand;
    private Category category;

    public Product(Integer productId, String productName, Float price, String images, LocalDateTime modelYear, String description, Integer stock, Brand brand, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.images = images;
        this.modelYear = modelYear;
        this.description = description;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
    }

    protected Product(Parcel in) {
        if (in.readByte() == 0) {
            productId = null;
        } else {
            productId = in.readInt();
        }
        productName = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readFloat();
        }
        images = in.readString();
        description = in.readString();
        if (in.readByte() == 0) {
            stock = null;
        } else {
            stock = in.readInt();
        }
        brand = in.readParcelable(Brand.class.getClassLoader());
        category = in.readParcelable(Category.class.getClassLoader());
    }

    public Product(String images, String productName, float price) {
        this.images = images;
        this.productName = productName;
        this.price = price;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (productId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(productId);
        }
        dest.writeString(productName);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(price);
        }
        dest.writeString(images);
        dest.writeString(description);
        if (stock == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(stock);
        }
        dest.writeParcelable(brand, flags);
        dest.writeParcelable(category, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public LocalDateTime getModelYear() {
        return modelYear;
    }

    public void setModelYear(LocalDateTime modelYear) {
        this.modelYear = modelYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
