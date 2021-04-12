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

      static List<Cart> findUserByEmail(String email, CartRepository cartRepository) {
return cartRepository.findUserByEmail(email);
    }

    public static void deleteAll(CartRepository cartRepository) {
        cartRepository.deleteAll();
    }


     public  void  addToCart(Cart cart,CartRepository cartRepository) {

        
      
             cartRepository.save(cart);
        

    }

    private void useful(Cart cart) {
        Long id = cart.getId();
        int a  = Integer.parseInt(String.valueOf(id));
        int b = a;
        Long l= new Long(b);//first way.
        cartRepository.deleteById(l);

    }


    public static void deleteCart(Long id, CartRepository cartRepository) {

        boolean b = cartRepository.existsById(id);
        if (!b) {

            throw new IllegalStateException("student is unnormal");
        }
        cartRepository.deleteById(id);

    }









}


