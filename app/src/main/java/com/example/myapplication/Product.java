package com.example.myapplication;

public class Product
{
    public  static final Integer TYPE_PHONE = 1;
    public  static final Integer TYPE_LAPTOP = 2;
    public  static final Integer TYPE_FURNITURE = 3;

    private Integer image;
    private String productName;
    private Float price;
    private Integer type;

    public Product(Integer image, String productName, Float price, Integer type) {
        this.image = image;
        this.productName = productName;
        this.price = price;
        this.type = type;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


}
