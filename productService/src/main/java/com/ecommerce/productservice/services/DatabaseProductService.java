package com.ecommerce.productservice.services;


import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.NotFoundExceptions;

import java.util.List;
import java.util.UUID;

public interface DatabaseProductService {
    List<GenericProductDto> getAllProducts();
   GenericProductDto getProductById(UUID id) throws NotFoundExceptions;
    GenericProductDto createProduct(GenericProductDto product);
    String deleteProduct(UUID id);
    GenericProductDto updateById(UUID id, GenericProductDto product);
}
