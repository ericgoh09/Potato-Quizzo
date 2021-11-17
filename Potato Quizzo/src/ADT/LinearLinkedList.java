/**
	Name:		Goh Kok Dong
	StudID:		20WMR09455
	Group:		RSF2 G4
	Date:		10/8/2020
	Project:	LinearLinkedList.java
*/

package ADT;

import java.io.Serializable;

public class LinearLinkedList<T> implements LinearLinkedListInterface<T>, Serializable {
	private Node firstNode;
	private int totalNodes;
        
        // To arrange the data, work as linear linked list
	private class Node {
		private T object;
		private Node next;
		
		private Node() {
			this.object = null;
			this.next = null;
		}
		
		private Node(T object) {
			this.object = object;
			this.next = null;
		}
		
		private Node(T object, Node next) {
			this.object = object;
			this.next = next;
		}
		
	}
        
        // Constructor
	public LinearLinkedList() {
		firstNode = null;
		totalNodes = 0;
	}
	
        // Add object to list and become the last one
	public void add(T newObject) {
            Node newNode = new Node(newObject);
            Node currentNode;
                
            if (isEmpty())
                firstNode = newNode;
            else {
		currentNode = firstNode;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;              
		}
		currentNode.next = newNode;
            }
		
            totalNodes++;
	}
	
        // Add new object after an object in the list
	public boolean addAfter(T thisObject, T newObject) {
		
            if (thisObject != null) {
		int count = 0;
                int objectPosition;
		
                Node thisNode = new Node(thisObject);
		Node newNode = new Node(newObject);
		Node currentNode = firstNode;
                
                while (currentNode != thisNode) {
                    currentNode = currentNode.next;
		}
						
		if (thisNode.next == null) {
                    currentNode.next = newNode;
		}
		else {
                    while (currentNode.next != null) {
                    currentNode = currentNode.next;
                    count++;
                    }
                
                    objectPosition = getSize() - count + 1;
                                
                    add(newObject);
                                
                    for (int i = 1; i <= count; i++) {
                        swap(objectPosition, objectPosition + i);
                    }
                    
		}
		totalNodes++;
                return true;
            }
            else
                return false;
	}
	
        // Remove object in the list based on position given
	public boolean remove(int position) {
                if (isEmpty())
                    return false;
                else if (position == 1) 
                    firstNode = firstNode.next;
                else if (position > 0 && position <= getSize()) {
                    Node currentNode = firstNode;

                    for (int i = 1; i < position - 1; i++) {
                        currentNode = currentNode.next;
                    }

                    currentNode.next = currentNode.next.next;
                }
                else
                    return false;

                totalNodes--;

                return true;
        }
        
        // Remove first object in the list
        public boolean removeFirst() {
                if (!isEmpty()) {
                    firstNode = firstNode.next;
                    
                    totalNodes--;
                    return true;
                }
                
                return false;
        }
        
        // Remove last object in the list
        public boolean removeLast() {
                if (!isEmpty()) {
                    Node currentNode = firstNode;
                    
                    while (currentNode.next != null) {
                        currentNode = currentNode.next;
                    }
                    currentNode = null;
                    
                    totalNodes--;
                    return true;
                }
                else
                    return false;
        }
        
        // Return the object without removing it based on position given
        public T search(int position) {
		T object = null;
		
		if (position > 0 && position <= getSize()) {
			Node currentNode = firstNode;
			
			for (int i = 1; i < position; i++) 
                            currentNode = currentNode.next;
			
			object = currentNode.object;
		}
		
		return object;
	}
	
        // Return the next object based on position given
        public T getNext(int position) {
                T object = null;
                
                if (position > 0 && position <= getSize()) {
                    Node currentNode = firstNode;
                    
                    for (int i = 1; i < position; i++) {
                        currentNode = currentNode.next;
                    }
                    
                    object = currentNode.next.object;
                }
                
                return object;
        }
        
        // Replace the object with new object based on position given
	public boolean replace(int position, T newObject) {
		
		if (position > 0 && position <= getSize()) {
			Node currentNode = firstNode;
				
			for (int i = 1; i < position; i++) {
				currentNode = currentNode.next;
			}
			
			currentNode.object = newObject;
		}
		else 
			return false;
		
		return true;
	}
	
        // Swap the object in the list based on position given
	public boolean swap(int position1, int position2) {
		
		if ((position1 > 0 && position1 <= getSize()) && (position2 > 0 && position2 <= getSize())) {
			Node swapFirstNode = firstNode;	
			Node swapSecondNode = firstNode;
			Node tempNode = new Node();
			
			for (int i = 1; i < position1; i++) 
				swapFirstNode = swapFirstNode.next;
			
			for (int i = 1; i < position2; i++) 
				swapSecondNode = swapSecondNode.next;
			
			if (swapFirstNode != null && swapSecondNode != null) {
				tempNode = swapFirstNode;
				swapFirstNode = swapSecondNode;
				swapSecondNode = swapFirstNode;
			}
			else
				return false;
		}
		
		return true;
	}
	
        // Return the length of the list
	public int getSize() {
		return totalNodes;
	}
        
        // Remove all objects from the list
        public void clear() {
		firstNode = null;
		totalNodes = 0;
	}
	
        // To check whether the object exist in the list
	public boolean isExist(T object) {
		Node currentNode = firstNode;
		
		while (currentNode != null) {
			if (currentNode.object.equals(object))
				return true;
			else
				currentNode = currentNode.next;
		}
		
		return false;
	}
	
        // To check whether the list is empty
	public boolean isEmpty() {
		if (firstNode == null && totalNodes == 0)
			return true;
		else
			return false;
	}
	
        // To check whether the list is full
	public boolean isFull(int max) {
		if (totalNodes <= max)
			return true;
		else
			return false;
	}
}