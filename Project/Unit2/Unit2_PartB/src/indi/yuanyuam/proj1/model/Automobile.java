package indi.yuanyuam.proj1.model;

import indi.yuanyuam.proj1.model.OptionSet.Option;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

import java.io.Serializable;
import java.util.ArrayList;

public final class Automobile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int basePrice;
	private ArrayList<OptionSet> optionSetList;
	private ArrayList<Option> choice;

	// Constructor with no parameter
	public Automobile() {

	}

	// Constructor with parameters
	public Automobile(String name, int basePrice) {
		this.name = name;
		this.basePrice = basePrice;
		this.optionSetList = new ArrayList<OptionSet>();
		this.choice = new ArrayList<Option>();

	}

	// Getter and Setter for name
	public String getName() {
		return name;
	}	

	// Getter and Setter for basePrice
	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	// Method to print the basic information of the car
	public void printBaseInfo() {
		System.out.println(this.getName());
		System.out.println("Base Price :"
				+  this.getBasePrice());
		System.out.println();
	}

	/********************** OptionSet *************************/
	// Getter for OptionSet size
	public int getOptionSetListSize() {
		return optionSetList.size();
	}

	// Method to get the Optionset according to the name
	protected OptionSet getOptionSet(String setName) {
		for (OptionSet optset : optionSetList) {
			if (optset.getOptionSetName().equals(setName)) {
				return optset;
			}

		}
		return null;
	}

	// Setter for OptionSet
	public void setOptionSet(String setName) {
		optionSetList.add(new OptionSet(setName));
	}

	// Method to delete the OptionSet
	public void deleteOptionSet(String setName) {
		for (OptionSet optset : optionSetList) {
			if (optset.getOptionSetName().equals(setName)) {
				optionSetList.remove(optset);
			}
		}
	}

	// Methods to update OptionSet
	public void updateOptionSetName(String setName, String newname) {
		for (OptionSet optset : optionSetList) {
			if (optset.getOptionSetName().equals(setName)) {
				optset.setOptionSetName(newname);
				return;
			}
		}
	}

	// Method to print optionSet
	public void printAllOptionSet() {
		for (OptionSet optset : optionSetList) {
			System.out.println(optset.getOptionSetName() + ":");
			optset.printAllOptions();
			System.out.println();
		}
	}

	/***************** Option *****************/

	// Methods to get Option
	protected Option getOption(String setName, String optionName) {
		for (OptionSet optset : optionSetList) {
			if (optset.getOptionSetName().equals(setName)) {
				return optset.getOption(optionName);
			}
		}
		return null;
	}

	// Methods to get Option price
	public float getOptionPrice(String setName, String optionName) {
		for (OptionSet optset : optionSetList) {
			if (optset.getOptionSetName().equals(setName)) {
				return optset.getOptionPrice(optionName);
			}
		}
		return 0;
	}

	
	// Setter for option
	public void setOption(String setName, String optionName, int price) {
			getOptionSet(setName).setOption(optionName, price);
		}

	// Method to delete option
	public void deleteOption(String setName, String optionName) {
		if (getOptionSet(setName) != null){
		getOptionSet(setName).deleteOption(optionName);
		}
	}


	 // Method to update option price 	
	public void updateOptionPrice(String setName, String optionName, int price) {
		if (getOptionSet(setName) != null) {
			getOptionSet(setName).updateOptionPrice(optionName, price);
		}
	}


	/******** Printer **********/
	public void print() {
		this.printBaseInfo();
		this.printAllOptionSet();
	}
	
	/******** Choice *********/
	// Getter for choice name
	public String getOptionChoice(String setName) {
		return getOptionSet(setName).getChoiceName();
	}
	
	// Getter for choice price
	public int getOptionChoicePrice(String setName){
		return getOptionSet(setName).getChoicePrice();
	}
	
	// Setter for option choice
	public void setOptionChoice(String setName, String optionName){
		OptionSet optset = getOptionSet(setName);
		choice.add(optset.getOption(optionName));
		optset.setChoice(optionName);
		
	}
	
	// Method to get the total price
	public int getTotalPrice() {
		int sum = basePrice;
		for (Option opt : choice) {
			sum += opt.getPrice();
		}
		return sum;
	}
	
	// Method to print choice
	public void printChoice() {
		for (Option opt : choice) {
			System.out.println("Option : " + opt.getName() + "Price : "
					+ opt.getPrice());
		}
	}
	


}
