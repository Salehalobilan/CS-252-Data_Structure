
public class Stack {
    public static void main(String[] args) throws Exception {
        ArrayStack<Integer> stack = new ArrayStack();
//        stack.push(10);
//        stack.push(3);
//        stack.push(90);
//        stack.push(145);
//        stack.pop();
        System.out.println("stack top " + stack.top());
        System.out.println("  is palindrome " + palindrome("MooM"));

    }
    public static boolean palindrome(String s) throws Exception {
        if(s.length() == 0) return true;
        int i = 0;
        ArrayStack<Character> stack = new ArrayStack<>(s.length());
        while (i < s.length())
            stack.push(s.charAt(i++));
        i = 0;
        while(!stack.isEmpty())
            if(stack.pop() != s.charAt(i++)) return false;
        return true;
    }
}

interface Stack072<E> {
    public int size(); //#1
    public boolean isEmpty(); //#2
    public void push(E element) throws Exception; //#3
    public E pop();   //#4
    public E top();   //#5
}


class ArrayStack<E> implements Stack072<E> {
    public static final int CAPACITY = 1000;
    private E data[];
    private int t = -1; //t for index of the top

    public ArrayStack() {   this(CAPACITY);  }
    public ArrayStack(int cap) { data = (E[]) new Object[cap]; } //they said it just for safe
                                                                 // to pass Error from compilor

    public int size() { return (t + 1); }
    public boolean isEmpty() { return (t == -1); }

    public E top() {
        if(isEmpty()) return null;
        return data[t];
    }
    public void push(E element) throws Exception {
        if(size() == data.length)
            throw new Exception("Stack is full!");
        data[++t] = element;
    }
    public E pop() {
        if(isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }

}

class LinkedStack<E> implements Stack072<E>{
    private singlyLinkedList<E> list = new singlyLinkedList();
    public LinkedStack() {      }

    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }

    public E top() { return list.first(); }
    public void push(E element) { list.addFirst(element); }
    public E pop() { return list.removeFirst(); }
}