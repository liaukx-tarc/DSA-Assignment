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
public interface ListInterface<T> {
    
    public boolean add(T entry);
    public boolean remove(int position);
    public T getEntry(int position);
    public int[] include(String stringInput);
    public boolean replace(int position, T entry);
    public boolean clear();
    public int getTotal();
    public boolean isFull();
    public void setComparator(Comparator comparator);
    public void sort();

    
}
