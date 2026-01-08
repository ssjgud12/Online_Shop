package ie.atu.onlineshopp.service;

import ie.atu.onlineshopp.model.Basket;
import ie.atu.onlineshopp.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BasketService
{

    private final List<Basket> store = new ArrayList<>();

    public List<Basket> findAll()
    {
        return new ArrayList<>(store);
    }

    private AtomicInteger counter = new AtomicInteger(1);

    public Product create(Basket b)
    {
        b.setBasket(counter.getAndIncrement());
        store.add(b);
        return b;
    }


}
