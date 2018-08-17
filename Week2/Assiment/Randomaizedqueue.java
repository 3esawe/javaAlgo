package Week2.Assiment;

import java.util.*;

public class Randomaizedqueue<T> implements RandomizedQueue<T> , Iterable {
    private int N;
    private T[] q;

    public Randomaizedqueue() {
        N = 0;
        this.q = (T[]) new Object[2] ;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void enqueue(T o) {
        if ( N == q.length) {
           T[] w =  Arrays.copyOf(q,q.length*2);
           q = w;
        }
        q[N++] = o ;
    }

    @Override
    public T dequeue() {

        Random rand = new Random();
        int random = rand.nextInt(N) +1;
        System.out.println(random-1);

        T  t = q[random-1];
        q[random-1] = null;
        N--;
        return t;
    }

    @Override
    public T sample() {
        Random rand = new Random();

        int random = rand.nextInt(N);
        T t = q[random];
        return t ;

    }

    @Override
    public Iterator iterator() {
        return new RIterator();
    }

    private class RIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return N > 0 ;
        }

        @Override
        public Object next() {
            if (!hasNext()) throw new NoSuchElementException();
            T t = q[N++];
            return t;
        }
    }

    private class Node<T> {
        private Node<T>  next,prev;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public Node() {
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {
        Randomaizedqueue <String>randomaizedqueue = new Randomaizedqueue<>();
        randomaizedqueue.enqueue("omar");
        randomaizedqueue.enqueue("ali");
        randomaizedqueue.enqueue("ad");
        randomaizedqueue.enqueue("as");
        randomaizedqueue.enqueue("da");

        Iterator  iterator = randomaizedqueue.iterator();
        while (iterator.hasNext()){
            System.out.println(randomaizedqueue.dequeue());
        }
    }
}
