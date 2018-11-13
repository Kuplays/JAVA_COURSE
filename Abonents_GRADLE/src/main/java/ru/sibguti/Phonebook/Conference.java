package ru.sibguti.Phonebook;

import java.util.*;

public class Conference {
	private int[] usersID;
	private int duration;

	public Conference(Integer ...vars) {
		int length = vars.length;
		usersID = new int[length];
		
		for (int i = 0; i < length; i++) usersID[i] = vars[i];
	}

	public void setDuration(int value) {this.duration = value;}
	public int getDuration() {return this.duration;}
	
	public String toString() {
		String list = "";
		for (int i = 0; i < usersID.length; i++) {
			list += this.usersID[i];
			list += ", ";
		}
		return "Conference ID`s: [" + list + "], Duration: " + this.duration + "\n";  
	}
}
