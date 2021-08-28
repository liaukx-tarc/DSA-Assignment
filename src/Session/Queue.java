package Session;

import java.util.Iterator;

public class Queue<T> implements QueueInterface<T> {

    Node firstNode;
    Node lastNode;
    int totalEntry;

    Queue() {
        firstNode = null;
        lastNode = null;
        totalEntry = 0;
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
        totalEntry++;
    }

    @Override
    public boolean removeFirst() {
        if (firstNode != null) {
            if (firstNode.equals(lastNode)) {
                firstNode = null;
                lastNode = null;
                totalEntry--;
                return true;
            } else {
                firstNode = firstNode.nextNode;
                totalEntry--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean InsertEntry(T newEntry, int position) {
        if (position <= totalEntry) {
            Node newNode = new Node(newEntry);
            Node previousNode = getPositionNode(position);

            if (position <= 1) {
                newNode.nextNode = firstNode;
                firstNode = newNode;

            } else {
                newNode.nextNode = previousNode.nextNode;
                previousNode.nextNode = newNode;
            }
            totalEntry++;
            return true;
        }

        return false;
    }

    @Override
    public boolean RemoveEntry(int position) {
        if (position > 0) {
            Node previousNode = getPositionNode(position);

            if (position <= 1) {
                if (totalEntry == 1) {
                    clearAll();
                } else {
                    firstNode = firstNode.nextNode;
                    totalEntry--;
                }

            } else {
                if (position == totalEntry) {

                    previousNode.nextNode = null;
                    lastNode = previousNode;
                } else {
                    previousNode.nextNode = previousNode.nextNode.nextNode;
                }
                totalEntry--;
            }
            
            return true;
        }

        return false;
    }

    @Override
    public T peek() {
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
        totalEntry = 0;
    }

    @Override
    public int countEntry() {
        return totalEntry;
    }

    @Override
    public Iterator<T> getIterator() {
        return new QueueIterator();
    }

    public Node getPositionNode(int position) {
        Node chooseNode = firstNode;
        Iterator<T> iterator = getIterator();
        int i = 1;

        while (iterator.hasNext() && i < position - 1) {
            chooseNode = chooseNode.nextNode;
            i++;
        }

        return chooseNode;
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