package ru.sibguti.Phonebook;

import java.util.*;

public class Statistics<T> {
	private ArrayList<T> list;

	public Statistics(ArrayList<T> argList) {
		this.list = argList;
	}

	public void totalLog() {
		for (int i = 0; i < this.list.size(); i++) 
			System.out.println(list.get(i).toString());
	}
}
