/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

/**
 *
 * @author user
 */
public class Song implements Comparable<Song> {
    private String name;
        private int songLength;//in sec

        Song(String name, int songLength) {
            this.name = name;
            this.songLength = songLength;
        }

        @Override
        public int compareTo(Song o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            String string;
            string = String.format("%-50s | ", name);
            string += String.format("%4d:%02d", songLength / 60, songLength % 60);
            System.out.println(string);
            return string;
        }
        
        public String getName(){
            return name;
        }
        
        public int getSongLength(){
            return songLength;
        }
    }
