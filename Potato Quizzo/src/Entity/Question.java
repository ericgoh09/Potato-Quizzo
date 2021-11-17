/*
	Name:		koh Xin Hao
	StudID:		20WMR09471
	Group:		RSF2 G4
	Project:	Question.java
*/

package Entity;

import Entity.*;
import Client.*;
import Superclass.*;
import Interface.*;
import ADT.*;
import java.io.Serializable;

public class Question extends Quiz implements QuestionInterface, Serializable {
    
    //Variable declaration
    private String questionTitle;
    private String questionAnswer;
    private int level;
    
    // Constructor
    public Question(){
        
    }
    
    public Question(String category, String questionTitle, String questionAnswer, int level){
        super(category);
        this.questionTitle = questionTitle;
        this.questionAnswer = questionAnswer;
        this.level = level;
        
    }
    
    // Setter
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    // Getter
    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public int getLevel() {
        return level;
    }
    
    // Validate answer that user input
    public boolean validateAnswer(String respond){
        
        return questionAnswer.equalsIgnoreCase(respond);
        
    } 
 
    // To String Method
    public String toString(){
        
        return "Level " + level + "\n"
                + questionTitle + "\n"
                + questionAnswer;
                
    }

}
