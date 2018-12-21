package ru.sibguti.Server;

import java.net.Socket;
import java.net.ServerSocket;

public class Client {
	private Socket socket;
	private String name;
	static int count = 0;
	private int id;

	public Client() {
		id = count++;
		name = "CLIENT #" + String.valueOf(id);
	}

	public void setSocket(ServerSocket ss) {
		try {
			this.socket = ss.accept();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public Socket getSocket() {
		return this.socket;
	}
	
	public String toString() {
		return name;
	}
}