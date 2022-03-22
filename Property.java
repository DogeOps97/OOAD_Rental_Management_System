 

import java.util.*;

// Builder DP
public class Property {
    // necessary---------------------------
    private int propertyID;
    private String propertyType;
    private double propertyPrice;
    private double propertySize; // in square ft
    private int uploader_userID;
    private String grantID;
    private String ownerName;
    private int numBathroom;
    private int numRoom;
    private int currentStatus;
    private String projectName; 
    private ArrayList<String> address;
	// ------------------------------------
    // unnecessary
	

    private ArrayList<String> facilities;
	//-------------------------------------


    private Property(PropertyBuilder propertyMaker) {
        this.propertyID = propertyMaker.propertyID;
        this.propertyType = propertyMaker.propertyType;
        this.propertyPrice = propertyMaker.propertyPrice;
        this.propertySize = propertyMaker.propertySize;
        this.uploader_userID = propertyMaker.uploader_userID;
        this.grantID = propertyMaker.grantID;
        this.ownerName = propertyMaker.ownerName;
        this.currentStatus = propertyMaker.currentStatus;
        this.projectName = propertyMaker.projectName;
        this.numRoom = propertyMaker.numRoom;
        this.numBathroom = propertyMaker.numBathroom;
        this.address = propertyMaker.address;
        this.facilities = propertyMaker.facilities;
    }
    // Debugging purpose
    public String toString() {
		return "Property ID:" + propertyID + " " + propertyType + " " + propertyPrice + " " + propertySize + " " + 
                uploader_userID + " " + address + " " + facilities + " " + currentStatus + " " + projectName;
    }
    public static class PropertyBuilder {
        private int propertyID;
        private String propertyType;
        private double propertyPrice;
        private int uploader_userID;
        private String grantID;
        private String ownerName;   
        private int currentStatus;
        private String projectName;
        private int numBathroom;
        private int numRoom;
        private double propertySize;
        private ArrayList<String> address;
        private ArrayList<String> facilities;
     
        public PropertyBuilder propertyID(int a){propertyID = a; return this;}
        public PropertyBuilder propertyType(String a){propertyType = a; return this;}
        public PropertyBuilder propertyPrice(double a){propertyPrice = a; return this;}
        public PropertyBuilder propertySize(double a){propertySize = a; return this;}
        public PropertyBuilder uploader_userID(int a){uploader_userID = a; return this;}
        public PropertyBuilder grantID(String a){grantID = a; return this;}
        public PropertyBuilder ownerName(String a){ownerName = a; return this;}
        public PropertyBuilder currentStatus(int a){currentStatus = a; return this;}
        public PropertyBuilder projectName(String a){projectName = a; return this;}
        public PropertyBuilder numBathroom(int a){numBathroom = a; return this;}
        public PropertyBuilder numRoom(int a){numRoom = a; return this;}
        public PropertyBuilder address(ArrayList<String> a){address = a; return this;}
        public PropertyBuilder facilities(ArrayList<String> a){facilities = a; return this;}
        
        public Property build() {
            return new Property(this);
        }
    }


    //getter methods
    // getter for propertyID
    public int getPropertyID (){
        return propertyID;
    }
    // getter for propertyType
    public String getPropertyType(){
        return propertyType;
    }
    // getter for propertyPrice
    public double getPropertyPrice(){
        return propertyPrice;
    }
    // getter for propertySize
    public double getPropertySize(){
        return propertySize;
    }
    // getter for uploader_userID
    public int getUploader_userID(){
        return uploader_userID;
    }
    // getter for propertyType
    public String getGrantID(){
        return grantID;
    }
    // getter for propertyType
    public String getOwnerName(){
        return ownerName;
    }   
    // getter for currentStatus
    public int getCurrentStatus(){
        return currentStatus;
    }
    // getter for projectName
    public String getProjectName(){
        return projectName;
    }
    // getter for number of Bathroom
    public int getNumBathroom(){
        return numBathroom;
    }
    // getter for number of room
    public int getNumRoom(){
        return numRoom;
    }
    // getter for address
    public ArrayList<String> getAddress(){
        return address;
    }
    // getter for facilities
    public ArrayList<String> getFacilities() {
        return facilities;
    }
    
    // setter methods
    // setter for propertyID
	public void setPropertyID(int propertyID){
        this.propertyID = propertyID;
    }
    // setter for propertyType
	public void setPropertyType(String propertyType){
        this.propertyType = propertyType;
    }
    // setter for propertyPrice
	public void setPropertyPrice(double propertyPrice){
        this.propertyPrice = propertyPrice;
    }
    // setter for propertySize
	public void setPropertySize(double propertySize){
        this.propertySize = propertySize;
    }
    // setter for uploader_userID
	public void setUploader_userID(int uploader_userID){
        this.uploader_userID = uploader_userID;
    }
    // setter for grantID
	public void setGrantID(String grantID){
        this.grantID = grantID;
    }
    // setter for ownerName
	public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }
    // setter for currentStatus
	public void setCurrentStatus(int currentStatus){
        this.currentStatus = currentStatus;
    }
    // setter for projectName
	public void setProjectName(String projectName){
        this.projectName = projectName;
    }
    // setter for number of bathroom
    public void setNumBathroom(int numBathroom) {
        this.numBathroom = numBathroom;
    }
    // setter for number of Room
	public void setNumRoom(int numRoom){
        this.numRoom = numRoom;
    }
    // setter for address
	public void setAddress(ArrayList<String> address){
        this.address = address;
    }
    // setter for facilities
    public void setFacilities(ArrayList<String> facilities){
        this.facilities = facilities;
    }

}
// sort by using property ID (accensding order)
class PropertyIDComparator implements Comparator<Property> {
	public int compare(Property p1, Property p2) {
		int compareID1 = p1.getPropertyID();
		int compareID2 = p2.getPropertyID();

		// ascending order
		return compareID1 - compareID2;
	}
}

// sort by price (cheapest to most expensive)
class PropertyPriceComparator implements Comparator<Property> {
    public int compare(Property p1, Property p2) {
        double comparePrice1 = p1.getPropertyPrice();
        double comparePrice2 = p2.getPropertyPrice();
        // cheapeast to expensive
        if(comparePrice1 > comparePrice2)
            return 1;
        if(comparePrice2 > comparePrice1)
            return -1;
        else 
            return 0;
    }   
}
// sort by price (most expensive to cheapest)
class PropertyPriceComparatorDescending implements Comparator<Property> {
	public int compare(Property p1, Property p2) {
		double comparePrice1 = p1.getPropertyPrice();
		double comparePrice2 = p2.getPropertyPrice();
        if(comparePrice2 > comparePrice1)
            return 1;
        if(comparePrice1 > comparePrice2)
            return -1;
        else 
            return 0;
	}
}