package ie.atu.onlineshopp.model;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class Basket {
    private List<BasketItem> items;
    private double totalPrice;

    public Basket()
    {
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }


    public static class BasketItem {
        private String name;
        private double price;
        private int quantity;

        public BasketItem() {}

        public BasketItem(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }


        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        public double getTotalPrice() {
            return price * quantity;
        }
    }


    public void addItem(String name, double price, int quantity)
    {

    }

    public void addItem(String name, double price) {
        addItem(name, price, 1);
    }

    public void removeItem(String name) {
        items.removeIf(item -> item.getName().equalsIgnoreCase(name));
        calculateTotal();
    }

    public void clear() {
        items.clear();
        totalPrice = 0.0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getTotalItemCount() {
        return items.stream().mapToInt(BasketItem::getQuantity).sum();
    }

    public int getUniqueItemCount() {
        return items.size();
    }

    public List<BasketItem> getItems() {
        return new ArrayList<>(items);
    }

    private void calculateTotal() {
        totalPrice = items.stream()
                .mapToDouble(BasketItem::getTotalPrice)
                .sum();
    }
}