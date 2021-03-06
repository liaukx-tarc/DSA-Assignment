package SongMaintenance;

import MemberMaintenance.SortedArrayList;
import MemberMaintenance.SortedListInterface;

public class SongList {

    Song song1 = new Song("Along", 120);
    Song song2 = new Song("Fire", 150);
    Song song3 = new Song("Cat", 60);
    Song song4 = new Song("Hello", 180);
    Song song5 = new Song("World", 90);

    private final SortedListInterface<Song> songList = new SortedArrayList<Song>();

    public SongList() {
        
        songList.setComparator(null);
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);
        songList.add(song4);
        songList.add(song5);
    }
    
    public SortedListInterface<Song> getSongList()
    {
        return songList;
    } 
}
