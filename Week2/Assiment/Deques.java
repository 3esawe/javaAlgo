package Week2.Assiment;

public interface Deques<Item> {
    public boolean isEmpty();
    public int size();
    public void addFirst(Item item);
    public void addLast(Item item);
    public Item removeLast();
    public Item removeFirst();


}
