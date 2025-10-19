package ie.atu.onlineshopp;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/product")
@RestController
public class ProductController {
    List<Product> myList = new ArrayList<>();
    @GetMapping("/hello")
    public String hello()
    {
        return "Good Morning World!";
    }

    @GetMapping("/getproducts")
    public List<Product> getProducts()
    {
        Product myProduct = new Product("Tv",677);
        return myList;
    }
    @PostMapping("/addProduct")
    public Product addProduct(@Valid @ie.atu.onlineshopp.RequestBody Product myproduct)
    {
        myList.add(myproduct);
        return myproduct;
    }
}