             //Questions 1 and 2
public class Main {

    public static void main(String[] args) {
        //Q1
        binaryTree<Integer> bt = new binaryTree();
        System.out.println(bt.getSize());
        TNode<Integer> r = bt.addRoot(5);
        TNode<Integer> lc = bt.addLeft(r, 8);
        TNode<Integer> rc = bt.addRight(r, 9);
        System.out.println(bt.isExternal(rc));
        System.out.println(bt.isInternal(lc));
        System.out.println(bt.isRoot(r));
        System.out.println(bt.isRoot(lc));
        System.out.println(bt.isEmpty());
        System.out.println(lc.getItem());

        bt.addLeft(lc, 25);
        bt.addLeft(rc, 90);
        System.out.println(bt.left(lc).getItem() + 23);
        System.out.println(bt.getSize());
        System.out.println("The height is "+bt.theheight(bt.getRoot()));
        System.out.println("The height is "+bt.height());
        //Q2
        bt.breadth_first(bt.getRoot());

    }

}

class TNode<E> {
    private E item;
    private TNode<E> parent;
    private TNode<E> left;
    private TNode<E> right;

    public TNode() {
        item = null;
        parent = null;
        left = null;
        right = null;
    }

    public E getItem() {
        return item;
    }

    public TNode<E> getParent() {
        return parent;
    }

    public TNode<E> getLeft() {
        return left;
    }

    public TNode<E> getRight() {
        return right;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public void setParent(TNode<E> parent) {
        this.parent = parent;
    }

    public void setLeft(TNode<E> left) {
        this.left = left;
    }

    public void setRight(TNode<E> right) {
        this.right = right;
    }


}
class binaryTree<E> {
     private TNode<E> root;
     private int size;
     public binaryTree() {
         root = null;
         size = 0;
     }
     public int getSize() {
         return size;
     }
     public TNode<E> getRoot() {
         return root;
     }
     public TNode<E> addRoot(E element) {
         if (root == null) {
             root = new TNode<E>();
             root.setItem(element);
             size++;
         }
         return root;
     }
     public TNode<E> parent(TNode<E> par) {
         if (par != null) {
             TNode<E> n = par.getParent();
             return n;    }
         return null;
     }
     public TNode<E> left(TNode<E> par) {
         if (par != null) {
             TNode<E> n = par.getLeft();
             return n;    }
         return null;
     }
     public TNode<E> right(TNode<E> par) {
         if (par != null) {
             TNode<E> n = par.getRight();
             return n;    }
         return null;
     }
     public boolean isRoot(TNode<E> par) {
         if (par != null)
             if (par.getParent() == null)
                 return true;
         return false;
     }
     public boolean isEmpty() {return root == null;}
     public int getSize(TNode<E> par) {return size;}


     public boolean isInternal (TNode<E> par) {
         if( par != null)
             if(par.getLeft() != null || par.getRight()!= null)
                 return true;
         return false;
     }
    public boolean isExternal(TNode<E> par) {
        if( par != null)
            if(par.getLeft() != null && par.getRight() != null)
                return true;
        return false;
    }

     public TNode<E> addLeft(TNode<E> par, E element) {
         if (par != null && par.getLeft() == null) {
             TNode<E> n = new TNode();
             n.setItem(element);
             par.setLeft(n);
             n.setParent(par);
             size++;
             return n;
         }
         else
             return null;
     }
     public TNode<E> addRight(TNode<E> par, E element) {
         if (par != null && par.getRight() == null) {
             TNode<E> n = new TNode();
             n.setItem(element);
             par.setRight(n);
             n.setParent(par);
             size++;
             return n;
         }
         else
             return null;
     }



    /**Height method*/
     public int theheight(TNode<E> root) {
         if(root == null)
             return 0;
         if(root.getLeft() == null && root.getRight() == null)
             return 1;
         return 1+ Math.max(theheight(root.getLeft()), theheight(root.getRight()));
     }
     // Because he Asked to be the method with no arguments :P
     public int height() { return theheight(root); }




    /**Second Question*/
                 //The method's ADT
    public class LinkedQueue<E> {
        private singlyLinkedList<E>list=new singlyLinkedList();
        public LinkedQueue() {}
        public boolean isEmpty(){return list.isEmpty();}
        public void enqueue(E element){list.addLast(element);}
        public E first(){return list.first();}
        public E dequeue(){return list.removeFirst();}
        public int size(){return list.size();}
    }
    //The method
    public void breadth_first(TNode<E> p){
        LinkedQueue<TNode<E>> items = new LinkedQueue();
        if(p != null)
            items.enqueue(p);
        while(!items.isEmpty()){
            TNode<E> p1 = items.dequeue();
            System.out.println(p1.getItem());
            if(p1.getLeft() != null)
                items.enqueue(p1.getLeft());
            if(p1.getRight()!= null)
                items.enqueue(p1.getRight());
        }
    }
}

