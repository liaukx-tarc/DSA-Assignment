package Session;

import Session.SongList.Song;
import java.time.LocalTime;

public class Session {

    public static Member currentUser;
    public static QueueInterface<ChooseSong> songQueue = new LinkQueue<ChooseSong>();
    public static SongList songList = new SongList();
    public static Session session;
    public static SessionFrame sessionFrame;
    public static ChooseSong currentSong;
    public static LocalTime songEndTime;

    Session() {
        currentUser = new Member("Kai Xian");
    }

    public static void main(String[] args) {
        session = new Session();
        int i = 0;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                sessionFrame = new SessionFrame();
                sessionFrame.setVisible(true);
            }
        });

        LocalTime nextUpdateTime = LocalTime.now().plusSeconds(1);

        do {
            if (nextUpdateTime.isBefore(LocalTime.now())) {
                nextUpdateTime = LocalTime.now().plusSeconds(1);

                if (currentSong != null) {
                    if (songEndTime.isBefore(LocalTime.now())) {
                        
                        if (songQueue.checkEmpty()) {
                            currentSong = null;
                            sessionFrame.clearCurrentSong();
                        } else {

                            sessionFrame.nextSong();
                        }
                    }

                    sessionFrame.updateProgress();

                }

                sessionFrame.refreshList();

            }

        } while (true);

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
        public String toString() {
            String string;

            string = String.format("%-50s |  %-50s", member.name, song.name);

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
