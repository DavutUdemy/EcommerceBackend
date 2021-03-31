package com.ecommerce.EcommerceTest.Cart;


import com.ecommerce.EcommerceTest.Products.Product;
import com.ecommerce.EcommerceTest.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query("SELECT s FROM Cart s WHERE s.productName=?1")
    Optional<Cart> findCartByName(String productName);
    @Query("SELECT s FROM Cart s WHERE s.email=?1")
    Optional<Cart> findUserByEmail(String email);

}