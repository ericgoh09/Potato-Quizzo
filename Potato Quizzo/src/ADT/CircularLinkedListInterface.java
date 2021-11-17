/*
	Name:		koh Xin Hao
	StudID:		20WMR09471
	Group:		RSF2 G4
	Project:	CicularLinkedListInterface.java
*/
package ADT;

import Entity.*;
import Client.*;
import Superclass.*;
import Interface.*;
import ADT.*;

public interface CircularLinkedListInterface<T> {
    
    // Add new element to list
    public boolean add(T newElemt);
    
    // Add to element to the specific location inside the list
    public boolean add(int index, T element);
    
    // Clear all element inside list
    public void clear();
    
    // Check if the list is empty
    public boolean isEmpty();
    
    // Remove specified element from list
    public boolean remove(int element);
    
    // Return the size for linked list
    public int size();
    
    // Get specified element from list
    public T get(int element);
    
    // Check if the list is full
    public boolean isFull();
    
    // Get the first element of the list
    public T head();
    
    // Get the last element of the list
    public T tail();
    
    // Get previous element inside the list base on location specified
    public T previous(int currentPosition);
    
    // Get next element inside the list base on location specified
    public T next(int currentPosition);
    
    // Check if an entry is inside the list
    public boolean contains(T anEntry);
    
    // Replace the existing data insdie a particular element with new data
    public boolean replace(int index, T element);
}
