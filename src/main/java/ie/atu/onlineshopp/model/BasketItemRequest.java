package ie.atu.onlineshopp.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class BasketItemRequest
{
    @NotBlank
    private String Name;

    @Positive
    private double Price;

    @Min(1)
    private int Quantity = 1;
}
