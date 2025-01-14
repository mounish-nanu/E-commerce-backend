package com.ecommerce.productservice.thirdpartyclients.productservice.fakestore;

import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.exceptions.NotFoundExceptions;
import com.ecommerce.productservice.thirdpartyclients.productservice.ThirdPartyProductServiceClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductServiceClient implements ThirdPartyProductServiceClient {

    private RestTemplateBuilder restTemplateBuilder;
    private String ProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(createProductRequestUrl, FakeStoreProductDto[].class);


        return Arrays.stream(response.getBody()).toList();
    }

    @Override
    public FakeStoreProductDto getProductById(Long id) throws NotFoundExceptions {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(ProductRequestUrl, FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if (fakeStoreProductDto == null){
            throw new NotFoundExceptions("Product with Id : " + id + " doesn't exist");
        }
        return fakeStoreProductDto;
    }

    @Override
    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(ProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor,id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return fakeStoreProductDto;
    }

    public FakeStoreProductDto updateProductById(Long id, GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(ProductRequestUrl, HttpMethod.PUT, requestCallback,responseExtractor, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return  fakeStoreProductDto;
    }
    public FakeStoreProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(createProductRequestUrl, product, FakeStoreProductDto.class);
        return response.getBody();
    }
}
