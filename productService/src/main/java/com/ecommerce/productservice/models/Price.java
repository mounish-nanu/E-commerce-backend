package com.ecommerce.productservice.models;

import jakarta.persistence.Entity;

@Entity
public class Price extends BaseModel {
    private String currency; // Use lowercase for the field name
    private double price;

    // Getters and Setters
    public String getCurrency() {
        return this.currency;
    }

    public double getPrice() {
        return this.price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
