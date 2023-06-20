public class DoubleLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> test = new DoublyLinkedList();
        //test.middul();
        test.addFirst(10);
        test.addLast(12);
        test.addLast(13);
        test.add(11, 0);
        test.print();
        //test.middul();



    }
}

    /*private static*/ class NodeDll<E>{
        private E element;
        private NodeDll<E> next;
        private NodeDll<E> prev;

        public NodeDll(E element, NodeDll<E> prev, NodeDll<E> next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public void setElement(E element) {
            this.element = element;
        }
        public void setNext(NodeDll<E> next) {
            this.next = next;
        }
        public void setPrev(NodeDll<E> prev) {
            this.prev = prev;
        }
        public E getElement() {
            return element;
        }
        public NodeDll<E> getNext() {
            return next;
        }
        public NodeDll<E> getPrev() {
            return prev;
        }
    }

    class DoublyLinkedList<E> {

        NodeDll<E> header;
        NodeDll<E> trailer;
        int size = 0;
        public DoublyLinkedList() {
            header = new NodeDll(null, null, null);
            trailer = new NodeDll(null, header, null);
        }

        public boolean isEmpty() { return size == 0; /*return trailer == null;*/}
        public int size() {return size;}

        public E first() {
            if (isEmpty()) return null;
            return header.getNext().getElement();
        }
        public E Last() {
            if (isEmpty()) return null;
            return trailer.getPrev().getElement();
        }



        public void addBetween(E element ,NodeDll<E> pre, NodeDll<E> succ) {
            NodeDll<E> newest = new NodeDll(element , pre, succ);
            pre.setNext(newest);
            succ.setPrev(newest);
            size++;                   }
        public void addFirst(E element) {addBetween(element,header , header.getNext());}
        public void addLast(E element) {addBetween(element, trailer.getPrev(), trailer);}
        public void add(E element, int index) {
            if(index < 0 || index > size)
            {System.out.println("the index out of bound!");  return;}
            if(index == 0)
                    addFirst(element);
            else {
                NodeDll<E> curr = header.getNext();
                for (int i = 0; i < index - 1; i++)
                    curr = curr.getNext();
                addBetween(element, curr, curr.getNext());

            }
        }




        public E remove(NodeDll<E> node) {
            NodeDll<E> pre = node.getPrev();
            NodeDll<E> succ = node.getNext();    /**this is the main remove method*/
            pre.setNext(succ);
            succ.setPrev(pre);
            size--;
            return node.getElement();
        }
        public E /*ودي أجرب أخليها void*/ removeFirst() {
            if(isEmpty()) return null;
            return remove(header.getNext());
        }
        public E /*ودي أجرب أخليها void*/ removeLast() {
            if(isEmpty()) return null;
            return remove(trailer.getPrev());
        }
        public E remove(int index) {
            if (index < 0 || index > size)
                System.out.println("Out of bound!");
            if (index == 0)
                return removeFirst();
            else {
                NodeDll<E> curr = header.getNext();
                for (int i = 0; i < index -1 ; i++)
                    curr = curr.getNext();
                return remove(curr);
            }
        }



        public NodeDll<E> middul() {
            NodeDll<E> h = header.getNext();
            NodeDll<E> t = trailer.getPrev();
            while (h != t && h.getNext() != t ) {
                h = h.getNext();
                t = t.getPrev();
            }
            return t;
        }
        public void print() {
            System.out.println("Print DLL");
            if (isEmpty()) return;
            NodeDll<E> curr = header.getNext();

            for (int i = 0; i < size; i++) {
                System.out.println(curr.getElement());
                curr = curr.getNext();
            }
        }









    }





