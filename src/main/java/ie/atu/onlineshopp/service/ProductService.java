package ie.atu.onlineshopp.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ie.atu.onlineshopp.model.Product;
import lombok.Builder;
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

    public Optional<Product> update(int id, Product updatedProduct)
    {
        for (int i = 0; i < store.size(); i++)
        {
            Product existing = store.get(i);
            if (existing.getId() == id)
            {
                existing.setName(updatedProduct.getName());
                existing.setDescription(updatedProduct.getDescription());
                existing.setPrice(updatedProduct.getPrice());
                existing.setQuantity(updatedProduct.getQuantity());
                existing.setCategory(updatedProduct.getCategory());
                existing.setImage(updatedProduct.getImage());
                existing.setManufacturer(updatedProduct.getManufacturer());


                store.set(i, existing);

                return Optional.of(existing);
            }
        }

        return Optional.empty();
    }


    public boolean delete(int id)
    {
        for (int i = 0; i < store.size(); i++)
        {
            Product p = store.get(i);


            if (p.getId() == id)
            {
                store.remove(i);
                return true;
            }
        }
        return false;

    }



}
