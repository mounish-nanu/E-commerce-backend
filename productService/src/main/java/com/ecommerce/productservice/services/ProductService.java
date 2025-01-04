package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.NotFoundExceptions;
import com.ecommerce.productservice.models.Product;

import java.util.List;


public interface ProductService {
    GenericProductDto getProductById(Long id) throws NotFoundExceptions;
    GenericProductDto createProduct(GenericProductDto product);
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProduct(Long id);
}
