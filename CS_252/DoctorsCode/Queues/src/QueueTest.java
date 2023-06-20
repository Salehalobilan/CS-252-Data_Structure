public class QueueTest {
    public static void main(String[] args) {
        /*
         * LinkedQueue<Integer> lq = new LinkedQueue<>();
         * lq.enqueue(5);
         * lq.enqueue(3);
         * System.out.println("size is " + lq.size());
         * System.out.println("deqeue is " + lq.dequeue());
         * System.out.println("Empty  " + lq.isEmpty());
         * System.out.println("deqeue is " + lq.dequeue());
         * System.out.println("Empty  " + lq.isEmpty());
         */
        /*
         * ArrayQueue<Integer> aq = new ArrayQueue<>(3);
         * aq.enqueue(5);
         * aq.enqueue(3);
         * // aq.enqueue(2);
         * // aq.enqueue(1);
         * System.out.println("size is " + aq.size());
         * System.out.println("deqeue is " + aq.dequeue());
         * System.out.println("Empty  " + aq.isEmpty());
         * System.out.println("deqeue is " + aq.dequeue());
         * System.out.println("Empty  " + aq.isEmpty());
         * aq.enqueue(3);
         * // System.out.println("deqeue is " + aq.dequeue());
         * aq.enqueue(4);
         */
        System.out.println("  is palindrome " + palindrome("Mom"));
        System.out.println("  is Compress " + Compress("H i might"));

    }

    public static boolean palindrome(String s) {
        if (s.length() == 0)
            return true;
        int i = s.length() - 1;
        Queue<Character> Q = new ArrayQueue<>(s.length());
        while (i >= 0)
            Q.enqueue(s.charAt(i--));
        i = 0;
        while (!Q.isEmpty())
            if (Q.dequeue() != s.charAt(i++))
                return false;
        return true;
    }

    public static String Compress(String str) {
        ArrayQueue<Character> Q = new ArrayQueue<Character>();

        for( int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) != ' ') {
                Q.enqueue(str.charAt(i)); }
        }
        String tmp = "";
        while(!Q.isEmpty()) {
            tmp = tmp +Q.dequeue();
        }
        return tmp;
    }
}

interface Queue<E> {
    int size();

    boolean isEmpty();

    void enqueue(E e);

    E first();

    E dequeue();
}




class SLinkedQueue<E> implements Queue<E> {
    private singlyLinkedList<E> list = new singlyLinkedList<>();

    SLinkedQueue() {}

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E first() {
        return list.first();
    }

    public E dequeue() {
        return list.removeFirst();
    }
}

class LinkedQueue<E>  {
    private Node<E> front;
    private Node<E> last;
    private int size;

    public LinkedQueue() {
        front = last = null;
        size = 0;
    }


    public int length() {
        return size;
    }


//    public boolean isEmpty() {
//        return false;
//    }


//    public void enqueue(E element) {
//        Node<E> temp = new Node<E> (element, null);
//        if (size == 0) {
//            front = last = temp;
//        }
//        else {
//            last = last.getNext() = temp;
//        }
//        size++;
//    }

    public E dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        E element = front.getElement(); // Store dequeued value
        front = front.getNext(); // Advance front
        if (front == null) {
            last = front; // Last Object
        }
        size--;
        return element;
    }

    public E front() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.getElement();
    }

}









class ArrayQueue<E> implements Queue<E> {
    private E data[];
    private int f = 0;
    private int size = 0;
    public static final int CAPACITY = 1000;

    ArrayQueue(int cap) {
        data = (E[]) new Object[cap];
    }

    ArrayQueue() {
        this(CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) {
        if (size == data.length)
            throw new IllegalStateException("Queue is full");
        int available = (f + size) % data.length;
        // System.out.println("ava " + available);
        data[available] = e;
        size++;
    }

    public E first() {
        if (isEmpty())
            return null;
        return data[f];
    }

    public E dequeue() {
        if (isEmpty())
            return null;
        E rd = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        // System.out.println("f " + f);
        size--;
        return rd;
    }


}