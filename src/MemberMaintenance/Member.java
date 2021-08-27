/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberMaintenance;
import SongMaintenance.Song;
import java.util.Comparator;

/**
 *
 * @author kaiel
 */
public class Member implements Comparable<Member>{

    private String memberID;
    private String memberName;
    private String memberEmail;
    private char memberGender;
    private String dateJoined;
    private ListInterface<Song> favSongList;
    
    public Member()
    {
        memberID = null;
        memberName = null;
        memberEmail = null;
        memberGender = '\0';
        dateJoined = null;
        favSongList = null;
    }
    
    public Member(String memberID, String memberName, String memberEmail, char memberGender, String dateJoined)
    {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberGender = memberGender;
        this.dateJoined = dateJoined;
        this.favSongList = new SortedArrayList<>();
    }
    
    public String getMemberID(){
        return memberID;
    }
    
    public void setMemberID(String memberID){
        this.memberID = memberID;
    }
    
    public String getMemberName(){
        return memberName;
    }
    
    public void setMemberName(String memberName){
        this.memberName = memberName;
    }
    
    public String getMemberEmail(){
        return memberEmail;
    }
    
    public void setMemberEmail(String memberEmail){
        this.memberEmail = memberEmail;
    }
    
    public char getMemberGender(){
        return memberGender;
    }
    
    public void setMemberGender(char memberGender){
        this.memberGender = memberGender;
    }
    
    public String getDateJoined(){
        return dateJoined;
    }
    
    public void setDateJoined(String dateJoined){
        this.dateJoined = dateJoined;
    }
    
    public ListInterface<Song> getFavSongList(){
        return favSongList;
    }
    
    public void setFavSongList(ListInterface<Song> favSongList){
        this.favSongList = favSongList;
    }
    
    @Override
    public String toString(){
    
        return String.format("%-8s%-30s%-40s%-8c%-11s",memberID, memberName, memberEmail, memberGender, dateJoined);
    }

    @Override
    public int compareTo(Member member) {
        return memberID.compareTo(member.getMemberID());
    }
}
