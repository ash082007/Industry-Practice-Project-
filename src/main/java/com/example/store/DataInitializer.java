package com.example.store;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public DataInitializer(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        // Create Default User if table is empty
        if (userRepository.count() == 0) {
            userRepository.save(new User("admin", "admin123"));
        }

        // Seed Products
        if (productRepository.count() == 0) {
            productRepository.saveAll(List.of(
                // Mobiles
                new Product("Smartphone 12 Pro", "Mobiles", 79999.00, "https://via.placeholder.com/200x160/333/FFF?text=Smartphone", 12),
                new Product("Samsung Galaxy S23", "Mobiles", 89999.00, "https://via.placeholder.com/200x160/1a5276/FFF?text=Galaxy+S23", 8),
                new Product("iPhone SE", "Mobiles", 42900.00, "https://via.placeholder.com/200x160/512e5f/FFF?text=iPhone+SE", 15),
                new Product("Google Pixel 8", "Mobiles", 69900.00, "https://via.placeholder.com/200x160/2e4053/FFF?text=Pixel+8", 5),

                // Books
                new Product("The Great Gatsby", "Books", 1499.00, "https://via.placeholder.com/200x160/2c3e50/FFF?text=Great+Gatsby", 25),
                new Product("Atomic Habits", "Books", 1820.00, "https://via.placeholder.com/200x160/27ae60/FFF?text=Atomic+Habits", 30),
                new Product("Clean Code", "Books", 3450.00, "https://via.placeholder.com/200x160/16a085/FFF?text=Clean+Code", 10),
                new Product("Design Patterns", "Books", 4500.00, "https://via.placeholder.com/200x160/884ea0/FFF?text=Design+Patterns", 7),

                // Electronics
                new Product("Wireless Headphones", "Electronics", 12950.00, "https://via.placeholder.com/200x160/8e44ad/FFF?text=Headphones", 14),
                new Product("Smart Watch Series 5", "Electronics", 24999.00, "https://via.placeholder.com/200x160/2980b9/FFF?text=Smartwatch", 9),
                new Product("Bluetooth Speaker", "Electronics", 5999.00, "https://via.placeholder.com/200x160/d35400/FFF?text=Speaker", 20),
                new Product("Noise Cancelling Earbuds", "Electronics", 17999.00, "https://via.placeholder.com/200x160/7d6608/FFF?text=Earbuds", 11),

                // Computers
                new Product("Gaming Laptop 15\"", "Computers", 119900.00, "https://via.placeholder.com/200x160/7f8c8d/FFF?text=Laptop", 4),
                new Product("Mechanical Keyboard", "Computers", 8999.00, "https://via.placeholder.com/200x160/c0392b/FFF?text=Keyboard", 18),
                new Product("Ergonomic Mouse", "Computers", 4999.00, "https://via.placeholder.com/200x160/f39c12/FFF?text=Mouse", 22),
                new Product("4K Ultra Monitor 27\"", "Computers", 32999.00, "https://via.placeholder.com/200x160/1b4f72/FFF?text=4K+Monitor", 6),

                // Home & Kitchen
                new Product("Espresso Coffee Maker", "Home & Kitchen", 14999.00, "https://via.placeholder.com/200x160/6e2c00/FFF?text=Coffee+Maker", 13),
                new Product("Air Fryer XL", "Home & Kitchen", 9999.00, "https://via.placeholder.com/200x160/17202a/FFF?text=Air+Fryer", 16),
                new Product("Robot Vacuum Cleaner", "Home & Kitchen", 21900.00, "https://via.placeholder.com/200x160/4a235a/FFF?text=Robot+Vacuum", 5),
                new Product("Electric Kettle 1.7L", "Home & Kitchen", 2999.00, "https://via.placeholder.com/200x160/117a65/FFF?text=Kettle", 24),

                // Accessories
                new Product("Leather Backpack", "Accessories", 6500.00, "https://via.placeholder.com/200x160/78281f/FFF?text=Backpack", 17),
                new Product("Polarized Sunglasses", "Accessories", 3550.00, "https://via.placeholder.com/200x160/1f618d/FFF?text=Sunglasses", 21),
                new Product("Stainless Steel Water Bottle", "Accessories", 2200.00, "https://via.placeholder.com/200x160/145a32/FFF?text=Water+Bottle", 35),
                new Product("Fast Wireless Charger Pad", "Accessories", 1999.00, "https://via.placeholder.com/200x160/4d5656/FFF?text=Wireless+Charger", 40)
            ));
        }
    }
}
