package com.tap.model;

import java.io.Serializable;

public class CartItem implements Serializable {

    private int itemId;
    private String itemName;
    private double price;
    private int quantity;
    private String image;

    // Default Constructor (Required for JSP / Servlet usage)
    public CartItem() {
    }

    // Parameterized Constructor
    public CartItem(int itemId, String itemName, double price, int quantity, String image) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    // Getter Methods

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }

    // Setter Methods

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // Helper Method (Optional but Useful)
    public double getTotalPrice() {
        return price * quantity;
    }
}
    