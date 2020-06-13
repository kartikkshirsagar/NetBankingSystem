package MallPack;

import java.util.NavigableMap;

public class Product {
    String Name;
    int id;
    int price;
    String description;
    int Quantity;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Product(String name, int id, int price, String description, int quantity) {
        Name = name;
        this.id = id;
        this.price = price;
        this.description = description;
        Quantity = quantity;
    }
    public Product(int  id,int price,int quantity){
        this.id=id;
        this.price=price;
        Quantity=quantity;
    }
}
