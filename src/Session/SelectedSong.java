package Session;

import SongMaintenance.Song;

public class SelectedSong {

        private Session.Member memberSing;
        private Song song;

        SelectedSong() {
            memberSing = null;
            song = null;
        }

        SelectedSong(Session.Member member, Song song) {
            this.memberSing = member;
            this.song = song;
        }

        @Override
        public String toString() {
            String string;

            string = String.format("%-50s |  %-50s", memberSing.name, song.getName());

            return string;
        }
        
        public Session.Member getMember(){
            return memberSing;
        }
        
        public Song getSong(){
            return song;
        }
    }
