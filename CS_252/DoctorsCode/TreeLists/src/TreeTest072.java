
// Importing required classes
import java.io.*;
import java.lang.*;
import java.util.*;

// Class 1
// Helper class (Node class)
public class TreeTest072 {

    // Main driver method
    public static void main(String[] args) {
        /*
         * // Creating object of class 2 inside main() method
         * Array_Tree obj = new Array_Tree(3);
         *
         * // Setting root node
         * obj.Root("A");
         * obj.set_Left("B", 0);
         * obj.set_Right("C", 0);
         * obj.set_Left("D", 1);
         * obj.set_Right("E", 1);
         * obj.set_Right("F", 2);
         * // obj.print_Tree();
         * // obj.postOrder(0);
         */
        BTNode<Integer> root = new BTNode<Integer>();
        BTNode<Integer> l1 = new BTNode<Integer>();
        BTNode<Integer> r1 = new BTNode<Integer>();
        BTNode<Integer> l2 = new BTNode<Integer>();
        BTNode<Integer> r2 = new BTNode<Integer>();
        BTNode<Integer> r3 = new BTNode<Integer>();

        root.setItem(7);
        l1.setItem(5);
        r1.setItem(8);
        l2.setItem(2);
        r2.setItem(6);
        r3.setItem(9);

        root.setLeft(l1);
        root.setRight(r1);
        l1.setLeft(l2);
        l1.setRight(r2);
        r1.setRight(r3);
        System.out.println("\n Is Bst " + isBST(root));
        /*
         * // r2.setRight(r3);
         * // System.out.println("\n " + root.getLeft().getLeft().getItem());
         * // postOrder(root);
         * // breadthFirstOrder(root);
         * // System.out.println(occurrence(root, 9));
         * // printWithoutSiblins(root);
         * printPath(root, "");
         */
        BSTree<Integer, String> bst = new BSTree();
        bst.insert(8, "Ahmed");
        bst.insert(7, "Fahed");
        bst.insert(11, "Mohmand");
        bst.insert(10, "Khlad");
        bst.insert(9, "Saad");
        bst.insert(12, "Adl");

        System.out.println("Max Key " + bst.findMax());

        System.out.println("Min Key " + bst.findMini());
        // bst.printPreOrder();
        // bst.delete(8);
        // System.out.println("AFter delete 10 ");
        // bst.printPreOrder();

    }

    public static <E> void preOrder(BTNode<E> p) {
        if (p != null) {
            System.out.println(p.getItem());
            preOrder(p.getLeft());
            preOrder(p.getRight());
        }
    }

    public static <E> void inOrder(BTNode<E> p) {
        if (p != null) {
            inOrder(p.getLeft());
            System.out.println(p.getItem());
            inOrder(p.getRight());
        }
    }

    public static <E> void postOrder(BTNode<E> p) {
        if (p != null) {
            postOrder(p.getLeft());
            postOrder(p.getRight());
            System.out.println(p.getItem());
        }
    }

                    public class LinkedQueue<E> {
                        private singlyLinkedList<E>list=new singlyLinkedList();
                        public LinkedQueue() {}
                        public boolean isEmpty(){return list.isEmpty();}
                        public void enqueue(E element){list.addLast(element);}
                        public E first(){return list.first();}
                        public E dequeue(){return list.removeFirst();}
                        public int size(){return list.size();}
                    }
                    public  <E> void breadthFirstOrder(BTNode<E> root) {
                        LinkedQueue<BTNode<E>> lq = new LinkedQueue<>();
                        lq.enqueue(root);
                        while (!lq.isEmpty()) {
                            BTNode<E> p = lq.dequeue();
                            System.out.print(" " + p.getItem() + " ");
                            if (p.getLeft() != null)
                                lq.enqueue(p.getLeft());

                            if (p.getRight() != null)
                                lq.enqueue(p.getRight());
                        }
                    }


    public static <E> int sum(BTNode<E> p) {
        if (p == null)
            return 0;
        return (int) p.getItem() + sum(p.getLeft()) + sum(p.getRight());
    }

    // occurrence
    public static <E> int occurrence(BTNode<E> p, E key) {
        if (p == null)
            return 0;
        if (p.getItem() == key)
            return 1 + occurrence(p.getLeft(), key) + occurrence(p.getRight(), key);

        return occurrence(p.getLeft(), key) + occurrence(p.getRight(), key);
    }

    public static <E> void printWithoutSiblins(BTNode<E> p) {
        if (p != null) {

            if (p.getLeft() != null && p.getRight() == null)
                System.out.println(p.getLeft().getItem());

            if (p.getLeft() == null && p.getRight() != null)
                System.out.println(p.getRight().getItem());

            printWithoutSiblins(p.getLeft());
            printWithoutSiblins(p.getRight());
        }
    }

    public static <E> void printPath(BTNode<E> p, String path) {
        if (p != null) {
            if (p.isLeaf()) {
                System.out.println(path + p.getItem());
                return;
            }
            printPath(p.getLeft(), path + p.getItem());
            printPath(p.getRight(), path + p.getItem());

        }
    }

    public static boolean isBST(BTNode root) {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBinarySearchTree(BTNode root, int low, int high) {
        if (root == null) {
            return true;
        }
        if ((int) root.getItem() <= low || (int) root.getItem() >= high) {
            return false;
        }
        return isBinarySearchTree(root.getLeft(), low, (int) root.getItem())
                && isBinarySearchTree(root.getRight(), (int) root.getItem(), (int) high);
    }

}



// Class 2
// Helper class   // WITHOUT USING NODES
class Array_Tree<E> {

    // Member variables of this class
    private int root = 0;
    private E[] tree;

    Array_Tree(int h) {
        int cap = (int) Math.pow(2, (h + 1)) - 1;
        tree = (E[]) new Object[cap];
    }

    // Method 1
    // Creating root node
    public void Root(E key) {
        tree[0] = key;
    }

    // Method 2
    // Creating left son of root
    public void set_Left(E key, int root) {

        int t = (root * 2) + 1;

        if (t >= tree.length)
            throw new IllegalStateException("Array based tree is full");

        if (tree[root] == null) {
            System.out.printf(
                    "Can't set child at %d, no parent found\n",
                    t);
        } else {
            tree[t] = key;
        }
    }

    // Method 3
    // Creating right son of root
    public void set_Right(E key, int root) {
        int t = (root * 2) + 2;

        if (t >= tree.length)
            throw new IllegalStateException("Array based tree is full");

        if (tree[root] == null) {
            System.out.printf(
                    "Can't set child at %d, no parent found\n",
                    t);
        } else {
            tree[t] = key;
        }
    }

    // Method 4
    // To print our tree
    public void print_Tree() {

        // Iterating using for loop
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                System.out.print(tree[i]);
            else
                System.out.print("-");
        }
    }

    public void preOrder(int index) {
        if (index < tree.length) {
            if (tree[index] != null) {
                System.out.println(tree[index]);
                preOrder((2 * index + 1));
                preOrder((2 * index + 2));
            }
        }
    }

    public void inOrder(int index) {
        if (index < tree.length) {
            if (tree[index] != null) {
                inOrder(2 * index + 1);

                System.out.println(tree[index]);
                inOrder((2 * index + 2));
            }
        }
    }

    public void postOrder(int index) {
        if (index < tree.length) {
            if (tree[index] != null) {
                postOrder((2 * index + 1));
                postOrder((2 * index + 2));

                System.out.println(tree[index]);
            }
        }
    }

}


class BTNode<E> {
    private E item;
    private BTNode<E> left;
    private BTNode<E> right;

    public BTNode() {
        item = null;
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

    public boolean isLeaf() {
        return (left == null && right == null);
    }

}

class BSTNode<K, T> {
    private K key;
    private T data;
    private BSTNode<K, T> left;
    private BSTNode<K, T> right;

    /** Constructors */
    public BSTNode() {
        left = right = null;
    }

    public BSTNode(K key, T data) {
        this.key = key;
        this.data = data;
        left = right = null;
    }

    public BSTNode(K key, T data, BSTNode<K, T> left, BSTNode<K, T> right) {
        this.key = key;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    /** Get and set the data value */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /** Get and set the left child */
    public BSTNode<K, T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<K, T> left) {
        this.left = left;
    }

    /** Get and set the right child */
    public BSTNode<K, T> getRight() {
        return right;
    }

    public void setRight(BSTNode<K, T> right) {
        this.right = right;
    }

    /** return True if a leaf node, false otherwise */
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

}

class BSTree<K extends Comparable<K>, E> {

    private BSTNode<K, E> root;

    public E search(K k) { // "wrapper method"
        BSTNode<K, E> n = searchTree(root, k); // get Node for key
        if (n == null)
            return null; // no such key
        else
            return n.getData(); // return list of values for key
    }

    private BSTNode<K, E> searchTree(BSTNode<K, E> n, K key) {
        if (n == null)
            return null;

        else if (n.getKey().compareTo(key) == 0)
            return n;

        else if (key.compareTo(n.getKey()) < 0)
            return searchTree(n.getLeft(), key);
        else
            return searchTree(n.getRight(), key);

    }

    public void insert(K key, E data) {
        BSTNode<K, E> parent = null;
        BSTNode<K, E> trav = root;
        while (trav != null) {
            // what should go here?
            parent = trav;
            if (key.compareTo(trav.getKey()) < 0)
                trav = trav.getLeft();
            else
                trav = trav.getRight();

        }
        BSTNode<K, E> newNode = new BSTNode<K, E>(key, data);
        if (root == null)
            root = newNode;
        else if (parent.getKey().compareTo(key) > 0)
            parent.setLeft(newNode);
        else
            parent.setRight(newNode);
    }

    public E delete(K key) {
        BSTNode<K, E> parent = null;
        BSTNode<K, E> trav = root;

        while (trav != null && trav.getKey().compareTo(key) != 0) {
            parent = trav;
            if (key.compareTo(trav.getKey()) < 0)
                trav = trav.getLeft();
            else
                trav = trav.getRight();
        }
        // Delete the node (if any) and return the removed item.
        if (trav == null) // no such key
            return null;
        else {
            E removedData = trav.getData();
            deleteNode(trav, parent); // call helper method
            return removedData;
        }
    }

    private void deleteNode(BSTNode<K, E> toDelete, BSTNode<K, E> parent) {

        if (toDelete.getLeft() != null && toDelete.getRight() != null) {
            // Find a replacement â€“ and the replacement's parent.
            BSTNode<K, E> replaceParent = toDelete;
            // Get the smallest item in the right subtree.
            BSTNode<K, E> replace = toDelete.getRight();

            // what should go here?
            while (replace.getLeft() != null) {
                replaceParent = replace;
                replace = replace.getLeft();
            }

            // Replace toDelete's key and data with those of the replacement item.
            toDelete.setKey(replace.getKey());
            toDelete.setData(replace.getData());
            // Recursively delete the replacement item's old node. It has at most one child,
            // so we don't have to
            // worry about infinite recursion.
            deleteNode(replace, replaceParent);
        } else {
            BSTNode<K, E> toDeleteChild;

            if (toDelete.getLeft() != null)
                toDeleteChild = toDelete.getLeft();
            else
                toDeleteChild = toDelete.getRight();

            // Note: in case 1, toDeleteChild will have a value of null.
            if (toDelete == root)
                root = toDeleteChild;
            else if (toDelete.getKey().compareTo(parent.getKey()) < 0)
                parent.setLeft(toDeleteChild);
            else
                parent.setRight(toDeleteChild);
        }

    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(BSTNode<K, E> p) {

        if (p != null) {
            System.out.println(p.getKey());
            printPreOrder(p.getLeft());
            printPreOrder(p.getRight());
        }
    }

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