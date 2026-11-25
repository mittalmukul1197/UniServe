package model;

public class MenuItem {

    private int id;
    private String name;
    private double price;
    private Category category;
    private boolean available;

    public MenuItem(int id, String name, double price,
                    Category category, boolean available) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {

        return "ID: " + id +
                " | Name: " + name +
                " | Price: Rs." + price +
                " | Category: " + category +
                " | Available: " + available;
    }

    
}
