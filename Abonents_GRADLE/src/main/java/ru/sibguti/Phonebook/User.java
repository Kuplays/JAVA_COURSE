package ru.sibguti.Phonebook;

import java.util.Comparator;


/**
* Main User abstract class
*/
public abstract class User {
	private static int increment = 1;
	protected int id;
	protected String nameDetails;
	protected String phoneDetails;

	/**
	* User constructor
	* @param argName Name details
	* @param argPhone Phone number
	*/
	public User(String argName, String argPhone) {
		this.id = increment;
		increment++;
		this.nameDetails = argName;
		this.phoneDetails = argPhone;
	}
	

	/**
	* Sets ID for a user
	* @param id ID to set
	*/
	public void setID(int id) {this.id = id;}

	/**
	* Sets Name for a user
	* @param newName Name to set
	*/
	public void setNameDetails(String newName) {this.nameDetails = newName;}

	/**
	* Sets new Phone number for a user
	* @param newPhone New phone number to set
	*/
	public void setPhoneDetails(String newPhone) {this.phoneDetails = newPhone;}

	/**
	* Gets user ID
	* @return Returns an ID of User
	*/
	public int getId() {return this.id;}

	/**
	* Gets Name from a user
	* @return Returns name from a user
	*/
	public String getNameDetails() {return this.nameDetails;}

	/**
	* Gets Phone number from a user
	* @return Returns Phone number
	*/
	public String getPhoneDetails() {return this.phoneDetails;}

	/**
	* Returns user specific number
	* Implemented in children classes
	* @return Returns user specific number
	*/
	public abstract String getSpecificNumber();


	/**
	* Comparing two Users by their ID
	*/
	public static Comparator<User> ByID = new Comparator<User>() {
		public int compare(User aLeft, User aRight) {
			return aLeft.getId() - aRight.getId();
		}
	};

	/**
	* Comparing two users by their Name
	*/
	public static Comparator<User> ByName = new Comparator<User>() {
		public int compare(User aLeft, User aRight) {
			return aLeft.getNameDetails().toUpperCase().compareTo(aRight.getNameDetails().toUpperCase());
		}
	};
}
