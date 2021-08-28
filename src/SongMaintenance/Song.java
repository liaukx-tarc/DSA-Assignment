package SongMaintenance;

public class Song implements Comparable<Song> {

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

    public String getName() {
        return songName;
    }

    public int getSongLength() {
        return songLength;
    }

    @Override
    public int compareTo(Song song) {
        return songName.compareTo(song.getName());
    }
}
