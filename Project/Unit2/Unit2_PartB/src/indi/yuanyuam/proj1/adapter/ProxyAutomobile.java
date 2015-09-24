package indi.yuanyuam.proj1.adapter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Timestamp;
import java.util.Date;

import indi.yuanyuam.proj1.model.*;
import indi.yuanyuam.proj1.exception.*;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public abstract class ProxyAutomobile {
	private static AutoList autoList = new AutoList();

	// Given a text file name a method called BuildAuto can be written to build
	// an instance of Automobile.
	public void buildAuto(String filename) {
		try {
			autoList.setAuto(filename);
		} catch (AutoException e) {
			System.out.println("Error -- " + e.toString());
			Helper helper = new Helper();
			String newfilename = helper.fixFileNotFound();
			try {
				autoList.setAuto(newfilename);
			} catch (AutoException error) {
				error.printStackTrace();
			}
		}
	}

	// This function searches and prints the properties of a given Automobile.
	public void printAuto(String modelname) {
		Automobile auto = autoList.getAutomobile(modelname);
		try {
			if (auto == null) {
				throw new AutoException(ExceptionEnum.CarModelNotFound);
			}
			auto.print();
		} catch (AutoException ae) {
			System.out.println("Error -- " + ae.toString());
		}
	}

	// This function searches the Model for a given OptionSet and sets the name
	// of OptionSet to newName.
	public void updateOptionSetName(String modelname, String optionSetname,
			String newName) {
		try {
			autoList.updateOptionSetName(modelname, optionSetname, newName);
		} catch (AutoException ae) {
			System.out.println("Error -- " + ae.toString());
		}

	}

	// This function searches the Model for a given OptionSet and Option name,
	// and sets the price to newPrice.
	public void updateOptionPrice(String modelname, String setname,
			String optionname, int newprice) {
		try {
			autoList.updateOptionPrice(modelname, setname, optionname, newprice);
		} catch (AutoException ae) {
			System.out.println("Error -- " + ae.toString());
		}
	}
	
	// Method to write log into file
	public void log() {
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		String s = ts.toString() + "\t" + this.toString() + "\n";

		try {
			FileOutputStream fo = new FileOutputStream("AutoException_log.txt",true);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo));
			bw.write(s);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to fix exception
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

}
