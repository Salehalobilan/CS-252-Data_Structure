package Question3;

public class ExpressionTree {

    private class Node {

        private char item;
        private Node left;
        private Node right;

        public Node() {
            item = ' ';
            left = right = null;
        }

        public void setItem(Character e) {
            item = e;
        }

        public void setLeft(Node n) {
            left = n;
        }

        public void setRight(Node n) {
            right = n;
        }

        public Character getItem() {
            return item;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public boolean isLeaf() {
            return (left == null && right == null);
        }

    }
    

    public Node root;
    public class LinkedStack<E>
    {
        singlyLinkedList<E>list=new singlyLinkedList<>();
        public LinkedStack(){}
        public int size(){return list.size();}
        public boolean isEmpty(){return list.isEmpty();}
        public void push(E element){list.addFirst(element);}
        public E top(){return list.first();}
        public E pop(){return list.removeFirst();}


    }

    public ExpressionTree() {
        root = null;
    }


    public void construct_infixExpretionTree(String infix) 
    { 
      
        
        LinkedStack <Node> NodeStac = new LinkedStack(); 
      
       
        LinkedStack <Character> charLinkedStack = new LinkedStack(); 
      
        for (int i = 0; i < infix.length(); i++) { 
            char curchar= infix.charAt(i);
            if (curchar == '(') { 
                charLinkedStack.push(curchar); 
            } 
      
            
            else if (Character.isDigit(curchar)){ 
                Node  n = new Node  ();
                n.setItem(curchar);
                NodeStac.push(n);
            } 
            else if (curchar == ')') { 
                while (!charLinkedStack.isEmpty()&& charLinkedStack.top() != '(') { 
                    Node  n = new Node  ( );
                    n.setItem(charLinkedStack.pop());
              
                    n.setRight (NodeStac.pop()); 
                    n.setLeft(NodeStac.pop()); 
                    NodeStac.push(n); 
                } 
                charLinkedStack.pop();
            } 
            else if (curchar=='+'||curchar=='/'||curchar=='*'||curchar=='-') { 
                 if (charLinkedStack.isEmpty()){
                    charLinkedStack.push(curchar); 
                 }
              else {

                while (!charLinkedStack.isEmpty()){
                    char op =charLinkedStack.pop();
                    if (op=='('){
                        charLinkedStack.push(op);
                        break; 
                    }
                    else { if (priority (curchar) > priority (op))
                        {
                            charLinkedStack.push(op);
                            break;
                        }
                        else {
                            Node  n = new Node ( );
               n.setItem(op);
                            
                            n.setRight (NodeStac.pop()); 
                            n.setLeft(NodeStac.pop());
                            NodeStac.push(n);  
                        }
                    }
                }
                
                charLinkedStack.push(curchar); 
            }
            }
            
        }
       while (!charLinkedStack.isEmpty()){
            Node  n = new Node ( );
            n.setItem(charLinkedStack.pop());
            n.setRight (NodeStac.pop()); 
            n.setLeft(NodeStac.pop()); 
            NodeStac.push(n);    
        } 
        root = NodeStac.pop(); 
        
    } 
    
    public static int priority (char op){
        if (op == '/'||op =='*'){
        return 2;}
        else {
        return 1;}
    }

    public Node getRoot() {
        return root;
    }

    boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }


    void construct_PostExpretionTree(char postfix[]) {  //56+34*3*+
        LinkedStack<Node> st = new LinkedStack<Node>();
        Node t;

        for (int i = 0; i < postfix.length; i++) {

            // If operand, simply push into stack
            if (isOperator(postfix[i]) == false) {
                t = new Node();
                t.setItem(postfix[i]);
                st.push(t);
            } else // operator
            {
                t = new Node();
                t.setItem(postfix[i]);
               
                t.setRight(st.pop());
                t.setLeft(st.pop());

                
                st.push(t);
            }
        }
       
        root = st.pop();

    }

    
    
    public void preorder(Node root) {
        if (root != null) {

            System.out.print(root.getItem());

            preorder(root.getLeft());
            preorder(root.getRight());

        }

    }

    public void inorder(Node root) {
        if (root != null) {

            inorder(root.getLeft());
            System.out.print(root.getItem());
            inorder(root.getRight());

        }

    }

    public  void postorder(Node root) {
        if (root != null) {

            postorder(root.getLeft());

            postorder(root.getRight());
            System.out.print(root.getItem());

        }

    }


    public int evalExpression(Node p) {
        if (p != null) {

            if (p.getLeft() == null && p.getRight() == null) {
                return Character.getNumericValue(p.getItem());
            }

            int x = evalExpression(p.getLeft());
            int y = evalExpression(p.getRight());
            switch (p.getItem()) {
                case '+':
                    return x + y;
                case '-':
                    return x - y;
                case '*':
                    return x * y;
                case '/':
                    return x / y;
                case '%':
                    return x % y;
            }
        }
        return 0;
    }

}

