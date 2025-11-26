package ie.atu.onlineshopp.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Product
{
    @NotBlank
    private String name;

    @NotBlank
    private double price;

    @NotBlank
    private int quantity;

    @NotBlank
    private String category;

    @NotBlank
    @Size(min = 1, max = 200)
    private String description;

    @NotBlank
    private String image;

    @NotBlank
    @Size(min = 1, max = 1000)
    private int id;

    @NotBlank
    private String manufacturer;

    private String ProductName;
    private double Price;

    public Product(String ProductName, double Price)
    {
        this.ProductName = ProductName;
        this.Price = Price;
    }

}
