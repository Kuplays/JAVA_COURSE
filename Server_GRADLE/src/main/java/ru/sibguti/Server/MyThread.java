package ru.sibguti.Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyThread implements Runnable {
	private Socket socketClient;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Scanner addressLineScanner, fileScanner;
	private FileInputStream fileStream;
	private PrintWriter outWriter;
	String address, addrFromStream[];
	String content, responseHeader;
	
	
	public MyThread(Socket sock) {
		this.socketClient = sock;
		address = "";
		content = "";
	//	responseHeader = "HTTP/1.1 OK 200\r\nContent-Type: text/html\r\nContent-Length: 128\r\n";
		try {
			this.inputStream = this.socketClient.getInputStream();
			this.outputStream = this.socketClient.getOutputStream();
		} catch(Exception ex) {
			ex.printStackTrace();
		}	
	}

	public void run() {
		addressLineScanner = new Scanner(inputStream);
		addrFromStream = addressLineScanner.nextLine().split(" ");
		
		if (addrFromStream[1].equals("/")) address = "index.html";
		else address = addrFromStream[1].substring(1, addrFromStream[1].length());
		
		try {
			fileStream = new FileInputStream(address);
			fileScanner = new Scanner(fileStream);
			
			while(fileScanner.hasNextLine())
				content += fileScanner.nextLine();
			fileStream.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		responseHeader = "HTTP/1.1 OK 200\r\nContent-Type: text/html\r\nContent-Length: " + String.valueOf(content.length()) + "\r\n";
		String fullResponse = responseHeader + content;
		outWriter = new PrintWriter(outputStream, true);
		outWriter.println(fullResponse);
		System.out.println(fullResponse);
	//	outWriter.flush();
		address = "";
		content = "";
	}
}
