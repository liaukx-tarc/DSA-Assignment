package Session;

import java.util.Iterator;

public class LinkQueue<T> implements QueueInterface<T> {

    Node firstNode;
    Node lastNode;

    LinkQueue() {
        firstNode = null;
        lastNode = null;
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

    }

    @Override
    public boolean removeFirst() {
        if (!checkEmpty()) {
            if (firstNode == lastNode) {
                firstNode = null;
                lastNode = null;
                return true;
            } else {
                firstNode = firstNode.nextNode;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean InsertEntry(T newEntry, int position) {
        if (position < countEntry()) {
            Node newNode = new Node(newEntry);
            Node positionNode = firstNode;
            Node oldNextNode;

            if (position <= 1) {
                newNode.nextNode = firstNode;
                firstNode = newNode;
            } else {
                for (int i = 0; i < position - 2; i++) { //2 is start from 0 and minus 1 before the position we need
                    positionNode = positionNode.nextNode;
                }

                oldNextNode = positionNode.nextNode;
                positionNode.nextNode = newNode;
                newNode.nextNode = oldNextNode;
            }

            return true;
        }

        return false;
    }

    @Override
    public boolean RemoveEntry(int position) {
        if (position < countEntry()) {
            Node positionNode = firstNode;

            if (position <= 1) {
                firstNode = firstNode.nextNode;
            } else {
                for (int i = 0; i < position - 2; i++) { //2 is start from 0 and minus 1 before the position we need
                    positionNode = positionNode.nextNode;
                }

                positionNode.nextNode = positionNode.nextNode.nextNode;
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
    }

    @Override
    public int countEntry() {
        Node currentNode = firstNode;
        int count = 0;
        if (!checkEmpty()) {
            while (currentNode != null) {
                count++;
                currentNode = currentNode.nextNode;
            }
        }

        return count;
    }

    @Override
    public Iterator<T> getIterator() {
        return new QueueIterator();
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
                Node nodeFirst = nodeReturn;
                nodeReturn = nodeReturn.nextNode;
                return (T)nodeFirst.data;
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
