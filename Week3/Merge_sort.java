package Week3;

import Week2.Players;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge_sort {
    public static void main(String[] args) {

        int [] x = {1,3,4,2};
        merge_sort(x);
        System.out.println(Arrays.toString(x));
    }
    private Merge_sort() {

    }

    private static void merge (int[] a , int[] b , int low , int mid , int high  ){

        System.arraycopy(a, low, b, low, high + 1 - low);
        int i = low ;
        int j = mid +1;
        for (int k = low ; k <= high ; k++ ){
            if ( i > mid ) a[k] =  b[j++];
            else if ( j > high) a[k] = b[i++];
            else if (b[j] < b[i]) a[k] = b[j++];
            else a[k] = b[i++];
        }
    }

    private static void  sort(int[] a , int[] b , int low  , int high){
        if(low >= high) return;
        int mid= low+(high - low)/2;
        sort(a,b,low,mid);
        sort(a,b,mid+1,high);
        merge(a,b,low,mid,high);
    }



    public static void merge_sort(int [ ] a ){
        int[] aux = new int[a.length];
        sort(a,aux,0,a.length-1);
    }







//    private static boolean less(int v, int w) {
//        return v.compareTo(w) < 0;
//    }
}
