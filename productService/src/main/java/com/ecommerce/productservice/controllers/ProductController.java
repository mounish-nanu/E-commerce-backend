package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.ExceptionDto;
import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.NotFoundExceptions;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.services.FakeStoreProductService;
import com.ecommerce.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private FakeStoreProductService fakeStoreProductService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundExceptions {

        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
        ResponseEntity<GenericProductDto> response = new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
        return response;
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return productService.createProduct(product);

    }

    @PutMapping("/{id}")
    public void updateProductById() {
    }
}


