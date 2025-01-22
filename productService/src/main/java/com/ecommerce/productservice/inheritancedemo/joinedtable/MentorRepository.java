package com.ecommerce.productservice.inheritancedemo.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jt_mr")
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    }