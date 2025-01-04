package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.FakeStoreProductDto;
import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.NotFoundExceptions;
import com.ecommerce.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private String ProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductRequestUrl, product, GenericProductDto.class);
        return response.getBody();
    }

    public GenericProductDto convertProductToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(createProductRequestUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> ans = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto: Arrays.stream(response.getBody()).toList()){
            ans.add(convertProductToGenericProductDto(fakeStoreProductDto));
        }
        return ans;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundExceptions {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(ProductRequestUrl, FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if (fakeStoreProductDto == null){
            throw new NotFoundExceptions("Product with Id : " + id + " doesn't exist");
        }
        return convertProductToGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(ProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor,id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return convertProductToGenericProductDto(fakeStoreProductDto);
    }
}
