package Phonebook;

import java.util.*;

public class Phonebook {
	private ArrayList<Abonent> abonents;
	
	public Phonebook() {
		this.abonents = new ArrayList<Abonent>();
	}

	public void setNewAccount(String name, String phone) {
		this.abonents.add(new Abonent(name, phone));
	}

	private int binSearch(ArrayList<Abonent> arr, int key, int low, int high) {
		if (high < low) return -1;

		int midPoint = (low + high) / 2;
		if (key == arr.get(midPoint).getId()) return midPoint;
		else if (key < arr.get(midPoint).getId()) return binSearch(arr, key, low, midPoint - 1);
		else return binSearch(arr, key, midPoint + 1, high);
	}

	private int findAccountByID(int id) {
		Collections.sort(this.abonents, Abonent.ByID);
		return  binSearch(this.abonents, id, 0, this.abonents.size());
	}

	public void displayAccountByID(int id) {
		int index = findAccountByID(id);
		if (index != -1)
			System.out.println(this.abonents.get(index).toString());
		else System.out.println("Not Found.");
	}

	public int removeAccountByID(int id) {
		int index = findAccountByID(id);
		if (index != -1) {
			this.abonents.remove(index);
			return 0;
		}

		return -1;
	}
	
	public void display(int key) {
		if (key == 0) Collections.sort(this.abonents, Abonent.ByID);
		else Collections.sort(this.abonents, Abonent.ByName);
		for (int i = 0; i < abonents.size(); i++) 
			System.out.println(abonents.get(i).toString());
	}
}
