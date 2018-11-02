package ru.sibguti.Phonebook;

import java.io.FileReader;
import java.io.FileWriter;

public class Legal extends User {
	private String taxNumber;
	
	public Legal(String aName, String aPhone, String aTaxNumber) {
		super(aName, aPhone);
		this.taxNumber = aTaxNumber;
	}

	public void setTaxNumber(String val) {this.taxNumber = val;}
	public String getTaxNumber() {return this.taxNumber;}

	public int toCSV() {
		try (FileWriter fr = new FileWriter("objects.csv", true)) {
			fr.write("legal " + this.id + " " + this.nameDetails + " " + this.phoneDetails + " " + this.taxNumber + "\n");
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
		return "[ФИО: " + this.nameDetails + "\tТЕЛЕФОН: " + this.phoneDetails + "\t\tИНН:\t" + this.taxNumber + "]";
	}
}
