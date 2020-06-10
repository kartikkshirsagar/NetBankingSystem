package MallPack.Items;

import java.util.*;

public class Order {
    private Long id;
    private Map<Items,Integer> currentOrder = new HashMap<>();
    private String status;
    private String customer;

    public void addToOrder(Items item, int quantity) {
        int currentQuantity = 0;
        if (currentOrder.get(item) != null) currentQuantity = currentOrder.get(item);
        currentOrder.put(item, currentQuantity + quantity);
    }

    public Double getOrderTotal() {
        double d = 0d;
        for (Items item : currentOrder.keySet()) {
            d += currentOrder.get(item) * item.getPrice();
        }
        return d;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Items item : currentOrder.keySet()) {
            sb.append(item.getName() + " : " + currentOrder.get(item) + "<br/>");
        }
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }
}
