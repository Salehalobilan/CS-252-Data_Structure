public abstract class Store {

    protected String storeName;
    protected static int MAX_PRODUCTS = 100;
    protected int productCount = 0;


    protected ShoppingCart customerCart = new ShoppingCart();
    protected singlyLinkedList<Item> StoreProducts = new singlyLinkedList<>();
    protected Item[] StoreProduct = new Item[MAX_PRODUCTS];

    public abstract void readProduct(String fileName) throws Exception;

    public abstract void viewProduct();

    public Item searchByID(String id) {
        StoreProducts.moveToStart();
        for (int i = 0; i < StoreProducts.size(); i++) {
            if (StoreProducts.getValue().getID().equalsIgnoreCase(id))
                return StoreProducts.getValue();
            StoreProducts.next();
        }
        return null;
    }

}
