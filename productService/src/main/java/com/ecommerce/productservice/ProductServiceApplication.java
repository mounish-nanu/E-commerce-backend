package com.ecommerce.productservice;

import com.ecommerce.productservice.inheritancedemo.tableperclass.Mentor;
import com.ecommerce.productservice.inheritancedemo.tableperclass.MentorRepository;
import com.ecommerce.productservice.models.Category;
import com.ecommerce.productservice.models.Price;
import com.ecommerce.productservice.repositories.PriceRepository;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.repositories.CategoryRepository;
import com.ecommerce.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private MentorRepository mentorRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(@Qualifier("tpc_mr") MentorRepository mentorRepository,
                                     ProductRepository productRepository,
                                     CategoryRepository categoryRepository,
                                     PriceRepository priceRepository) {

        this.mentorRepository = mentorRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Mentor mentor = new Mentor();
        mentor.setName("ABC");
        mentor.setEmail("abc@gmail.com");
        mentor.setAverageRating(4.65);
        mentorRepository.save(mentor);

        Category category = new Category();
        category.setName("Apple Mobiles");
        Category savedcategory = categoryRepository.save(category);

        Price price = new Price();
        price.setPrice(500);
        Price savedprice = priceRepository.save(price);

        Product product = new Product();
        product.setTitle("Iphone 14");
        product.setDescription("A good Mobile");
        product.setPrice(savedprice);
        product.setCategory(savedcategory);

        productRepository.save(product);

    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }


}
