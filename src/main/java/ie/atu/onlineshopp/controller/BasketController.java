package ie.atu.onlineshopp.controller;

import ie.atu.onlineshopp.model.Basket;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/basket")
@Tag(name = "Basket Controller", description = "APIs for managing shopping basket")
public class BasketController {

    @Autowired
    private Basket basket;

    // Add item to basket
    @PostMapping("/add")
    @Operation(summary = "Add item to basket")
    public ResponseEntity<String> addItem(@RequestBody Map<String, Object> request) {
        try {
            String name = (String) request.get("name");
            double price = Double.parseDouble(request.get("price").toString());
            int quantity = Integer.parseInt(request.get("quantity").toString());

            basket.addItem(name, price, quantity);
            return ResponseEntity.ok("Item added to basket: " + name + " x" + quantity);
        } catch (Exception e)
        {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
