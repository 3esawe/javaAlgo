package Week3.interview_question.Linked_List_Implemtations;

public class MyNode <E> {
    private MyNode next;
    private MyNode prev;
    private E data;

    public MyNode() {
    }

    public MyNode(E data) {
        this.data = data;
    }

    public MyNode(MyNode next, MyNode prev, E data) {
        this.next = next;
        this.prev = prev;
        this.data = data;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public MyNode getPrev() {
        return prev;
    }

    public void setPrev(MyNode prev) {
        this.prev = prev;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
