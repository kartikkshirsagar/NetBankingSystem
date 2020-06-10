package MallPack.Items;

public class Items {
    private int id;
    private String name;
    private String description;
    private ItemCate category;
    private double price;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ItemCate getCategory() {
        return category;
    }
    public void setCategory(ItemCate category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Items(int id, String name, String description, ItemCate category, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public Items() {}

    public String toString() {
        return (this.category + "\t\t " + this.name + " \nPrice: " + this.price + "");
    }


}

