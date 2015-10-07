package indi.yuanyuam.proj1.util;

import java.io.*;
import java.util.*;

import indi.yuanyuam.proj1.exception.*;
import indi.yuanyuam.proj1.model.Automobile;
import indi.yuanyuam.proj1.adapter.*;

public class FileIO {
	public Automobile readProperty(String filename) {
		// create the properties object by the property file
		Properties props = new Properties();
		FileInputStream in = null;

		try {
			in = new FileInputStream(filename);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Automobile auto = null;
		auto = new Automobile(props.getProperty("CarMake")
				+ props.getProperty("CarModel"), Integer.parseInt(props
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

		return auto;
	}

	// Method to build an automobile object
	public Automobile buildAutoObject(String filename) throws AutoException {

		BufferedReader buff = null;
		String line = null;
		Automobile auto = new Automobile();

		String[] info = new String[2];// Basic information: name, base price
		String optionSetName;// Store the optionSet's name
		String[] optionInfo; // Store the options
		String[] optionDetail;

		try {
			// Open the file using FileReader Object.
			File f = new File(filename);
			buff = new BufferedReader(new FileReader(f));

			// Read the basic information
			for (int i = 0; i < info.length; i++) {
				info[i] = buff.readLine();
			}

			try {
				// deal with the CarModelNotFound exception
				if (info[0].length() == 0) {
					throw new AutoException(ExceptionEnum.CarModelNotFound);
				}
			} catch (AutoException e) {
				Helper helper = new Helper();
				info[0] = helper.fixCarModelNotFound();
			}

			try {
				// deal with the FileMissBasePrice exception
				if (info[1].length() == 0) {
					throw new AutoException(ExceptionEnum.FileMissBasePrice);
				}
			} catch (AutoException e) {
				Helper helper = new Helper();
				info[1] = Integer.toString(helper.fixFileMissBasePrice());
			}

			auto = new Automobile(info[0], Integer.parseInt(info[1]));

			boolean eof = false;
			while (!eof) {
				line = buff.readLine();
				if (line == null) {
					eof = true;
					break;
				}

				while ((line = buff.readLine()) != null) {
					// Initial the option set
					try {
						optionSetName = line;
						if (optionSetName.length() == 0) {
							throw new AutoException(
									ExceptionEnum.OptionSetNotFound);
						}
					} catch (AutoException e) {
						Helper helper = new Helper();
						optionSetName = helper.fixOptionSetNotFound();
					}
					auto.setOptionSet(optionSetName);

					// Get the options
					line = buff.readLine();
					optionInfo = line.split(";");

					for (int j = 0; j < optionInfo.length; j++) {
						optionDetail = optionInfo[j].split(",");
						try {
							// deal with missing option price
							if (optionDetail.length != 2) {
								throw new AutoException(
										ExceptionEnum.FileMissOptionPrice);
							}
						} catch (AutoException e) {
							Helper helper = new Helper();
							String temp = optionDetail[0];
							optionDetail = new String[2];
							optionDetail[0] = temp;
							optionDetail[1] = String.valueOf(helper
									.fixFileMissOptionPrice());
						}

						auto.setOption(optionSetName, optionDetail[0],
								Integer.parseInt(optionDetail[1]));
					}
				}
			}

		} catch (IOException e) {
			System.out.println("Error--" + e.toString());
			throw new AutoException(ExceptionEnum.FileNotFound);
		}

		return auto;
	}

	// Method to serialize the Automobile object
	public void serializeAuto(Automobile auto) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("auto.ser"));
			oos.writeObject(auto);
			oos.close();
		} catch (IOException e) {
			System.out.println("Error--" + e.toString());
			System.exit(1);
		} finally {
			try {
				oos.close();
			} catch (IOException streamNotClose) {
				System.out.println("Error: " + streamNotClose.toString());
			}
		}
	}

	// Method to deserialize the Automobile object
	public Automobile deserializeAuto(String filename) {
		ObjectInputStream ois = null;
		Automobile auto = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
			auto = (Automobile) ois.readObject();
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
			System.exit(1);
		} catch (ClassNotFoundException e) {
			System.out.println("Error: " + e.toString());
			System.exit(1);
		} finally {
			try {
				ois.close();
			} catch (IOException streamNotClose) {
				System.out.println("Error: " + streamNotClose.toString());

			}
		}

		return auto;
	}
}
