
public class Question2 {
    public void swapLatTwoNodes() {

        if(isEmpty()) {
            return;
        }
        Node last = tail;
        curr = head;

        while(curr.getNext().getNext() != tail)
        {
            curr = curr.getNext();}

        Node p = curr.getNext();
        tail = p;

        p.setNext(null);
        last.setNext(p);
        curr.setNext(last);

    }
}
