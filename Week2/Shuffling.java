package Week2;
import java.util.*;
public class Shuffling{
    public static void main(String[] args) {
        int [] x = {1,2,3,4};
        Shuffle(x);
        System.out.println(Arrays.toString(x));
    }
    public static void Shuffle(int [] array){
        Random random = new Random();
        for (int i = 1; i <= array.length-1; i++){
            int rand = random.nextInt(i) + 1;
            int temp = array[rand];
            array[i] = temp;
            array[rand] = array[i];
        }
    }
}
