package ru.sibguti.kuplays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Abonent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nameDetails;
	private String phoneNumber;

	public String getNameDetails() {
		return nameDetails;
	}

	public void setNameDetails(String newNameDetails) {
		this.nameDetails = newNameDetails;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}
}