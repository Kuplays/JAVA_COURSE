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
	private Scanner addressLineScanner;
	private PrintWriter outWriter;
	private String address;
	private String addrFromStream[];
	private PageParser page; //Page Related work
	private Client cl;
	
	
	public MyThread(Client parsedClient) {
		this.cl = parsedClient;
		this.socketClient = cl.getSocket();

		try {
			address = "";
			this.inputStream = this.socketClient.getInputStream();
			this.outputStream = this.socketClient.getOutputStream();
		} catch(Exception ex) {
			ex.printStackTrace();
		}	
	}

	public void run() {
		addressLineScanner = new Scanner(inputStream);
		addrFromStream = addressLineScanner.nextLine().split(" ");
		
		if (addrFromStream[1].equals("/")) address = "html/index.html";
		else address = "html/" + addrFromStream[1].substring(1, addrFromStream[1].length());
		
		page = new PageParser(address);
		page.setHeaderOne(cl.toString());
		outWriter = new PrintWriter(outputStream, true);
		outWriter.println(page.toString());
		System.out.println(page.toString());
		page.resetContent();
	}
}
