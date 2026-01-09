package ie.atu.onlineshopp.controller;

import ie.atu.onlineshopp.model.Product;
import ie.atu.onlineshopp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // CREATE - POST
    @PostMapping("{Create}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@Valid @RequestBody Product product)
    {
        return service.create(product);
    }

    // READ ALL - GET
    @GetMapping("{Read}")
    public List<Product> getAllProducts()
    {
        return service.getAllProducts();
    }

    @PutMapping("/{Update}")
    public Product updateProduct(@PathVariable int id, @Valid @RequestBody Product product)
    {

        return service.updateProduct(id, product);
    }

    @DeleteMapping("/{Delete}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id)
    {
        service.deleteProduct(id);
    }

}