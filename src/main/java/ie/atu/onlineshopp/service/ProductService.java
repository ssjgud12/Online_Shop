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

    public Product getProductById(int id)
    {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }


    public Product create(Product p)
    {
        return repo.save(p);
    }

    public List<Product> getAllProducts()
    {
        return repo.findAll();
    }

    public Product updateProduct(int id, Product productDetails) {

        Product existingProduct = getProductById(id);


        existingProduct.setName(productDetails.getName());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setQuantity(productDetails.getQuantity());
        existingProduct.setCategory(productDetails.getCategory());
        existingProduct.setDescription(productDetails.getDescription());
        existingProduct.setImage(productDetails.getImage());
        existingProduct.setManufacturer(productDetails.getManufacturer());

        return repo.save(existingProduct);
    }

    public void deleteProduct(int id)
    {
        Product product = getProductById(id); // Corrected method call
        repo.delete(product);
    }





}
