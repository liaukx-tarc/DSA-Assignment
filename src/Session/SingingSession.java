/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import MemberMaintenance.ListInterface;
import MemberMaintenance.Member;
import MemberMaintenance.SortedArrayList;
import SongMaintenance.SongList;
import java.time.LocalTime;

public class SingingSession {

    public static ListInterface<Session> sessionList = new SortedArrayList<>();

    public static Session session;
    public static ChooseSessionFrame chooseSessionFrame;
    public static SessionFrame sessionFrame;
    public static SongList songList;

    public static LocalTime songEndTime;
    public static QueueInterface<SelectedSong> songQueue;
    public static Member currentUser;

    public static void main(String[] args) {
        //hardcore data
        currentUser = new Member("A100", "Kai Xian", "xiankai77@gmail.com", 'M', "29-6-2020");
        Member member1 = new Member("A200", "Ali", "a123@gmail.com", 'M', "17-8-2020");
        Member member2 = new Member("A300", "Meng", "b678@gmail.com", 'M', "9-3-2020");
        sessionList.add(new Session("Session 1"));
        sessionList.add(new Session("Session 2"));
        sessionList.getEntry(1).getMemberList().add(member1);
        sessionList.getEntry(1).getMemberList().add(member2);

        chooseSessionFrame = new ChooseSessionFrame();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                chooseSessionFrame.setVisible(true);
            }
        });

        LocalTime nextUpdateTime = LocalTime.now().plusSeconds(1);

        //Program Loop
        do {
            if (nextUpdateTime.isBefore(LocalTime.now())) {
                nextUpdateTime = LocalTime.now().plusSeconds(1);
                if (sessionFrame != null) {
                    if (session.getCurrentSong() != null) {
                        if (songEndTime.isBefore(LocalTime.now())) {

                            songQueue = session.getSongQueue();
                            if (songQueue.checkEmpty()) {
                                session.setCurrentSong(null);
                                sessionFrame.clearCurrentSong();

                            } else {
                                sessionFrame.nextSong();

                            }
                        }

                        sessionFrame.updateProgress();
                    }
                    sessionFrame.updateMemberJoinedList();
                }
            }
        } while (true);

    }
}
