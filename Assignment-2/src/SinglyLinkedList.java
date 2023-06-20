//Saleh Alobaylan 443014070
public class SinglyLinkedList <T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {

        head = null;
        tail = null;
        size = 0;

    }


    public boolean isEmpty() { return head == null; }



    ////////////////////////////////////////////////////
               // 1
    public void print() {

        System.out.print("Singly Linked List: [");

        Node<T> curr = head;
        for(int i = 0; i < size - 1; i++) {

            System.out.print(curr.getData() + ", ");
            curr = curr.getNext();

        }

        System.out.println(((tail == null)? "":tail.getData()) + "]");

    }
              // 2
    public T removeLast() {

        if(isEmpty()) {

            System.out.println("Error: empty linked list");
            return null;

        }

        T removedData = tail.getData();

        Node<T> curr = head;
        // do curr = curr.getNext();
        // while(curr.getNext() != tail);
        for(int i = 0; i < size - 2; i++)
            curr = curr.getNext();

        curr.setNext(null);
        tail = curr;

        size--;
        return removedData;
    }
              //  3
    public void removeAll() {
        head = null;
        tail = null;
        size = 0;
    }

           // 4
    public T get(int index) {

        if(index < 0 || index >= size){
            System.out.println("Error: index out of bounds");
            return null; }
        Node<T> curr = head;

        for(int i = 0; i < index; i++)
            curr = curr.getNext();

        return curr.getData();
    }

              //5
    public int search(T data) {

        Node<T> curr = head;
        int index = -1;
        for(int i = 0; i < size; i++) {
            if(curr.getData() == data) {
                index = i;
                break; }
            curr  = curr.getNext();
        }
        return index;
    }












    }
