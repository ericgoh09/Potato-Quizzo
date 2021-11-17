/**
 * @author Gan Soon Chi
 * Tutorial Group: RSF2G4
 * Student ID: 20WMR09454
 */

package ADT;

public class LinkedQueue<T> implements QueueInterface<T>{
   private Node front=null;
   private Node rear=null;
   private int size = 0;
   
   
   private class Node{
       private T data;
       private Node next;
       
       private Node(T data){
           this.data=data;
           next=null;
       }
       
       private Node(T data, Node next) {
           this.data = data;
           this.next = next;
    } 
   }
   
  @Override
  public void enque(T data){                //Insert progress into the front of queue
      Node newData=new Node(data,null);
      
      if (isEmpty()) {
          front=newData;
      }
      else{
          rear.next=newData;
      }
      rear=newData;
      
  }
  
  @Override
  public T deque(){                         //Remove progress from front of queue,return null if queue is empty.
      T firstNode = null;

    if (!isEmpty()) {
      firstNode = front.data;
      front = front.next;
      if (front == null) {
        rear = null;
      }
    } 
    
    return firstNode;
  }
  
  @Override
  public T getFront(){
      T firstNode = null;

    if (!isEmpty()) {
      firstNode = front.data;
    }

    return firstNode;
  }
  
  @Override
  public void clear(){
      front=null;
      rear=null;
  }
  
  @Override
  public boolean isEmpty(){                     //Determine the queue is empty.
      return (front==null)&&(rear==null);
  }
  
  @Override
  public int currentSize(){                     //Return current size of queue.
      return size;
  }
  
  @Override
  public String toString(){
      String outputStr = "";
        
        Node currentNode = front;
        
        for(int i = 0; i < size; i++){
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
    
        return outputStr;
    }
  
}

