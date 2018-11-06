package ru.sibguti.Phonebook;

import java.io.FileReader;
import java.io.FileWriter;

public abstract class CSV {
	static int toCSV(User user) {
		String className = user.getClass().getName();
		
		try (FileWriter fr = new FileWriter("objects.csv", true)) {
			if (className.equals("ru.sibguti.Phonebook.Individual")) {
				Individual temp = (Individual)user;
				fr.write("ind " + temp.id + " " + temp.nameDetails + " " + temp.phoneDetails + " " + temp.getSnils() + "\n");
				fr.close();
			} else {
				Legal temp = (Legal)user;
				fr.write("Leg " + temp.id + " " + temp.nameDetails + " " + temp.phoneDetails + " " + temp.getTaxNumber() + "\n");
				fr.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	static User fromCSV(String inputLine) {
		String[] splittedData = inputLine.split("\\s+");
		if (splittedData[0].equals("ind")) 
			return new Individual(splittedData[1], splittedData[2], splittedData[3]);
		return new Legal(splittedData[1], splittedData[2], splittedData[3]);
	}
}
