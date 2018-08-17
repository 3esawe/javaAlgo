package Week3;

import edu.princeton.cs.algs4.StdRandom;

/*used to improve qsort in presence of duplicate values*/
public class Quicksort3way {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    private static void sort(Comparable[] a , int lo , int high){
        if (lo >= high) return;
        Comparable v  = a[lo];
        int i = lo;

        int lt = i;
        int gt = high;
        while (i <= gt){
            int cmp = a[i].compareTo(v);
           if(cmp > 0) swap(a,lt++,i++);
           else if(cmp<0) swap(a,i,gt--);
            else i++;

        }
        sort(a,lo,lt-1);
        sort(a,gt+1,high);
    }




    private static void swap(Comparable [ ] a , int lo ,int high){
        Comparable temp = a[lo];
        a[lo] = a[high];
        a[high] = temp;
    }
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
}
