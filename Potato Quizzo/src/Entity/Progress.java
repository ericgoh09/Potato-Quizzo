/*
	Name:		koh Xin Hao
	StudID:		20WMR09471
	Group:		RSF2 G4
	Project:	Progress.java
*/


package Entity;

import java.io.Serializable;
import java.util.Objects;


public class Progress implements Serializable{
    
    private String userID;
    private int animalQuestionNo;
    private int countryQuestionNo;
    private int plantQuestionNo;

    public Progress(String userID, int animalQuestionNo, int countryQuestionNo, int plantQuestionNo) {
        this.userID = userID;
        this.animalQuestionNo = animalQuestionNo;
        this.countryQuestionNo = countryQuestionNo;
        this.plantQuestionNo = plantQuestionNo;
    }
    
    public Progress(){
        this.userID = "";
        this.animalQuestionNo = 1;
        this.countryQuestionNo = 1;
        this.plantQuestionNo = 1;
    }
    
    public double calculateAnimalQuizScore(){
        
        return (animalQuestionNo - 1) * 20;
    }
    
    public double calculateCountryQuizScore(){
        
        return (countryQuestionNo - 1) * 20;
    }
    
    public double calculatePlantQuizScore(){
        
        return (plantQuestionNo - 1) * 20;
    }

    public String getUserID() {
        return userID;
    }

    public int getAnimalQuestionNo() {
        return (animalQuestionNo);
    }

    public int getCountryQuestionNo() {
        return (countryQuestionNo);
    }

    public int getPlantQuestionNo() {
        return (plantQuestionNo);
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setAnimalQuestionNo(int animalQuestionNo) {
        this.animalQuestionNo = animalQuestionNo;
    }

    public void setCountryQuestionNo(int countryQuestionNo) {
        this.countryQuestionNo = countryQuestionNo;
    }

    public void setPlantQuestionNo(int plantQuestionNo) {
        this.plantQuestionNo = plantQuestionNo;
    }
    
    public String toString(){
        
        return String.format("User ID: " + this.userID + "\n"
                             + "Category       " + "Progress    " + "\n"
                            + "==============" + " ========== " + "\n" 
                             + "Animal Quiz:    " + (animalQuestionNo - 1) + "/5 \n" +
                             "Country Quiz:   " + (countryQuestionNo - 1) + "/5 \n" + 
                             "Plant Quiz:     " + (plantQuestionNo - 1) + "/5 \n" );
        
    }
}
