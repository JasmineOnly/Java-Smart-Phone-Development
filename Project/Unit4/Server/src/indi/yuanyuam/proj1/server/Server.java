package indi.yuanyuam.proj1.server;

import java.net.*;
import java.io.*;

public class Server implements SocketServerConstants {
	private ServerSocket serverSocket = null;
		
	public Server() {
		try {
			// open this server
			serverSocket = new ServerSocket(iDAYTIME_PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Listening on port " + iDAYTIME_PORT);
	}

	public void runServer() {
		DefaultSocketServer defaultClientSocket = null;
		try {
			while (true) {
				// accept the client
				Socket clientSocket = serverSocket.accept();
				// use a defaultClientSocket to handle the session
				defaultClientSocket = new DefaultSocketServer(iDAYTIME_PORT,clientSocket);
				defaultClientSocket.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.runServer();
	}

}
