package ru.sibguti.Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Runner {
	public static void main(String argv[]) {
//		try {
//		ServerSocket serv = new ServerSocket(8080);
//		Socket cs = serv.accept();
//		PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
//		BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
//		out.println("<html><body>gggg</body></html>");
//		out.close();
//		serv.close();
//		} catch(Exception e) {}

//		ServerSocket server;
///		Socket client;
//		Runnable runnable;
//		Thread thread;

		try {
			ServerSocket server = new ServerSocket(8080);
			while(true) {
				Socket client = server.accept();
				Runnable runnable = new MyThread(client);
				Thread thread = new Thread(runnable);
				thread.start();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
