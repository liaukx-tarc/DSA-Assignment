package Session;

import java.util.List;
import java.util.ArrayList;

public class SongList {
    Song song1 = new Song("Along");
    Song song2 = new Song("Fire");
    Song song3 = new Song("Hello");
    Song song4 = new Song("World");
    
    public static List<Song> songList = new ArrayList<>();
    
    SongList(){
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);
        songList.add(song4);  
    }
    
    public class Song {

        String name;

        Song(String name) {
            this.name = name;
        }

    }
    
}
