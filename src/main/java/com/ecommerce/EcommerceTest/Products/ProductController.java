package com.ecommerce.EcommerceTest.Products;

import com.ecommerce.EcommerceTest.Users.User;
import com.ecommerce.EcommerceTest.Users.UsersRepository;
import com.ecommerce.EcommerceTest.Users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(path = "api/v3/product")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;
    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService =productService ;
        this.productRepository = productRepository;
    }
    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts(productRepository);
    }
    @PostMapping
    public void addNewUsers(@RequestBody Product product){
        productService.addNewProduct(product);
    }





}

