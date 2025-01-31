package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.NotFoundExceptions;
import com.ecommerce.productservice.services.DatabaseProductService;
import com.ecommerce.productservice.services.FakeStoreProductService;
import com.ecommerce.productservice.services.ProductService;
import com.ecommerce.productservice.services.SelfProductServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final FakeStoreProductService fakeStoreProductService;
    private final SelfProductServiceImpl selfProductService;
    private final DatabaseProductService databaseProductService;

    public ProductController(ProductService productService,
                             FakeStoreProductService fakeStoreProductService,
                             @Qualifier("selfProductServiceImpl") SelfProductServiceImpl selfProductService,
                             DatabaseProductService databaseProductService) {
        this.productService = productService;
        this.fakeStoreProductService = fakeStoreProductService;
        this.selfProductService = selfProductService;
        this.databaseProductService = databaseProductService;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts() {
        return databaseProductService.getAllProducts();
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") UUID id) throws NotFoundExceptions {

        return databaseProductService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") UUID id) {
//        ResponseEntity<GenericProductDto> response = new ResponseEntity<>(databaseProductService.deleteProduct(id), HttpStatus.OK);
        databaseProductService.deleteProduct(id);
        return "Product with id " + id + " was deleted";
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
        return databaseProductService.createProduct(product);

    }

    @PutMapping("/{id}")
    public GenericProductDto updateProductById(@RequestBody GenericProductDto product, @PathVariable("id") UUID id) {
        return databaseProductService.updateById(id, product);
    }
}


