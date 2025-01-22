package com.ecommerce.productservice.inheritancedemo.joinedtable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "jt_mentor")
public class Mentor extends User {
    private double averageRating;

    public double getAverageRating() {
        return this.averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
