package ru.sibguti.Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyThread implements Runnable {
	private Socket socketClient;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	public MyThread(Socket sock) {
		
	}

	public void run() {
	}
}
