package Week4;

import edu.princeton.cs.algs4.MinPQ;

public class HeapPQ <Key extends Comparable<Key>> {
    private Key[] heapPQ;
    private int size;

    public HeapPQ(int cap) {
        this.heapPQ = (Key[]) new Comparable[cap+1];
        size = 0;
    }

    public void insert (Key key){
        heapPQ[++size] = key;
        swim(size);
    }

    private void swim (int key) {
        while (key > 1 &&  isless(key/2, key)){
            swap(key,key/2);
            key = key /2;
        }
    }

    private void sink(int key) {
        while (key*2 <= size){
            int j = 2 *key;
            if ( j < size && isless(j,j+1)) j++;
            if (isgreater(key,j)) break;
            swap(key,j);
            key = j;

        }
    }
    private  boolean isless(int a , int b ){
        return heapPQ[a].compareTo(heapPQ[b]) < 0;
    }

    private  boolean isless(Comparable[ ] keys,int a , int b ){
        return keys[a].compareTo(keys[b]) < 0;
    }
    private  boolean isgreater(int a , int b ){
        return heapPQ[a].compareTo(heapPQ[b]) > 0;
    }
    private  void swap( int lo ,int high){
        Key temp = heapPQ[lo];
        heapPQ[lo] = heapPQ[high];
        heapPQ[high] = temp;
    }

    private  void swap( Comparable []key, int lo ,int high){
        Comparable temp = key[lo];
        key[lo] = key[high];
        key[high] = temp;
    }
    public Key deleteAtPos(int k){
        Key key = heapPQ[k];

        if (key == null) {
            throw new NullPointerException("Wrong index");
        }
        swap(k,size--);
        sink(k);
        heapPQ[size+1] = null;
        return key;
    }
    public Key deletMax (){
        Key key = heapPQ[1];
        swap(1,size--);
        sink(1);
        heapPQ[size+1] = null;
        return key;
    }

    public Key deletMin(){

        Key key = heapPQ[size--];

        heapPQ[size+1] = null;
        return key;
    }
    public void print(){
        for (int i = 1; i <= size; i++){
            System.out.println(heapPQ[i]);
        }
    }

    public int getSize() {
        return size;
    }



    public void Heapsort(){
        int temp  = size;
        while (temp  > 1 ){
            swap(1,temp--);
            sink(1,temp);
        }
    }

    private  void sink( int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && isless( j, j+1)) j++;
            if (!isless( k, j)) break;
            swap( k, j);
            k = j;
        }
    }


    public static void main(String[] args) {
        HeapPQ<Character> heapPQ = new HeapPQ<>(10);
        heapPQ.insert('T');
        heapPQ.insert('A');
        heapPQ.insert('Z');
        heapPQ.insert('W');
        heapPQ.insert('O');
        heapPQ.insert('Q');
        heapPQ.print();
        System.out.println("***************");

        heapPQ.Heapsort();
        heapPQ.print();
//        System.out.println(heapPQ.deletMax());
//        System.out.println(heapPQ.deletMin());
//        System.out.println(heapPQ.deletMin());
//        System.out.println(heapPQ.deletMin());

//        System.out.println(heapPQ.getSize());
//        System.out.println(heapPQ.deleteAtPos(1));
//        heapPQ.print();
//        System.out.println("***************");
//        System.out.println(heapPQ.deleteAtPos(2));
//        heapPQ.print();

//        System.out.println(heapPQ.deletMax());
//        System.out.println("***************");
//        System.out.println(heapPQ.deletMax());
//        System.out.println("***************");
//        heapPQ.print();
//        System.out.println("***************");
//        System.out.println(heapPQ.deletMax());
//        System.out.println("***************");
//        heapPQ.print();







    }
}
