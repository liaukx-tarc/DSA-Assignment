/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SongMaintenance;

import java.util.Comparator;

/**
 *
 * @author kaiel
 */
public class SongComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Song s1 = (Song) o1;
        Song s2 = (Song) o2;
        return s1.getName().compareToIgnoreCase(s2.getName());
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
