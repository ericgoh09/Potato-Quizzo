/*
	Name:		koh Xin Hao
	StudID:		20WMR09471
	Group:		RSF2 G4
	Project:	CicularLinkedList.java
*/
    
package ADT;

import Entity.*;
import Client.*;
import Superclass.*;
import Interface.*;
import ADT.*;

public class CircularLinkedList<T> implements CircularLinkedListInterface<T>{
    
    private Node firstNode;
    private int length = 0;

    public CircularLinkedList() {
    }
   
    
    // Node class
    private class Node{
        
        T data;
        Node next;
        Node previous;
        
        // Constructor
        private Node(){
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
        
        private Node(T data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
        
        private Node(T data, Node next){
            this.data = data;
            this.next = next;
            this.previous = null;
        }
        
        private Node(T data, Node next, Node previous){
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }
    
    @Override
    public boolean add(T newElement) {
        
        Node newNode = new Node(newElement);
        
        // Check if the node is empty
        if(isEmpty()){ // if list is empty assigment new node as first element
            firstNode = newNode;
            firstNode.next = firstNode;
            firstNode.previous = firstNode;
        }
        else{ 
            Node currentNode = firstNode;
            
            // Use loop to acheive last element inside node
            for(int i = 1; i < length; i++){
                currentNode = currentNode.next;
            }
            
            newNode.previous = currentNode;
            newNode.next = firstNode;
            
            firstNode.previous = newNode;
            currentNode.next = newNode;

        }
        
        length++;
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        
        // Check if index given is valid
        if(index <= length + 1 && index > 0){
            
            Node newNode = new Node(element);
            
            // If node is empty
            if(isEmpty() || index == 1){
                if(firstNode.next != firstNode){
                    
                    Node currentNode = firstNode;
                    
                    for(int i = 1; i < length; i++){
                        currentNode = currentNode.next;
                    }
                    
                    
                    newNode.next = firstNode;
                    firstNode.previous = newNode;
                    
                    firstNode = newNode;
                    currentNode.next = firstNode;
                    
                    firstNode.previous = currentNode;
                 
                }
                else{
                    
                    newNode.next = firstNode;
                    
                    firstNode.previous = newNode;
                    
                    newNode.next = firstNode;
                    
                    firstNode = newNode;
                    
                    if(length > 1){
                        
                        Node currentNode = firstNode;
                        
                        for(int i = 0; i < length; i++){
                            currentNode = currentNode.next;
                        }
                        
                        currentNode.next = firstNode;
                    }
                    
                    
                }
                
            }else{
                Node nodeBefore = firstNode;
                
                for(int i = 1; i < index - 1; i++){
                    nodeBefore = nodeBefore.next;
                }
        
                Node nodeAfter = nodeBefore.next;

                newNode.previous = nodeBefore;

                newNode.next = nodeAfter;

                nodeBefore.next = newNode;

                nodeAfter.previous = newNode;
               
            }
            length++;
            return true;
        }
        else
            return false;
    }

    @Override
    public void clear() {
        firstNode = null;  // Assign first node to empty to clear the list
        length = 0;  // Clear the length of the list to 0
    }

    @Override
    public boolean isEmpty() {
        
        // Check if the node is empty
        if(firstNode != null || length != 0) // if first node is not empty, then the node is not empty
            return false;
        else 
            return true;
    }

    @Override
    public boolean remove(int element) {
        
        // Check if the element pass inside is valid
        if((element <= length) && (element > 0)){
            
            if(element == 1){
                firstNode = firstNode.next;
                
                Node currentNode = firstNode;
                
                for(int i = 0; i < length - 1; i++){
                    
                    currentNode = currentNode.next;
                }
                
                currentNode.next = firstNode;
            }
            else{
                Node nodeBefore = firstNode;

                for(int i = 1; i < element - 1; ++i){
                    nodeBefore = nodeBefore.next;
                }

                nodeBefore.next = nodeBefore.next.next;
                nodeBefore.next.previous = nodeBefore;
            
            }	
            length--;
            return true;
        
        }else{
            return false;
        }
        
    }

    @Override
    public int size() {
        return length;  // Return the size of the list
    }
    
    public T get(int element){
        
        // Check whether the element that user keyin is valid
        if((element <= length) && (element > 0)){
        
            Node currentNode = firstNode;
            
            if(element == 1){
                return currentNode.data;
            }else{
                
                for(int i = 1; i < element; i++){
                    currentNode = currentNode.next;
                }
                
                return currentNode.data;
            }
        }else
            return null;
    }
    
    @Override
    public boolean isFull() {
        return false;  // Return false, because linked implementation will not full
    }
    
    public T head(){
         
        // Check if the first node exists
        if(firstNode != null)
            return firstNode.data;   // Return first node data
        else
            return null;  // If firstNode does not exixts means the node is null

    }
    
    public T tail(){
        
        // Check if the first node exixts
        if(firstNode == null)
            return null;  // If firstNode does not exixts means the node is null
        else
            return get(length);  // return last node data
        
    }
    
    public T previous(int currentPosition){
        
        // Check if the element that user provided is valid
        if(currentPosition <= length){
            
            Node currentNode = firstNode;
            
            for(int i = 0; i < currentPosition - 1; i++){
                
                currentNode = currentNode.next;
            }
            
            return currentNode.previous.data;   // Return previos node data to user
        }
        else {
            return null;
        }
        
    }
    
    public T next(int currentPosition){
        
        // Check if the element that user provided is valid
        if(currentPosition <= length){
            
            Node currentNode = firstNode;
            
                for(int i = 0; i < currentPosition - 1; i++){
                
                currentNode = currentNode.next;
            }
            
            return currentNode.next.data;
        }
        else {
            return null;
        }
    }
    
    public boolean contains(T anEntry){
        
        boolean found = false;
        
        Node currentNode = firstNode;
        
        // Comparing anEntry which all element inside the list
        do{
            if(anEntry.equals(currentNode.data))
                return true;  // return true when found
            else
                currentNode = currentNode.next;
        }while(!found && (currentNode != firstNode));
        
        // return false when not found
        return found;
    
    }
    
    public boolean replace(int index, T element){
        
        // Check whether the element that user keyin is valid
        if((index <= length) && (index > 0)){
            
            Node currentNode = firstNode;
            
            // Use loop to get into element for particular index
            for(int i = 1; i < index; i++){

                currentNode = currentNode.next;
            }
            
            currentNode.data = element;
            
            return true;
        }else
            return false;
    }
    
    // Display all element inside list
    public String toString(){
        
        String outputStr = "";
        
        Node currentNode = firstNode;
        
        // Use loop to add all element inside list to outputStr
        for(int i = 0; i < length; i++){
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
    
        return outputStr;
    }
    
}
