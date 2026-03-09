package es.uvigo.esei.aed1.activity2.circularLinked;

import es.uvigo.esei.aed1.commonLinked.Node;

public class CircularLinked {
    private Node last;
    private int numberOfValues;

    public CircularLinked() {
        this.last = null;
        this.numberOfValues = 0;
    }

    public boolean isEmpty() {
        return this.numberOfValues == 0;
    }

    public int size() {
        return this.numberOfValues;
    }

    public int firstValue() throws NullPointerException {
        if (this.isEmpty()) {
            throw new NullPointerException();
        }
        return this.last.getNext().getValue();
    }

    public boolean contains(int value) {
        if (!this.isEmpty()) {
            Node current = last.getNext();
            while (current != this.last && !current.hasValue(value))
                current = current.getNext();

            return current.hasValue(value);
        }
        return false;
    }

    public boolean contains2(int value) {
        return true;
    }

    public int numberOfOccurrences(int value) {
        if (this.isEmpty())
            return 0;

        int counter = 0;
        Node current = last.getNext();
        for (int i = 1; i <= numberOfValues; i++) {
            if (current.hasValue(value))
                counter++;
            current = current.getNext();
        }
        return counter;
    }

    public void addLast(int value) {
        Node newNode = new Node(value, null);
        if (!this.isEmpty()) {
            newNode.setNext(this.last.getNext());
            this.last.setNext(newNode);
        } else {
            newNode.setNext(newNode);
        }
        this.last = newNode;
        this.numberOfValues++;
    }

    public void removeFirst() {
        if (!this.isEmpty()) {
            Node first = this.last.getNext();
            if ((first == this.last) /* || (this.numberOfValues == 1) */)
                this.last = null;
            else
                this.last.setNext(first.getNext());
            this.numberOfValues--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.isEmpty()) {
            Node current = last.getNext();
            while (current != this.last)
                current = current.getNext();

            sb.append(current.getValue()).append(' ');
        }
        return sb.toString();
    }
}
