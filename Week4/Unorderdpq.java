package Week4;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;

import java.util.Iterator;

public class Unorderdpq<key extends Comparable<key>> {
    private key [] pq ;
    private int size;

    public Unorderdpq(int capacity) {
        this.pq = (key[]) new Comparable[capacity +1 ] ;
    }





    private  boolean isless(int a , int b ){
        return pq[b].compareTo(pq[a]) < 0;
    }

    public void insert(key x  ) {
        pq[size++] = x ;

    }

    private boolean less(key v, key w) {
        return v.compareTo(w) < 0;
    }

    public void InsertInOrder(key Key) {
        int i = size-1;
        while (i >= 0 && less(Key, pq[i])) {
            pq[i+1] = pq[i];
            i--;
        }
        pq[i+1] = Key;
        size++;
    }

    public key deleteMin(){
        int min = 0;
        for (int i = 1; i < size; i++){
            if (isless(min,i)) min = i;
        }
        swap(min,size-1);
        return pq[--size];


    }
    private  void swap( int lo ,int high){
        key temp = pq[lo];
        pq[lo] = pq[high];
        pq[high] = temp;
    }

    public static void main(String[] args) {
        Unorderdpq<String> unorderdpq = new Unorderdpq<>(6);

//        System.out.println(unorderdpq.deleteMin());




    }
}
