package ru.sibguti.Phonebook;

import java.io.FileWriter;
import java.io.FileReader;


/**
* Class for Individual user extends abstract User
*/
public class Individual extends User {
	private String snils;
	
	/**
	* Constructor for Individual
	* @param aName Name details
	* @param aPhone Phone number
	* @param aSnils SNILS number
	*/
	public Individual(String aName, String aPhone, String aSnils) {
		super(aName, aPhone);
		this.snils = aSnils;
	}

	/**
	* Gets SNILS number
	* @return Returns SNILS number
	*/
	public String getSnils() {return this.snils;}
	
	/**
	* Sets SNILS number
	* @param aSnils SNILS String to set as SNILS number
	*/
	public void setSnils(String aSnils) {this.snils = aSnils;}

	/**
	* Gets user specific number must be implemented by all child classes of User
	* @return Returns SNILS number
	*/
	public String getSpecificNumber() {return getSnils();}

	/**
	* Formats Individual user as a string for output
	* @return Returns a string with user informations
	*/
	public String toString() {
		return "[ФИО: " + this.nameDetails + "\tТЕЛЕФОН: " + this.phoneDetails + "\t\tСНИЛС:\t" + this.snils + "]";
	}
};
