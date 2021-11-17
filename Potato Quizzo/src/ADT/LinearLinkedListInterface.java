/**
	Name:		Goh Kok Dong
	StudID:		20WMR09455
	Group:		RSF2 G4
	Date:		10/8/2020
	Project:	LinearLinkedListInterface.java
*/

package ADT;

public interface LinearLinkedListInterface<T> {
        // Add object to list and become the last one
	public void add(T newObject);
        // Add new object after an object in the list
	public boolean addAfter(T thisObject, T newObject);
	// Remove object in the list based on position given
        public boolean remove(int position);
        // Remove first object in the list
        public boolean removeFirst();
        // Remove last object in the list
        public boolean removeLast();
        // Return the object without removing it based on position given
	public T search(int position);
        // Return the next object based on position given
        public T getNext(int position);
	
        // Replace the object with new object based on position given
	public boolean replace(int position, T newObject);
        // Swap the object in the list based on position given
	public boolean swap(int position1, int position2);
        
        // Return the length of the list
	public int getSize();
        // Remove all objects from the list
	public void clear();
        // To check whether the object exist in the list
	public boolean isExist(T object);
        // To check whether the list is empty
	public boolean isEmpty();
        // To check whether the list is full
	public boolean isFull(int max);
}