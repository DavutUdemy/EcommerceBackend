package com.ecommerce.EcommerceTest.Cart;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query("SELECT s FROM Cart s WHERE s.productName=?1")
    List<Cart> findCartByName(String productName);
    @Query("SELECT s FROM Cart s WHERE s.email=?1")
    List<Cart> findUserByEmail(String email);

}