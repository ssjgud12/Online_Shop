package ie.atu.onlineshopp.controller;

import ie.atu.onlineshopp.model.Product;
import ie.atu.onlineshopp.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Products")
public class ProductController
{
  private final ProductService productService;

  public ProductController (ProductService productService)
  {
      this.productService = productService;
  }

  @GetMapping
    public ResponseEntity<List<Product>> getAll()
  {
      return ResponseEntity.ok(productService.findAll());
  }

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

}
