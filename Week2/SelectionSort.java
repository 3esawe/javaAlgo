package Week2;

public class SelectionSort {
    public static void main(String[] args) {

    }

    public static void slectionSort(Comparable [] array){
        for (int i = 0; i < array.length; i++){
            int min = i;
            for (int j = i +1 ; j < array.length ; j++){
                if (array[j].compareTo(array[min]) < 0){
                    Comparable temp = array[j];
                    array [j] = array[min];
                    array[min] = temp;
                }
            }
        }
    }
}
