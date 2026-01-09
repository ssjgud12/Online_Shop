package ie.atu.onlineshopp.service;


import ie.atu.onlineshopp.repository.ProductRepository;
import ie.atu.onlineshopp.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;



@Service
public class ProductService
{

    private final ProductRepository repo;

    public ProductService(ProductRepository repo)
    {
        this.repo = repo;
    }

    public Product create(Product p)
    {
        return repo.save(p);
    }

    public List<Product> getAllProducts()
    {
        return repo.findAll();
    }



}
