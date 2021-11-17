/**
	Name:		Goh Kok Dong
	StudID:		20WMR09455
	Group:		RSF2 G4
	Date:		10/8/2020
	Project:	Member.java
*/

package Entity;

import Superclass.Person;
import java.io.Serializable;

public class Member extends Person implements Serializable{
	private Account account;
	//private Progress progress;
	
	public Member(String firstName, String lastName, char gender, String userID, String password) {
		super(firstName, lastName, gender);
		account = new Account(userID, password);
                //progress();
	}
	
	// Getter
        public String getAccountUserID() {
                return account.getUserID();
        }
        
        public String getAccountPassword() {
                return account.getPassword();
        }
        
	public String getAccountInfo() {
		return account.toString();
	}
        
        public String getAccountRegisDate() {
                return account.getRegisDate();
        }
        
	// Setter
        public void setAccountUsername(String userID) {
                account.setUserID(userID);
        }
        
        public void setAccountPassword(String password) {
                account.setPassword(password);
        }
        
	public void setAccount(String userID, String password) {
		account.setUserID(userID);
		account.setPassword(password);
	}
        
        // Utilities
        public boolean validateUserID(String userIDInput) {
		return account.validateUserID(userIDInput);
	}
	
	public boolean validatePassword(String passwordInput) {
		return account.validatePassword(passwordInput);
	}
	
	public int calculateAccountAge() {
		return account.calculateAccountAge();
	}
	
	public String toString() {
    		return super.toString() + account;
   	}
}