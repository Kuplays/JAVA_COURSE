package ru.sibguti.Phonebook;

/**
* Contains all we need to make a call
*/
public class Call {
	private int callerA, callerB;
	protected int callLength;
	protected String callDescription;

	/**
	* Call constructor without description
	* @param idA ID for caller
	* @param idB ID for reaching out to
	*/
	public Call(int idA, int idB) {
		this.callerA = idA;
		this.callerB = idB;
	}

	/**
	* Overloaded one with optional description
	* @param idA ID for caller
	* @param idB for reaching out to
	* @param descr optional description for a call
	*/
	public Call(int idA, int idB, String descr) {
		this(idA, idB);
		this.callDescription = descr;
	}

	/**
	* Sets a description for already created Call object
	* @param s Description message
	*/
	public void setDescription(String s) {
		this.callDescription = s;
	}

	/**
	* Sets length for a call
	* @param value seconds for a call
	*/
	public void setLength(int value) {
		this.callLength = value;
	}

	/**
	* Gets Call length
	* @return Returns current length in seconds
	*/
	public int getDuration() {return this.callLength;}
	
	/**
	* Gets call description
	* @return Returns call description
	*/
	public String getDescription() {return this.callDescription;}
	
	/**
	* Outputs object as a string
	* @return Returns string with callers information, length and description
	*/
	public String toString() {
		return "CallerID A: " + this.callerA + "\nCallerID B: " + this.callerB + "\nDuration: " + this.callLength + "\nDescription: " + this.callDescription + "\n";
	}
}
