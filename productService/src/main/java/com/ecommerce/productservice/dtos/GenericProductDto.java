package com.ecommerce.productservice.dtos;

import com.ecommerce.productservice.models.BaseModel;
import com.ecommerce.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
        private Long id;
        private String title;
        private String description;
        private String image;
        private String category;
        private double price;
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}

