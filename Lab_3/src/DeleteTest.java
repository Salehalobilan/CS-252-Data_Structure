public class DeleteTest {


        public static <E> E DeleteSecond(singlyLinkedList<E> L){


            if(L.size()>1){                      //big o(1)
                E temp = L.removeFirst();
                E element = L.removeFirst();// second
                L.addFirst(temp);
                return element;
            }
            System.out.println("impossible, the size of list less than 2");
            return null;
        }



        public static void main( String [] args) {

            singlyLinkedList<Integer> L1= new singlyLinkedList<>();

            System.out.println("         DeleteSecond method inside Singly Linked List ADT");
            System.out.println("1st Test: Empty list - result : ");
            System.out.println(L1.DeleteSecond()+ " has been deleted \nThe list contains:");
            L1.print();

            L1.addFirst(1);
            System.out.println("\n\n2nd Test: Only One element inserted, result -> ");
            System.out.println(L1.DeleteSecond()+ " has been deleted  \nThe list contains:");
            L1.print();


            L1.addLast(2);
            System.out.println("\n\n3rd Test: Two elements inserted, result -> ");
            System.out.println(L1.DeleteSecond()+ " has been deleted  \nThe list contains:");
            L1.print();

            L1.addLast(2);
            L1.addLast(3);
            L1.addLast(4);
            System.out.println("\n\n4th Test: more than two elements inserted, result -> ");
            System.out.println(L1.DeleteSecond()+ " has been deleted  \nThe list contains:");
            L1.print();




            singlyLinkedList<Integer> L2= new singlyLinkedList<>();
            System.out.println("********** DeleteSecond method outside Singly Linked List ADT************");
            System.out.println("1st Test: Empty list , result -> ");
            System.out.println(DeleteSecond(L2)+ " has been deleted \nThe list contains:");
            L2.print();

            L2.addFirst(1);
            System.out.println("\n\n2nd Test: Only One element inserted, result -> ");
            System.out.println(DeleteSecond(L2)+ " has been deleted  \nThe list contains:");
            L2.print();

            L2.addLast(2);
            System.out.println("\n\n3rd Test: Two elements inserted, result -> ");
            System.out.println(DeleteSecond(L2)+ " has been deleted  \nThe list contains:");
            L2.print();

            L2.addLast(2);
            L2.addLast(3);
            L2.addLast(4);
            System.out.println("\n\n4th Test: more than two elements inserted, result -> ");
            System.out.println(DeleteSecond(L2)+ " has been deleted  \nThe list contains:");
            L2.print();

        }










}
