package Week3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;


public class Quicksort {
    static  int count = 0;

    public static void main(String[] args) {
        int [] x = {2,3,4,1};
        sort(x);
        System.out.println(Arrays.toString(x));;
    }

    private static int partition (int[] a , int lo ,int hi ){
        int i = lo;

        int j = hi +1;

        int v = a[lo];

        while (true){
            while (less(a[++i],v)) {
                if (i == hi) break;
            }
            while (less(v ,a[--j])){

                if (j== lo) break;
            }
            if (i >= j) break;
            swap(a,i,j);
            count ++;

        }

        swap(a,lo,j);
        return j;
    }

    private static void sort (int [] a , int lo, int hi){
        if (hi <= lo) return;
        int partition = partition(a,lo,hi);
        sort(a,lo,partition-1);
        sort(a,partition+1,hi);

    }

    public static void sort(int [] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static boolean less(int v, int w) {
        return v < w;
    }
    private static void swap(int [ ] a , int lo ,int high){
        int temp = a[lo];
        a[lo] = a[high];
        a[high] = temp;
    }

}
