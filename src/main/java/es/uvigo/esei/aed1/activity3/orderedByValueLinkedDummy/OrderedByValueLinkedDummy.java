package es.uvigo.esei.aed1.activity3.orderedByValueLinkedDummy;

public class OrderedByValueLinkedDummy {
    private NodePair dummy;
    private int numOfValues;

    public OrderedByValueLinkedDummy() {
        this.dummy = new NodePair(null, null);
        this.numOfValues = 0;
    }

    public boolean contains(int value) {
        NodePair current = this.dummy.getNext();
        while (current != null && current.getPair().getValue() < value)
            current = current.getNext();

        // return current != null && current.getPair().getValue() <= value;
        return !(current == null || current.getPair().getValue() > value);
    }

    public void add(int value) {
        NodePair current = this.dummy;
        while (current.getNext() != null && current.getNext().getPair().getValue() < value)
            current = current.getNext();

        if (current.getNext() == null || current.getNext().getPair().getValue() > value) {
            NodePair newPair = new NodePair(new Pair(1, value), null);
            newPair.setNext(current.getNext());
            current.setNext(newPair);
        } else {
            Pair pair = current.getNext().getPair();
            pair.setCounter(pair.getCounter() + 1);
        }

        this.numOfValues++;
    }

    public void remove(int value) {
        if (this.numOfValues < 1 || this.dummy.getNext() == null) {
            System.err.println("Empty structure.");
            return;
        } else if (this.numOfValues > 0) {
            NodePair current = this.dummy;
            while (current.getNext() != null && current.getNext().getPair().getValue() < value)
                current = current.getNext();

            if (current.getNext() == null || current.getNext().getPair().getValue() > value) {
                System.err.println("The value is not in the structure.");
                return;
            } else {
                Pair pair = current.getNext().getPair();
                if (pair.getCounter() == 1)
                    current.setNext(current.getNext().getNext());
                else
                    pair.setCounter(pair.getCounter() - 1);
            }

            this.numOfValues--;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NodePair current = dummy.getNext(); current != null; current = current.getNext()) {
            sb.append(current.getPair()).append(' ');
        }
        return sb.toString();
    }
}
