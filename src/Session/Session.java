package Session;
import Session.SongList.Song;



public class Session {
    
    public static Member currentUser;
    public static QueueInterface<ChooseSong> songQueue = new LinkQueue<ChooseSong>();
    public static SongList songList = new SongList();
    public static Session session;
    Session(){
        currentUser = new Member("Kai Xian");
    }
    
    public static void main(String[] args) {
        session = new Session();
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SessionFrame().setVisible(true);
            }
        });
    }

    public class ChooseSong {

        Member member;
        Song song;

        ChooseSong() {

        }

        ChooseSong(Member member, Song song) {
            this.member = member;
            this.song = song;
        }
        
        @Override
        public String toString(){
            String string;
            
            string = String.format("%-50s |  %-50s",member.name,song.name);
            
            return string;
        }
    }

    public class Member {

        String name;

        Member(String name) {
            this.name = name;
        }
    }
}
