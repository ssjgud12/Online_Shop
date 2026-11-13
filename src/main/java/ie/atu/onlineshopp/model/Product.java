package ie.atu.onlineshopp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
@Data // <--- This generates ALL getters, setters, and toStrings
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // Hides ID in Swagger
    
    
    private int id;
    
    private String name;
    
    @NotNull
    private double price;
    
    @NotNull
    private int quantity;
    
    @NotBlank
    private String category;
    
    @NotBlank
    private String description;
    
    @NotBlank
    private String image;
    
    @NotBlank
    private String manufacturer;
}