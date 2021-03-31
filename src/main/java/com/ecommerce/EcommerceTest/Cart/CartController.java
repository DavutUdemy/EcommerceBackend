package com.ecommerce.EcommerceTest.Cart;

import com.ecommerce.EcommerceTest.Products.Product;
import com.ecommerce.EcommerceTest.Products.ProductRepository;
import com.ecommerce.EcommerceTest.Products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping(path = "api/v3/Card")
public class CartController {
    private final CartService cartService;
    private final CartRepository cartRepository;
    @Autowired
    public CartController(CartService cartService, CartRepository cartRepository) {
        this.cartService =cartService ;
        this.cartRepository = cartRepository;
    }
    @GetMapping
    public List<Cart> getCartItems(){
        return cartService.getCartItems(cartRepository);
    }
    @PostMapping
    public void addToCart(@RequestBody Cart cart){
        cartService.addToCart(cart);
    }
    @DeleteMapping(path = "{id}")
    public void deleteCart(@PathVariable("id")Long id){
        CartService.deleteCart(id,cartRepository);
    }
    @GetMapping(path = "{email}")
    public Optional<Cart> FilterById(@PathVariable String email ){

        return CartService.findbyemail(email,cartRepository);
    }







}

