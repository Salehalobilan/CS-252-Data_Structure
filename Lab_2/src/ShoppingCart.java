public class ShoppingCart  {
    private Item[] items = new Item[MAX_SIZE];
    private static final int MAX_SIZE = 8;
    private int itemCount = 0;

    public boolean addItem(Item itemX) {    //Big (O) is 1
        if (this.itemCount < MAX_SIZE) {
            this.items[this.itemCount++] = itemX;
            System.out.println("The item in you cart now");
            return true;
        }
        else {
            System.out.println("can't add; because your cart is full");
            return false;
        }
    }

    public boolean removeItem(String itemId) {

        for (int i = 0; i < itemCount; i++) {        //Big (O) is 1
            if (items[i].getID().equals(itemId)) {
                itemCount--;
                if (i != itemCount)
                    items[i] = items[itemCount];
                items[itemCount] = null;
                System.out.println("The item has removed from your cart now");
                return true;
            }
        }
        System.out.println("can't remove; the item not found");
        return false;
    }

    public void viewItems() {
        System.out.println(toString());     //Big (O) is 1
    }

    @Override
    public String toString() {
        String cartItems = "There are " + itemCount + " item(s) in your cart.\n";
        for (int i = 0; i < itemCount; i++) {
            cartItems += (i + 1) + " -" + items[i];
        }
        return cartItems;
    }

    public int getItemCount() {
        return itemCount;
    }


            protected int productCount = 0;
            protected Item[] StoreProducts = new Item[MAX_PRODUCTS];
            protected static int MAX_PRODUCTS = 100;
    public Item searchByID(String id) {

        for (int i = 0; i < productCount; i++) {    //Big (O) is 1
            if (StoreProducts[i].getID().equalsIgnoreCase(id))             //
                return StoreProducts[i];
        }
        return null;
    }

}
