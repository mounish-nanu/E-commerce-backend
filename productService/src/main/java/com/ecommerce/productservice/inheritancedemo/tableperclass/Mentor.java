package com.ecommerce.productservice.inheritancedemo.tableperclass;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "tpc_mentor")
public class Mentor extends User {
    private double averageRating;

    public double getAverageRating() {
        return this.averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
