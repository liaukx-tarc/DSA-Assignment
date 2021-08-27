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
            if (firstNode.equals(lastNode)) {
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
        if (position <= countEntry()) {
            Node newNode = new Node(newEntry);
            Node positionNode = getPositionNode(position);
            Node oldNextNode;

            if (position <= 1) {
                newNode.nextNode = firstNode;
                firstNode = newNode;

            } else {
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
        int queueNum = countEntry();
        if (position > 0) {
            Node previousNode = getPositionNode(position);

            if (position <= 1) {
                if (queueNum == 1) {
                    clearAll();
                } else {
                    firstNode = firstNode.nextNode;
                }

            } else {
                if (position == countEntry()) {

                    previousNode.nextNode = null;
                    lastNode = previousNode;
                } else {
                    previousNode.nextNode = previousNode.nextNode.nextNode;
                }
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
        int count = 0;
        Iterator<T> iterator = getIterator();

        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }

        return count;
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
