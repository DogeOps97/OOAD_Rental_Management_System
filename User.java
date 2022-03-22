/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.Comparator;
class User{
	// private variables
	int userID;
	String userName;
	String userPassword;
	String userRealName = "Unknown";
	String userContact;
	

	String accountType = "User"; // default account type for user
	private static int userCount = 0;


	// --- Constructor methods --------------------------
	// User(int userID, String userName, String userContact){
	// 	this.userID = userID;
	// 	this.userName = userName;
	// 	this.userContact = userContact;

	// 	// check user ID
	// 	checkUserIDCount(userID);
	// }

	// User(int userID, String userName, String userContact, String userPassword){
	// 	this.userID = userID;
	// 	this.userName = userName;
	// 	this.userContact = userContact;
	// 	this.userPassword = userPassword;

	// 	checkUserIDCount(userID);
	// }

	// Absolute bare minimum, but not recommended
	User(String userName, String userPassword){
		this.userName = userName;
		this.userPassword = userPassword;
		this.userID = getNewIDAssign();
	}

	User(String userName, String userPassword, String userContact){
		this.userID = getNewIDAssign();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userContact = userContact;
	}

	// Same thing, but no ID
	User(String userName, String userPassword, String userRealName, String userContact, String accountType){
		this.userID = getNewIDAssign();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRealName = userRealName;
		this.userContact = userContact;
		this.accountType = accountType;
	}

	User(int userID, String userName, String userPassword, String userRealName, String userContact, String accountType){
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRealName = userRealName;
		this.userContact = userContact;
		this.accountType = accountType;
		checkUserIDCount(userID);
	}

	// ----------------------------------------
	// setters
	// ----------------------------------------
	void setUserRealName(String userRealName){
		this.userRealName = userRealName;
	}

	void setUserContact(String userContact){
		this.userContact = userContact;
	}

	void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}
        
        void setUserRole(String userRole){
		this.accountType = userRole;
	}

	// --- public getters ------------------
	public int getUserID(){
		return userID;
	}

	public String getUserName(){
		return userName;
	}

	public String getUserPassword(){
		return userPassword;
	}

	public String getUserRealName(){
		return userRealName;
	}

	public String getUserContact(){
		return userContact;
	}

	public String getAccountType(){
		return accountType;
	}
        
        public String getUserRole(){
            return accountType;
        }

	// Public methods ---------------------


	// Private methods -------------------
	// 
	private static void checkUserIDCount(int count){
		if (count > userCount){
			userCount = count;
		}
	}

	private static int getNewIDAssign(){
		return ++userCount;
	}
	//ArrayList<
        
        public static Comparator<User> userIDComparator = new Comparator<User>(){
		public int compare(User r1, User r2){
			int compareRes1 = r1.getUserID();
			int compareRes2 = r2.getUserID();

			// ascending order
			return compareRes1- compareRes2;
		}
	};

	// Mostly for debug purposes
	public String toString(){
		return String.format("username - " + this.userName + ", pass - " + this.userPassword + ", id - " + this.userID
			+ ", contact - " + this.userContact + ", role - " + this.accountType);
	}
}