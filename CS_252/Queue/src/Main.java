public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}



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
    private Node<E> curr;
    private int size;

    singlyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E e) {
        head = new Node(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void add(E e, int index) {
        if (index < 0 || index > size) {
            System.out.println("Error : index out of bounds ");

            return;
        }

        Node<E> newest = new Node(e, null);
        if (index == 0) {
            newest.setNext(head);
            head = newest;
            if (tail == null)
                tail = head;
        } else {
            Node<E> curr = head;
            for (int i = 0; i < index - 1; i++)
                curr = curr.getNext();

            newest.setNext(curr.getNext());

            curr.setNext(newest);

            if (tail == curr)
                tail = tail.getNext();
        }

        size++;
    }

    public void print() {
        System.out.println("PRint LL");
        Node<E> curr = head;
        for (int i = 0; i < size; i++) {
            System.out.println(curr.getElement());
            curr = curr.getNext();
        }

    }

    public E first() {
        if (isEmpty())
            return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    public boolean isEmpty() {
        return size == 0;
        // return head == null ;
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

    public E remove(int index) {
        if (index < 0 || index > size) {
            System.out.println("Error : index out of bounds ");

            return null;
        }
        E relement;
        if (index == 0) {
            // remove first elelement
            relement = head.getElement();
            head = head.getNext();

            if (head == null)
                tail = null;
        } else {
            Node<E> curr = head;
            for (int i = 0; i < index - 1; i++)
                curr = curr.getNext();
            relement = curr.getNext().getElement();

            // if the removed element is the last one
            if (tail == curr.getNext())
                tail = curr;

            curr.setNext(curr.getNext().getNext());
        }
        size--;
        return relement;
    }

    public void moveToStart() {
        curr = head;
    }

    public void moveToEnd() {
        curr = tail;
    }

    public void next() {
        if (curr != tail)
            curr = curr.getNext();

    }

    public E getValue() {
        return curr.getElement();

    }

    public int currPos() {
        Node<E> temp = head;
        int i = 0;
        while (temp != curr) {
            temp = temp.getNext();
            i++;
        }

        return i;

    }

    public void moveToPos(int index) {
        if (index < 0 || index > size) {
            System.out.println("Error : Position out of range ");

        } else {
            curr = head;
            for (int i = 0; i < index; i++)
                curr = curr.getNext();
        }
    }

    public int size() {
        return size;
    }
}