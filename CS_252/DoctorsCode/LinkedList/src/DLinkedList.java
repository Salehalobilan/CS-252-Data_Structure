//class NodeDLL<E> {
//    private E element;
//    private NodeDLL<E> next;
//    private NodeDLL<E> prev;
//
//    public NodeDLL(E element, NodeDLL<E> prev, NodeDLL<E> next) {
//        this.element = element;
//        this.prev = prev;
//        this.next = next;
//    }
/**this Node for Double Linked list
 *  is available on another class called main (in the same module)*/
//    public void setElement(E element) {
//        this.element = element;
//    }
//
//    public void setNext(NodeDLL<E> next) {
//        this.next = next;
//    }
//
//    public void setPrev(NodeDLL<E> prev) {
//        this.prev = prev;
//    }
//
//    public E getElement() {
//        return element;
//    }
//
//    public NodeDLL<E> getNext() {
//        return next;
//    }
//
//    public NodeDLL<E> getPrev() {
//        return prev;
//    }
//}





public class DLinkedList<E> {
    private NodeDLL<E> header;
    private NodeDLL<E> trailer;

    private int size = 0;

    DLinkedList() {
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

    // finding the middle node of a doubly linked list with header and trailer
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

    }


    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList();
        dll.addFirst(10);
        dll.addLast(12);
        dll.addLast(13);
        dll.add(11, 0);
        dll.print();
        dll.removeFirst();
//        dll.print();
//        System.out.println("Mid is " + dll.middle().getElement());

    }

}