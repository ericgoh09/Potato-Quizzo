/**
	Name:		Goh Kok Dong
	StudID:		20WMR09455
	Group:		RSF2 G4
	Date:		10/8/2020
	Project:	Person.java
*/

package Superclass;

import Entity.Name;
import java.io.Serializable;

public class Person implements Serializable {
	private Name name;
	private char gender;
	
	public Person() {
	}
	
	public Person(String firstName, String lastName, char gender) {
		name = new Name(firstName, lastName);
		this.gender = gender;
	}
	
	// Getter
	public String getName() {
		return name.toString();
	}

	public char getGender() {
		return gender;
	}
	
	// Setter
	public void rename(String firstName, String lastName) {
		name.setFirstName(firstName);
		name.setLastName(lastName);
	}
	
	
	
	public String toString() {
		return name.toString() + " " + String.format("%-9c", gender);
	}
}