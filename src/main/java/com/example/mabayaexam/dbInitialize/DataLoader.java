package com.example.mabayaexam.dbInitialize;

import com.example.mabayaexam.dbInitialize.DataInitializationProperties;
import com.example.mabayaexam.entities.Product;
import com.example.mabayaexam.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final DataInitializationProperties dataInitializationProperties;

    public DataLoader(ProductRepository productRepository, DataInitializationProperties dataInitializationProperties) {
        this.productRepository = productRepository;
        this.dataInitializationProperties = dataInitializationProperties;
    }

    @Override
    public void run(String... args) {
        if (dataInitializationProperties.isEnabled()) {
            generateAndSaveProducts();
        }
    }

    private void generateAndSaveProducts() {
        List<String> categories = Arrays.asList("Electronics", "Clothing", "Books", "Home Appliances");
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setTitle("Product " + i);
            product.setCategory(categories.get(random.nextInt(categories.size())));
            product.setPrice(random.nextDouble() * 1000); // Adjust the range based on your needs
            product.setSerialNumber("SN" + i);

            productRepository.save(product);
        }

        // Disable data initialization after the first run
        dataInitializationProperties.setEnabled(false);
    }
}