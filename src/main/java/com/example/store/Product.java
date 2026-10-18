package com.example.store;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String category;
    private Double price;
    private String image;
    private Integer stock; // New column for available quantity

    public Product() {}

    public Product(String title, String category, Double price, String image, Integer stock) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.image = image;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public Double getPrice() { return price; }
    public String getImage() { return image; }
    public Integer getStock() { return stock; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(Double price) { this.price = price; }
    public void setImage(String image) { this.image = image; }
    public void setStock(Integer stock) { this.stock = stock; }
}
