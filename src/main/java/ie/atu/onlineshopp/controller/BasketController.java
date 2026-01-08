package ie.atu.onlineshopp.controller;

import ie.atu.onlineshopp.model.Basket;
import ie.atu.onlineshopp.model.BasketItemRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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

    @PostMapping("/add")
    public ResponseEntity<Basket> addItem(@Valid @RequestBody BasketItemRequest request) {
        // Convert DTO → Domain Model
        basket.addItem(request.getName(), request.getPrice(), request.getQuantity());
        return ResponseEntity.ok(basket);
    }
}
