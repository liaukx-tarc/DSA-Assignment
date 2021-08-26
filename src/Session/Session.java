package Session;

import MemberMaintenance.ListInterface;
import MemberMaintenance.Member;
import MemberMaintenance.SortedArrayList;

public class Session {
    private ListInterface<Member> memberList = new SortedArrayList<Member>();
    private QueueInterface<SelectedSong> songQueue = new LinkQueue<SelectedSong>();
    private SelectedSong currentSong;
   
    public Session(Member currentUser) {
        memberList.add(currentUser);
    }
   
    //Song Queue
    public QueueInterface<SelectedSong> getSongQueue(){
        return songQueue;
    }
    
    public void setSongQueue(QueueInterface<SelectedSong> songQueue){
        this.songQueue = songQueue;
    }
    
    //Member List
    public ListInterface<Member> getMemberList(){
        return memberList;
    }

    public void setMemberList(ListInterface<Member> memberList){
        this.memberList = memberList;
    }   
    
    //current Song
    public SelectedSong getCurrentSong(){
        return currentSong;
    }
    
    public void setCurrentSong(SelectedSong currentSong){
        this.currentSong = currentSong;
    }
}
