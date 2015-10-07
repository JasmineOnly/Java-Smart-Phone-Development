package indi.yuanyuam.proj1.driver;

import indi.yuanyuam.proj1.exception.*;
import indi.yuanyuam.proj1.adapter.*;
import indi.yuanyuam.proj1.model.*;

public class DriverException {
	public static void main(String[] args) {

		BuildAuto auto = new BuildAuto();
		System.out.println("****** Test  AutoException *******");

		auto.buildAuto("FocusWagonZTW 002.txt");
		auto.printAuto("Focus Wagon ZTW");

	}

}
