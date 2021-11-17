/**
	Name:		Goh Kok Dong
	StudID:		20WMR09455
	Group:		RSF2 G4
	Date:		10/8/2020
	Project:	UserMenu.java
*/

package Client;

import ADT.*;
import Entity.*;

import java.util.*;
import java.lang.Character;

public class UserMenu extends LinearLinkedList {
	
	// List
	private LinearLinkedListInterface<Manager> managerList = new LinearLinkedList<>();
	private LinearLinkedListInterface<Member> memberList = new LinearLinkedList<>();
        
        // <editor-fold defaultstate="collapsed" desc="Variables Declaration">
        private final String fileManager = "Manager.bin";
        private final String fileMember = "Member.bin";
        private final int SIZE = 100;
        
        private Manager[] manager = new Manager[SIZE];
        private Member[] member = new Member[SIZE];
        
        private int accType;
        private String currentUserID;
        
        private Progress currentUserProgress;
        
	Scanner input = new Scanner(System.in);
        
        // </editor-fold>
	
        // Constructor
	public UserMenu() {
               
            //writeProgress();
            accType = -1;
            currentUserID = "";
            
            if (managerList.isEmpty())
                readManagerDetails();
            
            if (memberList.isEmpty())
                readMemberDetails();
	}
	
        // Driver function
	public static void main(String[] args) {
		UserMenu userMenu = new UserMenu();
                
		userMenu.welcomeMenu();
	}
        
        // <editor-fold defaultstate="collapsed" desc="Welcome Menu and functions">
        
        // Display logo design
        public void displayLogo() {
            System.out.println("   ___      _        _            ____       _              ");
            System.out.println("  / _ \\___ | |_ __ _| |_ ___     /___ \\_   _(_)___________  ");
            System.out.println(" / /_)/ _ \\| __/ _` | __/ _ \\   //  / / | | | |_  /_  / _ \\ ");
            System.out.println("/ ___/ (_) | || (_| | || (_) | / \\_/ /| |_| | |/ / / / (_) |");
            System.out.println("\\/    \\___/ \\__\\__,_|\\__\\___/  \\___,_\\ \\__,_|_/___/___\\___/ ");
        }
        
        // Display menu for user to login or register
	public void welcomeMenu() {
		int menuOption;
		
                displayLogo();
		do {
                    System.out.println("Welcome to Potato Quiz Game");
                    System.out.println("========================");
                    System.out.println("1. I have an ID");
                    System.out.println("2. I don't have an ID");
                    System.out.println("3. Exit");
                    System.out.println("========================");
                    System.out.print("Option > ");
		
                    menuOption = input.nextInt();
			
                    if (validationDigit(menuOption)) {
                        welcomeMenuSelection(menuOption);
                        
                        if (menuOption == 1 || menuOption == 2)
                            accDecision();
                    }
                    else
                        menuOption = 0;
                        
		} while (menuOption != 3 && !validationDigit(menuOption));	
		
	}
	
        // Switch statement for welcomeMenu()
	public void welcomeMenuSelection(int menuOption) {
		switch(menuOption) {
			case 1:
				login();
				break;
			case 2:
				register();
                                welcomeMenu();
				break;
			case 3:
				System.exit(0);				
			default:
				System.out.println("Please select between 1 to 3...\n");
		}
	}
	
        // Login function
	public void login() {
                String userID, password;
                
		System.out.println("Login");
		System.out.println("======================");
                System.out.print("-1 to cancel\n");
                
		System.out.print("== Username > ");
		input.nextLine();
                userID = input.nextLine();
                
		System.out.print("== Password > ");
		password = input.nextLine();
		
		System.out.println("======================");
                
                accType = validateAccount(userID, password);
                
                System.out.println("");
                
                if (accType != -1) {
                    currentUserID = userID;
                    System.out.println("Login Successfully");
                    accDecision();
                }
                else {
                    System.out.println("Incorrect password or Incorrect username");
                    welcomeMenu();
                }
                
                if (userID.equals("-1") || password.equals("-1"))
                    welcomeMenu();
	}
	
        // Register function
	public void register() {
                String firstName, lastName, userID, password, passwordConfirm;
                char gender;
                
                boolean runFirst = true;
                Member member;
                
                do {
                        System.out.println("Register");
                        System.out.print("======================\n");
                        System.out.print("-1 to cancel\n");
                        
                        System.out.print("== First Name > ");
                        firstName = input.nextLine();
                        if (runFirst)
                            firstName = input.nextLine();
                        
                        System.out.print("== Last Name > ");
                        lastName = input.nextLine();
                        
                        System.out.print("== Gender(M/F) > ");
                        gender = input.next().charAt(0);
                        
                        input.nextLine();
                        System.out.print("== Username > ");
                        userID = input.nextLine();
                        
                        System.out.print("== Password > ");
                        password = input.nextLine();
                        
                        System.out.print("== Confirm Password > ");
                        passwordConfirm = input.nextLine();
                        
                        System.out.println("======================");
                        runFirst = false;
                        
                        if (validateIsNull(firstName) || validateIsNull(lastName) || validateIsNull(userID) || validateIsNull(password))
                            System.out.println("\nDon't leave your answer blank. Please try again later..");
                        else if (!password.equals(passwordConfirm))
                            System.out.println("\nPassword and Confirm Password must be the same. Please try again later..");
                        
                        if (firstName.equals("-1") || lastName.equals("-1") || userID.equals("-1") || password.equals("-1") || passwordConfirm.equals("-1"))
                            welcomeMenu();
                        
                } while(!validateIsLetter(firstName) || !validateIsLetter(lastName) || validateIsNull(userID) || validateIsNull(password) || !password.equals(passwordConfirm) || !validationGender(gender));
                
                member = new Member(firstName, lastName, gender, userID, password);
                
                ProgressClient progress = new ProgressClient();
                progress.addNewPlayerProgress(userID, 1, 1, 1);
                
                if (!validateExistingAcc(userID))
                    memberList.add(member);
                else {
                    System.out.println("Username " + userID + " has been taken. Please try again later");
                    register();
                }
                
                if (memberList.isExist(member)) {
                    System.out.println("Member " + member.getName() + " has registered successfully");
                    writeMemberData();
                }
	}
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Decision making (switch)">
        
        // Decide which account type of the user ID belongs to
        public void accDecision() {
            if (accType == 1) {
                System.out.println("You are login as: MANAGER");
                managerMenu();
            }
            else if (accType == 2) {
                System.out.println("You are login as: MEMBER");
                memberMenu();
            }
            else
                System.out.println("Invalid Account Type");
        }
        
        // Decision which function user select from manager menu
        public void managerMenuSelection(int choice) {
                switch(choice) {
                    case 1:
                        addNewManager();
                        break;
                    case 2:
                        banUser();
                        break;
                    case 3:
                        removeManager();
                        break;
                    case 4:
                        displayAllUsers();
                        break;
                    case 5:
                        logOut();
                        break;
                    default:
                        System.out.println("Please select between 1 to 4...");
		}
        }
        
        // Decision which function user select from member menu
        public void memberMenuSelection(int choice) {
                switch(choice) {
                    case 1:
                        playQuiz();
                        break;
                    case 2:
                    	viewProgress();
                    	break;
                    case 3:
                        viewScoreboard();
                        break;
                    case 4:
                        logOut();
                        break;
                    default:
                        System.out.println("Please select between 1 to 4...");
		}
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Menu">
        
        // Display menu for manager account user
        public void managerMenu() {
                int choice;
                
		do {
                    System.out.println("Manager Abilities");
                    System.out.println("========================");
                    System.out.println("1. Add new Manager");
                    System.out.println("2. Ban user");
                    System.out.println("3. Remove Manager");
                    System.out.println("4. Display all users");
                    System.out.println("5. Logout");
                    System.out.println("========================");
                    System.out.print("Option > ");
		
                    choice = input.nextInt();
                    
                    if (validationDigit(choice))
                        managerMenuSelection(choice);
                    else
                        choice = 0;
                    
		} while (choice != 4);
        }
        
        // Display menu for member account user
        public void memberMenu() {
                int choice;
                
		do {
                    System.out.println("Member Abilities");
                    System.out.println("========================");
                    System.out.println("1. Play Quiz");
                    System.out.println("2. View Progress");
                    System.out.println("3. View Scoreboard");
                    System.out.println("4. Logout");
                    System.out.println("========================");
                    System.out.print("Option > ");
		
                    choice = input.nextInt();
			
                    if (validationDigit(choice))
                        memberMenuSelection(choice);
                    else
                        choice = 0;
                    
		} while (choice != 4);
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Manager's Abilities">
        
        // Add a new manager
        public void addNewManager() {
                String firstName, lastName, userID, password, passwordConfirm;
                char gender;
                boolean runFirst = true;
                Manager manager;
                
                do {
                    System.out.println("New manager details");
                    System.out.println("====================");
                        
                    System.out.print("== First Name > ");
                    firstName = input.nextLine();
                    
                    if (runFirst)
                        firstName = input.nextLine();
                        
                    System.out.print("== Last Name > ");
                    lastName = input.nextLine();
                        
                    System.out.print("== Gender(M/F) > ");
                    gender = input.next().charAt(0);
                        
                    input.nextLine();
                    System.out.print("== Username (Automatically start with '@')> ");
                    userID = '@' + input.nextLine();
                        
                    System.out.print("== Password > ");
                    password = input.nextLine();
                        
                    System.out.print("== Confirm Password > ");
                    passwordConfirm = input.nextLine();
                        
                    System.out.println("======================");
                    runFirst = false;
                        
                    if (validateIsNull(firstName) || validateIsNull(lastName) || validateIsNull(userID) || validateIsNull(password))
                        System.out.println("\nDon't leave your answer blank. Please try again later..");
                    else if (!password.equals(passwordConfirm))
                        System.out.println("\nPassword and Confirm Password must be the same. Please try again later..");
                    
                } while (!validateIsLetter(firstName) || !validateIsLetter(lastName) || validateIsNull(userID) || validateIsNull(password) || !password.equals(passwordConfirm) || !validationGender(gender));
                
                manager = new Manager(firstName, lastName, gender, userID, password);
                
                if (!validateExistingAcc(userID))
                    managerList.add(manager);
                else {
                    System.out.println("Username " + userID + " has been taken. Please try again later");
                    addNewManager();
                }
                
                if (managerList.isExist(manager)) {
                    System.out.println("Manager " + manager.getName() + " has been registered successfully");
                    writeManagerData();
                }
        }
        
        // Remove a manager from the list
        public void removeManager() {
                boolean success = false;
                String userID;
                Manager managerRemoved;
                
                if (currentUserID.equals("@potatoDono")) {
                    System.out.print("Enter managerID to be remove > ");
                    input.nextLine();
                    userID = input.nextLine();

                    // Remove user
                    for (int i = 0; i < managerList.getSize(); i++) {
                        if (userID.equals(manager[i].getAccountUserID())) {
                            managerRemoved = managerList.search(i + 1);

                            if (managerList.remove(i + 1)) {
                                System.out.printf("%-15s %-8s %-20s %-16s %-14s\n", "Name", "Gender", "User ID", "Password", "Age of Account");
                                System.out.printf("%-15s %-8s %-20s %-16s %-14s\n", "====", "======", "=======", "========", "==============");
                                System.out.println(managerRemoved + "\nRemoved successfully");

                                success = true;
                            }
                        }
                    }
                }
                else {
                    System.out.println("You do not have enough privilege to access this function");
                }
                
                if (success)
                    writeManagerData();
                else
                    System.out.println("Manger ID not found");
        }
        
        // Remove a member from the game/list
        public void banUser() {
                boolean success = false;
                String userID;
                Member memRemoved;
                
                
                System.out.print("Enter userID to be banned > ");
                input.nextLine();
                userID = input.nextLine();
                
                // Remove user
                for (int i = 0; i < memberList.getSize(); i++) {
                    if (userID.equals(member[i].getAccountUserID())) {
                        memRemoved = memberList.search(i + 1);
                                
                        if (memberList.remove(i + 1)) {
                            System.out.printf("%-15s %-8s %-20s %-16s %-14s\n", "Name", "Gender", "User ID", "Password", "Age of Account");
                            System.out.printf("%-15s %-8s %-20s %-16s %-14s\n", "====", "======", "=======", "========", "==============");
                            System.out.println(memRemoved + "\nRemoved successfully");
                            
                            success = true;
                        }
                    }
                }
                
                if (success)
                    writeMemberData();
                else
                    System.out.println("Member not found");
        }
        
        // Display all existing user in the game/list
        public void displayAllUsers() {
                getMemberDetails();
                if (!memberList.isEmpty())  {
                    System.out.println("Member");
                    System.out.println("==========");
                    System.out.printf("%-15s %-8s %-20s %-16s %-14s\n", "Name", "Gender", "User ID", "Password", "Age of Account");
                    System.out.printf("%-15s %-8s %-20s %-16s %-14s\n", "====", "======", "=======", "========", "==============");
         
                    for (int i = 0; i < memberList.getSize(); i++)
                        System.out.println(member[i].toString());
                    
                    System.out.printf("\n");
                }
                
                getManagerDetails();
                if (!managerList.isEmpty())  {
                    System.out.println("Manager");
                    System.out.println("==========");
                    System.out.printf("%-15s %-8s %-20s %-16s %-14s\n", "Name", "Gender", "User ID", "Password", "Age of Account");
                    System.out.printf("%-15s %-8s %-20s %-16s %-14s\n", "====", "======", "=======", "========", "==============");
         
                    for (int i = 0; i < managerList.getSize(); i++)
                        System.out.println(manager[i].toString());
                    
                    System.out.printf("\n");
                }
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Member's Abilities">
        
        // Play the game
        public void playQuiz() {
            
            ProgressClient proClient = new ProgressClient();
            
            Progress temp = proClient.validateUserID(currentUserID);
            
            QuizMenu quiz = new QuizMenu();
            
            QuizMenu tempQuiz = quiz.playQuiz(temp.getAnimalQuestionNo(), temp.getCountryQuestionNo(), temp.getPlantQuestionNo());
            

            temp.setAnimalQuestionNo(tempQuiz.getAnimalQuizQuestonNo());
            temp.setCountryQuestionNo(tempQuiz.getCountryQuizQuestonNo());
            temp.setPlantQuestionNo(tempQuiz.getPlantQuizQuestonNo());
            
            proClient.updateProgress(temp);
        }
        
        // View the user game progress
        public void viewProgress() {
            ProgressClient proClient = new ProgressClient();
            
            Progress temp = proClient.validateUserID(currentUserID);
            
            System.out.println("\n-------- Progress --------");
            System.out.println(temp);
        }
        
        // View the scoreboard
        public void viewScoreboard() {
            ScoreboardClient scoreboard = new ScoreboardClient();
            
            scoreboard.scoreboardMenu();
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Utilities">
       
        // Read manager data from the manager file and assign them to array and list
        public void readManagerDetails() {
                
            int numOfObject;
            ReadWriteFile file = new ReadWriteFile();
            
            // To read data from binary file
            numOfObject = file.read(manager, fileManager);
                
            // Write the results from binary file to linkedList
            for(int i = 0; i < numOfObject; i++)
                managerList.add(manager[i]);
                
        }
        
        // Read member data from the member file and assign them to array and list
        public void readMemberDetails() {
                
            int numOfObject;
            ReadWriteFile file = new ReadWriteFile();
             
            // To read question from binary file
            numOfObject = file.read(member, fileMember);
                
            // Write the results from binary file to linkedList
            for(int i = 0; i < numOfObject; i++)
                memberList.add(member[i]);
                
        }
        
        // Write the manager data in the managerList into the file
        public void writeManagerData() {
            ReadWriteFile file = new ReadWriteFile();
                
            Manager[] tempManager = new Manager[SIZE];
            
            for (int i = 0; i < managerList.getSize(); i++) {
                tempManager[i] = managerList.search(i + 1);
            }
            // To write data to binary file
            file.write(tempManager, fileManager);
        }
        
        // Write the member data in the memberList into the file
        public void writeMemberData() {
            ReadWriteFile file = new ReadWriteFile();
           
            Member[] tempMember = new Member[SIZE];
                
            for (int i = 0; i < memberList.getSize(); i++) {
                tempMember[i] = memberList.search(i + 1);
            }
                
            // To write data to binary file
            file.write(tempMember, fileMember);
        }
        
        // Write manager and member data to the file
        public void writeFinaliseData() {
            writeManagerData();
            writeMemberData();
        }
        
        // Read the member data from the memberList and assign it to the array
        public void getMemberDetails() {
            member = new Member[100];
            
            for(int i = 0; i < memberList.getSize(); i++)
                member[i] = memberList.search(i + 1);
        }
        
        // Read the manager data from the managerList and assign it to the array
        public void getManagerDetails() {
            manager = new Manager[100];
                
            for (int i = 0; i < managerList.getSize(); i++)
                manager[i] = managerList.search(i + 1);
        }
        
        // Logout
        public void logOut() {
                welcomeMenu();
                accType = -1;
                writeFinaliseData();
        }
        // </editor-fold>
        
	// <editor-fold defaultstate="collapsed" desc="Validations">
        
        // Validation for digits
        public boolean validationDigit(int digit) {
            char verifyDigit = (char)(digit + '0');
            
            if (Character.isDigit(verifyDigit))
                return true;
            else
                return false;
        }
        
        // Validation for gender (M / F), display error message when receive invalid character other than m and f
	public boolean validationGender(char gender) {
            gender = Character.toUpperCase(gender);
                
            if (gender == 'M' || gender == 'F') {
            	return true;
            }
            System.out.println("Invalid Character!! Please enter M or F for gender selection..\n");
            
            return false;
        }
        
        // Validataion for letter, display error message when receive invalid characters other than letter and space
        public boolean validateIsLetter(String word) {
            boolean output = true;
                
            if(word == null || word == "") {
                output = false;
            }
            else {
                for (int i = 0; i < word.length(); i++) {
                    if (!(Character.isLetter(word.charAt(i))) && !(Character.isSpaceChar(word.charAt(i))))
                        output = false;
                }
                        
                if (!output)
                    System.out.println("\nInvalid value. " + word + " can only contain letter and space..\n");
            }
                
            return output;
        }
        
        // Validation for unassigned variables
        public boolean validateIsNull(String word) {
            if (word != null || word != "")
                return false;
            
            return true;
        }
        
        // Validation userID and password for each account in the array
        public int validateAccount(String userID, String password) {
            
            getManagerDetails();
            for (int i = 0; i < managerList.getSize(); i++) {
                if (manager[i].validateUserID(userID) && manager[i].validatePassword(password)) {
                    return 1;
                }
            }
            
            getMemberDetails();
            for (int i = 0; i < memberList.getSize(); i++) {
                if (member[i].validateUserID(userID) && member[i].validatePassword(password)) {
                    return 2;
                }
            }
                
            return -1;
        }
        
        // Validate Existing Account of users
        public boolean validateExistingAcc(String userID) {
            getManagerDetails();
            for (int i = 0; i < managerList.getSize(); i++) {
                if (userID.equals(manager[i].getAccountUserID()))
                    return true;
            }
            
            getMemberDetails();
            for (int i = 0; i < memberList.getSize(); i++) {
                if (userID.equals(member[i].getAccountUserID()))
                    return true;
            }
            
            return false;
        }
	// </editor-fold>
}