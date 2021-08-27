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
 */
public class SortedArrayList<T extends Comparable<T>> implements ListInterface<T> {
    
    private static int arraySize;
    private T[] array;
    private int totalEntries;
    private int arrangeState;
    
    public SortedArrayList(){
        arraySize = 5;
        totalEntries = 0;
        array = (T[]) new Comparable[arraySize];
    }
    
    public boolean add(T entry){
        int i = 0;
        arrangeState = 0;
        
        if(isFull())
            reSize();
        while (i < totalEntries && entry.compareTo(array[i]) > 0) {
            i++;
        }
        reArrange(i,arrangeState);
        array[i] = entry;
        totalEntries++;
        return true;
    }
    
    public boolean remove(int position){
        arrangeState = 1;
        reArrange(position - 1,arrangeState);
        totalEntries--;
        array[totalEntries] = null;
        return true;
    }
    
    public T getEntry(int position){
        
        T entry = array[position - 1];
        return entry;
    }
            
    public int[] include(T entry){
        int i = 0;
        int n = 0;
        int[] entriesFound = new int [arraySize];
        while (i < totalEntries)
        {
            if(entry.equals(array[i]))
            {
                entriesFound[n] = i;
            }
            i++;
        }
        return entriesFound;
    }
    
    public boolean replace(int position, T entry){
        
        if(remove(position)&&add(entry))
            return true;
        else
            return false;
    }
    
    public boolean clear(){
        totalEntries = 0;
        return true;
    }
    
    public int getTotal(){

        return totalEntries;
    }
    
    public boolean isFull(){
      
        return totalEntries == arraySize;
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
    
    public void sort(Comparator comparator)
    {
        if(totalEntries > 1)
        {
            MergeSort mergeSort = new MergeSort(comparator);
            mergeSort.sort(array,0,totalEntries-1);
        }
    }
}
