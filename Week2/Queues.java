package Week2;

public class Queues {
    private int head ;
    private int tail ;
    private int capacity ;
    private int size;
    private int [] array;

    public Queues(int capacity) {
        this.head = 0;
        this.tail = capacity-1;
        this.capacity = capacity;
        this.size = 0;
        this.array = new int[capacity];
    }

    void enqueue (int data ){
        if (size == 0) array[tail] = data;
        tail = (tail+1) % capacity;
        array[tail] = data;
        size++;
    }
    int dequeue (){

        int data = array[head];
        head = (head+1) % capacity ;
        size--;
        return data;
    }


    public static void main(String[] args) {
        Queues queues = new Queues(5);
        queues.enqueue(5);
        queues.enqueue(6);
        queues.enqueue(7);
        System.out.println(queues.dequeue());
        System.out.println(queues.dequeue());

    }
}
