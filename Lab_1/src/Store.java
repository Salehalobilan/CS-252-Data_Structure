public abstract class Store {
    protected String storeName;
    protected static int MAX_PRODUCTS = 100;
    protected int productCount = 0;

    protected ShoppingCart customerCart = new ShoppingCart();
    protected Item[] StoreProducts = new Item[MAX_PRODUCTS];

    public abstract void readProduct(String fileName)throws Exception;
    public abstract void viewProduct();

    public Item searchByID(String id) {
        for (int i = 0; i < productCount; i++) {
            if (StoreProducts[i].getID().equalsIgnoreCase(id))
                return StoreProducts[i];
        }
        return null;
    }
}
