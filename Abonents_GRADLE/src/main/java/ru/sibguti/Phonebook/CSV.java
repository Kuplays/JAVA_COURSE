package ru.sibguti.Phonebook;

import java.io.FileReader;
import java.io.FileWriter;


/**
* Class to work with CSV functons Abstract
*/
public abstract class CSV {
	
	/**
	* Saves given user to CSV file
	* @param user Given user from User class and its children
	* @return Returns 0 on success
	*/
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

	/**
	* Composes new User from User class and its children from CSV file
	* @param inputLine String line that was read from CSV file for decomposition
	* @return Returns new user depends on user type
	*/
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
