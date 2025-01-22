package com.ecommerce.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Category extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Category() {
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
