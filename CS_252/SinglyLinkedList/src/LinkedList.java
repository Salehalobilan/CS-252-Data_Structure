public class LinkedList <E>{
    Node<E> head;
    Node<E> tail;

    //Constructor
    public LinkedList() { head = null; tail = null;}

    //---------


    public void AddFirst(E data) {
        Node n = new Node(data, null);
        if(head == null)
            head = tail = n;
        else {
            n.setNext(head);
            head = n;}
    }

    public void AddLast(E data) {
        Node n = new Node(data, null);
        if(head == null/*Or tail==null*/)
            head = tail = n;
        tail.setNext(n);
        tail = tail.getNext(); // tail = n
    }
    public void AddMid(int data) {

    }

    public void RemoveFirst() {
        if(head == null) {      //First case
            System.out.println("No Element");
            return;}
        else if (head == tail)       //Second case
            head = tail = null;
        else                         //Third case
            head = head.getNext();
    }

    public void RemoveLast() {
            if(head == null) {                   //first case
                System.out.println("No Element");
                return;}
            else if (head == tail)               //Second case
                head = tail = null;
            else {                               //third case
                Node curr = head;
                while(curr.getNext() != tail)
                    curr = curr.getNext();
                tail = curr;
                curr.setNext(null);
            }
    }

    public void print() {
        if (head == null) {
            System.out.println("No element");
            return;
        }
        else {
            Node curr = head;
            while(curr != null) {
                System.out.println(curr.getElement());
                curr = curr.getNext();
            }
        }

    }




}