package com.ecommerce.productservice.services;

import com.ecommerce.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.NotFoundExceptions;
import com.ecommerce.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        return convertProductToGenericProductDto(fakeStoreProductServiceClient.createProduct(product));
    }

    public GenericProductDto convertProductToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreProductServiceClient.getAllProducts()) {
            genericProductDtos.add(convertProductToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundExceptions {
        return convertProductToGenericProductDto(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return convertProductToGenericProductDto(fakeStoreProductServiceClient.deleteProduct(id));
    }

    public GenericProductDto updateProductById(Long id, GenericProductDto product) {
        return convertProductToGenericProductDto(fakeStoreProductServiceClient.updateProductById(id, product));
    }
}
