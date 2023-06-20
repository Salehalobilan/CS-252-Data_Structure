public abstract class Item {
    private final String id;
    private double price;
    private int quantity;

    public Item(String id, double price, int quantity) {
        this.id = id;
        this.setPrice(price);
        this.setQuantity(quantity);
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getID() {
        return id;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

}
