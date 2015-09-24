package indi.yuanyuam.proj1.test;

import indi.yuanyuam.proj1.model.*;
import indi.yuanyuam.proj1.util.*;

public class TestAutomobileOption {
	public static void main(String[] args){

	Util u = new Util();
	Automobile FordZTW = u.buildAutoObject("FordZTW.txt");
	System.out.println("Read in a car information");
	FordZTW.print();
	System.out.println("\n");
	
	
	//Test option get methods
	System.out.println("*** Part1: tests for getters for option (set the price as an example) ***");
	System.out.println("Option Price of Standard Transmission is " + FordZTW.getOptionPrice("Transmission", "Standard"));
	System.out.println("Option Price of Standard Transmission is " + FordZTW.getOptionPrice("Transmissionl", 0));
	System.out.println("Option Price of Standard Transmission is " + FordZTW.getOptionPrice(1, "Standard"));
	System.out.println("Option Price of Standard Transmission is " + FordZTW.getOptionPrice(1, 1));
	
	//Test option set methods
	System.out.println("\n");
	System.out.println("*** Part2: tests for setters for option ***");
	FordZTW.deleteOption("Transmission", 0);
	FordZTW.setOption("Transmission", "Automatic", 9999);
	FordZTW.setOption(1, 1, "Test setOption()", 815);
	FordZTW.print();

	
	//Test option delete methods
	System.out.println("\n");
	System.out.println("*** Part3: tests for delete methods for option ***");
	FordZTW.deleteOption("Transmission","TestSet");
	FordZTW.deleteOption(1,"Standard");
	FordZTW.deleteOption("Brakes/Traction Control",0);
	FordZTW.deleteOption(2,1);
	FordZTW.print();	
	
	
	//Test option update methods
	System.out.println("\n");
	System.out.println("*** Part4: tests for update methods for option ***");
	FordZTW.updateOptionName(0, 0, "updatename0");
	FordZTW.updateOptionName("Color", 1, "updatename1");
	FordZTW.updateOptionName(0, "Infra-Red Clearcoat", "updatename2");
	FordZTW.updateOptionName("Color", "Grabber Green Clearcoat Metallic", "updatename3");
	FordZTW.updateOptionPrice(0, "Sangria Red Clearcoat Metallic", 4);
	FordZTW.updateOptionPrice("Color", 5, 5);
	FordZTW.updateOptionPrice(0, 6, 6);
	FordZTW.updateOptionPrice(0, "CD Silver Clearcoat Metallic", 7);
	FordZTW.printAllOptionSet();
		
	
}

}
