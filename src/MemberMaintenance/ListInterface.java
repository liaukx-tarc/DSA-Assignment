/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberMaintenance;

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
    public int getTotal();
    public boolean isFull();
    
}
