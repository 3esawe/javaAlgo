package Week1.InterviesQuestions;

import com.sun.istack.internal.Nullable;

import java.util.Arrays;

/*3-SUM in quadratic time. Design an algorithm for the 3-SUM problem that takes time proportional to n2n^2n2 in the worst case. You may assume that you can sort the nnn integers in time proportional to n2n^2n2 or better.

Note: these interview questions are ungraded and purely for your own enrichment. To get a hint, submit a solution.*/
public class Q1 {
    public static void main(String[] args) {

        int [] array1 = {30, -40, -20, -10 ,40, 0, 10};
        System.out.println(sum3(array1));
        System.out.println(sum_3(array1));

    }

    /*this function is O(n^3)*/
    public static int sum3 (int [ ] x){
        int count = 0;
        for (int i = 0 ; i < x.length; i++){
            for (int j = i+1; j < x.length; j++){
                for (int k =j+1 ; k < x.length;k++){
                    if (x[i] + x[j] + x[k] == 0 ){
                        System.out.println(x[i] + " " + x[j] + " " + x[k]);
                        count++;
                    }
                }
            }
        }
        return count;
    }
    /*this one is O(n^2)
    **/

    /* the for loop we decreament  the length by 2 because our two variables left and right
    1- first we sort the array
    * 2- we create two variables left and right which are (j ,k)
    * 3- we loop through the array while the left is less than right
    * 4- if the sum is greater than the key we decreament the right value
    * 5- if the sum is less than the key we increament the left value
    * in this way we looped through all indicies in all itretions  */
    public static int  sum_3 (int [] A){
        int count = 0;
        Arrays.sort(A); // first sorting the array
        for (int i = 0; i < A.length-2; ++i) {
            int j = i+1;
            int k = A.length-1;

            while (j < k) {
                int sum = A[i]+A[j]+A[k];
                if (sum == 0) {
                    System.out.println(i+":"+ A[i]+", "+j+":"+A[j]+", "+k+":"+A[k]);
                    count++;
                }
                if (sum >= 0) {
                    --k;
                } else {
                    ++j;
                }
            }
        }
        return count;

    }

}
