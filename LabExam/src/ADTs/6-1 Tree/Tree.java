/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Tree {

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        System.out.println(bt.getSize());
        TNode<Integer> r = bt.addRoot(5);
        TNode<Integer> lc = bt.addLeft(r, 8);
        TNode<Integer> rc = bt.addRight(r, 9);
        System.out.println(bt.isRoot(r));
        System.out.println(bt.isRoot(lc));
        System.out.println(lc.getItem());
        System.out.println(bt.isEmpty());
        System.out.println(bt.isExternal(rc));
        System.out.println(bt.isInternal(lc));
        bt.addLeft(lc, 100);
        bt.addLeft(rc, 300);
        System.out.println(bt.getSize());
        System.out.println(bt.left(lc).getItem() + 30);
    }
}
