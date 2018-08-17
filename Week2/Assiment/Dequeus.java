package Week2.Assiment;

import java.util.Iterator;

public class Dequeus<T> implements Deques<T> ,Iterable<T> {

    private Node<T> head , tail;
   private int size;

    public Dequeus() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T t) {
        Node<T> oldfirst = head ;
        head = new Node<T>();
        head.setData(t);
        head.setNext(oldfirst);
        if (size == 0){
            tail = head;
        }
        else         oldfirst.setPrev(head);

        size++;
    }

    @Override
    public void addLast(T t) {

        Node<T> oldtail = tail;
        tail= new Node<T>();
        tail.setData(t);
        tail.setPrev(oldtail);

        if (size == 0)
            head = tail;
        else oldtail.setNext(tail);
        size++;
    }

    @Override
    public T removeLast() {
        if ( tail == null) throw new NullPointerException();
        T t = tail.getData();
        tail = tail.getPrev();
        size--;
        if (isEmpty()) head =null;
        else tail.setNext(null);
        return t;
    }

    @Override
    public T removeFirst() {
            if ( head == null )throw new NullPointerException();

            T t = head.getData();
            head = head.getNext();
            size--;
            if (isEmpty()) head = null;
            else head.setPrev(null);
            return t;

    }

    @Override
    public Iterator<T> iterator() {
        return new DequeuIterator(head);
    }

    private class DequeuIterator implements Iterator<T>{
        private Node<T> curr ;
        public DequeuIterator(Node<T> first) {
            curr = first;
        }

        @Override
        public boolean hasNext() {
            return  curr != null;
        }

        @Override
        public T next() {
            T item = curr.data;
            curr = curr.getNext();
            return item;
        }
    }
    private class Node <T> {
        Node<T> next , prev;
        T data;

        public Node() {
        }



        public Node(T data) {
            this.data = data;
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
        Dequeus<String > stringDequeus = new Dequeus<>();
        Iterator iterator = stringDequeus.iterator();
        stringDequeus.addFirst("omar");
        stringDequeus.addFirst("ali");
        stringDequeus.addFirst("bani-essa");
        stringDequeus.addFirst("bani-hani");
        stringDequeus.addLast("Rashed");
        stringDequeus.addLast("mahdi");

        while (!iterator.hasNext()){
            System.out.println(stringDequeus.removeFirst());
        }


    }
}
