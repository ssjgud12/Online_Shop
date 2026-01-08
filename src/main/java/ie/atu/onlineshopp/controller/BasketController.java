package ie.atu.onlineshopp.controller;

import ie.atu.onlineshopp.model.Basket;
import ie.atu.onlineshopp.model.BasketItemRequest;
import ie.atu.onlineshopp.service.BasketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/basket")
@Tag(name = "Basket Controller", description = "APIs for managing shopping basket")
public class BasketController
{
    private final BasketService basketService;



    @Autowired
    public BasketController(BasketService basketService)
    {
        this.basketService = basketService;
    }

    @GetMapping("/View")
    @Operation(summary = "Look at basket content", description = "Look at all the Products in your Basket")
    public ResponseEntity<Basket> getBasket()
    {
        Basket basket = basketService.getBasket();
        return ResponseEntity.ok(basket);
    }



    @PostMapping("/add")
    @Operation(summary = "Add Items to basket", description = "Add Products to your Basket")
    public ResponseEntity<Basket> addItem(@Valid @RequestBody BasketItemRequest request)
    {
        Basket basket = basketService.addItem(request);
        return ResponseEntity.ok(basket);
    }

    @DeleteMapping("/clear")
    @Operation(summary = "Clear basket", description = "Remove all items from the basket")
    public ResponseEntity<Basket> clearBasket()
    {
        Basket basket = basketService.clearBasket();
        return ResponseEntity.ok(basket);
    }


}
