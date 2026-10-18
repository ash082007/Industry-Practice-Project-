package com.example.store;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PostMapping("/checkout")
    public String checkout(@RequestBody List<CartItemDTO> cartItems) {
        for (CartItemDTO item : cartItems) {
            Product product = productRepository.findById(item.getProductId()).orElse(null);
            if (product != null && product.getStock() >= item.getQuantity()) {
                product.setStock(product.getStock() - item.getQuantity());
                productRepository.save(product);
            }
        }
        return "Order processed successfully!";
    }

    // Simple Data Transfer Object for incoming cart items
    public static class CartItemDTO {
        private Long productId;
        private Integer quantity;

        public Long getProductId() { return productId; }
        public Integer getQuantity() { return quantity; }
        public void setProductId(Long productId) { this.productId = productId; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }
    }
}
