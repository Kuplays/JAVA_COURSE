package ru.sibguti.Phonebook;

public class Legal extends User {
	private String taxNumber;
	
	public Legal(String aName, String aPhone, String aTaxNumber) {
		super(aName, aPhone);
		this.taxNumber = aTaxNumber;
	}

	public void setTaxNumber(String val) {this.taxNumber = val;}
	public String getTaxNumber() {return this.taxNumber;}

	public String toString() {
		return "[ФИО: " + this.nameDetails + "\tТЕЛЕФОН: " + this.phoneDetails + "\t\tИНН:\t" + this.taxNumber + "]";
	}
}
