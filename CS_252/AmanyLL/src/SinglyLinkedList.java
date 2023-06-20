// instance variables of the SinglyLinkedList
public class SinglyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private Node<E> curr;
    private int size;

    public SinglyLinkedList() {

        head = null;
        tail = null;
        curr = null;
        size = 0;
    }

// access methods
//    public int size() {//O(1)
//        return size;
//    }
    public boolean isEmpty() {//O(1)
        return size == 0;
    }

    public E first() { //O(1)
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() { //O(1)
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

// update methods
    public void addFirst(E e) { //O(1)
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) { //O(1)
        Node<E> newest = new Node<>(e, null); 
        if (isEmpty()) {
            head = newest; 
        } 
        else 
        {
            tail.setNext(newest); 
        }
        tail = newest; 
        size++;
    }
    public E removeFirst() { //O(1)
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }

    public E removeLast() { //O(n)
        if (isEmpty()) {
            return null;
        }
        E answer = tail.getElement();

        if (head == tail) {
            head = tail = null;
        } else {
            curr = head;
            while (curr.getNext() != tail) {
                curr = curr.getNext();
            }
            tail = curr;
            curr.setNext(null);

        }
        size--;
        return answer;
    }

    public void add(E element, int index)//O(n)
    {
        if (index < 0 || index > size) {
            System.out.println("Out of bound!");
            return;
        }
        Node<E> newest = new Node<E>(element, null);
        if (index == 0) {
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
    public E remove(int index) {//O(n)
        if (index < 0 || index >= size) {
            System.out.println("Out of bound!");
            return null;
        }
        E element;
        if (index == 0) {
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
            element = (E) curr.getNext().getElement();
            if (tail == curr.getNext()) {
                tail = curr;
            }
            curr.setNext(curr.getNext().getNext());
        }

        size--;
        return element;
    }

    public void print() {//O(n)
    
        if (head == null) {
            return;
        }

        curr = head;
        while (curr != null) {
            System.out.println(curr.getElement());
            curr = curr.getNext();
        }
    }

    public void moveToStart() {//O(1)
        curr = head;
    }

    public void next() {//O(1)
        if (curr != tail) {
            curr = curr.getNext();
        }
    }

    public void moveToEnd() {//O(1)
        curr = tail;
    }

    public E getValue() {//O(1)
        return curr.getElement();
    }

    //return the postion of current element
    public int CurrPos() {//O(n)
        Node<E> temp = head;
        int i = 0;
        while (temp != curr) {
            temp = temp.getNext();
            i++;
        }
        return i;
    }

    //move curr to postion 
    public void moveToPos(int pos) {//O(n)
        if (pos < 0 || pos >= size) {
            System.out.println("Position out of range!");
            return;
        } else {
            curr = head;
            for (int i = 0; i < pos; i++) {
                curr = curr.getNext();
            }
        }
    }

    //==================================
    //  Assume you did not have the tail attribute, rewrite the
//addLast(E e) method?
//    public void AddLast(E e) { //O(n)// 
//        Node<E> newest = new Node<>(e, null);
//        if (isEmpty()) {
//            head = newest;
//        } else {
//            Node tailCurr = head;
//            while (tailCurr.getNext() != null) {
//                tailCurr = tailCurr.getNext();
//            }
//
//            tailCurr.setNext(newest); // new node after existing tail
//            tailCurr = newest;
//        }
//        size++;
//    }
    //==================================
    //Write a method that remove all elements in a given
//SinglyLinkedList object.

    public void RemoveAll1()//o(1)
    {
        head = tail = null;
        size = 0;
    }

    //==================================
//  Give an implementation of the size( ) method for the
//SingularlyLinkedList class, assuming that we did not maintain
//size as an instance variable
    public int size() {//O(n)
        int counter = 0;
        Node curr = head;
        while (curr != null) {
            counter++;
            curr = curr.getNext();

        }
        return counter;
    }
//===========================================
//    Add the following function to the SingularlyLinkedList class:
// Search for a specific element in the list.

    public boolean search(E n) {//O(n)

        Node cur = head;
        while (cur != null) {
            if (cur.getElement() == n) {

                return true;

            }
            cur = cur.getNext();
        }
        return false;
    }

//========================
    public E GetElementInPosition(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("invalid index ");
            return null;
        }
        curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.getNext();
        }
        return curr.getElement();

    }

    public void prev() {
        Node temp = head;
        while (temp.getNext() != curr) {
            temp = temp.getNext();
        }

        curr = temp;
    }

 
    
public void SwapFirstLast(){
if(head==null||head.getNext()==null)
return;
//=================
if(size==2)
{Node temp=head;
head=tail;
tail=temp;
head.setNext(tail);
tail.setNext(null);
}

else
{
Node F=head;
Node L=tail;

head=head.getNext();
Node cur=head;
while(cur.getNext()!=tail)
cur=cur.getNext();

tail=cur;
tail.setNext(null);

L.setNext(head);
head=L;
F.setNext(null);
tail.setNext(F);
tail=tail.getNext();

}
}

  }
