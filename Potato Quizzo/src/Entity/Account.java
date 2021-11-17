/**
	Name:		Goh Kok Dong
	StudID:		20WMR09455
	Group:		RSF2 G4
	Date:		10/8/2020
	Project:	Account.java
*/

package Entity;

import Interface.AccountInterface;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.Serializable;

public class Account implements AccountInterface, Serializable {
	private String userID;
	private String password;
	private LocalDate registrationDate;
	
	public Account() {
		this.userID = "";
		this.password = "";
		this.registrationDate = LocalDate.now();
	}
	
	public Account(String userID, String password) {
		this.userID = userID;
		this.password = password;
		this.registrationDate = LocalDate.now();
	}
	
	// Getter
	public String getUserID() {
		return userID;
	}
	
	public String getPassword() {
		return password;
	}
	
        public String getRegisDate() {
                return String.format("%-10s", registrationDate);
        }
        
	// Setter
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	// Utilities
	public boolean validateUserID(String userIDInput) {
		if (this.userID.equals(userIDInput))
			return true;
		else
			return false;
	}
	
	public boolean validatePassword(String passwordInput) {
		if (this.password.equals(passwordInput))
			return true;
		else
			return false;
	}
	
	public int calculateAccountAge() {
		LocalDate currentDate = LocalDate.now();
		
		long accAge = ChronoUnit.DAYS.between(registrationDate, currentDate);
		return (int)accAge;		
	}
	
	public String toString() {
		return String.format("%-20s %-16s %-14d", userID, password, calculateAccountAge());
	}
}