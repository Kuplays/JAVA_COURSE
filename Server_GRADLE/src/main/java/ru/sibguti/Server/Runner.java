package ru.sibguti.Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.Scanner;

public class Runner {
	public static void main(String argv[]) {
		try {
			ServerSocket server = new ServerSocket(8888);
			while(true) {
				Client client = new Client();
				client.setSocket(server);
				Runnable runnable = new MyThread(client);
				Thread thread = new Thread(runnable);
				thread.start();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
