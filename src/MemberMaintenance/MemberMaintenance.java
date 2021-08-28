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
    private SortedListInterface<Member> memberList  = new SortedArrayList<Member>();
    private int memberDeleted = 0;
    private int memberIDNum = 650000;
    private Member memberSearch = new Member();
    private int[] searchResult = null;
    private SongList songList = new SongList();
    private SortedListInterface<Song> testFavSongList  = new SortedArrayList<Song>();
    
    public void memberController(){
        memberList.setComparator(new MemberComparator(0));
        
        //For testing
        Member member1 = new Member("A0002","Kai Xian", "xiankai77@gmail.com", 'M', "2021-08-20");
        for(int i = 1; i <= songList.getSongList().getTotal();i++)
        {
            testFavSongList.add(songList.getSongList().getEntry(i));
            member1.setFavSongList(testFavSongList);
        }
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
        int input = 0;
        
        while(!isExit)
        {
            System.out.println("--------------------------------------------------------------------------------------------------------\n"
                    + "Member Maintenance\n--------------------------------------------------------------------------------------------------------");
            System.out.println("1. Add new member ");
            System.out.println("2. View member list ");
            System.out.println("3. Exit ");
            System.out.print("Please enter your choice(1-3): ");
            if(userInput.hasNextInt())
            {
                input = userInput.nextInt();
                userInput.nextLine();
            }
            else
            {
                userInput.nextLine();
                input = 0;
            }
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
        int input = 0;
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
            if(userInput.hasNextInt())
            {
                input = userInput.nextInt();
                userInput.nextLine();
            }
            else
            {
                userInput.nextLine();
                input = 0;
            }
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
            System.out.print("Please enter your choice(1-5): ");
            if(userInput.hasNextInt())
            {
                inputSort = userInput.nextInt();
                userInput.nextLine();
            }
            else
            {
                userInput.nextLine();
                inputSort = 0;
            }
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
                    if(userInput.hasNextInt())
                    {
                        inputOrder = userInput.nextInt();
                        userInput.nextLine();
                    }
                    else
                    {
                        userInput.nextLine();
                        inputOrder = 0;
                    }
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
        boolean isExit = false;
        int input = 0;
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.print("Please enter search keyword: ");
        String searchKeyword = userInput.nextLine();
        memberSearch.setMemberName(searchKeyword);
        searchResult = memberList.include(memberSearch);
        do{
            System.out.println("--------------------------------------------------------------------------------------------------------\n"
            + "Member Search\n--------------------------------------------------------------------------------------------------------");
            System.out.println("No.     ID      Name                          Email                                  Gender   DateJoined");
            for(int i=1;i<=searchResult[0];i++)
            {
                System.out.println((i)+".      "+memberList.getEntry(searchResult[i]));
            }
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println(" "+searchResult[0]+" member(s) found.");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("1. Search Member");
            System.out.println("2. View member's favourite Song List");
            System.out.println("3. Edit member information");
            System.out.println("4. Delete member");
            System.out.println("5. Return to previous menu");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.print("Please enter your choice(1-5): ");
            if(userInput.hasNextInt())
                {
                    input = userInput.nextInt();
                    userInput.nextLine();
                }
                else
                {
                    userInput.nextLine();
                    input = 0;
                }
                switch(input)
                {
                    case 1:
                        searchMember();
                        isExit = true;
                        break;
                    case 2:
                        viewFavSongList();
                        break;
                    case 3:
                        editMember();
                        searchResult = memberList.include(memberSearch);
                        break;
                    case 4:
                        removeMember();
                        searchResult = memberList.include(memberSearch);
                        break;
                    case 5:
                        isExit = true;
                        break;
                    default: 
                        System.out.println("Invalid Input.Please Enter Again.");
                        userInput.nextLine();
                        break;
                }
        }while(!isExit);
        searchResult = null;
    }
    
    public void viewFavSongList(){
        int totalMember;
        SortedListInterface<Song> favSongList;
        int input;
        char charInput;
        int choiceInput;
        int songIndex;
        int totalSong;
        boolean isExit = false;
        boolean isExitSub = false;
        if (searchResult == null)
        {
            totalMember = memberList.getTotal();
        }
        else
        {
            totalMember = searchResult[0];
        }
        if (totalMember != 0)
        {
            do{
                System.out.println("--------------------------------------------------------------------------------------------------------");
                System.out.print("Please select a member (Member No.): ");
                if(userInput.hasNextInt())
                {
                    input = userInput.nextInt();
                    userInput.nextLine();
                }
                else
                {
                    userInput.nextLine();
                    input = 0;
                }
                if (input < 1 || input > totalMember)
                {
                    System.out.println("Invalid selection.Please Enter Again.");
                    userInput.nextLine();
                }
            }while (input < 1 || input > totalMember);
            do{
                if(searchResult == null)
                {
                    favSongList = memberList.getEntry(input).getFavSongList();
                }
                else 
                {
                    favSongList = memberList.getEntry(searchResult[input]).getFavSongList();
                }
                totalSong = favSongList.getTotal();
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
                System.out.println("1. Add Song to favourite song list");
                System.out.println("2. Remove Song from favourite song list");
                System.out.println("3. Clear all song");
                System.out.println("4. Return to previous menu");
                System.out.println("--------------------------------------------------------------------------------------------------------");
                System.out.print("Please enter your choice(1-3): ");
                if(userInput.hasNextInt())
                    {
                        choiceInput = userInput.nextInt();
                        userInput.nextLine();
                    }
                    else
                    {
                        userInput.nextLine();
                        choiceInput = 0;
                    }
                    switch(choiceInput)
                    {
                        case 1:
                            totalSong = songList.getSongList().getTotal();
                            if(songList.getSongList().getTotal() > 0)
                            {
                                System.out.println("--------------------------------------------------------------------------------------------------------\n"
                            + "Song list\n--------------------------------------------------------------------------------------------------------");
                                System.out.println("--------------------------------------------------------------------------------------------------------");
                                System.out.println("No.     Name                                                    Time Length");
                                for(int i=1;i<=totalSong;i++)
                                {
                                    System.out.println((i)+".      "+songList.getSongList().getEntry(i));
                                }
                                System.out.println("--------------------------------------------------------------------------------------------------------");
                            do{
                                    System.out.println("--------------------------------------------------------------------------------------------------------");
                                    System.out.print("Please select a song (Song No.): ");
                                    if(userInput.hasNextInt())
                                    {
                                        songIndex = userInput.nextInt();
                                        userInput.nextLine();
                                    }
                                    else
                                    {
                                        userInput.nextLine();
                                        songIndex = 0;
                                    }
                                    if (songIndex < 1 || songIndex > totalSong)
                                    {
                                        System.out.println("Invalid selection.Please Enter Again.");
                                        userInput.nextLine();
                                    }
                                }while (songIndex < 1 || songIndex > totalSong);
                                System.out.println("--------------------------------------------------------------------------------------------------------\n"
                                        + "Add song to favourite song list\n--------------------------------------------------------------------------------------------------------");
                                System.out.println("--------------------------------------------------------------------------------------------------------");
                                System.out.println("No.     Name                                                    Time Length");
                                System.out.println("1.      "+songList.getSongList().getEntry(songIndex));
                                System.out.println("--------------------------------------------------------------------------------------------------------");
                                do{
                                    System.out.println("Confirm add?(Y/N)");
                                    charInput = userInput.next().toUpperCase().charAt(0);
                                    userInput.nextLine();
                                    switch (charInput) {
                                        case 'Y':
                                            favSongList.add(songList.getSongList().getEntry(songIndex));
                                            memberList.getEntry(input).setFavSongList(favSongList);
                                            isExitSub = true;
                                            break;
                                        case 'N':
                                            isExitSub = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input.Please Enter Again.");
                                            userInput.nextLine();
                                            break;
                                    }
                                }while(!isExitSub);
                                isExitSub = false;
                            }
                            else
                            {
                               System.out.println("No song in song database.Press any key to continue.");
                               userInput.nextLine();
                            }
                            break;
                        case 2:
                            if(totalSong > 0)
                            {
                                do{
                                    System.out.println("--------------------------------------------------------------------------------------------------------");
                                    System.out.print("Please select a song (Song No.): ");
                                    if(userInput.hasNextInt())
                                    {
                                        
                                        songIndex = userInput.nextInt();
                                        userInput.nextLine();
                                    }
                                    else
                                    {
                                        userInput.nextLine();
                                        songIndex = 0;
                                    }
                                    if (songIndex < 1 || songIndex > totalSong)
                                    {
                                        System.out.println("Invalid selection.Please Enter Again.");
                                        userInput.nextLine();
                                    }
                                }while (songIndex < 1 || songIndex > totalSong);
                                System.out.println("--------------------------------------------------------------------------------------------------------\n"
                                        + "Remove song from favourite song list\n--------------------------------------------------------------------------------------------------------");
                                System.out.println("--------------------------------------------------------------------------------------------------------");
                                System.out.println("No.     Name                                                    Time Length");
                                System.out.println("1.      "+favSongList.getEntry(songIndex));
                                System.out.println("--------------------------------------------------------------------------------------------------------");
                                do{
                                    System.out.println("Confirm remove?(Y/N)");
                                    charInput = userInput.next().toUpperCase().charAt(0);
                                    userInput.nextLine();
                                    switch (charInput) {
                                        case 'Y':
                                            favSongList.remove(songIndex);
                                            memberList.getEntry(input).setFavSongList(favSongList);
                                            isExitSub = true;    
                                            break;
                                        case 'N':
                                            isExitSub = true;
                                            break;
                                        default:
                                            System.out.println("Invalid Input.Please Enter Again.");
                                            userInput.nextLine();
                                            break;
                                    }
                                }while(!isExitSub);
                                isExitSub = false;
                            }
                            else
                            {
                               System.out.println("No song found.Press any key to continue.");
                               userInput.nextLine();
                            }
                            break;
                        case 3:
                            if(totalSong > 0)
                            {
                               favSongList.clear();
                            }
                            else
                            {
                               System.out.println("No song found.Press any key to continue.");
                               userInput.nextLine();
                            }
                            break;
                        case 4:
                            isExit = true;
                            break;
                        default: 
                            System.out.println("Invalid Input.Please Enter Again.");
                            userInput.nextLine();
                            break;
                    }
                }while(!isExit);
            System.out.println("Press any key to return.");
            userInput.nextLine();
        }
        else
        {
            System.out.println("No member found. Press any key to continue."); 
            userInput.nextLine();
        }
    }
    
    public void editMember(){
        int totalMember;
        int input;
        int memberIndex;
        String stringInput;
        char charInput;
        boolean isExit = false;
        Member newInfo = new Member();
        Member oldInfo;
        if (searchResult == null)
        {
            totalMember = memberList.getTotal();
        }
        else
        {
            totalMember = searchResult[0];
        }
        if (totalMember != 0)
        {
            do{
                System.out.println("--------------------------------------------------------------------------------------------------------");
                System.out.print("Please select a member (Member No.): ");
                if(userInput.hasNextInt())
                {
                    input = userInput.nextInt();
                    userInput.nextLine();
                }
                else
                {
                    userInput.nextLine();
                    input = 0;
                }
                if (input < 1 || input > totalMember)
                {
                    System.out.println("Invalid selection.Please Enter Again.");
                    userInput.nextLine();
                }
            }while (input < 1 || input > totalMember);
            if(searchResult == null)
            {
                memberIndex = input;
            }
            else
            {
                memberIndex = searchResult[input];
            }
            System.out.println("--------------------------------------------------------------------------------------------------------\n"
                    + "Edit member\n--------------------------------------------------------------------------------------------------------");
            System.out.print("Enter name: ");
            stringInput = userInput.nextLine();
            newInfo.setMemberName(stringInput);
            System.out.print("Enter Email address: ");
            stringInput = userInput.nextLine();
            newInfo.setMemberEmail(stringInput);
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
            newInfo.setMemberGender(charInput);
            oldInfo = memberList.getEntry(memberIndex);
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("Name : "+oldInfo.getMemberName()+"--->"+newInfo.getMemberName());
            System.out.println("Email Address : "+oldInfo.getMemberEmail()+"--->"+newInfo.getMemberEmail());
            System.out.println("Gender : "+oldInfo.getMemberGender()+"--->"+newInfo.getMemberGender());
            System.out.println("--------------------------------------------------------------------------------------------------------");
            do{
                System.out.println("Save change?(Y/N)");
                charInput = userInput.next().toUpperCase().charAt(0);
                userInput.nextLine();
                switch (charInput) {
                    case 'Y':
                        newInfo.setMemberID(oldInfo.getMemberID());
                        newInfo.setDateJoined(oldInfo.getDateJoined());
                        newInfo.setFavSongList(oldInfo.getFavSongList());
                        isExit = memberList.replace(memberIndex,newInfo);
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
        else
        {
            System.out.println("No member found. Press any key to continue."); 
            userInput.nextLine();
        }
    }
    
    public void removeMember(){
        int totalMember;
        int input;
        int memberIndex;
        char charInput;
        boolean isExit = false;
        if (searchResult == null)
        {
            totalMember = memberList.getTotal();
        }
        else
        {
            totalMember = searchResult[0];
        }
        if (totalMember != 0)
        {
            do{
                System.out.println("--------------------------------------------------------------------------------------------------------");
                System.out.print("Please select a member (Member No.): ");
                if(userInput.hasNextInt())
                {
                    input = userInput.nextInt();
                    userInput.nextLine();
                }
                else
                {
                    userInput.nextLine();
                    input = 0;
                }
                if (input < 1 || input > totalMember)
                {
                    System.out.println("Invalid selection.Please Enter Again.");
                    userInput.nextLine();
                }
            }while (input < 1 || input > totalMember);
            if(searchResult == null)
            {
                memberIndex = input;
            }
            else
            {
                memberIndex = searchResult[input];
            }
            System.out.println("--------------------------------------------------------------------------------------------------------\n"
                    + "Delete member\n--------------------------------------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("No.     ID      Name                          Email                                  Gender   DateJoined");
            System.out.println("1.      "+memberList.getEntry(memberIndex));
            System.out.println("--------------------------------------------------------------------------------------------------------");
            do{
                System.out.println("Confirm delete?(Y/N)");
                charInput = userInput.next().toUpperCase().charAt(0);
                userInput.nextLine();
                switch (charInput) {
                    case 'Y':
                        isExit = memberList.remove(memberIndex);
                        if(isExit)
                            memberDeleted++;
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
        else
        {
            System.out.println("No member found. Press any key to continue."); 
            userInput.nextLine();
        }
    }
    
    
    public static void main(String[] args) {
        MemberMaintenance memberM = new MemberMaintenance();
        memberM.memberController();
        
        System.exit(0);
    }


    
}
