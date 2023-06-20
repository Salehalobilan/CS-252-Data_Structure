package Lab4;
/**Failed self try Lab_4*/
public class Main {

//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class Main {
//
//
//    class NodeDLL<E> {
//        private E element;
//        private NodeDLL<E> next;
//        private NodeDLL<E> prev;
//
//
//        public NodeDLL(E element, NodeDLL<E> prev, NodeDLL<E> next) {
//            this.element = element;
//            this.prev = prev;
//            this.next = next;
//        }
//
//        public void setElement(E element) {
//            this.element = element;
//        }
//
//        public void setNext(NodeDLL<E> next) {
//            this.next = next;
//        }
//
//        public void setPrev(NodeDLL<E> prev) {
//            this.prev = prev;
//        }
//
//        public E getElement() {
//            return element;
//        }
//
//        public NodeDLL<E> getNext() {
//            return next;
//        }
//
//        public NodeDLL<E> getPrev() {
//            return prev;
//        }
//    }
//
//
//
//
//
//
//
//    class DoublyLinkedList<E> {
//        private NodeDLL<E> header;
//        private NodeDLL<E> trailer;
//        private NodeDLL<E> Curr;
//
//        private int size = 0;
//
//        DoublyLinkedList() {
//            header = new NodeDLL(null, null, null);
//            trailer = new NodeDLL(null, header, null);
//            header.setNext(trailer);
//        }
//
//        public boolean isEmpty() {
//            return size == 0;
//            // return tail == null ;
//        }
//
//        public int size() {
//            return size;
//        }
//
//        public E first() {
//            if (isEmpty())
//                return null;
//            return header.getNext().getElement();
//        }
//
//        public E last() {
//            if (isEmpty())
//                return null;
//            return trailer.getPrev().getElement();
//        }
//
//        public void addFirst(E e) {
//            addBetween(e, header, header.getNext());
//        }
//
//        public void addLast(E e) {
//            addBetween(e, trailer.getPrev(), trailer);
//        }
//
//        public void add(E e, int index) {
//            if (index < 0 || index > size) {
//                System.out.println("Error : index out of bounds ");
//                return;
//            }
//            if (index == 0)
//                addFirst(e);
//            else {
//                NodeDLL<E> curr = header.getNext();
//                for (int i = 0; i < index - 1; i++) {
//                    curr = curr.getNext();
//                }
//                addBetween(e, curr, curr.getNext());
//            }
//        }
//
//        private void addBetween(E e, NodeDLL<E> pre, NodeDLL<E> succ) {
//            NodeDLL<E> newest = new NodeDLL(e, pre, succ);
//            pre.setNext(newest);
//            succ.setPrev(newest);
//            size++;
//        }
//
//        public E removeFirst() {
//            if (isEmpty())
//                return null;
//
//            return remove(header.getNext());
//        }
//
//        public E removeLast() {
//            if (isEmpty())
//                return null;
//
//            return remove(trailer.getPrev());
//        }
//
//        public E remove(int index) {
//            if (index < 0 || index > size) {
//                System.out.println("Error : index out of bounds ");
//                return null;
//            }
//            if (index == 0)
//                return removeFirst();
//            else {
//                NodeDLL<E> curr = header.getNext();
//                for (int i = 0; i < index; i++) {
//                    curr = curr.getNext();
//                }
//                return remove(curr);
//            }
//
//        }
//
//        private E remove(NodeDLL<E> node) {
//            NodeDLL<E> pre = node.getPrev();
//            NodeDLL<E> succ = node.getNext();
//            pre.setNext(succ);
//            succ.setPrev(pre);
//            size--;
//            return node.getElement();
//        }
//
//        // finding the middle node of a doubly linked list with header and trailer
//        public NodeDLL<E> middle() {
//            NodeDLL<E> h = header.getNext();
//            NodeDLL<E> t = trailer.getPrev();
//            while (h != t && h.getNext() != t) {
//                h = h.getNext();
//                t = t.getPrev();
//            }
//
//            return t;
//        }
//
//        public void print() {
//            System.out.println("Print DLL");
//            if (isEmpty())
//                return;
//            NodeDLL<E> curr = header.getNext();
//            for (int i = 0; i < size; i++) {
//                System.out.println(curr.getElement());
//                curr = curr.getNext();
//            }
//
//        }
//
//        public void movetoStart() {
//            Curr = header;
//        }
//        public void movetoNext() {
//            if (header != trailer)
//                Curr = Curr.getNext();
//        }
//        public void movetoPrev() {
//            Curr = Curr.getPrev();
//
//        }
//        public E getValue() {
//            return Curr.getElement();
//        }
//
//
//    }
//
//
//
//
//
//
//    public static void main(String[] args) {
//        try {
//        File Book = new File("page_1.txt");
//            File Book2 = new File("page_2.txt");
//            File Book3 = new File("page_3.txt");
//            File Book4 = new File("page_4.txt");
//        Scanner myReader = new Scanner(Book);
//            Scanner myReader2 = new Scanner(Book2);
//            Scanner myReader3 = new Scanner(Book3);
//            Scanner myReader4 = new Scanner(Book4);
//        while (myReader.hasNextLine()) {
//            String page = myReader.nextLine();
//            System.out.println(page);
//        }
//
//            while (myReader2.hasNextLine()) {
//                String page = myReader2.nextLine();
//                System.out.println(page);
//            }
//
//            while (myReader3.hasNextLine()) {
//                String page = myReader3.nextLine();
//                System.out.println(page);
//            }
//
//            while (myReader4.hasNextLine()) {
//                String page = myReader4.nextLine();
//                System.out.println(page);
//            }
//
//
//        //String page = new String(Files.readAllBytes(Paths.get("page_1.txt")));
//        myReader.close();
//
//
//
//    }
//        catch (FileNotFoundException e) {
//        System.out.println("An error occurred.");
//        e.printStackTrace();
//    }
//
//
//    }
//}
}
