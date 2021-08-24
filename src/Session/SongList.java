package Session;

import java.util.List;
import java.util.ArrayList;

public class SongList {
    Song song1 = new Song("Along",120);
    Song song2 = new Song("Fire",150);
    Song song3 = new Song("Hello",180);
    Song song4 = new Song("World",90);
    
    public static List<Song> songList = new ArrayList<>();
    
    SongList(){
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);
        songList.add(song4);  
    }
    
    public class Song {

        String name;
        int songLength;//in sec
        
        Song(String name, int songLength) {
            this.name = name;
            this.songLength = songLength;
        }
    }
    
}
