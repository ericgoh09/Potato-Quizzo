/**
	Name:		Goh Kok Dong
	StudID:		20WMR09455
	Group:		RSF2 G4
	Date:		10/8/2020
	Project:	Name.java
*/

package Entity;

import java.io.Serializable;

public class Name implements Serializable {
	private String firstName;
	private String lastName;
        
	public Name() {
		firstName = "";
		lastName = "";
	}
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
        public String getName() {
            return firstName + " " + lastName;
        }
        
	// Setter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}
        
        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

	public String toString() {
		return String.format("%-15s", getName());
	}
}
