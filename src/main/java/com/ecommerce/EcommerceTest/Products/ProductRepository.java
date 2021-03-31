package com.ecommerce.EcommerceTest.Products;

import com.ecommerce.EcommerceTest.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT s FROM Product s WHERE s.productName=?1")
    Optional<User> findProductByName(String productName);
}
