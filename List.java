



public class List implements ListInterface {

    private Node head = null;
    private Node tail = null;


    public List() {
    }


    @Override
    public boolean isEmpty() {
        return head == null;
    }


    @Override
    public void insertAtFront(String data) {
        Node n = new Node(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
    }

    @Override
    public void insertAtBack(String data) {
        Node n = new Node(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

  //throws EmptyListException
    @Override
    public String removeFromFront() {

        String data = head.getData();

        if (head == tail)
            head = tail = null;
        else
            head = head.getNext();

        return data;
    }


   // throws EmptyListException
    @Override
    public String removeFromBack() {


        String data = tail.getData();

        if (head == tail)
            head = tail = null;
        else {
            Node iterator = head;
            while (iterator.getNext() != tail)
                iterator = iterator.getNext();

            iterator.setNext(null);
            tail = iterator;
        }

        return data;
    }


    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty :(";
        }

        Node current = head;

        StringBuilder ret = new StringBuilder();

        // while not at end of list, output current node's data
        ret.append(" HEAD -> ");

        while (current != null) {
            ret.append(current.data);

            if (current.getNext() != null)
                ret.append(" -> ");

            current = current.next;
        }

        ret.append(" <- TAIL");

        return ret.toString();
    }
}

