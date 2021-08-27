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
public class MemberComparator implements Comparator {
    private final int comparatorNum;
    public MemberComparator(int comparatorNum){
        this.comparatorNum = comparatorNum;
    }
    public int getComparatorNum()
    {
        return comparatorNum;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Member m1 = (Member)o1;
        Member m2 = (Member)o2;
        
        String s1;
        String s2;
        
        switch(comparatorNum)
        {
            case 2:
                s1 = m1.getMemberName();
                s2 = m2.getMemberName();
                break;
            case 3:
                s1 = m1.getMemberEmail();
                s2 = m2.getMemberEmail();
                break;
            case 4:
                s1 = m1.getDateJoined();
                s2 = m2.getDateJoined();
                break;
            default:
                s1 = m1.getMemberID();
                s2 = m2.getMemberID();
                break;
        }    
        return s1.compareToIgnoreCase(s2);
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
