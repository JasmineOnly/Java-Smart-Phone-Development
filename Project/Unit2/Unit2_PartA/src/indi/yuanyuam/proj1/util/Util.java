package indi.yuanyuam.proj1.util;

import java.io.*;

import indi.yuanyuam.proj1.exception.AutoException;
import indi.yuanyuam.proj1.exception.ExceptionEnum;
import indi.yuanyuam.proj1.exception.Helper;
import indi.yuanyuam.proj1.model.Automobile;

public class Util {
	public Automobile buildAutoObject(String filename) throws AutoException {

		BufferedReader buff = null;
		String line = null;
		Automobile auto = new Automobile();
		int optionSetSize = 0;

		String[] info = new String[3];// Basic information: name, base price and
										// option set size
		String[] optionSetInfo;// Store the optionSet's name and size
		String[] optionInfo; // Store the options
		String[] optionDetail = null;
		
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
				info[1] = String.valueOf(helper.fixFileMissBasePrice());
			}

			auto = new Automobile(info[0], Float.parseFloat(info[1]),
					Integer.parseInt(info[2]));

			optionSetSize = auto.getOptionSetListSize();

			boolean eof = false;
			while (!eof) {
				line = buff.readLine();
				if (line == null) {
					eof = true;
					break;
				}

				for (int i = 0; i < optionSetSize; i++) {
					// Initial the option set
					line = buff.readLine();
					optionSetInfo = line.split(",");

					// deal with missing option set name
					try {
						if (optionSetInfo.length != 2) {
							throw new AutoException(
									ExceptionEnum.OptionSetNotFound);
						}
					} catch (AutoException e) {
						Helper helper = new Helper();
						String temp = optionSetInfo[0];
						optionSetInfo = new String[2];
						optionSetInfo[1] = temp;
						optionSetInfo[0] = String.valueOf(helper
								.fixOptionSetNotFound());
					}

					auto.setOptionSet(i, optionSetInfo[0],
							Integer.parseInt(optionSetInfo[1]));

					// Get the options
					line = buff.readLine();
					optionInfo = line.split(";");

					for (int j = 0; j < optionInfo.length; j++) {
						optionDetail = optionInfo[j].split(",");
						
						// deal with missing option price
						try {				
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
						auto.setOption(i, j, optionDetail[0],
								Float.parseFloat(optionDetail[1]));

					}
				}
			}

		} catch (IOException e) {
			System.out.println("Error--" + e.toString());
			throw new AutoException(ExceptionEnum.FileNotFound);
		} 
		

		return auto;
	}

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
