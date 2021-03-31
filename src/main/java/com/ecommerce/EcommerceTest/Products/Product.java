package com.ecommerce.EcommerceTest.Products;

import javax.persistence.*;

@Entity
@Table
public class Product {


    @Id
    @SequenceGenerator(
            name = "products_sequence",
            sequenceName = "products_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "products_sequence"

    )
    private Long id;
    private String productName;
    private String productDesc;
    private String productPrice;

    public Product() {
    }

    public Product(Long id, String productName, String productDesc, String productPrice) {
        this.id = id;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

    public Product(String productName, String productDesc, String productPrice) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
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

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}