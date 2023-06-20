
class BST<Key extends Comparable <Key> , T> {

    private BSTNode<Key, T> root; 
    int size;             

    BST() {
        root = null;
        size = 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    
    public int size() {
        return size;
    }

    public BSTNode<Key, T> Getroot(){
        return root;
    }

    public void Inorder (BSTNode<Key, T> root){
          if (root==null) return;
          Inorder ( root.getLeft());
          System.out.print (root.getData());
          Inorder ( root.getRight());

    }

    
    public void insert(Key k, T e) {
        root = inserthelp(root, k, e);
        size++;
    }

    private BSTNode<Key, T> inserthelp (BSTNode<Key, T> rt, Key k, T e) {
        BSTNode<Key, T> node =new BSTNode(k, e);
        if (rt == null) {
            return node; 
        }

        BSTNode<Key, T> parent=null , current = rt;

        while (current!=null){
            parent=current;
            if (current.getKey().compareTo(k) < 0){
                current=current.getRight();
            }
            else {
               current=current.getLeft(); 
                 }
        }
        if (parent.getKey().compareTo(k) > 0) {
            parent.setLeft(node); 
        } else {
            parent.setRight(node);
        }
        return rt;
    }




    public boolean contains(T data) {

        return search(root,(Integer)data);

    }

    private  boolean search(BSTNode rt, Integer data) {
        if(rt!=null)
        {
            if (rt.getData() == data) {
                return true;
            }

            return search(rt.getLeft(), data) || search(rt.getRight(), data);
        }
        return false;
    }

    public int GetleafCount() {
        return getLeafCount(root);

    }

    int getLeafCount(BSTNode<Key, T> node) {
        if (node == null)
            return 0;

        if (node.getLeft() == null && node.getRight() == null)
            return 1;

        return getLeafCount(node.getLeft()) + getLeafCount(node.getRight());

    }




    private BSTNode<Key, T> find(BSTNode<Key, T> rt, Key k) {
        if (rt == null) {
            return null;
        }
        BSTNode<Key, T>  current = rt;

        while (current!=null && current.getKey()!=k){
            if (current.getKey().compareTo(k) < 0){
                current=current.getRight();
            }
            else {
               current=current.getLeft(); 
                 }
        }

        if (current!=null) {
            return  current;
        } else {
            return null;}
    }

    

    public BSTNode<Key, T> remove(Key k) {
        BSTNode<Key, T> temp = find(root, k); // First find it
        if (temp != null) {
             root = removehelp(root, k); // Now remove it
            size--;
        }
        return temp;
    }

    private BSTNode<Key, T> getmin(BSTNode<Key, T> rt) {//return the min node in the right subtree
        if (rt == null) {
            return null;
        }
        BSTNode<Key, T> temp =rt.getRight();
        while (temp.getLeft()!=null){
            temp= temp.getLeft();
        }
        return temp;
    }
    private BSTNode <Key, T> removehelp(BSTNode<Key, T> rt, Key k) {
     
         if (rt.getKey().compareTo(k)<0){
            rt.setRight(removehelp(rt.getRight(),k));
        }
        else if (rt.getKey().compareTo(k)>0){
            rt.setLeft(removehelp(rt.getLeft(),k));}

            else {//found the node to be delete
                if (rt.isLeaf()){
                    rt =null;
                    
                }
                else if (rt.getLeft()==null && rt.getRight()!=null){
                    rt =rt.getRight();
                    
                }
                else if (rt.getLeft()!=null && rt.getRight()==null){
                    rt =rt.getLeft();
                    
                }
                else {
                    BSTNode<Key, T> min =getmin (rt);
                    rt.setData(min.getData());
                    rt.setKey(min.getKey());
                    rt.setRight (removehelp (rt.getRight(),rt.getKey()));
                    
                    
                }
            }
            return rt;

        
        }
    }

