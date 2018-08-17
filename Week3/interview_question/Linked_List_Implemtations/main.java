package Week3.interview_question.Linked_List_Implemtations;

public class main {
    public static void main(String[] args) {
        Mylinkedlist mylinkedlist = new Mylinkedlist();
        MyNode myNode = new MyNode();
        mylinkedlist.InsertAtFront("omar");
        mylinkedlist.InsertAtFront(2);
        mylinkedlist.InsertAtFront(3);
        mylinkedlist.InsertAtFront(4);
        mylinkedlist.InsertAtEnd(7);
        mylinkedlist.InsertAtPos(5,9);
        mylinkedlist.delete(2);
        mylinkedlist.shuffle();
        mylinkedlist.trevarse();
        System.out.println();

        System.out.println("**************"+ mylinkedlist.get(2));

    }
}
