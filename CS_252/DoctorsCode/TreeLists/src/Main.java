public class Main {
}


//SLL Node for Queue ADT for the breadthFirstOrder Method that needs Queue method
class Node<E> {
    private E element;
    private Node<E> next;

    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }
}
class singlyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    //private Node<E> curr;
    private int size;

    singlyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
        // return head == null ;
    }
    public int size() {
        return size;
    }

    public E first() {
        if (isEmpty())
            return null;
        return head.getElement();
    }


    public void addLast(E e) {
        Node<E> newest = new Node(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;

    }
    public E removeFirst() {
        if (isEmpty())
            return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;

        return answer;
    }

}