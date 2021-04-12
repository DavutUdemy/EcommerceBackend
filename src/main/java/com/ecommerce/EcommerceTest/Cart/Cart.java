package com.ecommerce.EcommerceTest.Cart;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table
public class Cart {
    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"

    )
    private Long id;
    private String productName;
    private String productDesc;
    private int productPrice;
    private int productQuantity;
    private String email;
    @Transient
    private int total;

    public Cart() {

    }

    public Cart(Long id, String productName, String productDesc, int productPrice, int productQuantity, String email, int total) {
        this.id = id;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.email = email;
        this.total = total;
    }

    public Cart(String productName, String productDesc, int productPrice, int productQuantity, String email, int total) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.email = email;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotal() {
        return this.productQuantity*this.productPrice;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

