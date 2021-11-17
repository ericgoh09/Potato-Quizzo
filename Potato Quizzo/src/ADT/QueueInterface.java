/**
 *
 * @author Gan Soon Chi
 * Tutorial Group: RSF2G4
 * Student ID: 20WMR09454
 */

package ADT;

import Entity.*;

public interface QueueInterface<T> {

  public void enque(T element); //Insert elements into the front of queue, otherwise return false.
  
  public T deque(); //Remove elements from front of queue,return null if queue is empty.
  
  public T getFront();//Return the fornt(first element)in the queue, otherwise return null.
  
  public void clear();//Remove all elements from the queue.
  
  public boolean isEmpty();//Determine the queue is empty.
  
  public int currentSize();//Return current size of queue.
  
  
}  // end QueueInterface

  

