/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.ArrayList;
import java.util.Collections;

// ----------------------------------------------
// Handles the loading, storing of the registration list
// Interacts with LoginIDManager to
// 		- add new users
//	
// ----------------------------------------------

// private String registation_FileName = "D:\\Works\\MMU\\Sem22020-21\\TCP2201\\Assignment_1\\data\\RegistrationSampleFile.txt";
// private String registration_saveTo = "D:\\Works\\MMU\\Sem22020-21\\TCP2201\\Assignment_1\\data\\RegistrationSampleFile.txt";

class RegistrationManager{
	// ==========================================================================
	// Private variable 
	// ==========================================================================

	// because why bother create a new registration class when it essentially
	// deals with the same thing - user
	private ArrayList<User> registrationList = new ArrayList<User>();

	private static RegistrationManager single_instance = null;


	// ----- edit this to change registration file location
	private String registation_FileName = "RegistrationSampleFile.txt";
	private String registration_saveTo = "RegistrationSampleFile.txt";

	// ----------------------------------
	// Constructor/getInstance
	// ----------------------------------

	private RegistrationManager(){

	}

	public static RegistrationManager getInstance(){
		if (single_instance == null){
			single_instance = new RegistrationManager();
		}
		single_instance.refreshRegistration();
		return single_instance;
	}

	// ===============================================
	// Reading/Saving to files (public)
	// Handles the in/out for Registration part
	// ===============================================

	// -----------------------------
	// refreshRegistration()
	// Updates the list of soon-to-be-verified uesrs by reading it from registration file
	// Cleans the current list and read from file
	//
	// -----------------------------

	public void refreshRegistration(){
		ArrayList<ArrayList<String>> aList = new ArrayList<ArrayList<String>>();
		registrationList.clear();


		FileReaderIO read_csv = new FileReaderIO();

		// Read from file
		read_csv.readDataFromFile(aList, registation_FileName);

		// Get count of data

		int count = 0;

		for (ArrayList<String> row : aList){
			// Make sure they at least have 6 fields, and fields can be empty
			if (row.size() < 6){
				continue;
			}

			// Enter the fields with what we have for now -----------------

			int userID = -1;
			String userName = row.get(1);
			String userPassword = row.get(2);
			String userRealName = row.get(3);
			String userContact = row.get(4);
			String userRole = row.get(5);

			try {
				userID = Integer.parseInt(row.get(0));
			} catch (NumberFormatException e){
				continue;
			}

			// ------------------------------------------------------------
			// Check for data integrity here ------------------------------

			// User ID can't be negative
			if (userID < 0){
				continue;
			}

			// Username and password can't be empty
			// if (userName.matches("^\\s*$") || userPassword.matches("^\\s*$")){
			// 	continue;
			// }

			// ------------------------------------------------------------
			// Check for roles --------------------------------------------
			if (userRole.equalsIgnoreCase("admin")){
				registrationList.add((User) new Admin(userID, userName, userPassword, userRealName, userContact, userRole));

			}
			else if (userRole.equalsIgnoreCase("tenant")){
				registrationList.add((User) new Tenant(userID, userName, userPassword, userRealName, userContact, userRole));
			}

			else if (userRole.equalsIgnoreCase("propertyagent")){
				registrationList.add((User) new PropertyAgent(userID, userName, userPassword, userRealName, userContact, userRole));
			}

			else if (userRole.equalsIgnoreCase("propertyowner")){
				registrationList.add((User) new PropertyOwner(userID, userName, userPassword, userRealName, userContact, userRole));
			}

			else{
				// comment this out later
				// But at least I need to know that it goes in instead of quietly
				// denies
				System.out.println("It shouldn't go here");
				registrationList.add(new User(userID, userName, userPassword, userRealName, userContact, userRole));
			}

			count++;
			System.out.println("New user added, username - " + userName);

		}
		Collections.sort(registrationList, User.userIDComparator);

		// Display number of user retrieved from file
		System.out.println("ID retrieved count - " + count);
	}

	// -----------------------------
	// updateRegistration()
	// Updates the list of soon-to-be-verified uesrs by reading it from registration file
	// Cleans the current list and read from file
	//
	// -----------------------------
	public void updateRegistration(){
		// for now, to seperate file ----------------------
		String fileName = registration_saveTo;
		// ----------------------------------------

		int count = 0;

		ArrayList<ArrayList<String>> outToFile = new ArrayList<>();

		// Add first line, also called column descriptor  ------------------------
		ArrayList<String> title_first_line = new ArrayList<>();
		title_first_line.add("#userID, userName, userPassword, userRealName, userContact, userRole");
		outToFile.add(title_first_line);
		// --------------------------------------------------------

		// Iterate through the userlist -------------------
		for (User row : registrationList){
			// Get the user attributes out ----------------
			int userID = row.getUserID();
			String userName = row.getUserName();
			String userPassword = row.getUserPassword();
			String userRealName = row.getUserRealName();
			String userContact = row.getUserContact();
			String userRole = row.getAccountType();

			// ---------------------------------------------=
			// Add them together as arraylist of string -----

			ArrayList<String> singleData = new ArrayList<>();

			singleData.add(Integer.toString(userID));
			singleData.add(userName);
			singleData.add(userPassword);
			singleData.add(userRealName);
			singleData.add(userContact);
			singleData.add(userRole);

			// ----------------------------------------------
			// add arraylist to the bunch of arraylist
			outToFile.add(singleData);
			count++;

		}

		FileReaderIO save_to_csv = new FileReaderIO();
		save_to_csv.writeDataToFile(outToFile, fileName);

	}

	// ==================================================
	//
	// Public methods for registration
	//
	// ==================================================

	// =====================================================
	// Accessor methods - only reads the list
	// =====================================================

	// -----------------------------------------------------
	// displayRegistration()
	// Display the registration list on the console
	// Likely for debug purposes
	// -----------------------------------------------------
	void displayRegistration(){
		for (User row : registrationList){
			System.out.println(row);
		}
		System.out.println("Currently there's " + registrationList.size() + " IDs in the list");
	}

	// ------------------------------------------------------
	// findUserRegistration(userID)
	// Returns the user object, given the userID passed into the func
	// If not found, return null
	// ------------------------------------------------------
	public User findUserRegistration(int userID){
		User userToBeFound = null;
		for (User row_data : registrationList){
			if (row_data.getUserID() == userID){
				userToBeFound = row_data;
				break;
			}
		}

		return userToBeFound;
	}

	// -----------------------------------------------------
	// getRegistrationList()
	// Returns the registraton list
	// -----------------------------------------------------
	ArrayList<User> getRegistrationList(){
		return registrationList;
	}



	// ===================================================================================
	// ===================================================================================




	// =====================================================
	// Mutator methods - change the list
	// ======================================================


	// --------------------------------------------------
	// addRegistration(User newUser)
	// Add newly created user to the registration list
	//
	// Return value 
	//		-  0 on success
	//		- -1 on null user
	//		- -2 on empty username/password
	// As to what can fail the registration, I haven't decided, 
	// maybe just few things like blank username/password
	// --------------------------------------------------

	public int addRegistration(User newUser){
		// Rudimentary/basic checks ---------------------

		String userName = newUser.getUserName();
		String userPassword = newUser.getUserPassword();

		if (userName.matches("^\\s*$") || userPassword.matches("^\\s*$")){
			System.out.println("Username and password can't be empty");
			return -1;
		}

		// Done simple checks ---------------

		// Add to list ----------------------
		registrationList.add(newUser);
		Collections.sort(registrationList, User.userIDComparator);
		updateRegistration();
		return 0;
	}
        
    // --------------------------------------------------
	// addRegistration(username, userpassword... accountType)
	// Create a new user and add it to the registration list
	//
	// return 
	// 		-  0 on success, 
	//		- -1 on empty realName
	//		- -2 on invalid role
	//
	// --------------------------------------------------    
    public int addRegistration(String userName, String userPassword, String userRealName, 
		String userContact, String accountType){
		// Rudimentary/basic checks ---------------------
		

		// if (userName.matches("^\\s*$") || userPassword.matches("^\\s*$")){
		// 	return -1;
		// }
		if (userRealName.matches("^\\s*$") || userContact.matches("^\\s*$")){
        	return -1;
        }

		String userRole = accountType;
		User newUser;
		// Done simple checks ---------------

		if (userRole.equalsIgnoreCase("admin")){
			newUser = ((User) new Admin(userName, userPassword, userRealName, userContact, "Admin"));

		}
		else if (userRole.equalsIgnoreCase("tenant") || userRole.equalsIgnoreCase("tenent")){
			newUser = ((User) new Tenant(userName, userPassword, userRealName, userContact, "Tenant"));
		}

		else if (userRole.equalsIgnoreCase("property agent") || userRole.equalsIgnoreCase("propertyagent")){
			newUser = ((User) new PropertyAgent(userName, userPassword, userRealName, userContact, "Property Agent"));
		}

		else if (userRole.equalsIgnoreCase("property owner") || userRole.equalsIgnoreCase("propertyowner")){
		  	newUser = ((User) new PropertyOwner(userName, userPassword, userRealName, userContact, "Property Owner"));
		}

		else{
			// comment this out later
			// But at least I need to know that it goes in instead of quietly
			// denies
			System.out.println("Error : Invalid role");
			return -2;
			//registrationList.add(new User(userID, userName, userPassword, userRealName, userContact, userRole));
		}
		// Add to list ----------------------
		//RegistrationManager userManager = RegistrationManager.getInstance();
		Collections.sort(registrationList, User.userIDComparator);
        registrationList.add(newUser);
		updateRegistration();

		return 0;
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

		for (int i = 0; i < registrationList.size(); i++){
			if (registrationList.get(i).getUserID() == userID){
				registrationList.remove(i);
				statusReturn = 0;
				break;
			}
		}
		updateRegistration();
		Collections.sort(registrationList, User.userIDComparator);
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
		int statusReturn = 0;
		LoginIDManager save_to_login = LoginIDManager.getInstance();

		User toBeApproved = findUserRegistration(userID);
		if (toBeApproved == null){
			return -1;
		}
		if (toBeApproved.getUserName().matches("^\\s*$") || toBeApproved.getUserPassword().matches("^\\s*$")){
			return -2;
		}

		// Add to the user list -------------
		save_to_login.addNewUser(toBeApproved);
		// And then delete from registration list
		deleteRegistration(userID);
		// ----------------------------------


		// Update --------------------------
		updateRegistration();
        save_to_login.updateLoginID();
        //----------------------------------
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

        User aRegistration = findUserRegistration(userID);
		// username change is ignored, maybe?
		if (userRealName.matches("^\\s*$")){
			aRegistration.setUserRealName(userRealName);
		}

		if (!userContact.matches("^\\s*$")){
			aRegistration.setUserContact(userContact);
		}

		if (aRegistration == null){
			return -1;
		}

		if (userName.matches("^\\s*$") || userPassword.matches("^\\s*$")){
			System.out.println("Username and password can't be empty");
			return -2;
		}




		// --------------------------------
		// Check user role here
		// ---------------------------------
		String userRole = accountType;
		User newUser = null;
		// Updating role is the hardest part
		// I need to create a new role to handle it
		// int userID = row.getUserID();
		// String userName = row.getUserName();
		// String userPassword = row.getUserPassword();
		// String userRealName = row.getUserRealName();
		// String userContact = row.getUserContact();
		// String userRole = row.getAccountType();

		if (userRole.equalsIgnoreCase("admin")){
			newUser = ((User) new Admin(userID, userName, userPassword, userRealName, userContact, "Admin"));
			deleteRegistration(userID);
			addRegistration(newUser);

		}
		else if (userRole.equalsIgnoreCase("tenant") || userRole.equalsIgnoreCase("tenent")){
			newUser = ((User) new Tenant(userID, userName, userPassword, userRealName, userContact, "Tenant"));
			deleteRegistration(userID);
			addRegistration(newUser);
		}

		else if (userRole.equalsIgnoreCase("property agent") || userRole.equalsIgnoreCase("propertyagent")){
			newUser = ((User) new PropertyAgent(userID, userName, userPassword, userRealName, userContact, "Property Agent"));
			deleteRegistration(userID);
			addRegistration(newUser);
		}

		else if (userRole.equalsIgnoreCase("property owner") || userRole.equalsIgnoreCase("propertyowner")){
		  	newUser = ((User) new PropertyOwner(userID, userName, userPassword, userRealName, userContact, "Property Owner"));
		  	deleteRegistration(userID);
			addRegistration(newUser);
		}

		else{
			// comment this out later
			// But at least I need to know that it goes in instead of quietly
			// denies
			System.out.println("Error : Invalid role");
			return -3;
			//registrationList.add(new User(userID, userName, userPassword, userRealName, userContact, userRole));
		}


		Collections.sort(registrationList, User.userIDComparator);
		updateRegistration();
		return 0;
	}
}

// ===============================================
// Trash code goes down here
// ================================================

// Me
// approveRegistration(userID)
// for (int i = 0; i < registrationList.size(); i++){
// 			if (registrationList.get(i).getUserID() == userID){
// 				save_to_login.addNewUser(registrationList.get(i));
// 				registrationList.remove(i);
// 				statusReturn = 0;
// 				break;
// 			}
// 		}


// //User getUser(int userID){
 //    	User userToBeFound = null;

 //    	for (User row_data : userList){
 //    		if (row_data.getUserID() == userID){
 //    			userToBeFound = row_data;
 //    		}

 //    	}

 //    	return userToBeFound;
 //    }

// ----------------------------------
// Check roles 
// ----------------------------------
// if (userRole.equalsIgnoreCase("admin")){
		// 	aRegistration.setUserRole("admin");

		// }
		// else if (userRole.equalsIgnoreCase("tenant")){
		// 	aRegistration.setUserRole("tenant");
		// }

		// else if (userRole.equalsIgnoreCase("property agent") || userRole.equalsIgnoreCase("propertyagent")){
		// 	aRegistration.setUserRole("propertyagent");
		// }

		// else if (userRole.equalsIgnoreCase("property owner") || userRole.equalsIgnoreCase("property owner")){
		// 	aRegistration.setUserRole("propertyowner");
		// }

		// else{
  //           System.out.println("[Admin - modifyRegistration()] Invalid role! Current role - " + userRole);
		// 	// Do nothing, let the old value be the default one
		// }
