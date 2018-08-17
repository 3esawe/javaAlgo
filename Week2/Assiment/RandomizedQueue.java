package Week2.Assiment;

public interface RandomizedQueue<Item> {
    public boolean isEmpty()    ;             // is the randomized queue empty?
    public int size()       ;                 // return the number of items on the randomized queue
    public void enqueue(Item item)     ;      // add the item
    public Item dequeue()         ;           // remove and return a random item
    public Item sample()         ;            // return a random item (but do not remove it)

}
