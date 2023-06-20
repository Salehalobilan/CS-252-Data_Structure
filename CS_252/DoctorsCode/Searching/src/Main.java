public class Main {

    public static void main(String[] args) {


          singlyLinkedList<Integer> sll = new singlyLinkedList<>();
          sll.addFirst(10);
          sll.addFirst(14);
          sll.add(11, 1);
          sll.addLast(20);

          sll.print();
          sll.remove(3);
          sll.print();


          CircularlyLinkedList<Integer> cll = new CircularlyLinkedList();
          cll.addFirst(10);
          cll.addFirst(2);
          cll.print();
          cll.removeFirst();
          cll.print();




        DoublyLinkedList<Integer> dll = new DoublyLinkedList();
        dll.addFirst(10);
        dll.addLast(12);
        dll.addLast(13);
        dll.add(11, 0);
        dll.print();
        dll.removeFirst();
        dll.print();
        System.out.println("Mid is " + dll.middle().getElement());



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


    public void SwapNodes() {
        if(head == null || head.getNext() == null)
            return ;

        if(size == 2) {
            Node<E> temp = head;
            head = tail;
            tail = temp;
            head.setNext(tail);
            tail.setNext(null);
        }
        else {
            Node<E> F = head;
            Node<E> L = tail;

            head = head.getNext();
            Node<E> curr = head;
            while(curr.getNext() != tail)
                curr = curr.getNext();

            tail = curr;
            tail.setNext(null);

            L.setNext(F);
            tail= tail.getNext();
        }



    }

}













class CircularlyLinkedList<E> {
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
            tail = new Node(e, null);
            tail.setNext(tail);

        } else {
            Node<E> newest = new Node(e, tail.getNext());
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
        System.out.println("Print CLL");
        if (isEmpty())
            return;
        Node<E> curr = tail.getNext();
        for (int i = 0; i < size; i++) {
            System.out.println(curr.getElement());
            curr = curr.getNext();
        }

    }
}















class NodeDLL<E> {
    private E element;
    private NodeDLL<E> next;
    private NodeDLL<E> prev;

    public NodeDLL(E element, NodeDLL<E> prev, NodeDLL<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(NodeDLL<E> next) {
        this.next = next;
    }

    public void setPrev(NodeDLL<E> prev) {
        this.prev = prev;
    }

    public E getElement() {
        return element;
    }

    public NodeDLL<E> getNext() {
        return next;
    }

    public NodeDLL<E> getPrev() {
        return prev;
    }
}







class DoublyLinkedList<E> {
    private NodeDLL<E> header;
    private NodeDLL<E> trailer;

    private int size = 0;

    DoublyLinkedList() {
        header = new NodeDLL(null, null, null);
        trailer = new NodeDLL(null, header, null);
        header.setNext(trailer);
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
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public void add(E e, int index) {
        if (index < 0 || index > size) {
            System.out.println("Error : index out of bounds ");
            return;
        }
        if (index == 0)
            addFirst(e);
        else {
            NodeDLL<E> curr = header.getNext();
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            addBetween(e, curr, curr.getNext());
        }
    }

    public void addBetween(E e, NodeDLL<E> pre, NodeDLL<E> succ) {
        NodeDLL<E> newest = new NodeDLL(e, pre, succ);
        pre.setNext(newest);
        succ.setPrev(newest);
        size++;
    }

    public E removeFirst() {
        if (isEmpty())
            return null;

        return remove(header.getNext());
    }

    public E removeLast() {
        if (isEmpty())
            return null;

        return remove(trailer.getPrev());
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            System.out.println("Error : index out of bounds ");
            return null;
        }
        if (index == 0)
            return removeFirst();
        else {
            NodeDLL<E> curr = header.getNext();
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
            return remove(curr);
        }

    }

    private E remove(NodeDLL<E> node) {
        NodeDLL<E> pre = node.getPrev();
        NodeDLL<E> succ = node.getNext();
        pre.setNext(succ);
        succ.setPrev(pre);
        size--;
        return node.getElement();
    }

    /* finding the middle node of a doubly
     linked list with header and trailer*/
    public NodeDLL<E> middle() {
        NodeDLL<E> h = header.getNext();
        NodeDLL<E> t = trailer.getPrev();
        while (h != t && h.getNext() != t) {
            h = h.getNext();
            t = t.getPrev();
        }

        return t;
    }

    public void print() {
        System.out.println("Print DLL");
        if (isEmpty())
            return;
        NodeDLL<E> curr = header.getNext();
        for (int i = 0; i < size; i++) {
            System.out.println(curr.getElement());
            curr = curr.getNext();
        }

    }}