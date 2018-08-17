package Week3;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Quicksort {


    private static int partition (Comparable[] a , int lo ,int hi ){
        int i = lo;

        int j = hi +1;

        Comparable v = a[lo];

        while (true){
            while (less(a[++i],v)) {
                if (i == hi) break;
            }
            while (less(v ,a[--j])){

                if (j== lo) break;
            }
            if (i >= j) break;
            swap(a,i,j);

        }

        swap(a,lo,j);
        return j;
    }

    private static void sort (Comparable [] a , int lo, int hi){
        if (hi <= lo) return;
        int partition = partition(a,lo,hi);
        sort(a,lo,partition-1);
        sort(a,partition+1,hi);

    }

    public static void sort(Comparable [] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void swap(Comparable [ ] a , int lo ,int high){
        Comparable temp = a[lo];
        a[lo] = a[high];
        a[high] = temp;
    }

}
