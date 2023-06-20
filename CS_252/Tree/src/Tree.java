public class Tree {

    public static void main(String[] args) {
        BSTree<Integer, String> bst = new BSTree();
        //bst.getKey().compareTo(key);


    }
    //pre order
    public static <E> void preOrder(BTNode<E> p) {
        if (p != null) {
            System.out.println(p.getItem());
            preOrder(p.getLeft());
            preOrder(p.getRight());
        }

    }
    //in order
    public static <E> void inOrder(BTNode<E> p) {
        if (p != null) {
            inOrder(p.getLeft());
            System.out.println(p.getItem());
            inOrder(p.getRight());
        }
    }
    //post order
    public static <E> void postOrder(BTNode<E> p) {
        if (p != null) {
            postOrder(p.getLeft());
            postOrder(p.getRight());
            System.out.println(p.getItem());
        }
    }
    ///////////////////////////////////////////
    public class LinkedQueue<E> {

        private singlyLinkedList<E>list=new singlyLinkedList();
        public LinkedQueue() {}
        public boolean isEmpty(){return list.isEmpty();}
        public void enqueue(E element){list.addLast(element);}
        public E first(){return list.first();}
        public E dequeue(){return list.removeFirst();}
        public int size(){return list.size();}
    }
    public <E> void breadthFirstOrder(BTNode<E> root) {
        LinkedQueue<BTNode<E>> lq = new LinkedQueue<>();
        lq.enqueue(root);
        while( !lq.isEmpty()) {
            BTNode<E>  p =  lq.dequeue();
            System.out.println(" " + p.getItem() + " ");
            if (p.getLeft() != null)
                lq.enqueue(p.getLeft());
            if(p.getRight() != null)
                lq.enqueue(p.getRight());
        }

    }

}



class ArrayTree {}

class BTNode <E> {
    private E item;
    private BTNode<E> left;
    private BTNode<E> right;

    public BTNode() {
        item =null;
        left = right = null;
    }

    public void setItem(E e) {
        item = e;
    }

    public void setLeft(BTNode<E> n) {
        left = n;
    }

    public void setRight(BTNode<E> n) {
        right = n;
    }

    public E getItem() {
        return item;
    }

    public BTNode<E> getLeft() {
        return left;
    }

    public BTNode<E> getRight() {
        return right;
    }
}




class BSTNode <K,T> {
    private K key;
    private T data;
    private BSTNode<K,T> left;
    private BSTNode<K,T> right;
    //Constructor 1
    public BSTNode() {left = right = null;}
    //Constructor 2
    public BSTNode (K key, T data) {
        this.key = key;
        this.data = data;
        left = right = null;
    }
    //Constructor 3
    public BSTNode(K key, T data, BSTNode<K,T> left, BSTNode<K,T> right) {
        this.key = key;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BSTNode<K, T> left) {
        this.left = left;
    }

    public void setRight(BSTNode<K, T> right) {
        this.right = right;
    }

    public K getKey() {
        return key;
    }

    public T getData() {
        return data;
    }

    public BSTNode<K, T> getLeft() {
        return left;
    }

    public BSTNode<K, T> getRight() {
        return right;
    }
    public boolean isLeaf() { return (left == null) && (right == null); }
}
class BSTree <K extends Comparable<K>,E> {
    BSTNode<K,E> root;


    public E search(K k) {
        BSTNode<K,E> n = searchTree(root, k);
        if (n == null) return  null;
        else
            return n.getData();
    }
    private BSTNode<K,E> searchTree(BSTNode<K,E> n, K key) {
        if (n == null)
            return null;
        else if (n.getKey().compareTo(key) == 0)
            return n;
        else if (key.compareTo(n.getKey()) < 0)
            return searchTree(n.getLeft(), key);
        else //if (key.compareTo(n.getKey()) > 0)
            return searchTree(n.getRight(), key);
    }

    public void insert(K key, E data) {
        BSTNode<K,E> parent = null;
        BSTNode<K,E> trav = root;
        while( trav != null) { //here we're traversing the parents through the tree until we reach the given key
            parent = trav;
            if (key.compareTo(trav.getKey()) < 0)
                trav = trav.getLeft();
            else //if (key.compareTo(trav.getKey()) > 0)
                trav = trav.getRight();
        }
        BSTNode<K,E> newNode = new BSTNode<K,E>(key,data);
        if (root == null)
            root = newNode;
        else if (parent.getKey().compareTo(key) > 0)
            parent.setLeft(newNode);
        else //if (parent.getKey().compareTo(key) < 0)
            parent.setRight(newNode);
    }

    public E delete(K key) {
        BSTNode<K,E> parent = null;
        BSTNode<K,E> trav = root;
        //first we need to traverse to the node's key
        while(trav != null && trav.getKey().compareTo(key) != 0) {
            parent = trav;
            if(trav.getKey().compareTo(key) < 0)
                trav = trav.getLeft();
            else
                trav = trav.getRight();
        }
        // now we start deleting the node
        if(trav == null)
            return null;
        else {
            E removedData = trav.getData(); // just to know what we removed
                                            // for the return
            deleteNode(trav,parent);
            return removedData;
        }
    }
    private void deleteNode(BSTNode<K,E> toDelete , BSTNode<K,E> parent) {
        if (toDelete.getLeft() != null && toDelete.getRight() != null) {
            //find replacement and its partner
            BSTNode<K,E> replaceParent = toDelete;
            //get the smallest item in the right subtree
            BSTNode<K,E> replace = toDelete.getRight();

            while(replace.getLeft() != null) { // هذي عبيناها حنا
                replaceParent = replace;
                replace = replace.getLeft();
            }
            toDelete.setKey(replace.getKey());
            toDelete.setData(replace.getData());
            //Recursively delete the replacement item's old node.
            // it has most one child,
            //so we don't have to worry about infinite recusrsion
            deleteNode(replace, replaceParent);
        }
        else {
            BSTNode<K,E> toDeleteChild;

            if (toDelete.getLeft() != null)
                toDeleteChild = toDelete.getLeft();
            else
                toDeleteChild = toDelete.getRight();


            if (toDelete == root)
                root = toDeleteChild;
            else if (toDelete.getKey().compareTo(parent.getKey()) < 0)
                parent.setLeft(toDeleteChild);

            else if (toDelete.getKey().compareTo(parent.getKey()) > 0)
                parent.setRight(toDeleteChild);
        }

    }
    //////////////////////////////////////////////////
    //Exercises

    public K findMax() {

        BSTNode<K, E> max = root;
        if (max == null)
            return null;

        while (max.getRight() != null)
            max = max.getRight();

        return max.getKey();
    }

    public K findMini() {

        BSTNode<K, E> min = root;
        if (min == null)
            return null;

        while (min.getLeft() != null)
            min = min.getLeft();

        return min.getKey();

    }


}
