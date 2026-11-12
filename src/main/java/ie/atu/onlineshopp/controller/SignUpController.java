package ie.atu.onlineshopp.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign-up")
public class SignUpController
{

    @GetMapping
    public String SignUp ( @RequestParam @Email String email,  @RequestParam @NotBlank String password)
    {
        return "Customer signed up with Email: " + email + " and Password: " + password;
    }

}
