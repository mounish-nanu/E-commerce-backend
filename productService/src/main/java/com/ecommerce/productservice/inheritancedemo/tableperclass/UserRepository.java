package com.ecommerce.productservice.inheritancedemo.tableperclass;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_ur")
public interface UserRepository extends JpaRepository<User, Long> {
}
