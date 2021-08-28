package Session;

import MemberMaintenance.Member;
import MemberMaintenance.SortedArrayList;
import MemberMaintenance.SortedListInterface;

public class Session implements Comparable<Session> {

    private SortedListInterface<Member> memberList = new SortedArrayList<Member>();
    private QueueInterface<SelectedSong> songQueue = new Queue<SelectedSong>();
    private SelectedSong currentSong;
    private String sessionName;

    public Session(String sessionName) {
        this.sessionName = sessionName;
        currentSong = null;
    }

    //Song Queue
    public QueueInterface<SelectedSong> getSongQueue() {
        return songQueue;
    }

    public void setSongQueue(QueueInterface<SelectedSong> songQueue) {
        this.songQueue = songQueue;
    }

    //Member List
    public SortedListInterface<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(SortedListInterface<Member> memberList) {
        this.memberList = memberList;
    }

    //current Song
    public SelectedSong getCurrentSong() {
        return currentSong;
    }

    public void setCurrentSong(SelectedSong currentSong) {
        this.currentSong = currentSong;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    @Override
    public int compareTo(Session o) {
        return sessionName.compareTo(o.getSessionName());
    }
}
