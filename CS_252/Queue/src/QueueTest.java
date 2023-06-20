public class QueueTest {
    public static void main(String[] args) {

    }

}

interface Queue<E> {
    public int size();
    public boolean isEmpty();
    public E first();
    public void enqueue(E element);
    public E dequeue();
}

class LinkedQueue<E> implements Queue<E> {
    singlyLinkedList<E> list = new singlyLinkedList<>();
    public LinkedQueue() {}
    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }

    public E first() { return list.first(); }
    public void enqueue(E element) { list.addLast(element); }
    public E dequeue() { return list.removeFirst(); }
}

class ArrayQueue<E> implements Queue<E> {
    private E data[];
    private int f = 0;
    private int size = 0;
    private static final int CAPACITY = 1000;

    public ArrayQueue(int cap) {data = (E[]) new Object[f]; }
    public ArrayQueue() { this(CAPACITY); }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0;}

    public E first() {
        if(isEmpty()) return null;
        return data[f];
    }
    public void enqueue(E element) {
        if(size == data.length) throw new IllegalStateException("Queue is full!");

        int available = (f + size) % data.length;
        //System.out.println("ava" + available);
        data[available] = element;
        size++;
    }
    public E dequeue() {
        if(isEmpty()) return null;
        E rd = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        System.out.println("f " + f);
        size--;
        return rd;
    }
}


