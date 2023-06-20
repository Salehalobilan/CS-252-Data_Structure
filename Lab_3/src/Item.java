public abstract class Item {

    private final String id;
    private double price;
    private int quantity;

    public Item(String id, double price, int quantity) {
        this.id = id;
        this.setPrice(price);
        this.setQuantity(quantity);
    }

    public String getID() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID= %s , Price= %.2f , Quantity= %d",id ,price ,quantity );
    }

}