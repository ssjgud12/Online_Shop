package ie.atu.onlineshopp.service;

import ie.atu.onlineshopp.model.Basket;
import ie.atu.onlineshopp.model.BasketItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService
{
    private final Basket basket;

    @Autowired
    public BasketService(Basket basket)
    {
        this.basket = basket;
    }

    public Basket getBasket()
    {
        return basket;
    }

    public Basket addItem(BasketItemRequest request)
    {
        basket.addItem(request.getName(), request.getPrice(), request.getQuantity());
        return basket;
    }

    public Basket clearBasket()
    {
        basket.clear();
        return basket;
    }
}