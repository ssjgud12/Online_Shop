package ie.atu.onlineshopp.service;

import ie.atu.onlineshopp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductService
{

    private final List<Product> store = new ArrayList<>();

    public List<Product> findAll() {
        return new ArrayList<>(store);
    }

    public Optional<Product> findById(int id)
    {
        for (Product product : store)
        {
            if (product.getId() == id)
            {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    private AtomicInteger counter = new AtomicInteger(1);

    public Product create(Product p)
    {
        p.setId(counter.getAndIncrement());
        store.add(p);
        return p;
    }



}
