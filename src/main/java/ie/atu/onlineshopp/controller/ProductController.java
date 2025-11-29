package ie.atu.onlineshopp.controller;

import ie.atu.onlineshopp.model.Product;
import ie.atu.onlineshopp.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/Products")
public class ProductController
{
  private ProductService productService;

  public ProductController (ProductService productService)
  {
      this.productService = productService;
  }

  @GetMapping
    public ResponseEntity<List<Product>> getAll()
  {
      return ResponseEntity.ok(service.findAll());
  }

}
