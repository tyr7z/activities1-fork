package es.uvigo.esei.aed1.activity2.circularDoublyLinked;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class CircularDoublyLinked {
    private DoubleNode last;
    private int numberOfValues;

    public CircularDoublyLinked() {
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
        if (!this.isEmpty()) {
            for (DoubleNode current = this.last.getNext(); current != this.last; current = current.getNext()) {
                if (current.hasValue(value))
                    i++;
            }
        }
        return i;
    }

    public boolean contains(int value) {
        if (!this.isEmpty()) {
            for (DoubleNode current = this.last.getNext(); current != this.last; current = current.getNext()) {
                if (current.hasValue(value))
                    return true;
            }
        }
        return false;
    }

    public int firstValue() throws NullPointerException {
        if (this.isEmpty()) {
            throw new NullPointerException();
        }
        return this.last.getNext().getValue();
    }

    public void addLast(int value) {
        DoubleNode newNode = new DoubleNode(this.last, value, null);
        if (this.isEmpty()) {
            newNode.setPrevious(newNode);
            newNode.setNext(newNode);
        } else {
            DoubleNode first = this.last.getNext();
            newNode.setNext(first);
            first.setPrevious(newNode);
            this.last.setNext(newNode);
        }
        this.last = newNode;
        this.numberOfValues++;
    }

    public void removeFirst() {
        if (this.isEmpty())
            return;

        DoubleNode first = this.last.getNext();
        if (this.last == first)
            this.last = null;
        else {
            DoubleNode next = first.getNext();
            next.setPrevious(this.last);
            this.last.setNext(next);
        }
        this.numberOfValues--;
    }

    public void remove(int value) {
        if (this.isEmpty())
            return;

        DoubleNode first = this.last.getNext();
        DoubleNode current = first;
        while (current != null) {
            if (current.hasValue(value)) {
                if (current == this.last && current.getNext() == this.last) {
                    this.last = null;
                } else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                    if (current == this.last) {
                        this.last = current.getPrevious();
                    }
                }
                numberOfValues--;
                return;
            }
            current = current.getNext();
            if (current == first)
                break;
        }
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        DoubleNode current = this.last.getNext();
        for (int i = 0; i < this.numberOfValues; i++) {
            sb.append(current.getValue());
            if (i < this.numberOfValues - 1) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
