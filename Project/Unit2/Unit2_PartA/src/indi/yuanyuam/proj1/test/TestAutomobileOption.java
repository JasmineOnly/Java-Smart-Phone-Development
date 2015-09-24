package indi.yuanyuam.proj1.test;

import indi.yuanyuam.proj1.exception.AutoException;
import indi.yuanyuam.proj1.model.*;
import indi.yuanyuam.proj1.util.*;

public class TestAutomobileOption {
	public static void main(String[] args) throws AutoException{

	Util u = new Util();
	Automobile FordZTW = u.buildAutoObject("FocusWagonZTW.txt");
	System.out.println("Read in a car information");
	FordZTW.print();
	System.out.println("\n");
	
	
	//Test option get methods
	System.out.println("*** Part1: tests for getters for option (set the price as an example) ***");
	System.out.println("Option Price of Standard Transmission is " + FordZTW.getOptionPrice("Transmission", "Standard"));
	
	
	//Test option set methods
	System.out.println("\n");
	System.out.println("*** Part2: tests for setters for option ***");
	FordZTW.deleteOption("Transmission", "0");
	FordZTW.setOption("Transmission", "Automatic", 9999);
	
	FordZTW.print();

	
	//Test option delete methods
	System.out.println("\n");
	System.out.println("*** Part3: tests for delete methods for option ***");
	FordZTW.deleteOption("Transmission","TestSet");
	FordZTW.print();	
	
	
	//Test option update methods
	System.out.println("\n");
	System.out.println("*** Part4: tests for update methods for option ***");
	FordZTW.updateOptionPrice("Color", "CD Silver Clearcoat Metallic", 7777);
	FordZTW.printAllOptionSet();
		
	
}

}
