package ru.sibguti.Phonebook;

import java.util.Calendar;
import java.nio.file.*;
import java.text.SimpleDateFormat;


/**
* Class for backup and other utlities
*/
public class Utilizer {
	static int backCounter = 0;

	/**
	* Static file info printing
	* @param fName File name to print about
	*/
	public static void printFileInfo(String fName) {
		Path file = Paths.get(fName);
		try {
			if (Files.exists(file, LinkOption.NOFOLLOW_LINKS)) {
				System.out.println("FILE NAME: " + file.getFileName() + "\nROOT: " + file.getRoot() +
								"\nIS READABLE: " + Files.isReadable(file) + "\nFILE SIZE: " + Files.getAttribute(file, "size"));
			}
		} catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
	}
	
	/**
	* Creates backups for given file as dd_MM_yyyy_HH_mm_ss
	* @param fName File name to save as backup
	*/
	public static void backup(String fName) {
		String currentDate = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(Calendar.getInstance().getTime());
		Path file = Paths.get(fName);
		String backupName = currentDate +  "_bckup_" + backCounter + "_" + file.getFileName();
		Path backDir = Paths.get("backup");
		if (!Files.exists(backDir)) {
			try {
				Files.createDirectory(backDir);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		try {
			Files.copy(file, Paths.get("backup/" + backupName));
		} catch(Exception ex) {ex.printStackTrace();}
		backCounter++;
	}
}
