package Session;

import java.util.Iterator;

public class Queue<T> implements QueueInterface<T> {

    Node firstNode;
    Node lastNode;
    int totalEntries;

    Queue() {
        firstNode = null;
        lastNode = null;
        totalEntries = 0;
    }

    @Override
    public void addQueue(T newEntry) {
        Node newNode = new Node(newEntry);
        if (firstNode == null) {
            firstNode = newNode;
        } else {
            lastNode.nextNode = newNode;
        }

        lastNode = newNode;
        totalEntries++;
    }

    @Override
    public void removeFirst() {
        if (totalEntries > 0) {
            if (totalEntries == 1) {
                clearAll();

            } else {
                firstNode = firstNode.nextNode;
                totalEntries--;
            }
        }
    }

    @Override
    public void insertEntry(T newEntry, int position) {
        if (position <= totalEntries && position > 0) {
            Node newNode = new Node(newEntry);
            Node previousNode = getPositionNode(position - 1);

            if (position == 1) {
                newNode.nextNode = firstNode;
                firstNode = newNode;

            } else {
                newNode.nextNode = previousNode.nextNode;
                previousNode.nextNode = newNode;
            }
            totalEntries++;
        }
    }

    @Override
    public void removeEntry(int position) {
        if (position > 0 && totalEntries > 0) {
            Node previousNode = getPositionNode(position - 1);

            if (position == 1) {
                removeFirst();

            } else {
                if (position == totalEntries) {

                    previousNode.nextNode = null;
                    lastNode = previousNode;
                } else {
                    previousNode.nextNode = previousNode.nextNode.nextNode;
                }
                totalEntries--;
            }
        }
    }

    @Override
    public T nextEntry() {
        if (!checkEmpty()) {
            Node dataNode = firstNode;
            removeFirst();
            return dataNode.data;
        }
        return null;
    }

    @Override
    public boolean checkEmpty() {
        return firstNode == null;
    }

    @Override
    public void clearAll() {
        firstNode = null;
        lastNode = null;
        totalEntries = 0;
    }

    @Override
    public int countEntry() {
        return totalEntries;
    }

    @Override
    public Iterator<T> getIterator() {
        return new QueueIterator();
    }

    private Node getPositionNode(int position) {
        if (position > 0) {
            Node chooseNode = firstNode;
            Iterator<T> iterator = getIterator();
            int i = 1;

            while (iterator.hasNext() && i < position) {
                chooseNode = chooseNode.nextNode;
                iterator.next();
                i++;
            }

            return chooseNode;
        }
        return null;
    }

    public class QueueIterator implements Iterator<T> {

        Node nodeReturn;

        QueueIterator() {
            nodeReturn = firstNode;
        }

        @Override
        public boolean hasNext() {
            return nodeReturn != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                Node nodeNext = nodeReturn;
                nodeReturn = nodeReturn.nextNode;
                return (T) nodeNext.data;
            }
            return null;
        }

    }

    public class Node {

        private T data;
        private Node nextNode;

        private Node(T data) {
            this.data = data;
        }
    }

}
