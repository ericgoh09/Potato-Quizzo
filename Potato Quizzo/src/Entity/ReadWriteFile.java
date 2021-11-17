/**
	Name:		Goh Kok Dong, Koh Xin Hao
	StudID:		20WMR09455, 20WMR09471
	Group:		RSF2 G4
	Date:		10/8/2020
	Project:	ReadWriteFile.java
*/

package Entity;

import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.ObjectStreamClass; 
import java.io.IOException;
import java.io.EOFException;
import java.io.File;

public class ReadWriteFile {
    
    public ReadWriteFile(){
    }
    
    // Write object into file
    public void write(Object[] obj, String fileName){
        
        boolean write = false;
        
        // Serialization
        try{
            // Saving object into a file
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            
            for(int i = 0; i < obj.length; i++){
                if (obj[i] != null) {
                        objOut.writeObject(obj[i]);
                        write = true;
                }
            }
            
            fileOut.close();
            objOut.close();
            
            if (write)
                System.out.println("The Object was succesfully written to the file");
        }
        catch(IOException ex){
            System.out.println("IOException is caught"); 
            ex.printStackTrace();
        }
    }
    
    // Read content from file to object
    public int read(Object[] obj, String fileName){
        
        int counter = 0;
        
        try {
            File file = new File(fileName);
            
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
            
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            
            for(int i = 0; i < obj.length; i++) {
                Object o = objIn.readObject();
            
                // Check the object is instance of which class
                if(o instanceof Member){
                    obj[i] = (Member)o;
                    counter++;
                }
                else if (o instanceof Manager){
                    obj[i] = (Manager)o;
                    counter++;
                }
		else if(o instanceof Question){
                    obj[i] = (Question)o;
                    counter++;
                }
		else if(o instanceof Progress){
                    obj[i] = (Progress)o;
                    counter++;
                }
		
            }
            
            fileIn.close();
            objIn.close();
            
            if (counter > 0)
                System.out.println("The Object was succesfully read from the file");
        }
        catch(EOFException ex1) {
        }
        catch(IOException ex){
            System.out.println("IOException is caught"); 
            //ex.printStackTrace();
        } 
        catch (ClassNotFoundException exClass) {
            System.out.println("Class not found");
            //exClass.printStackTrace();
        }
        
        return counter;
    }

    
}
