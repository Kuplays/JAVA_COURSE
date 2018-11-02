package ru.sibguti.Phonebook;

import java.lang.reflect.*;

class Test {
	public static void main(String[] args) {
		Phonebook book = new Phonebook();
		book.setNewLegal("Garry Mason", "8-952-904", "73232423221");
		book.setNewLegal("Borya Elcin", "7-495-999", "12311111111");
		book.setNewIndividual("Vasya Pupkin", "232323-111", "998211111");
		book.setNewIndividual("Vladimir Putin", "111-323211-11", "0099111211");
		book.saveToFile();
	}
}
