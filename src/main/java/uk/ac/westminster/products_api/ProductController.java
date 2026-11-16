package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    // 1. Wire in the service
    @Autowired
    private ProductService productService;

    // 2. GET all producsats
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // 3. GET productinid
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    // 4. POST a new product
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // 5. DELETE a product
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // 6. SEARCH products by name
    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam String name) {
        return productService.findByName(name);
    }
}