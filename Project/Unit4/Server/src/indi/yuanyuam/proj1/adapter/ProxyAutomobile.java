package indi.yuanyuam.proj1.adapter;

import java.io.*;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.*;

import indi.yuanyuam.proj1.scale.*;
import indi.yuanyuam.proj1.util.FileIO;
import indi.yuanyuam.proj1.model.*;
import indi.yuanyuam.proj1.exception.*;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public abstract class ProxyAutomobile {
	private static LinkedHashMap<String, Automobile> autoList = new LinkedHashMap<String, Automobile>();
	private static int threadID = 0;

	/**
	 * Given a text file name a method called BuildAuto can be written to build
	 * an instance of Automobile.
	 * 
	 * @param filename
	 * @param fileType
	 */
	public void buildAuto(String filename, String fileType) {
		if (fileType.equals("txt")) {
			try {
				Automobile auto = new FileIO().buildAutoObject(filename);
				autoList.put(auto.getName(), auto);
			} catch (AutoException e) {
				System.out.println("Error -- " + e.toString());
				Helper helper = new Helper();
				String newfilename = helper.fixFileNotFound();
				try {
					Automobile auto = new FileIO().buildAutoObject(newfilename);
					autoList.put(auto.getName(), auto);
				} catch (AutoException error) {
					error.printStackTrace();
				}
			}
		} else if (fileType.equals("property")) {
			Automobile auto = new FileIO().readProperty(filename);
			autoList.put(auto.getName(), auto);
		} else {
			System.out.println("Type Error!");
		}
	}

	/**
	 * This function searches and prints the properties of a given Automobile.
	 * 
	 * @param modelname
	 */
	public void printAuto(String modelname) {
		Automobile auto = autoList.get(modelname);
		try {
			if (auto == null) {
				throw new AutoException(ExceptionEnum.CarModelNotFound);
			}
			auto.print();
		} catch (AutoException ae) {
			System.out.println("Error -- " + ae.toString());
		}
	}

	/**
	 * This function searches the Model for a given OptionSet and sets the name
	 * of OptionSet to newName.
	 * 
	 * @param modelname
	 * @param optionSetname
	 * @param newName
	 */
	public void updateOptionSetName(String modelname, String optionSetname,
			String newName) {
		Automobile auto = autoList.get(modelname);
		try {
			if (auto != null) {
				auto.updateOptionSetName(optionSetname, newName);
				autoList.put(modelname, auto);
			} else {
				throw new AutoException(ExceptionEnum.CarModelNotFound);
			}

		} catch (AutoException ae) {
			System.out.println("Error -- " + ae.toString());
		}

	}

	/**
	 * This function searches the Model for a given OptionSet and Option name,
	 * and sets the price to newPrice.
	 * 
	 * @param modelname
	 * @param setname
	 * @param optionname
	 * @param newprice
	 */
	public void updateOptionPrice(String modelname, String setname,
			String optionname, int newprice) {
		Automobile auto = autoList.get(modelname);
		try {
			if (auto != null) {
				auto.updateOptionPrice(setname, optionname, newprice);
				autoList.put(modelname, auto);
			} else {
				throw new AutoException(ExceptionEnum.CarModelNotFound);
			}
		} catch (AutoException ae) {
			System.out.println("Error -- " + ae.toString());
		}
	}

	/**
	 * This function is used to edit option set name, or option name or option
	 * price
	 * 
	 * @param editOptionEnum
	 * @param editInfo
	 */
	public void edit(EditOptionEnum editOptionEnum, String[] editInfo) {
		// editInfo[0] is model name
		Automobile auto = autoList.get(editInfo[0]);
		try {
			if (auto == null) {
				throw new AutoException(ExceptionEnum.CarModelNotFound);
			} else {
				EditOption edit = new EditOption(auto, (++threadID), editInfo,
						editOptionEnum);
				edit.start();

			}
		} catch (AutoException ae) {
			System.out.println("Error -- " + ae.toString());
		}

	}

	/**
	 * Method to accept properties object from client socket over an
	 * ObjectStream and create an Automobile.
	 * 
	 * @param objectInputStream
	 * @return
	 */
	public void createAutoByProperty(ObjectInputStream objectInputStream) {
		Properties props = null;
		Automobile auto = null;

		try {
			props = (Properties) objectInputStream.readObject();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		String modelname = props.getProperty("CarMake")
				+ props.getProperty("CarModel");
		auto = new Automobile(modelname, Integer.parseInt(props
				.getProperty("BasePrice")));

		for (char optionsetNum = '1'; props
				.getProperty("Option" + optionsetNum) != null; optionsetNum++) {
			auto.setOptionSet(props.getProperty("Option" + optionsetNum));
			for (char optionNum = 'a'; props.getProperty("OptionValue"
					+ optionsetNum + optionNum) != null; optionNum++) {
				auto.setOption(
						props.getProperty("Option" + optionsetNum),
						props.getProperty("OptionValue" + optionsetNum
								+ optionNum),
						Integer.parseInt(props.getProperty("OptionPrice"
								+ optionsetNum + optionNum)));
			}

		}

		autoList.put(modelname, auto);
	}

	/**
	 * Method to accept txt file from client socket over an ObjectStream and
	 * create an Automobile. Then add that created Automobile to the
	 * LinkedHashMap
	 * 
	 * @param filename
	 */
	public void createAutoByTxt(String filename,
			ObjectInputStream objectInputStream, Socket socketClient) {
		try {
			File file = new File(filename);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(
					socketClient.getInputStream());

			byte[] buf = new byte[10240];
			int len = 0;
			while ((len = bufferedInputStream.read(buf, 0, 10240)) > 0) {
				// read file from client and write it in the file
				fileOutputStream.write(buf, 0, len);
				fileOutputStream.flush();
				break;
			}
			fileOutputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		Automobile auto = null;
		try {
			auto = new FileIO().buildAutoObject(filename);
		} catch (AutoException e) {
			e.printStackTrace();
		}

		// Get the model name
		File file = new File(filename);
		String modelname = null ;
		try {
			BufferedReader buff = new BufferedReader(new FileReader(file));
			modelname = buff.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		autoList.put(modelname, auto);

	}

	/**
	 * Method to get all the model name
	 * 
	 * @return
	 */
	public ArrayList<String> getAllModelList() {
		ArrayList<String> autoNameList = new ArrayList<String>();
		for (String key : autoList.keySet()) {
			autoNameList.add(key);
		}
		return autoNameList;
	}

	/**
	 * Method to send the selected model
	 * 
	 * @param objectOutputStream
	 * @param modelName
	 * @throws IOException
	 */
	public void sendSelectedModel(ObjectOutputStream objectOutputStream,
			String modelName) throws IOException {
		Automobile selectedAuto = autoList.get(modelName);
		objectOutputStream.writeObject(selectedAuto);
	}

	/**
	 * Method to fix exception
	 * 
	 * @param errno
	 */
	public void fix(int errno) {

		Helper helper = new Helper();
		log();

		switch (errno) {
		case 1:
			helper.fixFileNotFound();
		case 2:
			helper.fixCarModelNotFound();
		case 3:
			helper.fixFileMissBasePrice();
		case 4:
			helper.fixOptionSetNotFound();
		case 5:
			helper.fixFileMissOptionPrice();

		}
	}

	/**
	 * Method to write log into file
	 */
	public void log() {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		String s = ts.toString() + "\t" + this.toString() + "\n";

		try {
			FileOutputStream fo = new FileOutputStream("AutoException_log.txt",
					true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo));
			bw.write(s);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
