package ie.atu.onlineshopp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Product
{

    @NotBlank
    private String name;

    @NotBlank
    @Email
    @Size(max = 60)
    private String email;
}
