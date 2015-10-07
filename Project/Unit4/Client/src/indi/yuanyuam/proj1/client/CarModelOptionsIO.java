package indi.yuanyuam.proj1.client;

import indi.yuanyuam.proj1.adapter.BuildAuto;
import indi.yuanyuam.proj1.adapter.CreateAuto;

import java.io.*;
import java.net.Socket;
import java.util.*;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public class CarModelOptionsIO {

	/**
	 * Read data from the Properties file; create properties object, using the
	 * load method, which transfers the object from the client to server, using
	 * ObjectStream.
	 * 
	 * @param sock
	 * @param filename
	 */
	public void transferPropertiesToServer(
			ObjectOutputStream objectOutputStream, String fileName) {
		// create the properties object by the property file
		Properties props = new Properties();
		FileInputStream in = null;

		try {
			in = new FileInputStream(fileName);
			props.load(in);
			in.close();
			objectOutputStream.writeObject(props);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read data from the txt file then transfers from the client to server
	 * 
	 * @param fileName
	 * @param sock
	 */
	public void transferTxtToServer(String fileName, Socket sock) {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(
					fileName));
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					sock.getOutputStream());
			byte[] buf = new byte[1024];
			int len = 0;

			// upload the car file in client
			while ((len = fileInputStream.read(buf, 0, 1024)) != -1) {
				// write the txt file to server
				bufferedOutputStream.write(buf, 0, len);
				bufferedOutputStream.flush();
			}
			fileInputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Receive a response from the Server, verifying that the Car Model object
	 * is created successfully.
	 * 
	 * @param objectInputStream
	 */
	public void verify(ObjectInputStream objectInputStream) {
		try {
			String mess = (String) objectInputStream.readObject();
			System.out.println("Server: " + mess);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Use CreateAuto interface to build Automobile and handle different type of
	 * files, passed in file type.
	 * 
	 * @param filename
	 * @param fileType
	 */
	public void buildAuto(String filename, String fileType) {
		CreateAuto create = new BuildAuto();
		create.buildAuto(filename, fileType);
	}

}
