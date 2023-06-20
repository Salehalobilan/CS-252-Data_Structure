public class ShoppingCart {
    
    private singlyLinkedList<Item> items = new singlyLinkedList<>();

    public void addItem(Item item1) {

            this.items.addLast(item1);
            System.out.println("Item successfully added to your cart");
    }

    public boolean removeItem(String itemId) {

        items.moveToStart();
        for (int i = 0; i < items.size(); i++) {
            if(items.getValue().getID().equals(itemId)){
                items.remove(i);
                System.out.println("Item successfully removed from your cart");
                return true;
            }
            items.next();
        }
        System.out.println("Failed to remove, the item not found in your cart");
        return false;
    }

    
    public void viewItems() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        String cartItems = "There are " + items.size() + " item(s) in your cart.\n";
        items.moveToStart();
        for (int i = 0; i < items.size(); i++) {
            cartItems += (i + 1) + " -" + items.getValue();
            items.next();
        }
        return cartItems;
    }

    public int getItemCount() {
        return items.size();
    }
    


}
