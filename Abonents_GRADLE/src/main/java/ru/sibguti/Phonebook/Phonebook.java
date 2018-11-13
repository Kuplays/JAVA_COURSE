package ru.sibguti.Phonebook;

import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;

public class Phonebook {
	private Random rand;
	private ArrayList<User> users;
	private ArrayList<Call> calls;
	private ArrayList<Conference> confs;
	private Statistics<Call> callsStats;
	private Statistics<Conference> confStats;
	
	public Phonebook() {
		rand = new Random();
		this.users = new ArrayList<User>();
		this.calls = new ArrayList<Call>();
		this.confs = new ArrayList<Conference>();
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

	public User getAccountByID(int id) {
		int index = findAccountByID(id);
		return this.users.get(index);
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
		for (int i = 0; i < users.size(); i++)
			CSV.toCSV(users.get(i));
	}

	public void fillFromFile() {
		BufferedReader bfReader;
		try {
			bfReader = new BufferedReader(new FileReader("objects.csv"));
			String ln = bfReader.readLine();
			while(ln != null) {
				this.users.add(CSV.fromCSV(ln));
				ln = bfReader.readLine();
			}
			bfReader.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void makeCall(User usrA, User usrB, String descr) {
		Call call = new Call(usrA.getId(), usrB.getId());
		call.setLength(rand.nextInt(100));
		call.setDescription(descr);
		calls.add(call);
	}
	
	public void makeConferenceCall(User ...users) {
		Integer[] ids = new Integer[users.length];
		for (int i = 0; i < users.length; i++) {
			ids[i] = users[i].getId();
		}
		Conference conf = new Conference(ids);
		conf.setDuration(rand.nextInt(100));
		confs.add(conf);
	}

	public void callsLog() {
		for (int i = 0; i < this.calls.size(); i++)
			System.out.println(this.calls.get(i));
	}

	public void confLog() {
		for (int i = 0; i < this.confs.size(); i++)
			System.out.println(this.confs.get(i));
	}

	public void callStats() {
		this.callsStats = new Statistics<>(this.calls);
		this.callsStats.totalLog();
	}

	public void confStats() {
		this.confStats = new Statistics<>(this.confs);
		this.confStats.totalLog();
	}
}
