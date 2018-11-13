package ru.sibguti.Phonebook;

public class Call {
	private int callerA, callerB;
	protected int callLength;
	protected String callDescription;

	public Call(int idA, int idB) {
		this.callerA = idA;
		this.callerB = idB;
	}

	public Call(int idA, int idB, String descr) {
		this(idA, idB);
		this.callDescription = descr;
	}

	public void setDescription(String s) {
		this.callDescription = s;
	}

	public void setLength(int value) {
		this.callLength = value;
	}

	public int getLength() {return this.callLength;}
	public String getDescription() {return this.callDescription;}

	public String toString() {
		return "CallerID A: " + this.callerA + "\nCallerID B: " + this.callerB + "\nDuration: " + this.callLength + "\nDescription: " + this.callDescription + "\n";
	}
}
