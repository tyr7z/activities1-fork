package es.uvigo.esei.aed1.activity2.linkedWith2References;

import es.uvigo.esei.aed1.commonLinked.Node;

public class LinkedWith2References {
    private Node first;
    private Node last;
    private int numberOfValues;

    public LinkedWith2References() {
        this.first = null;
        this.last = null;
        this.numberOfValues = 0;
    }

    public boolean isEmpty() {
        return this.numberOfValues == 0;
    }

    public int size() {
        return this.numberOfValues;
    }

    public int numberOfOccurrences(int value) {
        int i = 0;
        for (Node current = this.first; current != null; current = current.getNext()) {
            if (current.hasValue(value))
                i++;
        }
        return i;
    }

    public boolean contains(int value) {
        for (Node current = this.first; current != null; current = current.getNext()) {
            if (current.hasValue(value))
                return true;
        }
        return false;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value, null);
        if (this.isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
        this.numberOfValues++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value, null);
        if (this.isEmpty())
            this.first = newNode;
        else
            this.last.setNext(newNode);
        this.last = newNode;
        this.numberOfValues++;
    }

    public void remove(int value) {
        if (this.isEmpty())
            return;

        Node current = this.first;
        Node previous = null;

        while (current != null && !current.hasValue(value)) {
            previous = current;
            current = current.getNext();
        }

        if (current == null)
            return;

        if (previous == null)
            this.first = current.getNext();
        else
            previous.setNext(current.getNext());

        if (current == this.last)
            this.last = previous;

        this.numberOfValues--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node current = this.first; current != null; current = current.getNext()) {
            sb.append(current.getValue()).append(' ');
        }
        return sb.toString();
    }
}
