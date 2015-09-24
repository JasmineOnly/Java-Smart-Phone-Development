package indi.yuanyuam.proj1.driver;

import indi.yuanyuam.proj1.adapter.*;
import indi.yuanyuam.proj1.exception.*;
import indi.yuanyuam.proj1.model.Automobile;
import indi.yuanyuam.proj1.util.Util;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public class Driver {
	public static void main(String[] args) throws AutoException {
		// Create and print an Auto instance through CreateAuto interface
		CreateAuto auto = new BuildAuto();

		System.out.println("****** Test buildAuto ****** \n");
		auto.buildAuto("FocusWagonZTW.txt");
		auto.printAuto("Focus Wagon ZTW");

		// Create and print an Auto instance through BuildAuto
		BuildAuto auto2 = new BuildAuto();

		System.out
				.println("****** Test updateOptionPrice and updateOptionSetName ****** \n");
		// Update one of OptionSet’s name or Option Price for the Auto instance

		auto2.buildAuto("FocusWagonZTW.txt");
		auto2.updateOptionPrice("Focus Wagon ZTW", "Color",
				"Fort Knox Gold Clearcoat Metallic", 1000);
		auto2.updateOptionSetName("Focus Wagon ZTW", "Color", "NewColor");
		auto2.printAuto("Focus Wagon ZTW");

		// Build Automobile Object from a file.
		Util u = new Util();
		Automobile FordZTW = u.buildAutoObject("FocusWagonZTW.txt");

		System.out
				.println("********* Serialize Automobile ************" + "\n");
		FordZTW.print();

		// Serialize the automobile
		u.serializeAuto(FordZTW);

		Automobile newFordZTW = u.deserializeAuto("auto.ser");
		System.out.println("The result of deserialization" + "\n");
		newFordZTW.print();

	}

}
