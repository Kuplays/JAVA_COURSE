package ru.sibguti.Phonebook;

import java.io.FileWriter;
import java.io.FileReader;

public class Individual extends User {
	private String snils;
	
	public Individual(String aName, String aPhone, String aSnils) {
		super(aName, aPhone);
		this.snils = aSnils;
	}

	public String getSnils() {return this.snils;}
	public void setSnils(String aSnils) {this.snils = aSnils;}

	public int toCSV() {
		try (FileWriter fr = new FileWriter("objects.csv", true)) {
			fr.write("individual " + this.id + " " + this.nameDetails + " " + this.phoneDetails + " " + this.snils + "\n");
			fr.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return 0;
	}

	public int fromCSV() {
		return 0;
	}

	public String toString() {
		return "[ФИО: " + this.nameDetails + "\tТЕЛЕФОН: " + this.phoneDetails + "\t\tСНИЛС:\t" + this.snils + "]";
	}
};
