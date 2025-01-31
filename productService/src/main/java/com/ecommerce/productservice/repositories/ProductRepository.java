package com.ecommerce.productservice.repositories;

import com.ecommerce.productservice.models.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {


//    Product findByTitleEquals(String title);
//
//    Product findByTitleEqualsAndPrice_Price(String title, double price);
//
//    List<Product> findAllByPrice_Currency(String Currency);
//

    Product findByUuid(UUID uuid);

    @Override
    void deleteById(UUID uuid);

    @Query("update Product p set p.title = :title, p.price.price = :price, p.category.name = :category, p.description = :description  where p.uuid = :uuid")
    @Modifying
    @Transactional
    void updateByUuid(UUID uuid, Product p);

    @Query(value = "select * from product where title = :title",nativeQuery = true)
    List<Product> findAllByTitle(String title);
}
