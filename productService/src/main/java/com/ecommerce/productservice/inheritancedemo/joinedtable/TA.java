package com.ecommerce.productservice.inheritancedemo.joinedtable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_ta")
@DiscriminatorValue(value = "2")
public class TA extends User {
    private double averageRating;
}