package com.ecommerce.productservice.services;

import com.ecommerce.productservice.dtos.GenericProductDto;
import com.ecommerce.productservice.models.Category;
import com.ecommerce.productservice.models.Price;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.repositories.CategoryRepository;
import com.ecommerce.productservice.repositories.PriceRepository;
import com.ecommerce.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("selfProductServiceImpl")

public class SelfProductServiceImpl implements DatabaseProductService {
    private final CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public SelfProductServiceImpl(ProductRepository productRepository,
                                  PriceRepository priceRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public GenericProductDto getProductById(UUID id) {

        Product prod =  productRepository.findByUuid(id);
        GenericProductDto productDto = new GenericProductDto();
        productDto.setTitle(prod.getTitle());
        productDto.setDescription(prod.getDescription());
        productDto.setPrice(prod.getPrice().getPrice());
        productDto.setCategory(prod.getCategory().getName());
        return productDto;
    }

    public GenericProductDto convertProductToGenericProductDto(Product product) {
        GenericProductDto prod = new GenericProductDto();
        prod.setImage(product.getImage());
        prod.setDescription(product.getDescription());
        prod.setTitle(product.getTitle());
        Price price = new Price();
        price = product.getPrice();
        prod.setPrice(price.getPrice());
        Category category = new Category();
        category = product.getCategory();
        prod.setCategory(category.getName());

        return prod;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        Price price = new Price();
        price.setPrice(product.getPrice());
        Price savedPrice = priceRepository.save(price);

        Category category = new Category();
        category.setName(product.getCategory());
        Category savedCategory = categoryRepository.save(category);

        Product prod = new Product();
        prod.setTitle(product.getTitle());
        prod.setDescription(product.getDescription());
        prod.setPrice(savedPrice);
        prod.setCategory(savedCategory);

        productRepository.save(prod);

        GenericProductDto prodDto = new GenericProductDto();

        prodDto.setTitle(prod.getTitle());
        prodDto.setDescription(prod.getDescription());
        prodDto.setPrice(prod.getPrice().getPrice());
        prodDto.setCategory(savedCategory.getName());
        return prodDto;
    }


    public List<GenericProductDto> getAllProducts(){

        List<Product> prod1 = productRepository.findAll();
        List<GenericProductDto> products = new ArrayList<>();
        for (Product p : prod1) {
            products.add(convertProductToGenericProductDto(p));
        }
        return products;
    }

    public String deleteProduct(UUID id) {
        productRepository.deleteById(id);
        return "Product with id " + id + " was deleted" ;
    }

    public GenericProductDto updateById(UUID id, GenericProductDto product) {
        Product prod = productRepository.findByUuid(id);
        prod.setTitle(product.getTitle());
        prod.setDescription(product.getDescription());

        Price price = new Price();
        price.setPrice(product.getPrice());
        Price savedPrice = priceRepository.save(price);

        Category category = new Category();
        category.setName(product.getCategory());
        Category savedCategory = categoryRepository.save(category);

        prod.setPrice(savedPrice);
        prod.setCategory(savedCategory);
        productRepository.save(prod);

        return convertProductToGenericProductDto(prod);
    }
}
