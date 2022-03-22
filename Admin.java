/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

  
import java.lang.String.*;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.Collections;
class Admin extends User{
	Admin(int userID, String userName, String userPassword, String userRealName, String userContact, String accountType){
		super(userID, userName, userPassword, userRealName, userContact, accountType);
	}

	Admin(String userName, String userPassword, String userRealName, String userContact, String accountType){
		super(userName, userPassword, userRealName, userContact, accountType);

	}
	// -----------------------------------------------
	// Admin can handle 3 things
	// - Registration
	// - User list
	// - Properties
	// ------------------------------------------- 


	// ==============================================
	//
	// Registration methods
	// 
	// ==============================================

	// --------------------------------------------------------
	// Accessors
	// --------------------------------------------------------

	// ------------------------------------------------------
	// findUserRegistration(userID)
	// Returns the user object, given the userID passed into the func
	// If not found, return null
	// ------------------------------------------------------
	public User findUserRegistration(int userID){
		RegistrationManager userManager = RegistrationManager.getInstance();
		User userToBeFound = null;

		userToBeFound = userManager.findUserRegistration(userID);
		return userToBeFound;
	}

	// -----------------------------------------------------
	// getRegistrationList()
	// Returns the registraton list
	// -----------------------------------------------------
	ArrayList<User> getRegistrationList(){
		RegistrationManager userManager = RegistrationManager.getInstance();
		return userManager.getRegistrationList();
	}



	// --------------------------------------------------------
	// Mutators
	// --------------------------------------------------------


	// --------------------------------------------------
	// addRegistration(username, userPassword, ..., accountType)
	// Add newly created user to the registration list
	//
	// Return value 
	//		-  0 on success
	//		- -1 on empty realName
	//		- -2 on invalid role
	// As to what can fail the registration, I haven't decided, 
	// maybe just few things like blank username/password
	// --------------------------------------------------

	public int addRegistration(String userName, String userPassword, String userRealName, 
		String userContact, String accountType){
		// Rudimentary/basic checks ---------------------
		

		if (userName.matches("^\\s*$") || userPassword.matches("^\\s*$")){
			return -1;
		}

		userName = userName.trim();
		userPassword = userPassword.trim();
		userRealName = userRealName.trim();
		userContact = userContact.trim();
		accountType = accountType.trim();
		// Add to list ----------------------
		RegistrationManager userManager = RegistrationManager.getInstance();
		int returnCode = userManager.addRegistration(userName, userPassword, userRealName, userContact, accountType);

		return returnCode;
	}



	// -------------------------------------------------
	// deleteRegistration(userID)
	// Delete registration from the list, specified by userID
	// If succesfully deleted, return 0
	//
	// If the registration does not exist, 
	// return -1, but shouldn't do much beyond warning message
	// -------------------------------------------------
	public int deleteRegistration(int userID){
		int statusReturn = -1;
		RegistrationManager userManager = RegistrationManager.getInstance();


		statusReturn = userManager.deleteRegistration(userID);

		return statusReturn;
	}


	// ---------------------------------------------------
	// approveRegistration(userID)
	// Verify a user registration from the list, specified by userID
	// User needs to have username and password, otherwise it'll fail
	//
	// Interacts with LoginIDManager to have user added there (on userList)
	// Return value 
	// 		- if successfully verified, returns 0
	// 		- if registration does not exist, return -1
	// 		- if username or password is empty, return -2
	// ---------------------------------------------------
	public int approveRegistration(int userID){
		int statusReturn = -1;
		RegistrationManager userManager = RegistrationManager.getInstance();



		statusReturn = userManager.approveRegistration(userID);



		return statusReturn;
	}


	// -----------------------------------------------------------
    // modifyRegistration(userID, username, userpassword..... userrole)
    // Modify the registration details of users (except userID)
    //
    // If realName and contact field are left empty, then it will reuse the old value
    // (even if the old value is empty)
    // 
    // Checks whether username/userpassword is blank, if so, return -2
    //
    // Finally, recreate the user class based on their userRole, and sorts the list
    // 
    // Return values
    //		-  0 on success
    //		- -1 on registration not found
    //		- -2 on empty username/password
    //		- -3 on invalid role (will not default to any values)
    //		
    // -----------------------------------------------------------
	public int modifyRegistration(int userID, String userName, String userPassword, String userRealName, String userContact, String accountType){

		RegistrationManager userManager = RegistrationManager.getInstance();
                
        userName = userName.trim();
		userPassword = userPassword.trim();
		userRealName = userRealName.trim();
		userContact = userContact.trim();
		accountType = accountType.trim();

            return userManager.modifyRegistration(userID, userName, userPassword, userRealName, userContact, accountType);


	}



	

	// end of registration =======================================

	// =============================================================
	//
	// loginIDs methods
	//
	// =============================================================


	// --------------------------------------------------------
	// Accessors
	// --------------------------------------------------------

	ArrayList<User> getUserList(){
		LoginIDManager loginMan = LoginIDManager.getInstance();
		return loginMan.getUserList();
	}

	// -------------------------------------------
    // findUser(userID)
    // get the user based on the user ID given
    // returns the user if found
    // else, return null
    // -------------------------------------------
    User findUser(int userID){
    	LoginIDManager loginMan = LoginIDManager.getInstance();
    	User userToBeFound = null;

    	return loginMan.findUser(userID);
    }

    // ---------------------------------------------------------


	// --------------------------------------------------------
	// Mutators
	// --------------------------------------------------------


    // ------------------------------------------------------------
	// addUser(userID, userName, ...., userRole)
	// Add a new user to the list
	// Allows for specifying IDs, however does not check for ID duplicates
	// (Generally, used for registration, in which user should've already have unique IDs
	//		OR
	//	 reading from files)
	//
	// Return value
	//		-  0 on success
	//		- -1 on empty username/password
	//		- -2 on invalid roles
	// -------------------------------------------------------------
    int addUser(String userName, String userPassword, String userRealName, String userContact, String userRole){
    	LoginIDManager loginMan = LoginIDManager.getInstance();

    	userName = userName.trim();
		userPassword = userPassword.trim();
		userRealName = userRealName.trim();
		userContact = userContact.trim();
		userRole = userRole.trim();

		return loginMan.addUser(userName, userPassword, userRealName, userContact, userRole);
    }





    // -------------------------------------------------------------
	// modifyUser(userID, userName, ... userRole)
	// Modify the details of user (except userID)
	//
	// Check if the userID is in the list, if not, return error (-1)
	// If realName and contact field are left empty, it would use the old value
	// (even if the value is empty)
	//
	// Checks whether userName/userPassword is blank, if so, return -2
	//
	// Finally, recreates the user class based on their userRole (they have same ID), and sorts
	// the list based on ID
	//
	// Return values
	//		-  0 on success
	//		- -1 on user not found
	//		- -2 on empty username/password
	// 		- -3 on invalid role
	// -------------------------------------------------------------
    // int modifyUser(int userID, String userName, String userPassword, String userRealName, String userContact, String accountType)
    public int modifyUser(String userID_field, String userName, String userPassword, String userRealName, String userContact, String accountType){
    	int userID;
    	LoginIDManager loginMan = LoginIDManager.getInstance();
    	// -------------------------------------
    	// Check if the userID is valid
    	try{
    		userID = Integer.parseInt(userID_field);
    	} catch (NumberFormatException e){
    		userID = -1;
    	}
    	// -------------------------------------

    	return loginMan.modifyUser(userID, userName, userPassword, userRealName, userContact, accountType);
    }

    // -----------------------------------------
	// deleteUser(userID)
	// Delete the user in the list that has the specified ID
	//
	// Return value
	//		-  0 on success
	//		- -1 on invalid ID (user not found)
	// -----------------------------------------
	int deleteUser(int userID){
		LoginIDManager loginMan = LoginIDManager.getInstance();
		return loginMan.deleteUser(userID);
	}


	// === loginID ends here =======================================

	// =============================================================
	//
	// Property methods
	//
	// =============================================================



	// --------------------------------------------------------
	// Accessors
	// --------------------------------------------------------

	public ArrayList<Property> getPropertyList(){
		PropertyManager propertyMan = PropertyManager.getInstance();
		propertyMan.refreshProperty();

		return propertyMan.getPropertyList();
	}

	private Property findProperty(int propertyID){
		PropertyManager propertyMan = PropertyManager.getInstance();
		return propertyMan.findProperty(propertyID);
	}


	// == comment method ends here =================================
	// --------------------
	// private
	// --------------------
	private String escapeSpecialCharacters(String data) {
    	String escapedData = data.replaceAll("\\R", " ");
    	if (data.contains(",") || data.contains("\"") || data.contains("'")) {
        	data = data.replace("\"", "");
        	data = data.replace(",", " ");
        	//data = data.replace("")
        	//escapedData = "\"" + data + "\"";

    	}
    	return escapedData;
	}
}