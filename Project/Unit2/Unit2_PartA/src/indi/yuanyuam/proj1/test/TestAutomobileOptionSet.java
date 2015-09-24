package indi.yuanyuam.proj1.test;

import indi.yuanyuam.proj1.exception.AutoException;
import indi.yuanyuam.proj1.model.Automobile;
import indi.yuanyuam.proj1.util.Util;

public class TestAutomobileOptionSet {
	public static void main(String[] args) throws AutoException{
		Util u = new Util();
		Automobile FordZTW = u.buildAutoObject("FocusWagonZTW.txt");
		System.out.println("Read in a car information");
		FordZTW.print();
		System.out.println("\n");
		
		System.out.println("*** Part1: tests for method to get option set list size***");
		System.out.println("Option set list size is " + FordZTW.getOptionSetListSize());
		
		System.out.println("\n");
		System.out.println("*** Part2: tests for setters for option set ***");
		FordZTW.setOptionSet("NewOptionSet", 1);
		FordZTW.printAllOptionSet();
		
		System.out.println("\n");
		System.out.println("*** Part3: tests for delete method for option set ***");
		FordZTW.deleteOptionSet("Test Optionset set method");
		FordZTW.printAllOptionSet();
		
		System.out.println("\n");
		System.out.println("*** Part4: tests for update method for option set ***");
		FordZTW.updateOptionSetName("Power Moonroof", "New name");
		FordZTW.printAllOptionSet();

	}
	

}
