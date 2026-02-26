package es.uvigo.esei.aed1.commonLinked;

public class Node {
    Node next;
    int value;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean hasValue(int value) {
        return this.value == value;
    }
}
