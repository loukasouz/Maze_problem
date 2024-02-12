import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringQueueImpl implements StringQueue{
    private Node head, tail;
    private int size;
 List l = new List();
    private class Node {
        String item;
        Node next;
        Node(String item) {
            this.item = item;
            next = null; } }
    StringQueueImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public void put(String item) {
        Node t = tail;
        tail = new Node(item);
        if(isEmpty())
        {
            head =tail;
        }else{t.next =  tail;}
        l.insertAtBack(item);
        size++;

    }

    @Override
    public String get() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("NoSuchElementException");

        } else {
            String v = head.item;
            Node t = head.next;
            head = t;
            l.removeFromFront();
            size--;
            return v;
        }
    }

    @Override
    public String peek() throws NoSuchElementException {
        if(isEmpty()) {

            throw new NoSuchElementException("NoSuchElementException");

        }else {
            String v = head.item;
            return v;
        }
    }

    @Override
    public void printQueue(PrintStream stream) {
        while(!isEmpty())
        {
            stream.println(head.item);
            stream.flush();
            head = head.next;
        }

    }

    @Override
    public int size() {
        return size;
    }
}
