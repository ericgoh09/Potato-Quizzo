/**
	Name:		Goh Kok Dong
	StudID:		20WMR09455
	Group:		RSF2 G4
	Date:		10/8/2020
	Project:	ScoreboardClient.java
*/

package Client;
import ADT.LinearLinkedList;
import ADT.LinearLinkedListInterface;
import Entity.Progress;
import Entity.ReadWriteFile;
import java.util.*;

public class ScoreboardClient {
    
    private LinearLinkedListInterface<Progress> progressList = new LinearLinkedList<>();
    
    private final String fileProgress = "Progress.bin";
    
    private Progress[] progress = new Progress[100];
    
    ScoreboardClient() {
        readProgressDetails();
    }
    
    public void readProgressDetails() {
                
        int numOfObject;
        ReadWriteFile file = new ReadWriteFile();
            
        // To read data from binary file
        numOfObject = file.read(progress, fileProgress);
                
        // Write the results from binary file to linkedList
        for(int i = 0; i < numOfObject; i++)
            progressList.add(progress[i]);
        
        System.out.println(progressList.search(1));
        System.out.println(progressList.search(2));
        
    }
    
    public void scoreboardMenu() {
        Scanner input = new Scanner(System.in);
        
        int choice;
        
        System.out.println("Scoreboard Categories");
        System.out.println("=============================");
        System.out.println("1. ScoreBoard Category Animal");
        System.out.println("2. ScoreBoard Category Country");
        System.out.println("3. ScoreBoard Category Plant");
        System.out.println("4. Exit");
        
        System.out.print("\nEnter your choice (1-4) > ");
        
        choice = input.nextInt();
        
        scoreboardMenuSelection(choice);
    }
    
    public void scoreboardMenuSelection(int choice) {
        switch(choice) {
            case 1:
                categoryAnimal();
                break;
            case 2:
                categoryCountry();
                break;
            case 3:
                categoryPlant();
                break;
            default:
                
        }
    }
    
    public void categoryAnimal() {
        int highest = -999;
        int lowest = 999;
        String userID = "";
        
        Progress[] temp = progress;
        Progress lowestProgress = new Progress();
        Progress highestProgress = new Progress();
        
        getProgressDetails();
        System.out.println("Category Animal");
        System.out.println("==================");
        System.out.printf("%-10s %-20s %-10s\n", "Ranking", "User ID", "Score");
        System.out.printf("%-10s %-20s %-10s\n", "=======", "=======", "=====");
        
        for (int i = 0; i < progressList.getSize(); i++) {
            if (highest < temp[i].getAnimalQuestionNo()) {
                highest = temp[i].getAnimalQuestionNo();
                
                highestProgress = temp[i];
            }
            
            if (lowest > temp[i].getAnimalQuestionNo()) {
                lowest = temp[i].getAnimalQuestionNo();
                
                lowestProgress = temp[i];
            }
        }
        
        System.out.printf("%-10d %-20s %-10.2f %-10s\n", 1, highestProgress.getUserID(), highestProgress.calculateAnimalQuizScore(), "HIGHEST");
        
        if ((progressList.getSize() - 2) != 0) {
            for (int i = 0; i < progressList.getSize() - 2; i++) {
                if (temp[i].getUserID() != null)
                    System.out.printf("%-10d %-20s %-10.2f %-10s\n", i + 2, temp[i].getUserID(), temp[i].calculateAnimalQuizScore(), "RANDOM");
            }
        }
        
        System.out.printf("%-10d %-20s %-10.2f %-10s\n", progressList.getSize(), lowestProgress.getUserID(), lowestProgress.calculateAnimalQuizScore(), "LOWEST");
        
        System.out.println("==================");
    }
    
    public void categoryCountry() {
        int highest = -999;
        int lowest = 999;
        String userID = "";
        
        Progress[] temp = progress;
        Progress lowestProgress = new Progress();
        Progress highestProgress = new Progress();
        
        getProgressDetails();
        System.out.println("Category Country");
        System.out.println("==================");
        System.out.printf("%-10s %-20s %-10s\n", "Ranking", "User ID", "Score");
        System.out.printf("%-10s %-20s %-10s\n", "=======", "=======", "=====");
        
        for (int i = 0; i < progressList.getSize(); i++) {
            if (highest < temp[i].getCountryQuestionNo()) {
                highest = temp[i].getCountryQuestionNo();
                
                highestProgress = temp[i];
            }
            
            if (lowest > temp[i].getCountryQuestionNo()) {
                lowest = temp[i].getCountryQuestionNo();
                
                lowestProgress = temp[i];
            }
        }
        
        System.out.printf("%-10d %-20s %-10.2f %-10s\n", 1, highestProgress.getUserID(), highestProgress.calculateCountryQuizScore(), "HIGHEST");
        
        if ((progressList.getSize() - 2) != 0) {
            for (int i = 0; i < progressList.getSize() - 2; i++) {
                if (temp[i].getUserID() != null)
                    System.out.printf("%-10d %-20s %-10.2f %-10s\n", i + 2, temp[i].getUserID(), temp[i].calculateCountryQuizScore(), "RANDOM");
            }
        }
        
        System.out.printf("%-10d %-20s %-10.2f %-10s\n", progressList.getSize(), lowestProgress.getUserID(), lowestProgress.calculateCountryQuizScore(), "LOWEST");
        
        System.out.println("==================");
    }
    
    public void categoryPlant() {
        int highest = -999;
        int lowest = 999;
        String userID = "";
        
        Progress[] temp = progress;
        Progress lowestProgress = new Progress();
        Progress highestProgress = new Progress();
        
        getProgressDetails();
        System.out.println("Category Plant");
        System.out.println("==================");
        System.out.printf("%-10s %-20s %-10s\n", "Ranking", "User ID", "Score");
        System.out.printf("%-10s %-20s %-10s\n", "=======", "=======", "=====");
        
        for (int i = 0; i < progressList.getSize(); i++) {
            if (highest < temp[i].getPlantQuestionNo()) {
                highest = temp[i].getPlantQuestionNo();
                
                highestProgress = temp[i];
            }
            
            if (lowest > temp[i].getPlantQuestionNo()) {
                lowest = temp[i].getPlantQuestionNo();
                
                lowestProgress = temp[i];
            }
        }
        
        System.out.printf("%-10d %-20s %-10.2f %-10s\n", 1, highestProgress.getUserID(), highestProgress.calculatePlantQuizScore(), "HIGHEST");
        
        if ((progressList.getSize() - 2) != 0) {
            for (int i = 0; i < progressList.getSize() - 2; i++) {
                if (temp[i].getUserID() != null)
                    System.out.printf("%-10d %-20s %-10.2f %-10s\n", i + 2, temp[i].getUserID(), temp[i].calculatePlantQuizScore(), "RANDOM");
            }
        }
        
        System.out.printf("%-10d %-20s %-10.2f %-10s\n", progressList.getSize(), lowestProgress.getUserID(), lowestProgress.calculatePlantQuizScore(), "LOWEST");
        
        System.out.println("==================");
    }
    
    public void getProgressDetails() {
            progress = new Progress[100];
            
            for(int i = 0; i < progressList.getSize(); i++)
                progress[i] = progressList.search(i + 1);
    }
}
