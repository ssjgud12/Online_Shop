package ie.atu.onlineshopp.controller;

import ie.atu.onlineshopp.model.Product;
import ie.atu.onlineshopp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Products")
public class ProductController
{
    List<Product> myList = new ArrayList<>();
//Bean created by Spring

  private final ProductService productService;
//Used to access product logic
  public ProductController (ProductService productService)
  {
      this.productService = productService;
  }
//Returns all products in the store
  @GetMapping
    public ResponseEntity<List<Product>> getAll()
  {
      return ResponseEntity.ok(productService.findAll());
  }


  //If a product with the Given id exists return it, If not return 404 Not found
    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable int id)
    {

        Optional<Product> maybe = productService.findById(id);
        if(maybe.isPresent())
        {
            return ResponseEntity.ok(maybe.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
    // This endpoint creates a new product evertthing except price and quantity are dummy values for now

    @GetMapping("display")
    public ResponseEntity<List<Product>> displayProducts()
    {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping("Add")
    public ResponseEntity<Product> create(@Valid @RequestBody Product p)
    {
        Product newProduct = productService.create(p);
        return ResponseEntity.created(URI.create("/api/Products/" + newProduct.getId())).body(newProduct);
    }

    @PutMapping("/Update{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product)
    {

        Optional<Product> updated = productService.update(id,product);
        return updated.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }




}
