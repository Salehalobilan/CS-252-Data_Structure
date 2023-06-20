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


    public void clear() {
        head = tail = null;
        size = 0;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        if(head.getNext()==null)
        return head.getElement();
       
        Node cur=head;
        while(cur.getNext()!=null)
        cur=cur.getNext();
        
        return (E)cur.getElement();
       
       // return tail.getElement();
    }

    
    
    
    
    
    
    

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
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


    public void add(E element, int index) {
        if (index < 0 || index > size) {
            System.out.println("Out of bound!");
            return;
        }
        Node<E> newest = new Node<E>(element, null);
        if (index == 0)
        {
            newest.setNext(head);
            head = newest;
            if (tail == null) {
                tail = head;
            }
        } else
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


    public E remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Out of bound!");
            return null;
        }
        E element;
        if (index == 0)
        {
            element = head.getElement();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
        } else {
            curr = head;
            for (int i = 1; i < index ; i++) {
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


    public int CurrPos() {
        Node<E> temp = head;
        int i = 0;
        while (temp != curr) {
            temp = temp.getNext();
            i++;
        }
        return i;
    }

    

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

}