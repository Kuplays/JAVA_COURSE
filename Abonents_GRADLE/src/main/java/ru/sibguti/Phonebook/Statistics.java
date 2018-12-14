package ru.sibguti.Phonebook;

import java.util.*;


/**
* Statistics generic class
*/
public class Statistics<T> {
	private ArrayList<T> list;

	/**
	* Constructor for a Statistics
	* @param argList Given list of either Calls or Conferences
	*/
	public Statistics(ArrayList<T> argList) {
		this.list = argList;
	}

	/**
	* Total log function for output
	*/
	public void totalLog() {
		for (int i = 0; i < this.list.size(); i++) 
			System.out.println(list.get(i).toString());
	}
}
