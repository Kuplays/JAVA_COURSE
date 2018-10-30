package ru.sibguti.Phonebook;

public class Individual extends User {
	private String snils;
	
	public Individual(String aName, String aPhone, String aSnils) {
		super(aName, aPhone);
		this.snils = aSnils;
	}

	public String getSnils() {return this.snils;}
	public void setSnils(String aSnils) {this.snils = aSnils;}
	public String toString() {
		return "[ФИО: " + this.nameDetails + "\tТЕЛЕФОН: " + this.phoneDetails + "\t\tСНИЛС:\t" + this.snils + "]";
	}
};
