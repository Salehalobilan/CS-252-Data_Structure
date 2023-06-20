public class List {
    Node n = new Node(5, null);
}


class Node <E>{
    private E element;
    private Node next;

    public Node(E e,Node n) {

        element = e;
        next = n;
    }

    public void setElement(E element) {
        this.element = element;
    }
    public E getElement() {
        return element;
    }

    public void setNext(Node next) {
         this.next = next;
    }
    public Node getNext() {
         return next;
    }




 }
