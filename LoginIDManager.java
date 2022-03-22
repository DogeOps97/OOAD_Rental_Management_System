 
import java.util.ArrayList;
import java.util.Collections;

// ----------------------------------------------
// Handles the verification side of the login system
// ----------------------------------------------



// ------------------------------------------------------------------
// Using 2d arrays to handle login id list
//		- possibly use arraylist of loginID objects? 
//
// As of now, it will only iterate through the arraylist to the find the appropriate login ID
// Hash table for login would be faster, but maybe later (soon:tm:)


// However, we still need a way to handle the data stored in each role, each object somewhere (and possibly seperatedly)
// By returning only the role code, then you can only create new object/instance with those (already existing) users
// In the essence, it doesn't store users' data, only that they existed
// So if the loginIDManager is still a separate entity, then there need to be a way to store said data
// Hence, we could either
//		- create a new file containing ID of the user and data need to be stored
//			- how much file needed? New file for each role?
// 		- dump everything in a single file, containing both user role and their data (maybe don't do this)

// Maybe in the future, we could return only the userID, then we can try to look
// ------------------------------------------------------------------

// Also, uses Singleton DP <--- important maybe
class LoginIDManager{

	// ---------------------------------------
	// Private variables
	// ---------------------------------------

	private ArrayList<ArrayList<String>> loginIDList = new ArrayList<ArrayList<String>>();
	private ArrayList<User> userList = new ArrayList<User>();
	private static LoginIDManager single_instance = null;
	// ------- edit this to change loginID file location ----
	
	//private String loginID_FileName = "sampleLoginID.txt";
	private String loginID_FileName = "UserSampleFile.txt";
	

	// ------------------------------------------------------
	// Constructor/getInstance
	// ------------------------------------------------------
	// Creates a new loginID list, and then populate the list by reading from the loginID file
	private LoginIDManager(){

	}

	// -------------------------------
	//
	// getInstance()
	// Gets a current existing instance of LoginIDManager, 
	// if it doesn't exist, create a new instance
	//
	// ------------------------------

	public static LoginIDManager getInstance(){
		if (single_instance == null){
			single_instance = new LoginIDManager();
		}
		single_instance.refreshLoginID();
		return single_instance;
	}

	// ----------------------------------------
	// Public method
	// ----------------------------------------

	// =======================================================
	// Reading/saving to files (public)
	// Handles the in/out for LoginID part
	// =======================================================


	// --------------------------------------------------------
	// updateLoginID()
	// updates the loginID list by writing to file
	// Note : save to file and overwrites

	// note : this saves to file (also overwrites)
	// --------------------------------------------------------
	void updateLoginID(){
		// for now, this will save to separate file
		System.out.println("[LoginIDManager] updateLoginID -----------------");
		//String fileName = "out_chocolate.txt";
		String fileName = loginID_FileName;

		int count = 0;

		ArrayList<ArrayList<String>> outToFile = new ArrayList<ArrayList<String>>();
		ArrayList<String> titles_first_line = new ArrayList<String>();
		titles_first_line.add("#UserID, userName, userPassword, userRealName, userContact, userRole");
		outToFile.add(titles_first_line);
		for (User row : userList){
			int userID = row.getUserID();
			String userName = row.getUserName();
			String userPassword = row.getUserPassword();
			String userRealName = row.getUserRealName();
			String userContact = row.getUserContact();
			String userRole = row.getAccountType();

			ArrayList<String> singleData = new ArrayList<String>();

			singleData.add(Integer.toString(userID));
			singleData.add(userName);
			singleData.add(userPassword);
			singleData.add(userRealName);
			singleData.add(userContact);
			singleData.add(userRole);


			outToFile.add(singleData);
			count++;
		}

		FileReaderIO aTest = new FileReaderIO();
		aTest.writeDataToFile(outToFile, fileName);

		System.out.println("---------------------------------------------");
	}

	// --------------------------------------------------------
	// refreshLoginID()
	//
	// Updates the list of login ID by reading it from the login ID file
	// Before you do any operation from login, update from file first (DO THIS METHOD)
	// note : cleans the current list, and read
	// ---------------------------------------------------------
	void refreshLoginID(){
		ArrayList<ArrayList<String>> aList = new ArrayList<ArrayList<String>>();
		userList.clear();
		FileReaderIO read_csv = new FileReaderIO();

		// Reads from the file
		read_csv.readDataFromFile(aList, loginID_FileName);


		int count = 0;

		
		for (ArrayList<String> row : aList){
			if (row.size() < 6){
				continue;
			}

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

			// if (userID = ""){
			// 	continue;
			// }
			// if (userName = ""){
			// 	continue;
			// }

			// User ID can't be negative
			if (userID < 0){
				continue;
			}

			// Username and password can't be empty
			if (userName.matches("^\\s*$") || userPassword.matches("^\\s*$")){
				continue;
			}



			// Check for roles
			if (userRole.equalsIgnoreCase("admin")){
				userList.add((User) new Admin(userID, userName, userPassword, userRealName, userContact, userRole));

			}
			else if (userRole.equalsIgnoreCase("tenant")){
				userList.add((User) new Tenant(userID, userName, userPassword, userRealName, userContact, userRole));
			}

			else if (userRole.equalsIgnoreCase("property agent") || userRole.equalsIgnoreCase("propertyagent")){

				userList.add((User) new PropertyAgent(userID, userName, userPassword, userRealName, userContact, userRole));
			}

			else if (userRole.equalsIgnoreCase("property owner") || userRole.equalsIgnoreCase("propertyowner")){
				userList.add((User) new PropertyOwner(userID, userName, userPassword, userRealName, userContact, userRole));
			}

			else{
				// comment this out later
				// But at least I need to know that it goes in instead of quietly
				// denies
				System.out.println("It shouldn't go here");
				userList.add(new User(userID, userName, userPassword, userRealName, userContact, userRole));
			}
			
			count++;
			System.out.println("New user added, username - " + userName);

		}

		// Display number of ID retrieved from file
		//
		System.out.println("ID retrieved from file : " + count);

	}

	// ===================================================================
	//
	// Public methods
	//
	// ===================================================================


	// =====================================================
	// Accessor methods - only reads the list
	// =====================================================

	// debug purpose usually
	// -------------------------------------------
	// displayLoginID()
	//
	// Simply display the list of users in the console
	// -------------------------------------------
	public void displayLoginID(){
		// Simply display the whole thing in console
		//System.out.format("%-15s %-15s %8s %-30s\n", "username", "Password", "Role");
		for (ArrayList<String> row : loginIDList){
			for (String data : row){
				System.out.print(data + " ");
			}
			System.out.println();
		}
		System.out.println("Currently there's " + loginIDList.size() + " IDs in the list");
	}


	// --------------------------------------------
	// getUserList()
	//
	// Return the user list
	// --------------------------------------------
	ArrayList<User> getUserList(){
    	return userList;
    }


	// -------------------------------
	// verifyLogin(username, password)
	//
	// Given the username and password, search through the loginID list 
	// Returns the user object if found
	// else, return null
	// -------------------------------
	public User verifyLogin(String username, String password){
            //int statusReturn = 0;
		User currentlyLoggedInUser = null;

		for (User row_data : userList){
			if (row_data.getUserName().equals(username) && row_data.getUserPassword().equals(password)){
				currentlyLoggedInUser = row_data;
				break;
			}
		}
		//return statusReturn;
		return currentlyLoggedInUser;
    }

    // -------------------------------------------
    // getUser(userID)
    // get the user based on the user ID given
    // returns the user if found
    // else, return null
    // -------------------------------------------
    User getUser(int userID){
    	User userToBeFound = null;

    	for (User row_data : userList){
    		if (row_data.getUserID() == userID){
    			userToBeFound = row_data;
    		}

    	}

    	return userToBeFound;
    }

    // -------------------------------------------
    // findUser(userID)
    // get the user based on the user ID given
    // returns the user if found
    // else, return null
    // -------------------------------------------
    User findUser(int userID){
    	User userToBeFound = null;

    	for (User row_data : userList){
    		if (row_data.getUserID() == userID){
    			userToBeFound = row_data;
    		}

    	}

    	return userToBeFound;

    }

    // ===================================================================================
	// ===================================================================================


	// =====================================================
	// Mutator methods - change the list
	// ======================================================


    // somewhat depreceated, change to addUser for more standardized func naming
	// -------------------------------------------------------
	// addNewUser(userName, userPassword, ..., userRole)
	//
	// Add new users to the userlist
	// Return value 
	//		-  0 on success
	// 		- -1 on empty username/password
	// 		- -2 on invalid roles
	// if role is invalid, return
	// -------------------------------------------------------
	int addNewUser(String userName, String userPassword, String userRealName, String userContact, String userRole){
		System.out.println("[LoginIDManager] - addNewUser()");
		int statusReturn = 0;
		this.addUser(userName, userPassword, userRealName, userContact, userRole);

		System.out.println("-----------------------------------------");
		return statusReturn;
	}

	// somewhat depreceated, change to addUser()
	// --------------------------------------------------------
	// addNewUser(newUser)
	// Add new user to the list
	// 
	// Return value
	//		-  0 on success
	//		- -1 on empty username
	//		- -2 on empty password
	// 		- -3 on invalid role
	// --------------------------------------------------------

	int addNewUser(User newUser){

		System.out.println("[LoginIDManager] - addNewUser()");

		String userName = newUser.getUserName();
		String userPassword = newUser.getUserPassword();
		String userRole = newUser.getAccountType();
		String userRealName = newUser.getUserRealName();
		if (userName.equals("")){
			return -1;
		}

		else if (userPassword.equals("")){
			return -2;
		}

		else if (userRealName.equals("")){
			// do nothing for now, tolerate empty userRealName
		}

		if (userRole.equalsIgnoreCase("admin")){
			//userList.add((User) new Admin(userName, userPassword, userRealName, userContact, userRole));
			userList.add(newUser);
			updateLoginID();
		}
		else if (userRole.equalsIgnoreCase("tenant")){
			userList.add(newUser);
			updateLoginID();
			////userList.add((User) new Tenant(userName, userPassword, userRealName, userContact, userRole));
		}

		else if (userRole.equalsIgnoreCase("propertyagent") || userRole.equalsIgnoreCase("property agent")){
			userList.add(newUser);
			updateLoginID();
			//userList.add((User) new PropertyAgent(userName, userPassword, userRealName, userContact, userRole));
		}
		else if (userRole.equalsIgnoreCase("propertyowner") || userRole.equalsIgnoreCase("property owner")){
			userList.add(newUser);
			updateLoginID();
			//userList.add(new PropertyOwner(userName, userPassword, userRealName, userContact, userRole));
		}

		else{
			System.out.println("Error : Invalid role");
			return -3;
			//userList.add(new User(userName, userPassword, userRealName, userContact, userRole));
		}
		return 0;
	}

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

		System.out.println("[LoginIDManager] - addUser()");
		int statusReturn = 0;

		if (userName.matches("^\\s*$") || userPassword.matches("^\\s*$")){
			System.out.println("Error : User/Password cannot be empty");
			return -1;
		}

		if (userRole.equalsIgnoreCase("admin")){
			userList.add((User) new Admin(userName, userPassword, userRealName, userContact, userRole));
			updateLoginID();

		}
		else if (userRole.equalsIgnoreCase("tenant")){
			userList.add((User) new Tenant(userName, userPassword, userRealName, userContact, userRole));
			updateLoginID();
		}

		else if (userRole.equalsIgnoreCase("propertyagent") || userRole.equalsIgnoreCase("propertyagent")){
			userList.add((User) new PropertyAgent(userName, userPassword, userRealName, userContact, userRole));
			updateLoginID();
		}
		else if (userRole.equalsIgnoreCase("property owner") || userRole.equalsIgnoreCase("propertyowner")){
			userList.add(new PropertyOwner(userName, userPassword, userRealName, userContact, userRole));
			updateLoginID();
		}

		else{
			System.out.println("Error : Invalid role");
			return -2;
			//userList.add(new User(userName, userPassword, userRealName, userContact, userRole));
		}

		Collections.sort(userList, User.userIDComparator);

		return 0;
	}

	// ---------------------------------------------------
	// addUser(User newUser)
	// Add newly created user to the user list
	//
	// Return value 
	//		-  0 on success
	//		- -1 on null user
	//		- -2 on empty username/password
	// ---------------------------------------------------

	int addUser(User newUser){
		System.out.println("[LoginIDManager] - addUser()");

		if (newUser == null){
			System.out.println("Error : User object cannot be null");
			return -1;
		}
		// --- Simple checks ----------------------
		String userName = newUser.getUserName();
		String userPassword = newUser.getUserPassword();

		



		if (userName.matches("^\\s*$") || userPassword.matches("^\\s*$")){
			System.out.println("Error : Username/password can't be empty");
			return -2;
		}

		// end checks -----------------------------

		userList.add(newUser);
		Collections.sort(userList, User.userIDComparator);
		updateLoginID();
		return 0;


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

	int modifyUser(int userID, String userName, String userPassword, String userRealName, String userContact, String accountType){
		System.out.println("[LoginIDManager] - modifyUser()");
		User aUser = findUser(userID);

		if (aUser == null){
			System.out.println("Error : User not found");
			return -1;
		}

		// Checks whether realname and usercontact is empty ---
		if (userRealName.matches("^\\s*$")){
			aUser.setUserRealName(userRealName);
		}

		if (!userContact.matches("^\\s*$")){
			aUser.setUserContact(userContact);
		}

		// ------------------------------------------------ end 

		// ----------------------------------------------------
		// Check if the username or password is empty
		if (userName.matches("^\\s*$") || userPassword.matches("^\\s*$")){
			System.out.println("Error : Username and password can't be empty");
			return -2;
		}

		// ------------------------------------------------ end

		// ----------------------------------------
		// Checks for user role here
		// ----------------------------------------

		String userRole = accountType;
		User newUser = null;

		if (userRole.equalsIgnoreCase("admin")){
			newUser = ((User) new Admin(userID, userName, userPassword, userRealName, userContact, "Admin"));
			deleteUser(userID);
			addUser(newUser);

		}
		else if (userRole.equalsIgnoreCase("tenant") || userRole.equalsIgnoreCase("tenent")){
			newUser = ((User) new Tenant(userID, userName, userPassword, userRealName, userContact, "Tenant"));
			deleteUser(userID);
			addUser(newUser);
		}

		else if (userRole.equalsIgnoreCase("property agent") || userRole.equalsIgnoreCase("propertyagent")){
			newUser = ((User) new PropertyAgent(userID, userName, userPassword, userRealName, userContact, "propertyagent"));
			deleteUser(userID);
			addUser(newUser);
		}

		else if (userRole.equalsIgnoreCase("property owner") || userRole.equalsIgnoreCase("propertyowner")){
		  	newUser = ((User) new PropertyOwner(userID, userName, userPassword, userRealName, userContact, "propertyowner"));
		  	deleteUser(userID);
			addUser(newUser);
		}

		else{
			// comment this out later
			// But at least I need to know that it goes in instead of quietly
			// denies
			System.out.println("Error : Invalid role");
			return -3;
			//registrationList.add(new User(userID, userName, userPassword, userRealName, userContact, userRole));
		}

		return 0;

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
		System.out.println("[LoginIDManager] - deleteUser()");
		if (userID < 0){
			return -1;
		}

		int statusReturn = -1;
		for (int i = 0; i < userList.size(); i++){
			if (userList.get(i).getUserID() == userID){
				userList.remove(i);
				statusReturn = 0;
				updateLoginID();
				break;
			}
		}

		return statusReturn;
	}

	


    // ===================================================================
	//
	// private methods
	//
	// ===================================================================

	// ---------------------------------------------------
	// 
	// Checks whether if the user instance is equal to their
	// Sorts the list, and check the next/prev 
    int checkUserValidity(User user){
    	return 0;
    }
}

// =====================================================
// Trash code goes down here
// =====================================================
	// Me
	// -------------------------------
	//
	// verifyLogin(username, password)
	// Given the username and password, search through the loginID list 
	// If loginID is found, then
	//	- checks the role, and return code based on that
	//		- 1 for tenent
	// 		- 2 for admin
	// 		- 3 for	 property agent
	//		- 4 for property owner
	// else, if not found
	//	- returns -1

	// IMPORTANT : 	Any other return code that's not specified here is not valid, 
	//				and should be treated as such
	// Also, again, for now it doesn't return role code, just returns whether it's found or not (1 found, 0 otherwise)

	// Note :	Empty fields (either username or password) is valid
	//			i.e you can have admin with empty password, or even empty username
	// For now, 
	// 	- only if both username and password matches matter, else it'll return the same invalid login error
	// 	- searching is done directly in verify login method
	// 	- doesn't return role code, just returns whether it's found or not (1 found, 0 otherwise)
	// TODO:
	//	- Thinking of returning a class based on the role directly, but none of those has been written yet, 
	//		so I can't test just yet (and thus writing one effectively just yet)
	// ------------------------------
	// int verifyLogin(String username, String password){
	// 	int statusReturn = 0;

	// 	for (ArrayList<String> row : loginIDList){
			
	// 		if (row.get(0).equals(username)){
	// 			if (row.get(1).equals(password)){
	// 				statusReturn = 1;
	// 			}
	// 			break;
	// 		}
	// 	}
	// 	return statusReturn;
	// }

	// void displayLoginID(){
	// 	for (User row : userList){
	// 		System.out.println(row);
	// 	}
	// 	System.out.println("Currently there's " + userList.size() + " IDs in the list");
	// }

// ---------------------------------------------------
// refreshLoginID() description
// ----------------------------------------------------
		// Read only the necessary part (aka deleting the excess)
		// Here, it would only read the first three fields, 
		// 		- username
		//		- pass
		//		- role
		// Any more than that (in a single row) would be considered junk, and thrown away
		// If there's duplicates, then it would still be added, but only the first one matter for verification purpose
		// If the row has less than 3 fields, it'll get thrown out
		// TODO : 	- deal with duplicates somehow
		// 			- check if it's a valid role
		//				- if not, then (maybe hard though)
		//					- possible invalid role with no close match
		//					- find matching for mistyped roles
		// 				- OR
		//					- throw the row away

// 		// for (ArrayList<String> row : aList){
		// 	// only first three column matters, so we're only going to get that

		// 	// However, if it's less than 3, skip this line
		// 	if (row.size() < 3){
		// 		continue;
		// 	}

		// 	// Then, create a new row for this
		// 	ArrayList<String> newLoginID = new ArrayList<String>();

		// 	for (int i = 0; i < row.size(); i++){
		// 		if (i == 3){
		// 			// we already gotten the three column we need, 
		// 			// then we just throw the rest away
		// 			break;
		// 		}
		// 		else {
		// 			newLoginID.add(row.get(i));
		// 		}

		// 	}
		// 	loginIDList.add(newLoginID);
		// 	count++;
		// }/ }