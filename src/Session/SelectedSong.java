package Session;

public class SelectedSong {

        private Session.Member memberSing;
        private SongList.Song song;

        SelectedSong() {
            memberSing = null;
            song = null;
        }

        SelectedSong(Session.Member member, SongList.Song song) {
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
        
        public SongList.Song getSong(){
            return song;
        }
    }
