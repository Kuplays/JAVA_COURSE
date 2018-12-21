package ru.sibguti.Server;

import java.io.FileInputStream;
import java.util.Scanner;

public class PageParser {
	private FileInputStream fStream;
	private Scanner fScanner;
	private String responseHeader;
	private String responseContent;
	private String headerOne;

	public PageParser(String address) {
		responseHeader = "HTTP/1.1 OK 200\r\nContent-Type: text/html; text/css\r\nContent-Length: ";
		responseContent = "";

		try {
			fStream = new FileInputStream(address);
			fScanner = new Scanner(fStream);
			
			while(fScanner.hasNextLine())
				responseContent += fScanner.nextLine();
			fStream.close();
			String length = String.valueOf(responseContent.length());
			responseHeader += length + "\r\n\r\n";
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setHeaderOne(String s) {
		this.headerOne = s;
	}

	public void resetContent() {
		this.responseContent = "";
	}

	public String toString() {
		String temp = this.responseHeader + this.responseContent;
		String fullRespone = temp.replaceFirst("HOLDER", this.headerOne);
		return fullRespone;
	}
}




