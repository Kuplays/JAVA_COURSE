package ru.sibguti.Phonebook;

import java.util.Comparator;

public abstract class User implements CSV {
	private static int increment = 1;
	protected int id;
	protected String nameDetails;
	protected String phoneDetails;

	public User(String argName, String argPhone) {
		this.id = increment;
		increment++;
		this.nameDetails = argName;
		this.phoneDetails = argPhone;
	}
	
	public void setNameDetails(String newName) {this.nameDetails = newName;}
	public void setPhoneDetails(String newPhone) {this.phoneDetails = newPhone;}

	public int getId() {return this.id;}
	public String getNameDetails() {return this.nameDetails;}
	public String getPhoneDetails() {return this.phoneDetails;}

	public static Comparator<User> ByID = new Comparator<User>() {
		public int compare(User aLeft, User aRight) {
			return aLeft.getId() - aRight.getId();
		}
	};

	public static Comparator<User> ByName = new Comparator<User>() {
		public int compare(User aLeft, User aRight) {
			return aLeft.getNameDetails().toUpperCase().compareTo(aRight.getNameDetails().toUpperCase());
		}
	};
}
