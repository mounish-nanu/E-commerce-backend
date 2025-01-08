package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")

public class SelfProductServiceImpl implements ProductService {

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }
    public List<GenericProductDto> getAllProducts(){
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }

    public GenericProductDto updateProductById(Long id, GenericProductDto product) {
        return null;
    }
}
