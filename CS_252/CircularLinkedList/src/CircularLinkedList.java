
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
//////////////////////////////////////////////////////

public class CircularLinkedList {


     static/**حطيته بس عشان أحل مشكلة صارت بالماين->*/ class CircularlyLinkedList<E> {
        private Node<E> tail = null;
        // private Node<E> curr;
        private int size = 0;

        public CircularlyLinkedList() {
        }

        public boolean isEmpty() {
            return size == 0;
            // return tail == null ;
        }

        public int size() {
            System.out.println("cll size now is: " + this.size);
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

        public void addFirst(E element) {
            if (size == 0) {
                tail = new Node(element, null);
                tail.setNext(tail);

            } else {
                Node<E> newest = new Node(element, tail.getNext());
                tail.setNext(newest);
            }
            size++;
        }

        public void addLast(E element) {
            addFirst(element);
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
            System.out.println("\nthe CLL is: ");
            if (isEmpty())
                return;
            Node<E> curr = tail.getNext();
            for (int i = 0; i < size; i++) {

                System.out.print("["+ curr.getElement()+"] , " );
                curr = curr.getNext();
            }


        }
    }


    //-------------------------------------------------------------
    public static void main(String[] args) {

        CircularlyLinkedList cll = new CircularlyLinkedList();
        //System.out.println();
        cll.size();
        cll.addFirst(10);
        cll.size();
        cll.addFirst(2);
        cll.print();
        cll.removeFirst();
        cll.print();
        cll.addLast("X");
        cll.addFirst(true);
       // cll.rotate();
        System.out.println("\n"+cll.first());
        System.out.println(cll.last());
        cll.print();

    }



}
