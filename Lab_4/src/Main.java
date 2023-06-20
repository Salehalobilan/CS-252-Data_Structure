import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Scanner;
import static java.nio.file.Files.readAllBytes;

class NodeDLL<E> {
    private E element;
    private NodeDLL<E> next;
    private NodeDLL<E> prev;

    public NodeDLL(E element, NodeDLL<E> prev, NodeDLL<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(NodeDLL<E> next) {
        this.next = next;
    }

    public void setPrev(NodeDLL<E> prev) {
        this.prev = prev;
    }

    public E getElement() {
        return element;
    }

    public NodeDLL<E> getNext() {
        return next;
    }

    public NodeDLL<E> getPrev() {
        return prev;
    }
}

class DoublyLinkedList<E> {
    private NodeDLL<E> header;
    private NodeDLL<E> trailer;

    private NodeDLL<E> Curr;

    private int size = 0;


    DoublyLinkedList() {
        header = new NodeDLL(null, null, null);
        trailer = new NodeDLL(null, header, null);
        header.setNext(trailer);
        Curr = header.getNext(); //extra for the lab
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() { return size;}

    public void movetoStart() {
        this.Curr = header.getNext();
            /* we make it start from header.next because the question said
            it has to open the first page when the user run the program*/
    }

    public void movetoNext() {
        if (Curr.getNext() == this.trailer) {
            System.out.println("You are at the last page");
            return; }
        Curr = Curr.getNext();
    }
    public void movetoPrev() {
        if(Curr.getNext() == header){
            System.out.println("You are at the first page");
            return; }
    }
    public E getValue() {return Curr.getElement();}

    private void addBetween(E e, NodeDLL<E> pre, NodeDLL<E> succ) {
        NodeDLL<E> newest = new NodeDLL(e, pre, succ);
        pre.setNext(newest);
        succ.setPrev(newest);
        size++;
    }
    public void addlast(E e) {addBetween(e, trailer.getPrev(), trailer);}


}


public class Main { //Book Viewer program
     String bookName;

     static DoublyLinkedList <String> myBook = new DoublyLinkedList();
     static Scanner input;
     public Main(String bookName) {
         this.bookName = bookName;
         try {
             readAllBytes();
         }
         catch(Exception e) {
             System.out.println("Error in the File !");
         }
     }
     public void readAllBytes ()throws Exception {
             for (int i = 1; i<=4 ; i++){
                 String num = Integer.toString(i);
                 String file_name = "page_" + num + ".txt";

                 String page = new String(Files.readAllBytes(Paths.get(file_name)));
                 myBook.addlast(page);
             }
     }

     public static String Next() {
         myBook.movetoNext();
         return myBook.getValue();
     }
     public static String previous() {
         myBook.movetoPrev();
         return myBook.getValue();
     }
     public static String search_by_number(int pagenum) {
         if (pagenum > 4 || pagenum < 1) {
             System.out.println("Wrong page number!");
             return null; }
         myBook.movetoStart();
         if (pagenum == 1){ System.out.println(myBook.getValue()); return null;}
         else {
             for (int i = 1; i < pagenum ; i++) {   myBook.movetoNext();  }
             String page = myBook.getValue();
             return page;
             //return myBook.getValue();
         }
     }






    public static void main(String[] args) {
         Main book = new Main("How to program");
         int select;
         Scanner inp = new Scanner(System.in);
         myBook.movetoStart(); //we put it because he asked to open the first page when the program start
        System.out.println(myBook.getValue());

        do {
            System.out.println("\n Would you like to:");

            System.out.println("1- move to next page:");
            System.out.println("2- move to previous page:");
            System.out.println("3- Search by a number:");
            System.out.println("4- Exit:");
            System.out.print("Enter here: ");
            select = inp.nextInt();

            switch(select) {
                case 1: System.out.println(/*book.*/Next());   // we don't need to connect it with an object
                case 2: System.out.println(/*book.*/previous()); // we don't need to connect it with an object
                case 3: {
                    System.out.println("Enter the page:");
                    int pagenum = inp.nextInt();
                    System.out.println(book.search_by_number(pagenum));
                }
            }

        } while (select != 4);
    }// the static (run) main ends here

} // the whole book veiwer program ends here

