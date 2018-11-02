package Merge_sort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingInversion {
    public static void main(String[] args) throws Exception {
        int  x [] = null;
        try (BufferedReader fileReader = new BufferedReader(new FileReader("IntegerArray.txt"))) {
            List<String> lines = new ArrayList<String>();
            String line;
            while(( line = fileReader.readLine()) != null) {
                lines.add(line);
            }

            String [] c = lines.toArray(new String[]{});
            System.out.println(c.length);
            x  = new int[c.length];
            System.out.println(Arrays.toString(c));
            for (int i = 0; i < c.length; i++){
                x[i] = Integer.parseInt(c[i]);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }


        long c = countinvs(x);
        System.out.println(c);
//        System.out.println(mergeSort(x,x.length));
//        System.out.println(getInvCount(x,x.length));
    }

    static long countinvs(int [] x){
        long count = 0;
        for (int i = 0; i < x.length; i++){
            for (int j = i+ 1; j < x.length; j++){
                if (x[i] > x[j]){
                    count ++;
                }
            }
        }
        return count;
    }

    public static long split(int [] a, int [] b, int lo, int hi){
        long count =0 ;
        int mid =0;
        if (lo < hi){
            mid = (hi + lo)/2;
            long l = split(a,b,lo,mid);
            long r =split(a,b,mid+1, hi );
            long z = merege_count(a, b,lo,mid+1, hi);
            count = l + z+ r;

        }
        return count;
    }
    public static long merege_count(int [] a,int[] b,int lo, int mid, int hi){
        long count = 0;
        for (int k =lo; k <= hi ; k++){
            b[k] = a[k];
        }
        int i = lo;
        int j = mid;
        for (int k = lo; k <= hi; k++){
            if (i > mid ) {
                a[k] = b[j++];

            }
            else if (j > hi) a[k] = b[i++];
            else if (b[j] < b[i] ){
                a[k] = b[j++];
                count = count + (hi/2 - i);
//                System.out.println("*");
            }
            else
                a[k] = b[i++];

        }

        return count;
    }


    public static long countinv(int [] x){
        int [] aux = new int[x.length];
        return split(x,aux,0,x.length-1);
    }















    static  int getInvCount(int arr[], long n)
    {
        int inv_count = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i+1; j < n; j++)
                if (arr[i] > arr[j])
                    inv_count++;

        return inv_count;
    }















    static int mergeSort(int arr[], int array_size)
    {
        int temp[] = new int[array_size];
        return _mergeSort(arr, temp, 0, array_size - 1);
    }

    /* An auxiliary recursive method that sorts the input array and
      returns the number of inversions in the array. */
    static int _mergeSort(int arr[], int temp[], int left, int right)
    {
        int mid, inv_count = 0;
        if (right > left)
        {
        /* Divide the array into two parts and call _mergeSortAndCountInv()
           for each of the parts */
            mid = (right + left)/2;

        /* Inversion count will be sum of inversions in left-part, right-part
          and number of inversions in merging */
            inv_count  = _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid+1, right);

            /*Merge the two parts*/
            inv_count += merge(arr, temp, left, mid+1, right);
        }
        return inv_count;
    }

    /* This method merges two sorted arrays and returns inversion count in
       the arrays.*/
    static int merge(int arr[], int temp[], int left, int mid, int right)
    {
        int i, j, k;
        int inv_count = 0;

        i = left; /* i is index for left subarray*/
        j = mid;  /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right))
        {
            if (arr[i] <= arr[j])
            {
                temp[k++] = arr[i++];
            }
            else
            {
                temp[k++] = arr[j++];

                /*this is tricky -- see above explanation/diagram for merge()*/
                inv_count = inv_count + (mid - i);
            }
        }

      /* Copy the remaining elements of left subarray
       (if there are any) to temp*/
        while (i <= mid - 1)
            temp[k++] = arr[i++];

      /* Copy the remaining elements of right subarray
       (if there are any) to temp*/
        while (j <= right)
            temp[k++] = arr[j++];

        /*Copy back the merged elements to original array*/
        for (i=left; i <= right; i++)
            arr[i] = temp[i];

        return inv_count;
    }
}
