package ie.atu.onlineshopp.controller;

import ie.atu.onlineshopp.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("product")
@RestController

public class ProductController
{

    List<Product> myList = new ArrayList<>();

    @GetMapping("/hello")

    public String hello()
    {
        return "Good Morning World";
    }

    @GetMapping("/getproduct")
    public Product getProduct()
    {
        Product myProduct = new Product("TV",677);
        return myProduct;
    }

    @GetMapping("/addProduct")
    public Product addProduct(@RequestBody Product myproduct)
    {
        myList.add(myproduct);
        return myproduct;
    }


}
