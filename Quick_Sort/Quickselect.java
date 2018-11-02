package Quick_Sort;

public class Quickselect {

    public static void main(String[] args) {
        int [] c = {7, 10, 4, 3, 20, 15};
        int kth = Rselect(c,0,c.length-1,5);
        System.out.println(kth);
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

        }

        swap(a,lo,j);
        return j;
    }
    static int Rselect(int [] x,int l, int hi, int i){
        int j = partition(x,l,hi);
        if (x.length == 1) return x[0];

        else{

            if (j == i){
                return x[j];
            }
            else if (j > i){
                return Rselect(x,l,j,i);
            }
            else{
                return Rselect(x,j+1,hi,i);
            }
        }

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
