class CNode<E> {

    private E element;
    private CNode<E> next;

    public CNode(E element, CNode<E> next) {
        this.element = element;
        this.next = next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(CNode<E> next) {
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public CNode<E> getNext() {
        return next;
    }
}
//////////////////////////////////////////////////////
public class ClinkedList {
    static/**حطيته بس عشان أحل مشكلة صارت بالماين*/ class CircularlyLinkedList<E> {
    private CNode<E> tail = null;
    // private Node<E> curr;
    private int size = 0;

    public CircularlyLinkedList() {
    }

    public boolean isEmpty() {
        return size == 0;
        // return tail == null ;
    }

    public int size() {
        return size;
    }

    public E first() {
        if (isEmpty())
            return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    public void addFirst(E e) {
        if (size == 0) {
            tail = new CNode<>(e, null);
            tail.setNext(tail);

        } else {
            CNode<E> newest = new CNode(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (isEmpty())
            return null;

        // Node<E> head = tail.getNext();
        E removed = tail.getNext().getElement();
        if (tail.getNext() == tail)
            tail = null;
        else
            tail.setNext(tail.getNext().getNext());
        size--;
        return removed;
    }

    public void print() {
        //System.out.println("Print CLL");
        if (isEmpty())
            return;
        CNode<E> curr = tail.getNext();
        for (int i = 0; i < size; i++) {
            System.out.println(curr.getElement());
            curr = curr.getNext();
        }

    }
}


    //-------------------------------------------------------------
    public static void main(String[] args) {

        CircularlyLinkedList<Integer> cll = new CircularlyLinkedList();
        cll.addFirst(10);
        cll.addFirst(2);
        cll.print();
        cll.removeFirst();
        cll.print();

    }



}