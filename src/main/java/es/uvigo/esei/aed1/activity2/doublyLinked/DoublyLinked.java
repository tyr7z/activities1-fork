package es.uvigo.esei.aed1.activity2.doublyLinked;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinked {
    private DoubleNode first;
    private int numberOfValues;
    private DoubleNode last;

    public DoublyLinked() {
        this.first = null;
        this.numberOfValues = 0;
        this.last = null;
    }

    public boolean isEmpty() {
        return this.numberOfValues == 0;
    }

    public int size() {
        return this.numberOfValues;
    }

    public int numberOfOccurrences(int value) {
        int i = 0;
        for (DoubleNode current = this.first; current != null; current = current.getNext()) {
            if (current.hasValue(value))
                i++;
        }
        return i;
    }

    public boolean contains(int value) {
        for (DoubleNode current = this.first; current != null; current = current.getNext()) {
            if (current.hasValue(value))
                return true;
        }
        return false;
    }

    public void addFirst(int value) {
        DoubleNode newNode = new DoubleNode(null, value, this.first);

        if (this.isEmpty())
            this.last = newNode;
        else
            this.first.setPrevious(newNode);

        this.first = newNode;
        this.numberOfValues++;
    }

    public void addLast(int value) {
        DoubleNode newNode = new DoubleNode(this.last, value, null);

        if (this.isEmpty())
            this.first = newNode;
        else
            this.last.setNext(newNode);

        this.last = newNode;
        this.numberOfValues++;
    }

    public void remove(int value) {
        for (DoubleNode current = this.first; current != null; current = current.getNext()) {
            if (!current.hasValue(value))
                continue;

            if ((this.first == this.last) /* && (this.numberOfValues == 1) */) {
                this.first = null;
                this.last = null;
            } else {
                if (current == this.first) {
                    current.getNext().setPrevious(null);
                    this.first = current.getNext();
                } else if (current == this.last) {
                    current.getPrevious().setNext(null);
                    this.last = current.getPrevious();
                } else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
            }
            this.numberOfValues--;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (DoubleNode current = this.first; current != null; current = current.getNext()) {
            builder.append(current.getValue()).append(" ");
        }
        return builder.toString();
    }
}
