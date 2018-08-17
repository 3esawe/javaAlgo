package Week3;

import Week2.Players;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge_sort {

    private Merge_sort() {
    }

    private static void merge (Comparable[] a , Comparable[] b , int low , int mid , int high  ){

        System.arraycopy(a, low, b, low, high + 1 - low);
        int i = low ;
        int j = mid +1;
        for (int k = low ; k <= high ; k++ ){
            if ( i > mid ) a[k] =  b[j++];
            else if ( j > high) a[k] = b[i++];
            else if (less(b[j],a[i])) a[k] = b[j++];
            else a[k] = b[i++];
        }
    }

    private static void  sort(Comparable[] a , Comparable[] b , int low  , int high){
        if(low >= high) return;
        int mid= low+(low+high)/2;
        sort(a,b,low,mid);
        sort(a,b,mid+1,high);
        merge(a,b,low,mid,high);
    }



    public static void merge_sort(Comparable [ ] a ){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }







    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
