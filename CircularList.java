public class CircularList {
    static class Node {
        String val; Node next;
        Node(String v) { val = v; }
    }
    Node next(Node x) { return x.next; }

    String val(Node x) { return x.val; }

    Node insert(Node x, String v) {
        Node t = new Node(v);
        if (x == null)
        {
            t.next = t;
        }
        else { t.next = x.next; x.next = t; }

        return t; }

    void remove(Node x)
    { x.next = x.next.next; }

}
