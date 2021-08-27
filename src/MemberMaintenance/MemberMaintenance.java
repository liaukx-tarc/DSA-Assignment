/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberMaintenance;

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
    private int memberIDNum = 65000;
    
    public void memberController(){
        Member member1 = new Member("A0002","Kai Xian", "xiankai77@gmail.com", 'M', "2021-08-20");
        Member member2 = new Member("A0003","Zi Xiu", "zx123@gmail.com", 'M', "2021-08-21");
        Member member3 = new Member("A0001","Mok", "mokgae@gmail.com", 'M', "2021-08-19");
        Member member4 = new Member("A0004","Ali", "ali@gmail.com", 'M', "2021-08-19");
        
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        memberList.add(member4);
        
        boolean isExit = false;
        
        while(!isExit)
        {
            System.out.println("----------------------\nMember Maintenance\n----------------------");
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
        
        System.out.println("----------------------\nAdd new member\n----------------------");
        System.out.print("Enter name: ");
        stringInput = userInput.nextLine();
        newMember.setMemberName(stringInput);
        System.out.print("Enter Email address: ");
        stringInput = userInput.nextLine();
        newMember.setMemberEmail(stringInput);
        System.out.print("Enter gender (M/F): ");
        charInput = userInput.next().charAt(0);
        userInput.nextLine();
        newMember.setMemberGender(charInput);
        System.out.println("---------------------------------------------------");
        System.out.println("Name :"+newMember.getMemberName());
        System.out.println("Email Address :"+newMember.getMemberEmail());
        System.out.println("Gender :"+newMember.getMemberGender());
        System.out.println("---------------------------------------------------");
        do{
            System.out.println("Save member?(Y/N)");
            charInput = userInput.next().charAt(0);
            userInput.nextLine();
            switch (charInput) {
                case 'Y':
                case 'y':
                    memberIDNum += (memberList.getTotal()- memberDeleted +1);
                    memberID = String.format("%c%04d",(char)(memberIDNum / 1000),memberIDNum % 1000);
                    newMember.setMemberID(memberID);
                    newMember.setDateJoined(LocalDate.now().toString());
                    isExit = memberList.add(newMember);
                    break;
                case 'N':
                case 'n':
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
            System.out.println("6. Exit");
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
        int sortCode = 0;
        
        while(!isExit)
        {
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("Sort by");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("1. Member ID");
            System.out.println("2. Member name");
            System.out.println("3. Member Email address");
            System.out.println("4. Member date joined");
            System.out.println("5. Exit");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.print("Please enter your choice(1-4): ");
            int input = Integer.parseInt(userInput.nextLine());
            if(input >= 1 && input <= 4)
            {
                do{
                    sortCode+=input*10;
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    System.out.println("Order");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    System.out.println("1. Ascending Order");
                    System.out.println("2. Descending Order");
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    System.out.print("Please enter your choice(1-2): ");
                    input = Integer.parseInt(userInput.nextLine());
                    if(input == 1 || input == 2)
                    {
                        sortCode+=input;
                    }
                    else
                    {
                        System.out.println("Invalid Input.Please Enter Again.");
                        userInput.nextLine();
                    }
                }while(input != 1 && input != 2);
                isExit = true;
                memberList.sort(new NameComparator());
            }
            else if(input == 5)
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
