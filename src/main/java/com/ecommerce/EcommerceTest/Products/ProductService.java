package com.ecommerce.EcommerceTest.Products;


import com.ecommerce.EcommerceTest.Cart.Cart;
import com.ecommerce.EcommerceTest.Cart.CartRepository;
import com.ecommerce.EcommerceTest.Users.User;
import com.ecommerce.EcommerceTest.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public  List<Product> getProducts(ProductRepository
                                              productRepository) {
        return productRepository.findAll();
    }




    public void addNewProduct(Product product) {
        Optional<Product> productByName = productRepository.findProductByName(product.getProductName());
        if(productByName.isPresent()){
            throw  new IllegalStateException("email is taken");

        }
        productRepository.save(product);
        //System.out.println("user created");

    }    public static void deleteProduct(Long id, ProductRepository productRepository) {

        boolean b = productRepository.existsById(id);
        if (!b) {

            throw new IllegalStateException("student is unnormal");
        }
        productRepository.deleteById(id);

    }


    public Optional<Product> findProductByName(String productname, ProductRepository productRepository) {
        return productRepository.findProductByName(productname);

    }
     public void deleteAllProduct(ProductRepository productReposit)
     {
         productRepository.deleteAll();
     }

}

