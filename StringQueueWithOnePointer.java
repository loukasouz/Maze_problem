public class StringQueueWithOnePointer {
    private Node head;
    private int size;
    CircularList l = new CircularList();
    CircularList.Node n = null;

    private class Node
    {
        String item;
        Node next;
        Node(String item)
        {
            this.item = item;
            next = null;
        }

    }

    StringQueueWithOnePointer()
    {
        this.head = null;
        size = 0;
    }
    public boolean isEmpty(){return (head == null);}

    public void put(String item)
    {
        Node t = head;
        head = new Node(item);
        l.insert(n,item);
        size++;
    }
    public int size()
    {return size;}

    public String get()
    {
        String v = head.item;
        Node t = head.next;
        head = t;

        l.remove(n);

        size--;
        return v;
    }


}
