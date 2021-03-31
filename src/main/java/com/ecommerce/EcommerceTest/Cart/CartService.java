package com.ecommerce.EcommerceTest.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public static List<Cart> getCartItems(CartRepository cartRepository) {

        return cartRepository.findAll();
    }

      static Optional<Cart> findbyemail(String email, CartRepository cartRepository) {
return cartRepository.findUserByEmail(email);
    }


    public void addToCart(Cart cart) {

        Optional<Cart> cartbyEmail = cartRepository.findCartByName(cart.getProductName());
        if (cartbyEmail.isPresent()) {
            System.out.println("hi");
        }
        cartRepository.save(cart);

    }


    public static void deleteCart(Long id, CartRepository cartRepository) {

        boolean b = cartRepository.existsById(id);
        if (!b) {

            throw new IllegalStateException("student is unnormal");
        }
        cartRepository.deleteById(id);

    }
}


