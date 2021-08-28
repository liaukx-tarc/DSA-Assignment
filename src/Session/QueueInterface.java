package Session;

import java.util.Iterator;

public interface QueueInterface<T> {

    public void addQueue(T newEntry);
    public void removeFirst();
    public void insertEntry(T newEntry, int position);
    public void removeEntry(int position);
    public T nextEntry();
    public boolean checkEmpty();
    public void clearAll();
    public int countEntry();
    public Iterator<T> getIterator();
}