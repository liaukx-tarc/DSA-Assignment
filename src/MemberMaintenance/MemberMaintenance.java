/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberMaintenance;

import SongMaintenance.Song;
import SongMaintenance.SongList;
import java.util.Scanner;
import java.time.LocalDate;
/**
 *
 * @author kaiel
 */
public class MemberMaintenance {

    private Scanner userInput = new Scanner(System.in);
    private ListInterface<Member> memberList  = new SortedArrayList<Member>();
    private int memberDeleted = 0;
    private int memberIDNum = 650000;
    
    public void memberController(){
        memberList.setComparator(new MemberComparator(0));
        
        //For testing
        SongList songList = new SongList();
        Member member1 = new Member("A0002","Kai Xian", "xiankai77@gmail.com", 'M', "2021-08-20");
        member1.setFavSongList(songList.songList);
        Member member2 = new Member("A0003","Zi Xiu", "zx123@gmail.com", 'M', "2021-08-21");
        Member member3 = new Member("A0001","mok", "mokgae@gmail.com", 'M', "2021-08-19");
        Member member4 = new Member("A0004","Alice", "alice@gmail.com", 'M', "2021-08-23");
        //Member member5 = new Member("A0005","Bob", "123bob@gmail.com", 'M', "2021-08-16");
        
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        memberList.add(member4);
        //memberList.add(member5);
        
        boolean isExit = false;
        
        while(!isExit)
        {
            System.out.println("--------------------------------------------------------------------------------------------------------\n"
                    + "Member Maintenance\n--------------------------------------------------------------------------------------------------------");
            System.out.println("1. Add new member ");
            System.out.println("2. View member list ");
            System.out.println("3. Exit ");
            System.out.print("Please enter your choice(1-3): ");
            int input = Integer.parseInt(userInput.nextLine());
            switch(input)
            {
                case 1:
                    addMember();
                    break;
                case 2:
                    displayMember();
                    break;
                case 3:
                    isExit = true;
                    break;
                default: 
                    System.out.println("Invalid Input.Please Enter Again.");
                    break;
            }
        }
    }
    
    public void addMember(){
        Member newMember = new Member();
        String stringInput;
        char charInput;
        String memberID;
        boolean isExit = false;
        
        System.out.println("--------------------------------------------------------------------------------------------------------\n"
                + "Add new member\n--------------------------------------------------------------------------------------------------------");
        System.out.print("Enter name: ");
        stringInput = userInput.nextLine();
        newMember.setMemberName(stringInput);
        System.out.print("Enter Email address: ");
        stringInput = userInput.nextLine();
        newMember.setMemberEmail(stringInput);
        do{
            System.out.print("Enter gender (M/F): ");
            charInput = userInput.next().toUpperCase().charAt(0);
            userInput.nextLine();
            if(charInput != 'M' && charInput != 'F')
            {
                System.out.println("Invalid Input.Please Enter Again.");
                userInput.nextLine();
            }
        }while(charInput != 'M' && charInput != 'F');
        newMember.setMemberGender(charInput);
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Name : "+newMember.getMemberName());
        System.out.println("Email Address : "+newMember.getMemberEmail());
        System.out.println("Gender : "+newMember.getMemberGender());
        System.out.println("--------------------------------------------------------------------------------------------------------");
        do{
            System.out.println("Save member?(Y/N)");
            charInput = userInput.next().toUpperCase().charAt(0);
            userInput.nextLine();
            switch (charInput) {
                case 'Y':
                    memberIDNum = (int)'A'*10000 + memberList.getTotal() + memberDeleted + 1;
                    memberID = String.format("%c%04d",(char)(memberIDNum / 10000),memberIDNum % 10000);
                    newMember.setMemberID(memberID);
                    newMember.setDateJoined(LocalDate.now().toString());
                    isExit = memberList.add(newMember);
                    break;
                case 'N':
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid Input.Please Enter Again.");
                    userInput.nextLine();
                    break;
            }
        }while(!isExit);
    }
    
    public void displayMember(){
        boolean isExit = false;
        while(!isExit)
        {
            System.out.println("--------------------------------------------------------------------------------------------------------\n"
                    + "Member List\n--------------------------------------------------------------------------------------------------------");
            System.out.println("No.     ID      Name                          Email                                  Gender   DateJoined");
            for(int i=1;i<=memberList.getTotal();i++)
            {
                System.out.println((i)+".      "+memberList.getEntry(i));
            }
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println(" "+memberList.getTotal()+" member(s) found.");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("1. Sort member list");
            System.out.println("2. Search member");
            System.out.println("3. View member's favourite Song List");
            System.out.println("4. Edit member information");
            System.out.println("5. Delete member");
            System.out.println("6. Return to previous menu");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.print("Please enter your choice(1-6): ");
            int input = Integer.parseInt(userInput.nextLine());
                switch(input)
                {
                    case 1:
                        sortMember();
                        break;
                    case 2:
                        searchMember();
                        break;
                    case 3:
                        viewFavSongList();
                        break;
                    case 4:
                        editMember();
                        break;
                    case 5:
                        removeMember();
                        break;
                    case 6:
                        isExit = true;
                        break;
                    default: 
                        System.out.println("Invalid Input.Please Enter Again.");
                        userInput.nextLine();
                        break;
                }
        }
    }
    public void sortMember(){
        boolean isExit = false;
        int inputSort = 0;
        int inputOrder = 0;
        
        while(!isExit)
        {
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("Sort by");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("1. Member ID");
            System.out.println("2. Member name");
            System.out.println("3. Member Email address");
            System.out.println("4. Member date joined");
            System.out.println("5. Return to previous menu");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.print("Please enter your choice(1-4): ");
            inputSort = Integer.parseInt(userInput.nextLine());
            if(inputSort >= 1 && inputSort <= 4)
            {
                do{
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    System.out.println("Order");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    System.out.println("1. Ascending Order");
                    System.out.println("2. Descending Order");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    System.out.print("Please enter your choice(1-2): ");
                    inputOrder = Integer.parseInt(userInput.nextLine());
                    switch (inputOrder) 
                    {
                        case 1:
                            memberList.setComparator(new MemberComparator(inputSort));
                            memberList.sort();
                            break;
                        case 2:
                            memberList.setComparator(new MemberComparator(inputSort).reversed());
                            memberList.sort();
                            break;
                        default:
                            System.out.println("Invalid Input.Please Enter Again.");
                            userInput.nextLine();
                            break;
                    }
                }while(inputOrder != 1 && inputOrder != 2);
                isExit = true;
            }
            else if(inputSort == 5)
            {
                isExit = true;
            }
            else
            {
                System.out.println("Invalid Input.Please Enter Again.");
                userInput.nextLine();
            }
        }
    }
    
    public void searchMember(){
        
    }
    
    public void viewFavSongList(){
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.print("Please select a member (Member No.): ");
        int input = Integer.parseInt(userInput.nextLine());
        if(input > 0 && input <= memberList.getTotal())
        {
            ListInterface<Song> favSongList = memberList.getEntry(input).getFavSongList();
            int totalSong = favSongList.getTotal();
            System.out.println("--------------------------------------------------------------------------------------------------------\n"
        + "Favourite Song List\n--------------------------------------------------------------------------------------------------------");
            System.out.println("No.     Name                                                    Time Length");
            for(int i=1;i<=totalSong;i++)
            {
                System.out.println((i)+".      "+favSongList.getEntry(i));
            }
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println(" "+totalSong+" song(s) found.");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("Press any key to return.");
            userInput.nextLine();
        }
    }
    
    public void editMember(){
        
    }
    
    public void removeMember(){
        
    }
    

    
    public static void main(String[] args) {
        MemberMaintenance memberM = new MemberMaintenance();
        memberM.memberController();
        
        System.exit(0);
    }
    
}
