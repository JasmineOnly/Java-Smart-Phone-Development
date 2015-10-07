package indi.yuanyuam.proj1.server;

import java.io.*;
import java.net.Socket;
import java.util.*;

import indi.yuanyuam.proj1.model.*;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public interface AutoServer {
	/**
	 * Method to accept properties object from client socket over an
	 * ObjectStream and create an Automobile. Then add that created Automobile
	 * to the LinkedHashMap
	 * 
	 * @param objectInputStream
	 */
	public void createAutoByProperty(ObjectInputStream objectInputStream);

	/**
	 * Method to accept txt file from client socket over an ObjectStream and
	 * create an Automobile. Then add that created Automobile to the
	 * LinkedHashMap
	 * 
	 * @param filename
	 */
	public void createAutoByTxt(String filename,ObjectInputStream objectInputStream,Socket socketClient);

	/**
	 * Method to return all available automobile in LinkedHashMap
	 * @return
	 */
	public ArrayList<String> getAllModelList();

	/**
	 * Method return selected model to client
	 * 
	 * @param objectOutputStream
	 * @param modelName
	 * @throws IOException
	 */
	public void sendSelectedModel(ObjectOutputStream objectOutputStream,
			String modelName) throws IOException;
}
