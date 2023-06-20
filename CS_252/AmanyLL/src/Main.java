public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        list.AddFirst(5);
        list.AddLast(20);
        list.AddLast(26);
        list.AddLast(30);
        list.AddFirst(2);
        list.RemoveFirst();
        list.RemoveLast();
        list.print();


    }
}