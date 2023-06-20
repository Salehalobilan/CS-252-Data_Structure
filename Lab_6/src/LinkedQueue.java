public class LinkedQueue<E> {
    private SinglyLinkedList<E>list=new SinglyLinkedList();
    public LinkedQueue(){}
    public boolean isEmpty(){return list.isEmpty();}
    public void enqueue(E element){list.addLast(element);}
    public E first(){return list.first();}
    public E dequeue(){return list.removeFirst();}
    public int size(){return list.size();}
}
