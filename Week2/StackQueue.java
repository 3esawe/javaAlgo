package Week2;

public class StackQueue {

    private Stacks input = new Stacks(5);
    private Stacks output = new Stacks(5);

    public StackQueue() {

    }
    public int size (){
        return input.getSize()+output.getSize();
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public void enqueue(int data ){
        input.push(data);
    }



    public int dequeue(){
        if (isEmpty()) throw new java.util.NoSuchElementException("to elements to dequeue");
        if(output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enqueue(5);
        stackQueue.enqueue(4);
        System.out.println(stackQueue.dequeue());


    }
}
