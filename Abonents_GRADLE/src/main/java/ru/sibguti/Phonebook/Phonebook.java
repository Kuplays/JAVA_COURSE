package ru.sibguti.Phonebook;

import java.util.*;

public class Phonebook {
	private ArrayList<User> users;
	
	public Phonebook() {
		this.users = new ArrayList<User>();
	}

	public void setNewIndividual(String name, String phone, String snils) {
		this.users.add(new Individual(name, phone, snils));
	}

	public void setNewLegal(String name, String phone, String taxNumber) {
		this.users.add(new Legal(name, phone, taxNumber));
	}

	private int binSearch(ArrayList<User> arr, int key, int low, int high) {
		if (high < low) return -1;

		int midPoint = (low + high) / 2;
		if (key == arr.get(midPoint).getId()) return midPoint;
		else if (key < arr.get(midPoint).getId()) return binSearch(arr, key, low, midPoint - 1);
		else return binSearch(arr, key, midPoint + 1, high);
	}

	private int findAccountByID(int id) {
		Collections.sort(this.users, User.ByID);
		return  binSearch(this.users, id, 0, this.users.size());
	}

	public void displayAccountByID(int id) {
		int index = findAccountByID(id);
		if (index != -1)
			System.out.println(this.users.get(index).toString());
		else System.out.println("Not Found.");
	}

	public int removeAccountByID(int id) {
		int index = findAccountByID(id);
		if (index != -1) {
			this.users.remove(index);
			return 0;
		}

		return -1;
	}
	
	public void display(int key) {
		if (key == 0) Collections.sort(this.users, User.ByID);
		else Collections.sort(this.users, User.ByName);
		for (int i = 0; i < users.size(); i++) 
			System.out.println(users.get(i).toString());
	}

	public void saveToFile() {
		Collections.sort(this.users, User.ByID);
		for (int i = 0; i < users.size(); i++) {
			users.get(i).toCSV();				
		}
	}
}
