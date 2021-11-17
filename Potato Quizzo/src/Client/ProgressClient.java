/*
	Name:		koh Xin Hao
	StudID:		20WMR09471
	Group:		RSF2 G4
	Project:	ProgressClient.java
*/

package Client;

import ADT.CircularLinkedList;
import ADT.CircularLinkedListInterface;
import Entity.Progress;
import Entity.Question;
import Entity.ReadWriteFile;


public class ProgressClient {
    
    // ADT declareation
    private CircularLinkedListInterface<Progress> progressList = new CircularLinkedList<>();
    
    public ProgressClient(){
        
        readProgress(progressList, "Progress.bin");
    }
    
    
    // Write the progress to binary file
    public static void writeProgress(CircularLinkedListInterface list){
        
        Progress[] progress = new Progress[100];
        
        
        for(int i = 0; i < list.size(); i++){
            
            progress[i] = (Progress) list.get(i + 1);
            
        }
        
       
        ReadWriteFile readWriteFile = new ReadWriteFile();
        
        readWriteFile.write(progress, "Progress.bin");
        
    }
    
    // Read quiz from binary file to CircularLinkedList
    public void readProgress(CircularLinkedListInterface list, String fileName){
        
        // To read question from binary file 
        Progress[] progress = new Progress[100];
     
        ReadWriteFile readWriteFile = new ReadWriteFile();
        
        int noOfElement = readWriteFile.read(progress, fileName);
        
        // Write the result from binary file to linkedlist
        for(int i = 0; i < noOfElement; i++){
            
            progress[i].setPlantQuestionNo(1);
            list.add(progress[i]);
            
        }
        
    }
    
    // TO return the progress for a particular user.
    public Progress validateUserID(String ID){
        
        Progress pro;
        
        
        // Archieve an element from list
        for(int i = 1; i <= progressList.size(); i++){
            
            pro = progressList.get(i);
            
            if(pro.getUserID().equals(ID)){
                return pro;
            }
        }

        return null;
    
    }
    
    // Update progress 
    public void updateProgress(Progress pro){
            
        Progress temp;
        for(int i = 1; i <= progressList.size(); i++){
            
            temp = progressList.get(i);
            
            if(temp.getUserID().equals(pro.getUserID())){
                temp.setAnimalQuestionNo(pro.getAnimalQuestionNo());
                temp.setCountryQuestionNo(pro.getCountryQuestionNo());
                temp.setPlantQuestionNo(1);
                
                progressList.replace(i, temp);
               
            }
        }
         
         writeProgress(progressList);
        
    }
    
    public void addNewPlayerProgress(String userID, int animalQuestionNo, int countryQuestionNo, int plantQuestionNo){
        
        Progress progress = new Progress(userID, animalQuestionNo, countryQuestionNo, plantQuestionNo);
        
        progressList.add(progress);
        
        writeProgress(progressList);
        
    }
    
     // Write the progress to binary file (To reset data)
    public static void writeProgress(){
        
        Progress[] progress = new Progress[100];
        
        progress[0] = new Progress("potatoDono", 1, 1, 1);
        progress[1] = new Progress("hokxh", 1, 1, 1);
      
        /*
        for(int i = 0; i < list.size(); i++){
            
            progress[i] = (Progress) list.get(i + 1);
            
        }*/
        
       
        ReadWriteFile readWriteFile = new ReadWriteFile();
        
        readWriteFile.write(progress, "Progress.bin");
        
    }

    
}
