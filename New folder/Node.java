public class Node {
    Book data;
    Node prev;
    Node next;

    public Node(Book data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}