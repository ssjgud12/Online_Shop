package ie.atu.onlineshopp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ie.atu.onlineshopp.model")
public class OnlineshoppApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineshoppApplication.class, args);
    }
}
