import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl implements StringStack{

    private Node head;
    private int  size;
    List l = new List();
    private class Node
    {
        String item;
        Node next;
        Node(String item,Node next)
        {
            this.item = item;
            this.next = next;
        }
    }
    StringStackImpl(){
        head = null;
        size = 0;
    }
    @Override
    public boolean isEmpty() {
        return(head == null);
    }

    @Override
    public void push(String item) {
       head = new Node(item,head);
       l.insertAtFront(item);
       size++;
    }

    @Override
    public String pop() throws NoSuchElementException {

      if(isEmpty()){
          throw new NoSuchElementException("NoSuchElementException");
      }else {
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
    public void printStack(PrintStream stream) {
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
