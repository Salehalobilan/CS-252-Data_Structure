package Question2;

// instance variables of the SinglyLinkedList
public class SinglyLinkedList<E> {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList<>();
        list.addFirst(10);
        list.addFirst(14);
        list.add(11, 1);
        list.addLast(20);


        list.print();
        list.MySwapTwoNodes();
        System.out.println("==============================");
        list.print();
    }

    private Node<E> head;
    private Node<E> tail;
    private Node<E> curr;   // Acess to current element
    private int size;

    public SinglyLinkedList() {

        head = null;
        tail = null;
        curr = null;
        size = 0;
    }
//Remove all elements

    public void clear() {
        head = tail = null;
        size = 0;
    }
// access methods

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // returns (but does not remove) the first element
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

// update methods
    public void addFirst(E e) { // adds element e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if (size == 0) {
            tail = head; // special case: new node becomes tail also
        }
        size++;
    }

    public void addLast(E e) { // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty()) {
            head = newest; // special case: previously empty list
        } else {
            tail.setNext(newest); // new node after existing tail
        }
        tail = newest; // new node becomes the tail
        size++;
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) {
            return null; // nothing to remove
        }
        E answer = head.getElement();
        head = head.getNext(); // will become null if list had only one node
        size--;
        if (size == 0) {
            tail = null; // special case as list is now empty
        }
        return answer;
    }

    // Add 
    public void add(E element, int index) {
        if (index < 0 || index > size) {
            System.out.println("Out of bound!");
            return;
        }
        Node<E> newest = new Node<E>(element, null);
        if (index == 0) // add at front
        {
            newest.setNext(head);
            head = newest;
            if (tail == null) {
                tail = head;
            }
        } else // add the middle 
        {
            curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            newest.setNext(curr.getNext());
            curr.setNext(newest);
            if (tail == curr) {
                tail = tail.getNext();
            }
        }
        size++;
    }

    //removing node at index i
    public E remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Out of bound!");
            return null;
        }
        E element;
        if (index == 0) // remove from front
        {
            element = head.getElement();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else {
            curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            element = curr.getNext().getElement();
            if (tail == curr.getNext()) {
                tail = curr;
            }
            curr.setNext(curr.getNext().getNext());
        }

        size--;
        return element;
    }

    // 
    public void moveToStart() {
        curr = head;
    }

    public void moveToEnd() {
        curr = tail;
    }

    public void next() {
        if (curr != tail) {
            curr = curr.getNext();
        }
    }

    public E getValue() {
        return curr.getElement();
    }

    //return the postion of current element
    public int CurrPos() {
        Node<E> temp = head;
        int i = 0;
        while (temp != curr) {
            temp = temp.getNext();
            i++;
        }
        return i;
    }

    //move curr to postion 
    public void moveToPos(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Position out of range!");
        } else {
            curr = head;
            for (int i = 0; i < pos; i++) {
                curr = curr.getNext();
            }
        }
    }

    public void print() {
        curr = head;
        while (curr != null) {
            System.out.println(curr.getElement());
            curr = curr.getNext();
        }
    }



    public void swapLastTwoNodes() {   //most correct one

        if(isEmpty()) {
            return;
        }
        Node last = tail;
        curr = head;

        while(curr.getNext().getNext() != tail) {
            curr = curr.getNext();
        }

        Node p = curr.getNext();
        tail = p;

        p.setNext(null);
        last.setNext(p);
        curr.setNext(last);

    }


    public void MySwapTwoNodes() {
//        Node<E> curr = new Node<E>();
        Node<E> curr = head;
        Node<E> last = tail;
        while(curr.getNext().getNext() != tail) {
            curr = curr.getNext();
        }
        Node<E> temp = curr.getNext();
        tail = temp;

        temp.setNext(null);
        last.setNext(temp);
        curr.setNext(last);
    }

    public void ChatSwapTwoNodes() {
        if (head == null || head.getNext() == null) {
            return; // there are less than two nodes in the list, nothing to swap
        }

        Node secondLast = null;
        Node last = head;
        while (last.getNext() != null) {
            secondLast = last;
            last = last.getNext();
        }

        secondLast.setNext(null); // set the second to last node's next pointer to null
        last.setNext(head.getNext());   // set the last node's next pointer to the second node
        head.setNext(last);  // set the head's next pointer to the last node

    }



    public void ADTSwapTwoNodes() {
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