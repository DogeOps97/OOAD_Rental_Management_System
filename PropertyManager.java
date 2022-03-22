 

import java.util.*;

// Singleton DP
class PropertyManager {
	private ArrayList<Property> propertyList = new ArrayList<>();
	private static PropertyManager single_instance = null;

	// File path
	private String propertyFileName = "PropertyFile.txt";

	// Constructor
	private PropertyManager() {
	}

	public static PropertyManager getInstance() {
		if (single_instance == null) {
			single_instance = new PropertyManager();
		}

		single_instance.refreshProperty();
		return single_instance;
	}

	// Search Property Function
	public ArrayList<Property> searchProperty(int propertyID, String propertyType, double minPrice, double maxPrice,
			int uploader_userID, ArrayList<String> facilities, int currentStatus, String projectName,
			int priceSortingMethod, String address) {

		ArrayList<Property> temp = new ArrayList<>();
                ArrayList<Property> tempPropertyList = new ArrayList<>();
		tempPropertyList = (ArrayList) propertyList.clone();
		Collections.reverse(tempPropertyList);
		// We will make the parameter = -1 if the user didn't insert for the parameter,
		// if it is -1, then don't compare it
		// If the user insert the parameter, then we will compare the parameter
		for (int i = 0; i < tempPropertyList.size(); i++) {
			boolean equal = true;
			if (propertyID != -1) {
				if (tempPropertyList.get(i).getPropertyID() != propertyID) {
					equal = false;
				}
			}
			if (!(propertyType.equals("-1")) && equal) {
				if (!tempPropertyList.get(i).getPropertyType().equals(propertyType))
					equal = false;
			}
			if (minPrice != -1 && equal) {
				if ((tempPropertyList.get(i).getPropertyPrice() - minPrice) < 0)
					equal = false;
			}
			if (maxPrice != -1 && equal) {
				if ((tempPropertyList.get(i).getPropertyPrice() - maxPrice) > 0)
					equal = false;
			}
			if (uploader_userID != -1 && equal) {
				if (tempPropertyList.get(i).getUploader_userID() != uploader_userID)
					equal = false;
			}
			if (facilities != null && equal) {
				for (int j = 0; j < facilities.size(); j++) {
					if (!(tempPropertyList.get(i).getFacilities().contains(facilities.get(j)))) {
						equal = false;
					}
				}
			}
			if (currentStatus != -1 && equal) {
				if (tempPropertyList.get(i).getCurrentStatus() != currentStatus)
					equal = false;
			}
			if (!(projectName.equals("-1")) && equal) {
				if (!(tempPropertyList.get(i).getProjectName().equals(projectName))) {
					equal = false;
				}
			}
			// check address
			if (!(address.equals("-1")) && equal) {
				ArrayList<String> addressList = tempPropertyList.get(i).getAddress();
				StringBuilder sb = new StringBuilder();
				for (String addressPart : addressList) {
					sb.append(addressPart);
				}
				String addressString = sb.toString() + " ";
				for (int j = 0; j < address.length(); j++) {
					if (!(addressString.contains(String.valueOf(address.charAt(j))))) {
						equal = false;
						break;
					}
				}
			}
			if (equal) {
				System.out.println(i + 1 + " Property Found");
				temp.add(tempPropertyList.get(i));
			}
		}
		// cheap to expensive
		if (priceSortingMethod == 0) {
			Collections.sort(temp, new PropertyPriceComparator());
		}
		// expensive to cheap
		else {
			Collections.sort(temp, new PropertyPriceComparatorDescending());
		}
		return temp;
	}

	// Read File to ArrayList
	public void refreshProperty() {
		System.out.println("[PropertyManager] - refreshProperty()");
		ArrayList<ArrayList<String>> aList = new ArrayList<ArrayList<String>>();
		propertyList.clear();

		FileReaderIO read_csv = new FileReaderIO();

		// Read from file
		read_csv.readDataFromFile(aList, propertyFileName);

		for (ArrayList<String> row : aList) {
			// Enter the fields with what we have
			// ----------------------------------------------
			// For int or double, we get it later
			int propertyID; // row 0
			String propertyType = row.get(1);
			double propertyPrice; // row 2
			double propertySize; // row 3
			String ownerName = row.get(4);
			int uploader_userID; // row 5
			String grantID = row.get(6);
			String projectName = row.get(7);
			int currentStatus; // row 8
			int numBathroom; // row 9
			int numRoom; // row 10
			// Address 1, address 2, post code, state
			String addressString = row.get(11); // get address as string from file
			String facilitiesString = row.get(12); // get faclities as string from file
			// convert address String into address arrayList
			ArrayList<String> address = new ArrayList<>();
			String temp = "";
			for (int i = 0; i < addressString.length(); i++) {
				if (addressString.charAt(i) == '|') {
					address.add(temp);
					temp = "";
				} else
					temp += addressString.charAt(i);
			}
			// convert facilities String into facilities arrayList
			ArrayList<String> facilities = new ArrayList<>();
			for (int i = 0; i < facilitiesString.length(); i++) {

				if (facilitiesString.charAt(i) == '|') {
					facilities.add(temp);
					temp = "";
				} else
					temp += facilitiesString.charAt(i);
			}
			// read for int and double variable from file
			try {
				propertyID = Integer.parseInt(row.get(0));
				propertyPrice = Double.parseDouble(row.get(2));
				propertySize = Double.parseDouble(row.get(3));
				uploader_userID = Integer.parseInt(row.get(5));
				currentStatus = Integer.parseInt(row.get(8));
				numBathroom = Integer.parseInt(row.get(9));
				numRoom = Integer.parseInt(row.get(10));
			} catch (NumberFormatException e) {
				continue;
			}

			// Check for data integrity ----------------------------
			// -----------------------------------------------------
			// We can delete this part when we complete our program

			if (propertyID < 0) {
				continue;
			}
                        
                        System.out.println(numBathroom);

			// This is a bad operation to compare between two doubles,
			// but at the very least we're not trying to find exact value
			// Double.compare are not any better however,
			// since Double.NaN == Double.NaN (It shouldn't!)
			// https://stackoverflow.com/a/8081911 (comments)
			// ------------------------------------------
			// Create and add new property
			// ArrayList variables don't work, have to figure out a way to save ArrayList
			// variables in file
			Property p = new Property.PropertyBuilder().propertyID(propertyID).propertyType(propertyType).
					propertyPrice(propertyPrice).ownerName(ownerName).uploader_userID(uploader_userID).grantID(grantID).
					projectName(projectName).currentStatus(currentStatus).numBathroom(numBathroom).numRoom(numRoom).
					address(address).facilities(facilities).propertySize(propertySize).build();
			propertyList.add(p);

			System.out.println("New property added, ID - " + propertyID);
		}
		System.out.println("--------------------------------------------------");

	}

	// ------------------------------------------------------
	// updateProperty()
	// update the property list by writing to the file
	// Note : cleans the current file and reads from list
	//
	// Also, address is treated as one whole field for now
	// No separation between address part1,part2, postcode and state

	// ------------------------------------------------------
	public void updateProperty() {
		System.out.println("[PropertyManager] - refreshProperty()");
		Collections.sort(propertyList, new PropertyIDComparator());
		// for now, to separate file-----
		String fileName = propertyFileName;
		// -------------------------- end

		int count = 0;
		ArrayList<ArrayList<String>> outToFile = new ArrayList<>();

		// column descriptor --------------------------------
		ArrayList<String> title_first_line = new ArrayList<>();
		title_first_line.add("#propertyID, propertyType, propertyPrice, propertySize, uploader_userID, grantID,ownerName,"
				+ "currentStatus,projectName,numBathroom,numRoom,address,facilities");
		outToFile.add(title_first_line);
		// ---------------------------------------------- end

		// Iterate through the property list ---------------------
		for (Property row : propertyList) {
			// Get the property attribute out --------------------
			int propertyID = row.getPropertyID();
			String propertyType = row.getPropertyType();
			double propertyPrice = row.getPropertyPrice();
			double propertySize = row.getPropertySize();
			int uploader_userID = row.getUploader_userID();
			String grantID = row.getGrantID();
			String ownerName = row.getOwnerName();
			String projectName = row.getProjectName();
			int currentStatus = row.getCurrentStatus();
			int numBathroom = row.getNumBathroom();
			int numRoom = row.getNumRoom();
			ArrayList<String> address = row.getAddress();
			ArrayList<String> facilities = row.getFacilities();

			// ------------------------------------------------------
			// Add them together
			// ------------------------------------------------------
			ArrayList<String> singleData = new ArrayList<>();
			// add into ArrayList first then add to ArrayList<ArrayList<String>>
			singleData.add(Integer.toString(propertyID));
			singleData.add(propertyType);
			singleData.add(Double.toString(propertyPrice));
			singleData.add(Double.toString(propertySize));
			singleData.add(ownerName);
			singleData.add(Integer.toString(uploader_userID));
			singleData.add(grantID);
			singleData.add(projectName);
			singleData.add(Integer.toString(currentStatus));
			singleData.add(Integer.toString(numBathroom));
			singleData.add(Integer.toString(numRoom));
			// convert address ArrayList to addressString to save into file
			StringBuilder addressString = new StringBuilder();
			for (String addressPart : address) {
				addressString.append(addressPart);
				addressString.append("|");
			}
			singleData.add(addressString.toString());

			// convert facilities ArrayList to facilities String to save into file
			StringBuilder facilitiesString = new StringBuilder();
			for (String facilitiesPart : facilities) {
				facilitiesString.append(facilitiesPart);
				facilitiesString.append("|");
			}
			singleData.add(facilitiesString.toString());

			// ------------------------------------------------------
			// Add to file/
			// ------------------------------------------------------
			outToFile.add(singleData);
			count++;
		}

		FileReaderIO save_to_csv = new FileReaderIO();
		save_to_csv.writeDataToFile(outToFile, fileName);

		System.out.println("Property added count - " + count);
		System.out.println("--------------------------------------------------");
	}

	// Create a property and add to property arraylist
	//
	public void addProperty(String propertyType, double propertyPrice, double propertySize, String ownerName,
	 		int uploader_userID,String grantID, String projectName, int currentStatus, int numBathroom, 
			int numRoom, ArrayList<String> address, ArrayList<String> facilities) {

		System.out.println("[PropertyManager] - addProperty() --- start------");
		int propertyID = getLargestPropertyID() + 1;

		// --------------------------------------------
		// Create new property, and add to list
		// --------------------------------------------
		Property p = new Property.PropertyBuilder().propertyID(propertyID).propertyType(propertyType).propertyPrice(propertyPrice).
					propertySize(propertySize).ownerName(ownerName).uploader_userID(uploader_userID).grantID(grantID).projectName(projectName)
					.currentStatus(currentStatus).numBathroom(numBathroom).numRoom(numRoom).address(address).facilities(facilities).build();
		propertyList.add(p);

		updateProperty();

		System.out.println("[PropertyManager] - addProperty() ------ end -----");
	}

	// Modify property, parameter will be checked in the GUI, only allow some
	// attributes to be modified
	// propertyID not allow to change, is used to find property
	// uploaderID not allow to change
	public void modifyProperty(int propertyID, String propertyType, double propertyPrice, double propertySize,
		String ownerName,String grantID, String projectName, int currentStatus, int numBathroom, 
   		int numRoom, ArrayList<String> address, ArrayList<String> facilities) {

		System.out.println("[PropertyManager] - modifyProperty() --- start------");

		Property aProperty = findProperty(propertyID);
		// if the parameter is empty, the GUI will handle it and set them as null or 0,
		// unlike searchProperty()
		aProperty.setPropertyType(propertyType);
		aProperty.setPropertyPrice(propertyPrice);
		aProperty.setPropertySize(propertySize);
		aProperty.setOwnerName(ownerName);
		aProperty.setGrantID(grantID);
		aProperty.setNumBathroom(numBathroom);
		aProperty.setNumRoom(numRoom);
		aProperty.setAddress(address);
		aProperty.setProjectName(projectName);
		aProperty.setCurrentStatus(currentStatus);
		aProperty.setFacilities(facilities);
		// set it
		updateProperty();
		System.out.println("[PropertyManager] - modifyProperty() --- end ------");
	}

	// ---------------------------------------------
	// findProperty(propertyID)
	// Find the property object in the property list, and return the property object
	// If not found, it will return null
	// ---------------------------------------------
	public Property findProperty(int propertyID) {
		System.out.println("[PropertyManager] - findProperty() --- start------");
		Property propertyToBeFound = null;

		for (Property row_data : propertyList) {
			if (row_data.getPropertyID() == propertyID) {
				propertyToBeFound = row_data;
				System.out.println("Property found");
				break;
			}
		}

		System.out.println("[PropertyManager] - findProperty() --- end ------");
		return propertyToBeFound;
	}
	// Find property with propertyID and uploaderID, if unable to find, return null
	public Property findPropertyWithUploaderID(int propertyID, int uploaderID) {
		Property temp = null;
		for (int i = 0; i < propertyList.size(); i++) {
			if (propertyList.get(i).getPropertyID() == propertyID && propertyList.get(i).getUploader_userID() == uploaderID) {
				temp = propertyList.get(i);
			}
		}
		return temp;
	}

	// getter for Property List
	public ArrayList<Property> getPropertyList() {
		return propertyList;
	}

	// getter for PorpertyList with UserID, if unable to find, return an array with 0 size
	public ArrayList<Property> getPropertyListWithUploaderID(int uploaderID) {
		ArrayList<Property> temp = new ArrayList<>();
		for (int i = 0; i < propertyList.size(); i++) {
			if (propertyList.get(i).getUploader_userID() == uploaderID) {
				temp.add(propertyList.get(i));
			}
		}
		return temp;
 	}

	// Delete property
	public void deleteProperty(int propertyID) {
		for (int i = 0; i < propertyList.size(); i++) {
			if (propertyList.get(i).getPropertyID() == propertyID) {
				propertyList.remove(i);
				updateProperty();
				break;
			}
		}
	}

	// Get largest property ID
	public int getLargestPropertyID() {
		int max = 0;
		for (int i = 0; i < propertyList.size(); i++) {
			if (propertyList.get(i).getPropertyID() > max) {
				max = propertyList.get(i).getPropertyID();
			}
		}
		return max;
	}

}