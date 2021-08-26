package Session;

import java.time.LocalTime;

public class Session {

    public static Member currentUser;
    public static QueueInterface<SelectedSong> songQueue = new LinkQueue<SelectedSong>();
    public static SongList songList = new SongList();
    public static Session session;
    public static SessionFrame sessionFrame;
    public static SelectedSong currentSong;
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

        //Program Loop
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

            }

        } while (true);

    }

    public class Member {

        String name;

        Member(String name) {
            this.name = name;
        }
    }
}
