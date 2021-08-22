package Session;

import java.util.Iterator;

public interface QueueInterface<T> {

    public void addQueue(T newEntry);
    public boolean removeFirst();
    public boolean InsertEntry(T newEntry, int position);
    public boolean RemoveEntry(int position);
    public T peek();
    public boolean checkEmpty();
    public void clearAll();
    public int countEntry();
}