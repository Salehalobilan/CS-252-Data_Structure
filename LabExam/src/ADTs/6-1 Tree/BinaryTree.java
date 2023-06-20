/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class BinaryTree<E> {

    private TNode<E> root;
    private int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public TNode<E> getRoot() {
        return root;
    }

    public TNode<E> addRoot(E e) {
        if (root == null) {
            root = new TNode<E>();
            root.setItem(e);
            size++;
        }
        return root;

    }

    public TNode<E> parent(TNode<E> p) {
        if (p != null) {
            TNode<E> n = p.getParent();
            return n;
        }
        return null;
    }

    public TNode<E> left(TNode<E> p) {
        if (p != null) {
            TNode<E> n = p.getLeft();
            return n;
        }
        return null;
    }

    public TNode<E> right(TNode<E> p) {
        if (p != null) {
            TNode<E> n = p.getRight();
            return n;
        }
        return null;
    }

    public boolean isRoot(TNode<E> p) {
        if (p != null) {
            if (p.getParent() == null) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

    public int getSize(TNode<E> p) {
        return size;
    }

    public TNode<E> addLeft(TNode<E> p, E e) {
        if (p != null && p.getLeft() == null) {
            TNode<E> n = new TNode<E>();
            n.setItem(e);
            p.setLeft(n);
            n.setParent(p);
            size++;
            return n;
        } else {
            return null;
        }
    }

    public TNode<E> addRight(TNode<E> p, E e) {
        if (p != null && p.getRight() == null) {
            TNode<E> n = new TNode<E>();
            n.setItem(e);
            p.setRight(n);
            n.setParent(p);
            size++;
            return n;
        } else {
            return null;
        }
    }

    public boolean isInternal(TNode<E> p) {
        if (p != null) {
            if (p.getLeft() != null || p.getRight() != null) {
                return true;
            }
        }
        return false;
    }

    public boolean isExternal(TNode<E> p) {
        if (p != null) {
            if (p.getLeft() == null && p.getRight() == null) {
                return true;
            }
        }
        return false;
    }
}// end of class BinaryTree

