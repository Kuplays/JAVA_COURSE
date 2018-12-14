package ru.sibguti.Phonebook;

import java.io.FileReader;
import java.io.FileWriter;


/**
* Legal user class extends abstract User class
*/
public class Legal extends User {
	private String taxNumber;
	
	/**
	* Constructor for legal user
	* @param aName Name details
	* @param aPhone Phone number
	* @param aTaxNumber Tax Number
	*/
	public Legal(String aName, String aPhone, String aTaxNumber) {
		super(aName, aPhone);
		this.taxNumber = aTaxNumber;
	}

	/**
	* Sets current tax number
	* @param val New tax number string to set as
	*/
	public void setTaxNumber(String val) {this.taxNumber = val;}

	/**
	* Gets current tax number
	* @return Returns tax Number
	*/
	public String getTaxNumber() {return this.taxNumber;}

	/**
	* Gets user specific number must be implemented as from User class
	* @return Returns tax Number
	*/
	public String getSpecificNumber() {return getTaxNumber();}

	/**
	* Formats Legal user as a string for output
	* @return Returns user information as a string
	*/
	public String toString() {
		return "[ФИО: " + this.nameDetails + "\tТЕЛЕФОН: " + this.phoneDetails + "\t\tИНН:\t" + this.taxNumber + "]";
	}
}
