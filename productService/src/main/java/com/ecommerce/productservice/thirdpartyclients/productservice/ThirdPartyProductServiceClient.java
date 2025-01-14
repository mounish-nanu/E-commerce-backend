package com.ecommerce.productservice.thirdpartyclients.productservice;

import com.ecommerce.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.NotFoundExceptions;

import java.util.List;

public interface ThirdPartyProductServiceClient {
    FakeStoreProductDto getProductById(Long id) throws NotFoundExceptions;
    FakeStoreProductDto createProduct(GenericProductDto product);
    List<FakeStoreProductDto> getAllProducts();
    FakeStoreProductDto deleteProduct(Long id);
    FakeStoreProductDto updateProductById(Long id, GenericProductDto product);
}
