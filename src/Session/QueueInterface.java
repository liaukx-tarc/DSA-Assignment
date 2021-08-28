package Session;

import java.util.Iterator;

public interface QueueInterface<T> {
    
    //Add newEntry at the end of the queue
    public void addQueue(T newEntry);
    //remove the remove the first entry
    public void removeFirst();
    //insert the new entry in a selected position
    public void insertEntry(T newEntry, int position);
    //remove a entry at selected position
    public void removeEntry(int position);
    //get first entry and remove it
    public T nextEntry();
    //check the queue is empty or not
    public boolean checkEmpty();
    //clear all the entries in queue
    public void clearAll();
    //get how many entry in queue
    public int countEntry();
    //get Iterator of the queue
    public Iterator<T> getIterator();
}