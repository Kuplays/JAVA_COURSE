package ru.sibguti.Phonebook;

import java.util.*;

/**
* Class for a conference call
*/
public class Conference {
	private int[] usersID;
	private int duration;

	/**
	* Constructor for a conference
	* @param vars IDs array for a conference
	*/
	public Conference(Integer ...vars) {
		int length = vars.length;
		usersID = new int[length];
		
		for (int i = 0; i < length; i++) usersID[i] = vars[i];
	}

	/**
	* Sets duration for a conference call
	* @param value In seconds to set length
	*/
	public void setDuration(int value) {this.duration = value;}
	
	/**
	* Gets conference call durations
	* @return Returns duration in seconds
	*/
	public int getDuration() {return this.duration;}
	
	/**
	* Formats an object as string for output
	* @return return a string with IDs and duration of a call
	*/
	public String toString() {
		String list = "";
		for (int i = 0; i < usersID.length; i++) {
			list += this.usersID[i];
			list += ", ";
		}
		return "Conference ID`s: [" + list + "], Duration: " + this.duration + "\n";  
	}
}
