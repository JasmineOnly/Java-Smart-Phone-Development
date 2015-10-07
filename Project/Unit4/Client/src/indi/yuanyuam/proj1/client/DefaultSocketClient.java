package indi.yuanyuam.proj1.client;

import indi.yuanyuam.proj1.model.Automobile;

import java.io.*;
import java.net.*;
import java.util.*;

public class DefaultSocketClient extends Thread implements
		SocketClientInterface, SocketClientConstants {
	private Socket sock;// client socket
	private String strHost;// server IP
	private int iPort;// socket port for this service
	private CarModelOptionsIO optionsIO = new CarModelOptionsIO();

	ObjectOutputStream objectOutputStream = null;
	ObjectInputStream objectInputStream = null;

	public DefaultSocketClient(String strHost, int iPort) {
		setPort(iPort);
		setHost(strHost);
	}

	public void setHost(String strHost) {
		this.strHost = strHost;
	}

	public void setPort(int iPort) {
		this.iPort = iPort;
	}

	// run
	public void run() {
		if (openConnection()) {
			handleSession();
			closeSession();
		}
	}

	// Method to open connection
	@Override
	public boolean openConnection() {
		try {
			sock = new Socket(strHost, iPort); // connected to server
		} catch (IOException socketError) {
			if (DEBUG)
				System.err.println("Unable to connect to " + strHost);
			return false;
		}

		try {
			// open input and output stream
			objectInputStream = new ObjectInputStream(sock.getInputStream());
			objectOutputStream = new ObjectOutputStream(sock.getOutputStream());
		} catch (Exception e) {
			if (DEBUG)
				System.err
						.println("Unable to obtain stream to/from " + strHost);
			return false;
		}
		return true;
	}

	// Method to handle session
	@Override
	public void handleSession() {
		String fromServer = "";
		String fromUser = "";
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(
				System.in));

		if (DEBUG)
			System.out
					.println("Handling session with " + strHost + ":" + iPort);

		// display the successful connection
		optionsIO.verify(objectInputStream);

		try {
			System.out.println("Please enter the request!");
			fromUser = stdIn.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (fromUser.equals("Quit")) {
			try {
				objectOutputStream.writeObject(fromUser);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		} else if (fromUser.equals("Upload")) {
			// send the request to server
			try {
				objectOutputStream.writeObject(fromUser);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// get successful operation reply
			optionsIO.verify(objectInputStream);
			String fileName = null;
			try {
				fileName = stdIn.readLine();

				// send the file name to server
				objectOutputStream.writeObject(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// get successful operation reply
			optionsIO.verify(objectInputStream);

			// if upload .Properties
			if (fileName.matches("[a-zA-Z0-9]+.Properties")) {
				// create the properties object and pass it to the server
				optionsIO.transferPropertiesToServer(objectOutputStream,
						fileName);

				// get the success reply
				optionsIO.verify(objectInputStream);

			} else {// if upload .txt
				optionsIO.transferTxtToServer(fileName, sock);

				// get the success reply
				optionsIO.verify(objectInputStream);

			}
		} else if (fromUser.equals("Get")) {
			try {
				objectOutputStream.writeObject(fromUser);
			} catch (IOException e) {
				e.printStackTrace();
			}
			optionsIO.verify(objectInputStream);

			// get auto name list from stream
			ArrayList<String> autoNameList = null;
			try {
				autoNameList = (ArrayList<String>) objectInputStream
						.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			optionsIO.verify(objectInputStream);

			// if no saved car, break as the client and please upload a car
			// first
			if (autoNameList.size() == 0) {
				System.out
						.println("Empty List in Server, please upload a car first");
				return;
			}

			SelectCarOption selectedCar = new SelectCarOption();
			String modelName = selectedCar.selectCar(autoNameList);

			// write the required model name to server
			try {
				objectOutputStream.writeObject(modelName);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// get selected automobile from server
			Automobile selectedAuto = null;
			try {
				selectedAuto = (Automobile) objectInputStream.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			// get transfer successful reply
			optionsIO.verify(objectInputStream);

			// start configure your car in SelectCarOptionClass
			System.out.println("Start Configure the Car");
			
			new SelectCarOption().configureCarChoice(selectedAuto);

			// get the configured car and print all your choice and price
			System.out.println("Configured Car For Your Choice");
			System.out.println(selectedAuto.getName());
			selectedAuto.printChoice();
			System.out.println();
		} else {
			System.out.println("Illegal Input");
		}

	}

	// Method to close session
	@Override
	public void closeSession() {
		try {
			sock.close();
			objectOutputStream.close();
			objectInputStream.close();
			System.out.println("closed!");
		} catch (IOException e) {
			if (DEBUG)
				System.err.println("Error closing socket to " + strHost);
		}

	}

	public static void main(String arg[]) {
		String strLocalHost = "";
		// get local IP address
		try {
			strLocalHost = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			System.err.println("Unable to find local host");
		}
		// start this client
		DefaultSocketClient client = new DefaultSocketClient(strLocalHost,
				iDAYTIME_PORT);
		client.start();
	}

}
