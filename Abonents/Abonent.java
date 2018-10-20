package Phonebook;

import java.util.Comparator;

public class Abonent  {
	private static int increment = 1;
	private int id;
	private String nameDetails;
	private String phoneDetails;

	public Abonent(String argName, String argPhone) {
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

	public String toString() {
		return "[ID: " + this.id + "\tФИО: " + this.nameDetails + "\tТЕЛЕФОН: " + this.phoneDetails + "]";

	}

	public static Comparator<Abonent> ByID = new Comparator<Abonent>() {
		public int compare(Abonent aLeft, Abonent aRight) {
			return aLeft.getId() - aRight.getId();
		}
	};

	public static Comparator<Abonent> ByName = new Comparator<Abonent>() {
		public int compare(Abonent aLeft, Abonent aRight) {
			return aLeft.getNameDetails().toUpperCase().compareTo(aRight.getNameDetails().toUpperCase());
		}
	};
}
