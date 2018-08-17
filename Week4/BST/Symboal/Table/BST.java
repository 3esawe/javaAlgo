package Week4.BST.Symboal.Table;

import edu.princeton.cs.algs4.BinarySearchST;

public class BST <Key extends Comparable<Key> , Value> implements  IBST<Key,Value> {
    private Node root;

    public BST() {
    }


    @Override
    public void put(Key key, Value value) {
        root = put(root,key,value);

    }

    private Node put (Node node ,Key key, Value value){
        if ( node == null) return new Node(key,value);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            System.out.println("going left");
            node.left = put(node.left,key,value);
            System.out.println("going upward-l");

        }
        else if (cmp > 0 ) {
            System.out.println("going right");

            node.right = put(node.right,key,value);
            System.out.println("going upward-r");


        }
        else node.value =value;
        node.size = 1 + size(node.left) + size(node.right);
        System.out.println("adding the link");
        return node;
    }



    @Override
    public Value get(Key key) {
        Node temp = root;
        while (temp != null){
            int cmp = key.compareTo(temp.key);
            if (cmp < 0) temp = temp.left;
            else if (cmp > 0) temp = temp.right;
            else return temp.value;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        root = delete(root,key);
    }


    private Node delete(Node node , Key key){
        if ( key == null ) return null;
        int cmp = key.compareTo(node.key);
        if ( cmp < 0 ) node.left = delete(node.left,key);
        else if ( cmp > 0) node.right = delete(node.right,key);
        else {
            if (node.left == null ) return node.right;
            if (node.right == null ) return node.left;
            Node t  =  node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    @Override
    public boolean contains(Key key) {
       if (get(key)  != null)return true;
       else return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }
    private int size(Node  x){
        if (x == null){
            return 0;
        }
        return x.size;

    }
    private Node min (Node x ){
        if (x.left == null) return x;
        else return min(x.left);
    }
    @Override
    public Key min() {
       return min(root).key;
    }
    private Node max(Node node){
        if (node.right == null) return node;
       return max(node.right);
    }
    @Override
    public Key max() {
        return max(root).key;
    }

    @Override
    public Key floor(Key key) {
         Node x = floor(root,key);
         return x.key;
    }

    private Node floor (Node node , Key key){
        if ( node == null ) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        if (cmp < 0) return floor(node.left,key);
            Node t = floor(node.right,key);
            if ( t != null) return t;
            else return node;
    }

    @Override
    public Key ceiling(Key key) {
        return ceiling(root,key).key;

    }
    private Node ceiling (Node node , Key key){
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if ( cmp == 0) return node;
        if ( cmp > 0) return ceiling(node.right,key);
        Node t = ceiling(node.left,key);
        if (t != null) return t;
        else return node;
    }


    @Override
    public int rank(Key key) {
        return rank(root,key);
    }

    private int rank (Node node , Key key){
        if(node == null) return 0;
        int cmp = key.compareTo(node.key);
        if ( cmp < 0) return rank(node.left , key) ;
        else if ( cmp > 0) return  1 + size(node.left) + rank(node.right, key);
        else return size(node.left);
    }

    private Node deleteMin(Node x){
        if (x.left == null){
            return x.right;
//            System.out.println("going right 1 ");
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + 1 + size(x.right);
        return x;

    }
    @Override
    public void deleteMin() {
       root = deleteMin(root);
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }
    private Node deleteMax(Node x){
        if (x.right == null){
            return x.left;
//            System.out.println("going right 1 ");
        }
        x.right = deleteMax(x.right);
        return x;

    }

    public boolean isBST (){
        return  (isBST(root));
    }

    private boolean isBST(Node x ){
        if ( x.left != null){
            int cmp = x.left.key.compareTo(x.key);
            if ( cmp < 0 ) isBST(x.left);
            else return false;

        }
        if ( x.right != null){
            int cmp = x.right.key.compareTo(x.key);
            if ( cmp > 0 ) isBST(x.right);
            else return false;

        }
        return true;
    }

    private void inorder(Node root){
        if (root != null){
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
        }
    }
    public void inorder() {
        inorder(root);
    }

    @Override
    public int height() {
        return  height(root );
    }

    private int  height(Node x ) {
        int count = 0;
        if (x != null){
            count += height(x.left);
            count += height(x.right);
            count++;
        }
        return count;
    }

    private class Node {
        private Node left , right ;
        private Key key;
        private Value value;
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;

        }

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
//        edu.princeton.cs.algs4.BST<String , Integer> bst = new edu.princeton.cs.algs4.BST<String , Integer>();
////        bst.put("omar",3);
////        bst.put("ali",7);
////        bst.put("mjali",8);
////        bst.put("bani-essa",9);
////        bst.put("zaid" , 5);
//        System.out.println(bst.rank("ali"));
        BST<String , Integer> bst = new BST<>();
        bst.put("omar",3);
        bst.put("ali",7);
        bst.put("ab" , 32);
        bst.put("mjali",8);
        bst.put("bani-essa",9);
        bst.put("zaid" , 5);

        bst.inorder();
        System.out.println(bst.isBST());
//
//        bst.deleteMax();
//        bst.inorder()
//        System.out.println(bst.max());
//        System.out.println(bst.height());
//        System.out.println(bst.size());
//        bst.inorder();
    }
}
