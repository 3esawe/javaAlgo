package Week4.Symboal.Table;
import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.MinPQ;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ST <Key extends Comparable<Key> , Value> implements  IST<Key,Value>  {
    private Node head;
    private int size;


    public ST() {
    }

    @Override
    public void put(Key key , Value value) {
        if ( size == 0){
            head = new Node(key,value,null);
            size++;
            return;
        }
        else if (key.compareTo(head.getKey()) < 0 ){
            while (head != null && key.compareTo(head.getKey()) < 0 ){
                Node old = head;
                head = new Node(key,value,old);

            }
            size ++;
        }


        else {
            Node temp = head ;
            while (temp.getNext() != null &&  key.compareTo(temp.getNext().getKey()) > 0){

                temp = temp.getNext();
            }
            Node node  =  new Node(key,value,temp.getNext());
            temp.setNext(node);
            size++;
        }

    }

    @Override
    public Value get(Key key) {
        Node temp = head;
        while (temp != null ){
            if (temp.getKey().equals(key)) return temp.getValue();
            temp = temp.getNext();
        }

        return null;
    }

    @Override
    public void delete(Key key) {
        Node temp = head;
        Node prev = null;
        if (temp.getKey().equals(key)){
            head = head.getNext();
            size--;
            return;
        }
        while (temp != null && temp.getKey() != key){
            prev = temp;
            temp = temp.getNext();
        }
        prev.setNext(temp.getNext());
        size++;
    }

    @Override
    public boolean contains(Key key) {
        Node temp = head ;
        while ( temp != null){
            if (temp.getKey() == key){
                return true;
            }
            else temp = temp.getNext();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Key min() {
        return head.getKey();
    }

    @Override
    public Key max() {
        Node temp = head;
        while (temp.getNext() != null){
            temp = temp.getNext();
        }
        return temp.getKey();
    }

    @Override
    public Key floor(Key key) {
        Node temp = head;
        Node prev = null;
        while (temp.getKey() != key && temp != null){
            prev = temp;
            temp = temp.getNext();
        }
        return prev.getKey();

    }

    @Override
    public Key ceiling(Key key) {
        if (contains(key)){
            Node temp = head;
            while (temp != null && !(temp.getKey().equals(key))){
                temp = temp.getNext();
            }
            return temp.getNext().getKey();
        }

        return null;
    }

    @Override
    public int rank(Key key) {
        int count = 0;
        if ( contains(key)){
            Node temp = head;
            while (temp.getNext() != null && !(temp.getKey().equals(key))){
                temp = temp.getNext();
                count ++;
            }
        }
        return count;
    }

//    @Override
//    public Key select(int k) {
//        return null;
//    }

    @Override
    public void deleteMin() {
        head = head.getNext();
    }

    @Override
    public void deleteMax() {
        Node temp = head;
        Node prev = null;

        while (temp != null ){
            prev = temp;
            temp = temp.getNext();
        }
        prev.setNext(temp);
        size++;
    }

    @Override
    public int search( Key key) {
        Node temp = head;
        int count = 1 ;
        while (temp.getKey() != null && temp.getKey() != key){
            temp = temp.getNext();
            count ++ ;
        }
        return count;
    }

    @Override
    public Iterable<Key> keys() {
        edu.princeton.cs.algs4.Queue  queue = new edu.princeton.cs.algs4.Queue<>();
        for (Node x = head; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }




    private final class Node {
        private Key key;
        private Value value;
        private Node next;

        private Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        private Node() {
        }

        private Key getKey() {
            return key;
        }

        private void setKey(Key key) {
            this.key = key;
        }

        private Value getValue() {
            return value;
        }

        private void setValue(Value value) {
            this.value = value;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }
    }


    public static void main(String[] args) {
        IST <String, Integer> ist = new ST<>();
        ist.put("Omar", 5);
        ist.put("Ali", 6);
        ist.put("Zaid" , 8);
        ist.put("Bob", 5);
        ist.put("Rashed" , 3);
        System.out.println(ist.search("Omar"));
        BinarySearchST <String, Integer> binarySearchST = new BinarySearchST<>();
        binarySearchST.put("Omar", 5);
        binarySearchST.put("Ali", 6);
        binarySearchST.put("Zaid" , 8);
        binarySearchST.put("Bob", 5);
        binarySearchST.put("Rashed" , 3);
        System.out.println(binarySearchST.floor("Ali"));

//        System.out.println(ist.get("Zaid"));
//        ist.delete("Omar");
//        System.out.println(ist.contains("Ali"));
//        System.out.println(ist.floor("Zaid"));
        System.out.println(ist.floor("Bob"));


    }

}
