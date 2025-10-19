package ie.atu.onlineshopp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

public class Product
{
    @NotBlank
    private String ProductName;
    @Positive
    private double Price;
}
