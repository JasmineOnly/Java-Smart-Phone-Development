package indi.yuanyuam.proj1.server;

import indi.yuanyuam.proj1.adapter.*;
import indi.yuanyuam.proj1.model.Automobile;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.io.*;
import java.net.Socket;

public class BuildCarModelOptions implements AutoServer {
	private static BuildAuto buildAuto = new BuildAuto();

	// Method to accept properties object from client socket over an
	// ObjectStream and create an Automobile.Then add that created Automobile to the
	// LinkedHashMap
	public void createAutoByProperty(ObjectInputStream objectInputStream) {
		buildAuto.createAutoByProperty(objectInputStream);
	}

	// Method to accept txt file from client socket over an ObjectStream and
	// create an Automobile. Then add that created Automobile to the
	// LinkedHashMap
	public void createAutoByTxt(String filename,
			ObjectInputStream objectInputStream, Socket socketClient){
		buildAuto.createAutoByTxt(filename, objectInputStream, socketClient);
	}

	// Method to get all available car model in server
	public ArrayList<String> getAllModelList() {
		ArrayList<String> autoNameList = buildAuto.getAllModelList();
		return autoNameList;
	}

	// Method to send the selected model to client
	public void sendSelectedModel(ObjectOutputStream objectOutputStream,
			String modelName) throws IOException {
		buildAuto.sendSelectedModel(objectOutputStream, modelName);
	}

}
