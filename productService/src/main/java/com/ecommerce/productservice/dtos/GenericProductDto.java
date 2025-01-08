package com.ecommerce.productservice.dtos;

public class GenericProductDto {
        private Long id;
        private String title;
        private String description;
        private String image;
        private String category;
        private double price;

        public Long getId() {
                return this.id;
        }

        public String getTitle() {
                return this.title;
        }

        public String getDescription() {
                return this.description;
        }

        public String getImage() {
                return this.image;
        }

        public String getCategory() {
                return this.category;
        }

        public double getPrice() {
                return this.price;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public void setImage(String image) {
                this.image = image;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public void setPrice(double price) {
                this.price = price;
        }
}

