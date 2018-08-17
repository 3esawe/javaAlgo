package Week2;

import java.util.Arrays;
import java.util.Stack;

public class Stacks  {
    private int size;
    private int [] array;

    public Stacks(int capacity){
        array = new int[capacity];
    }

    public int getSize() {
        return size;
    }

    public  void push (int data ){
        if (isFull()) {
            int [ ] c = Arrays.copyOf(array,size * 2+1);
            array = c;
        }
        array[size++] = data;
    }
    public int pop (){
        if (isEmpty()) throw  new ArrayIndexOutOfBoundsException("No items");
        if (size > 0 && size == array.length/4) {
            int [] c = Arrays.copyOf(array, array.length/2);
            array =c;
        }
        int data = array[--size];

        return data;
    }
    boolean isFull (){
        return size == array.length;
    }
    boolean isEmpty (){
        return size == 0;
    }

    public static void main(String[] args) {
        Stacks stacks = new Stacks (5);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);
        stacks.push(7);

        System.out.println(stacks.pop());


    }
}
