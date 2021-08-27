package Session;

import MemberMaintenance.Member;
import SongMaintenance.Song;

public class SelectedSong {

        private Member memberSing;
        private Song song;

        SelectedSong() {
            memberSing = null;
            song = null;
        }

        SelectedSong(Member member, Song song) {
            this.memberSing = member;
            this.song = song;
        }

        @Override
        public String toString() {
            String string;

            string = String.format("%-50s |  %-50s", memberSing.getMemberName(), song.getName());

            return string;
        }
        
        public Member getMember(){
            return memberSing;
        }
        
        public Song getSong(){
            return song;
        }
    }
