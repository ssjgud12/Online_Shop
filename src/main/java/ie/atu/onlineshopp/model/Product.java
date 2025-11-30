package ie.atu.onlineshopp.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class Product
{
    private String name;
    private double price;
    private int quantity;
    private String category;
    private String description;
    private String image;
    private int id;
    private String manufacturer;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

}
