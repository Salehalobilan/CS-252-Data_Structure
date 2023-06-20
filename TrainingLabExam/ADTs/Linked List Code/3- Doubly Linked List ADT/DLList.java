public class DLList<T> {

    private Node<T> head;
    private Node<T> last;

    private int size;

    public DLList() {

        head = null;
        last = null;
        size = 0;
    }
//Remove all elements

    public void clear() {
        head = last = null;
        size = 0;
    }
// access methods

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T data) {
        Node<T> temp = new Node<>(data, null, null);
        if (head == null) {
            head = last = temp;
        } else {
            last.next = temp;
            temp.prev = last;
            last = temp;
        }
        size++;
    }

    /**
     * add "element" at specific position
     */
    public void add(T data, int index) {
        if (index > size || index < 0) {
            System.out.println("Index out of bounds");
            return;
        }

        Node<T> temp = new Node<>(data, null, null);
        if (index == 0) { 	// Add at the front or empty list
            if (head != null) {
                temp.next = head;
                head.prev = temp;
                head = temp;
            } else // If list is empty 
            {
                last = head = temp;
            }
        } else { 		// Add at the middle 
            Node<T> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            temp.next = curr.next;
            temp.prev = curr;
            if (curr.next != null) {
                curr.next.prev = temp;
            }
            curr.next = temp;

            if (last == curr) // Add at the end 
            {
                last = last.next;
            }
        }
        size++;
    }

    /**
     * Remove and return the removed data
     */
    public T remove(int index) {
        if (index >= size || index < 0) {
            System.out.println("Index out of bounds");
            return null;
        }
        T data;
        if (index == 0) { // remove front element 
            data = head.data;
            head = head.next;
            head.prev = null;
            if (head == null) // become empty list
            {
                last = null;
            }
        } else {
            Node<T> curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            data = curr.next.data;
            if (last == curr.next) // remove last element 
            {
                last = curr;
            }
            curr.next = curr.next.next; // Remove from list
            if (curr.next != null) {
                curr.next.prev = curr;
            }
        }
        size--;// Decrement count
        return data; // Return value
    }

    public T getValue(int index) {
        Node<T> curr = head;
        if (index < 0 || index >= size) {
            System.out.println("Index out of range!");
            return null;
        } else {

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

        }
        return curr.data;
    }

    public void setValue(T data, int index) {
        Node<T> curr = head;
        if (index < 0 || index >= size) {
            System.out.println("Index out of range!");
        } else {

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            curr.data = data;
        }
    }

}
