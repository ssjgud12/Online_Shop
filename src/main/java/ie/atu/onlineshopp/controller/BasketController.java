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
    private Basket basket;



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
    public ResponseEntity<Basket> addItem(@RequestBody BasketItemRequest request) {
        System.out.println("=== DEBUG ===");
        System.out.println("Name: " + request.getName());
        System.out.println("Price: " + request.getPrice());
        System.out.println("Quantity: " + request.getQuantity());

        Basket basket = basketService.addItem(request);
        System.out.println("Items in basket: " + basket.getItems().size());

        return ResponseEntity.ok(basket);
    }

    @DeleteMapping("/clear")
    @Operation(summary = "Clear basket", description = "Remove all items from the basket")
    public ResponseEntity<Basket> clearBasket()
    {
        Basket basket = basketService.clearBasket();
        return ResponseEntity.ok(basket);
    }

    @GetMapping("/summary")
    @Operation(summary = "Get basket summary", description = "Returns basket summary including total price and item count")
    public ResponseEntity<?> getBasketSummary()
    {
        Basket basket = basketService.getBasket();


        var summary = new Object()
        {
            public final double totalPrice = basket.getTotalPrice();
            public final int totalItems = basket.getTotalItemCount();
            public final int uniqueItems = basket.getUniqueItemCount();
        };

        return ResponseEntity.ok(summary);
    }

    @GetMapping("/items")
    @Operation(summary = "Get basket items", description = "Returns all items in the basket")
    public ResponseEntity<?> getBasketItems()
    {
        Basket basket = basketService.getBasket();
        return ResponseEntity.ok(basket.getItems());
    }

}
