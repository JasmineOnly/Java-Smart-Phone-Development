package indi.yuanyuam.proj1.server;

import java.io.*;
import java.net.*;
import java.util.*;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public class DefaultSocketServer extends Thread implements
		SocketServerInterface, SocketServerConstants {

	private int iPort;
	private Socket socketClient = null;
	private ObjectInputStream objectInputStream = null;
	private ObjectOutputStream objectOutputStream = null;

	// Constructor with parameters
	public DefaultSocketServer(int iPort, Socket socketClient) {
		this.iPort = iPort;
		this.socketClient = socketClient;
	}

	// run
	public void run() {
		if (openConnection()) {
			handleSession();
			closeSession();
		}
	}

	// Method to open socket
	public boolean openConnection() {
		try {
			objectOutputStream = new ObjectOutputStream(
					socketClient.getOutputStream());
			objectInputStream = new ObjectInputStream(
					socketClient.getInputStream());
		} catch (Exception e) {
			if (DEBUG)
				System.err.println("Unable to obtain stream from Port" + iPort);
			return false;
		}
		return true;

	}

	// Method to handle session
	public void handleSession() {
		String strInput = null;
		String strOutput = null;

		if (DEBUG)
			System.out.println("Handling Session in" + iPort);

		// send the message that the successful connection
		strOutput = "connect to " + iPort;
		try {
			objectOutputStream.writeObject(strOutput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		BuildCarModelOptions buildCarModelOptions = new BuildCarModelOptions();

		// read the request
		try {
			strInput = (String) objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/**
		 * If the request is "Quit", return directly
		 */
		if (strInput.equals("Quit")) {
			return;
		}

		/**
		 * If the request is "Upload ", build up the automobile object depending
		 * on the uploaded file. One way is by a property file, the other way is
		 * by a txt file.
		 */
		else if (strInput.equals("Upload")) {
			strOutput = "Receive the upload automobile request, please enter the file name!";
			try {
				objectOutputStream.writeObject(strOutput);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// get the file name and then build the automobile according to the
			// file type
			String fileName = null;
			try {
				fileName = (String) objectInputStream.readObject();
				// write back the file name
				String output = "Get File Name: " + fileName;
				objectOutputStream.writeObject(output);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// If the client uploads a .Properties file, then build Automobile
			// according to the Property file
			if (fileName.matches("[a-zA-Z0-9]+.Properties")) {
				Properties prop = null;

				// add car in linked hash map
				buildCarModelOptions.createAutoByProperty(objectInputStream);

				// send the message that build automobile successfully
				try {
					strOutput = "build Auto successfully";
					objectOutputStream.writeObject(strOutput);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {// If the client uploads a .txt file, then build Automobile
					// according to the .txt file
				buildCarModelOptions.createAutoByTxt(fileName,
						objectInputStream, socketClient);

				// delete the file in server end
				File file = new File(fileName);
				file.delete();

				// send the message that build automobile successfully
				strOutput = "Build Car From Txt Successfully";
				try {
					objectOutputStream.writeObject(strOutput);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

		/**
		 * If the request is "Get", send the client the car model they want
		 */
		else if (strInput.equals("Get")) {
			strOutput = "Receive the set request";

			try {
				objectOutputStream.writeObject(strOutput);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// get all auto name in server and send back
			ArrayList<String> autoNameList = buildCarModelOptions
					.getAllModelList();
			try {
				objectOutputStream.writeObject(autoNameList);
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (autoNameList.size() == 0) {
				return;
			}

			// send the saved auto list to client
			strOutput = "transfer AutoList successfully";
			try {
				objectOutputStream.writeObject(strOutput);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// get model name from client
			String modelName = null;
			try {
				modelName = (String) objectInputStream.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// send the selected auto mobile to client
			try {
				buildCarModelOptions.sendSelectedModel(objectOutputStream,
						modelName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// send the successful reply to client
			strOutput = "Transfer automobile succesfully";
			try {
				objectOutputStream.writeObject(strOutput);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		/**
		 * For other requirements, prompt the "Illegal Input"
		 */
		else {
			System.out.println("Illegal Input");
		}

	}

	// Method to close this session
	public void closeSession() {
		try {
			socketClient.close();

		} catch (IOException e) {
			if (DEBUG)
				System.err.println("Error closing socket");
		}

	}

}
