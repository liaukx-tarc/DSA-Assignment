/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberMaintenance;
import java.util.Comparator;

/**
 *
 * @author kaiel
 * @param <T>
 */
public class SortedArrayList<T extends Comparable<T>> implements SortedListInterface<T> {
    
    private static int arraySize;
    private T[] array;
    private int totalEntries;
    private int arrangeState;
    private Comparator comparator;
    
    public SortedArrayList(){
        arraySize = 5;
        totalEntries = 0;
        array = (T[]) new Comparable[arraySize];
        comparator = null;
    }
        
    @Override
    public boolean add(T entry){
        int i = 0;
        arrangeState = 0;
        
        if(isFull())
            reSize();
        if(comparator != null)
        {
            while (i < totalEntries && comparator.compare(entry,array[i]) > 0) 
            {
                i++;
            }
        }
        else
        {
            while (i < totalEntries && entry.compareTo(array[i]) > 0) 
            {
                i++;
            }
        }
        reArrange(i,arrangeState);
        array[i] = entry;
        totalEntries++;
        return true;
    }
        
    @Override
    public boolean remove(int position){
        arrangeState = 1;
        reArrange(position - 1,arrangeState);
        totalEntries--;
        array[totalEntries] = null;
        return true;
    }
        
    @Override
    public T getEntry(int position){
        T entry = null;
        if(position > 0)
        {
            entry = array[position - 1];
        }
        return entry;
    }
                
    @Override
    public int[] include(T entry){
        int i = 0;
        int n = 0;
        int[] entriesFound = new int [totalEntries + 1];
        while (i < totalEntries)
        {
            if(array[i].toString().toUpperCase().contains(entry.toString().toUpperCase()))
            {
                n++;
                entriesFound[n] = i + 1; // get position instead of array index
            }
            i++;
        }
        entriesFound[0] = n;
        return entriesFound;
    }
        
    @Override
    public boolean replace(int position, T entry){
        
        if(remove(position)&&add(entry))
            return true;
        else
            return false;
    }
        
    @Override
    public boolean clear(){
        totalEntries = 0;
        return true;
    }
        
    @Override
    public int getTotal(){

        return totalEntries;
    }
        
    @Override
    public boolean isFull(){
      
        return totalEntries == arraySize;
    }
    
    @Override
    public boolean isEmpty(){
      
        return totalEntries == 0;
    }
    
    @Override
    public void setComparator(Comparator comparator) {
        this.comparator = comparator; 
    }
    
    @Override
    public void sort()
    {
        if(totalEntries > 1)
        {
            MergeSort mergeSort = new MergeSort(comparator);
            mergeSort.sort(array,0,totalEntries-1);
        }
    }

    private void reArrange(int position, int state){
        int i;
        int arrangeNo = position;
        int lastNo = totalEntries - 1;
        if(state == 0)
        {
            for (i = lastNo; i >= arrangeNo; i--) {
            array[i + 1] = array[i];
          }
        }
        else
        {
            for (i = arrangeNo; i < lastNo; i++) {
            array[i] = array[i + 1];
           }
        }
    }
    
    private void reSize()
    {
        T[] oldArray = array;
        array = (T[]) new Comparable[arraySize * 2];

        System.arraycopy(oldArray, 0, array, 0, arraySize);
        arraySize*=2;
    }
}
