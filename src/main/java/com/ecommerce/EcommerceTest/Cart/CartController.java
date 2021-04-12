package com.ecommerce.EcommerceTest.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")

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
        cartService.addToCart(cart,cartRepository);
    }
    @DeleteMapping(path = "{id}")
    public void deleteCart(@PathVariable("id")Long id){
        CartService.deleteCart(id,cartRepository);
    }
    @GetMapping(path = "{email}")
    public List<Cart> findUserByEmail(@PathVariable String email ){

        return CartService.findUserByEmail(email,cartRepository);
    }
    @PutMapping("{productName}")
    void cartProduct(@RequestBody Cart cart, @PathVariable String productName) {
int productquantity = 5;

    }
    @DeleteMapping("all")
    public void deleteAll(){
        CartService.deleteAll(cartRepository);
    }








}

