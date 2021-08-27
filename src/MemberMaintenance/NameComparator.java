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
public class NameComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Member m1 = (Member)o1;
        Member m2 = (Member)o2;
        
        return m1.getMemberName().compareTo(m2.getMemberName());
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
