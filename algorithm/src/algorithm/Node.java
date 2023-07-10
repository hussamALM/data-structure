package algorithm;

public class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" + this.data + "}";

    }

}
