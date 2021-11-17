/*
	Name:		koh Xin Hao
	StudID:		20WMR09471
	Group:		RSF2 G4
	Project:	Quiz.java
*/
package Superclass;

import Entity.*;
import Client.*;
import Superclass.*;
import Interface.*;
import ADT.*;

public class Quiz {
    
    private String category;
    
    // Constructor
    public Quiz(){
        
    }
    
    public Quiz(String category){
        this.category = category;
    }
    
    // Setter
    public void setCategory(String catrgory){
        
        this.category = category;
    }
    
    // Getter
    public String getCategory(){
        return category;
    }
    
    
     // Check whether the object pass in is equals 
    public boolean equals(Object o){
        
        // Casting object passed in to quiz object
        Quiz q = (Quiz)o;
        
        // Check if the object passed in is null
        if(o == null)
            return false;
        
        // return true when category is match
        return this.category.equals(q.category);
        
    }
    
    // Compare the method whether grether, smaller or euqal
    public int compareTo(Object o){
        
        Quiz q = (Quiz)o;
        
        return category.compareTo(q.category);
    }
    
    // To String Method
    public String toString(){
        return "Category: " + category;
    }
    
}
