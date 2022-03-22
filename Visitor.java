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

// -----------------------------------------
//
// Visitor, also defined as unregisted user, would only be able to 
// - Access the login method
// 		- there's a possbily a separate method 
// - View listing
// - Register for new account
//
// old note : 	Somehow, I can't really decide on whether to let visitor class as the
// 				somewhat UI class or a complete model class on its own
//
// 				Though, if we're going with the latter, then the flow of the program
//				is dictacted by the flow of the UI program, not the model (and respective objects) behind it
//				
// 				Maybe a good thing, I have no idea. Going both way to test it sounds awful, but doable at least
// -----------------------------------------

class Visitor{
	// private variable ------------------------
	// 
	// -----------------------------------------

	private int errno = 0;
	Visitor(){
		// do nothing in particular, don't override this kthank, 
		// unless you guys think we should add something to this
	}

	// Do nothing
	int login(){
		return 0;
	}

	// ----------------------------
	// Error checks 
	// ----------------------------
	public int getErrno(){
		return errno;
	}

	private void setErrno(int errno){
		this.errno = errno;
	}


	// ---------------------------------------------------------------------------------------
	// login(username,password)
	// Return the user object if found, 
	// Else return null
	//
	// Calls for verifyLogin() method from LoginIDManager
	// 
	// Sets the errno if error occurs or sets back to 0 if things are fine
	// 		-  0 on success
	//		- -1 on not found
	//		- -2 on user found, role improperly configured
	//		- -3 on user found, role not yet configured
	// 
	// However, if there's some abnormal errors, due to invalid value
	// inputted directly into the database. This is to check against that from happening
	// 6:48 am - 5/2/2021
	// ---------------------------------------------------------------------------------------
	User login(String username, String password){

		LoginIDManager getLogin = LoginIDManager.getInstance();

		// Given the string, sanitize as much as you can
		// For now, I'm only going to trim those

		String user_ID = username.trim();
		String user_pass = password.trim();

		User user = getLogin.verifyLogin(user_ID, user_pass);

		if (user == null){
			System.out.println("Invalid userID or password");
			setErrno(-1);
			return user;
		}

		
		// --------------------------------------------------------
		// Checks for role here
		// also make sure they have the right class ---------------

                // -----------------------------
                // Admin 
                // -----------------------------
		else if (user.getUserRole().equalsIgnoreCase("admin")){
			if (user instanceof Admin){
				// do nothing for now
				// At least it now knows it got the proper thing
				setErrno(0);
			} 

			else{
				System.out.println("Error : User found, role improperly configured");
				user = null;
				setErrno(-2);
			}
		}
                
                // -----------------------------
                // Property owner
                // -----------------------------
                else if (user.getUserRole().equalsIgnoreCase("property owner") || user.getUserRole().equalsIgnoreCase("propertyowner")){
                    if (user instanceof PropertyOwner){
                        setErrno(0);
                    }
                    
                    else {
                        System.out.println("Error : User found, role improperly configured");
                        user = null;
			setErrno(-2);
                    }
                }

                // -----------------------------
                // Property agent
                // -----------------------------
                else if (user.getUserRole().equalsIgnoreCase("property agent") || user.getUserRole().equalsIgnoreCase("propertyagent")){
                    if (user instanceof PropertyAgent){
                        setErrno(0);
                    }
                    
                    else {
                        System.out.println("Error : User found, role improperly configured");
                        user = null;
			setErrno(-2);
                    }
                }
                
		else {
			System.out.println("User found, role not yet configured");
			user = null;
			setErrno(-3);
		}

		// -------------------------------------------------------
		// End role checks here
		// -------------------------------------------------------
		return user;
		

	}

	// -------------------------------------------------------------
	// viewPropertyList()
	// Get the listing of property
	// 
	// Calls for getPropertyList() of Property Manager
	// 
	// No checks done here, empty list is empty is it comes to that
	// 6:48 am - 5/2/2021
	// -------------------------------------------------------------
	public ArrayList<Property> getPropertyList(){
		PropertyManager propertyMan = PropertyManager.getInstance();

		setErrno(0);
		return propertyMan.getPropertyList();
	}

	// -------------------------------------------------------------
	// getPropertyDetails(propertyID)
	//
	// Calls for findProperty(propertyID) of propertyManager
	//
	// Returns the object of the property if found, else return null
	// Errno value
	//		-  0 on success
	// 		- -1 on not found
	// -------------------------------------------------------------
	public void getPropertyDetails(int propertyID){
		PropertyManager propertyMan = PropertyManager.getInstance();


		Property property = null;
		property = propertyMan.findProperty(propertyID);

		if (property == null){
			setErrno(-1);
		}
		else{
			setErrno(0);
		}
	}


	// -------------------------------------------------------------
	// register(userRealName, userContact, userRole)
	// Registers the user to the the registrationMan
	//
	// Calls for addRegistration(username, userPassword, ....., accountType)
	// First two fields are left empty
	//
	// They can only put in their username, userContact, and accountType
	// 
	// Soon : License number if property agent selected
	// 7:12 am - 5/2/2021
	// --------------------------------------------------------------
	public void register(String userRealName, String userContact, String userRole){
		int statusReturn = 0;

		// This need to be empty -----------------------
		String userName = "";
		String userPassword = "";

		// Get the parameter and clean it a bit --------
		String user_realName = userRealName.trim();
     
		String user_contact = userContact.trim();
		String user_role = userRole.trim();
		// ---------------------------------------------

                if (user_realName.equals("") || user_contact.equals("")){
                    
                }
		// Calls for addRegistration() method -----------
		RegistrationManager registerMan = RegistrationManager.getInstance();

		statusReturn = registerMan.addRegistration(userName, userPassword, user_realName, user_contact, user_role);

		setErrno(statusReturn);
	}


}




// =============================================================
// Trash code goes down here
// =============================================================
	// somewhat on the UI side
	//int login(){

		// --------------- Display UI ---------------
		// Get username and password here ------------

		// // test_case 1
		// // Available 
		// String username = "Awoo";
		// String password = "1234";


		// call method for login

		// -------------UI end here-----------------
	//	return 0;
	//}
