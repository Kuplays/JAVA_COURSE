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
		User tmp;
		String[] splittedData = inputLine.split("\\s+");
		//for (int i = 0; i < splittedData.length; i++) System.out.print(splittedData[i]);
		if (splittedData[0].equals("ind")) {
			tmp = new Individual(splittedData[2], splittedData[3], splittedData[4]);
			tmp.setID(Integer.parseInt(splittedData[1]));
		} else {
			tmp = new Legal(splittedData[2], splittedData[3], splittedData[4]);
			tmp.setID(Integer.parseInt(splittedData[1]));
		}
		return tmp;
	}
}
