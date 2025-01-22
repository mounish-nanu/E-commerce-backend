package com.ecommerce.productservice.models;

import jakarta.persistence.Entity;

@Entity
public class Price extends BaseModel {
    String Currency;
    double Price;

    public String getCurrency() {
        return this.Currency;
    }

    public double getPrice() {
        return this.Price;
    }

    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
}
