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
public interface ListInterface<T extends Comparable<T>> {
    
    public boolean add(T entry);
    public boolean remove(int position);
    public T getEntry(int position);
    public int[] include(T entry);
    public boolean replace(int position, T entry);
    public boolean clear();
    public int getTotal();
    public boolean isFull();
    public void sort(Comparator comparator);
    
}
