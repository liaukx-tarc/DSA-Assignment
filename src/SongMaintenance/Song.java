/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SongMaintenance;

import java.util.Comparator;

/**
 *
 * @author user
 */
public class Song implements Comparable<Song>{
    private String songName;
        private int songLength;//in sec

        Song(String name, int songLength) {
            this.songName = name;
            this.songLength = songLength;
        }

        @Override
        public String toString() {
            String string;
            string = String.format("%-50s | ", songName);
            string += String.format("%4d:%02d", songLength / 60, songLength % 60);
            return string;
        }
        
        public String getName(){
            return songName;
        }
        
        public int getSongLength(){
            return songLength;
        }

    @Override
        public int compareTo(Song song) {
            return songName.compareTo(song.getName());
        }
    }
