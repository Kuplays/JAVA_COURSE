package ru.sibguti.Phonebook;

import java.lang.reflect.*;

class Test {
	public static void main(String[] args) {
		Phonebook book = new Phonebook();
		//book.setNewLegal("Garry Mason", "8-952-904", "73232423221");
		//book.setNewLegal("Borya Elcin", "7-495-999", "12311111111");
		//book.setNewIndividual("Vasya Pupkin", "232323-111", "998211111");
		//book.setNewIndividual("Vladimir Putin", "111-323211-11", "0099111211");

		//book.setNewLegal("TOSHA", "8-999-2313", "229999111");

	 	//book.saveToFile();
		//User ind = CSV.fromCSV("ind Vasya 99232 99999");
		book.fillFromFile();
	//	book.display(1);
		book.makeCall(book.getAccountByID(5), book.getAccountByID(7), "Just a regular convo of lovers");
		book.makeConferenceCall(book.getAccountByID(5), book.getAccountByID(7), book.getAccountByID(1));
	//	book.callsLog();
	//	book.confLog();
		book.callStats();
		book.confStats();
	//	book.displayAccountByID(1);
	}
}
