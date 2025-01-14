package com.ecommerce.productservice.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
@MappedSuperclass
@Getter
@Setter
public class User {
    @Id
    private long id;
    private String name;
    private String email;
}
