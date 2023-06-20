//import java.util.Stack;

public class stack072 {

    public static void main(String[] args) throws Exception {
         ArrayStack072<Integer> stack = new ArrayStack072(10);
//         stack.push(10);
//         stack.push(12);
//         stack.pop();
//         System.out.println("stack top " + stack.top());
       // System.out.println("  is palindrome " + palindrome("MoM"));
        stack.isMatched("({[]})");


    }

    public static boolean palindrome(String s) throws Exception {
        if (s.length() == 0)
            return true;
        int i = 0;
        ArrayStack072<Character> stack = new ArrayStack072<>(s.length());
        while (i < s.length())
            stack.push(s.charAt(i++));
        i = 0;
        while (!stack.isEmpty())
            if (stack.pop() != s.charAt(i++))
                return false;
        return true;
    }


}

interface Stack072<E> {
    int size();

    boolean isEmpty();

    void push(E e) throws Exception;

    E top();

    E pop();
}

class ArrayStack072<E> implements Stack072<E> {
    public static final int CAPACITY = 1000;
    private E data[];
    private int t = -1;

    ArrayStack072(int cap) {
        data = (E[]) new Object[cap];
    }

    ArrayStack072() {
        this(CAPACITY);
    }

    public int size() {
        return (t + 1);
    }

    public boolean isEmpty() {
        return (t == -1);
    }

    public E top() {
        if (isEmpty())
            return null;
        return data[t];
    }

    public void push(E e) throws Exception {
        if (size() == data.length)
            throw new Exception("Stack is full");

        data[++t] = e;
    }

    public E pop() {
        if (isEmpty())
            return null;

        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }


    /**Midterm coding Question*/
    public void EncryptWords(ArrayStack072<char> s) throws Exception {
        ArrayStack072<char> s1 = new ArrayStack072<char>();
        ArrayStack072<char> s2 = new ArrayStack072<char>();
        char ch;
        int iterations = s.size();

        while(!s.isEmpty())
            s1.push(s.pop());

        for(int i = 0; i < iterations; i++) {

            ch = s1.pop();
            if(ch != ' ')
                s2.push(ch);
            else
                while(s2.isEmpty())
                    s.push(s2.pop());

        }
        while(s2.isEmpty())
            s.push(s2.pop());
    }


    //Important method in slides
    public static boolean isMatched(String expression) throws Exception {
        final String opening = "({[";
        final String closing = "]})";
        ArrayStack072<Character> buffer = new ArrayStack072<>();
        for(char c : expression.toCharArray()) {
            if(opening.indexOf(c) != -1)
                buffer.push(c);
            else if (closing.indexOf(c) != -1) {
                if(buffer.isEmpty())
                    return false;
                if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
                    return false;
            }

        }
        return buffer.isEmpty();

    }


//    stack S:
//    top 1,2,3,4,5
//    stack T:
//    top 5,4,3,2,1
    public void transfer(ArrayStack072 S, ArrayStack072 T) throws Exception {
        E e;
        while (!S.isEmpty()) {
            e = (E) S.pop();
            T.push(e);
        }
    }
//    OR

    public void transfer2 (ArrayStack072 S, ArrayStack072 T) throws Exception {
        while (!S.isEmpty())
        {
            T.push(S.pop());
        }
    }




}




class LinkedStack072<E> implements Stack072<E> {
    private singlyLinkedList<E> list = new singlyLinkedList();

    public LinkedStack072() {
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E top() {

        return list.first();
    }

    public void push(E e) {
        list.addFirst(e);
    }

    public E pop() {

        return list.removeFirst();
    }




}