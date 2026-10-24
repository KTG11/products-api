package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // 1. The List and the ID counter
    private final List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    // 2. Method to get all products
    public List<Product> getAllProducts() {
        return products;
    }

    // 3. Method to add a product
    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    // 4. Method to find one product by ID
    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id)) // Use .equals(), NOT ==
                .findFirst();
    }

    // 5. Method to delete a product
    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    // 6. Method to search by name
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }
}