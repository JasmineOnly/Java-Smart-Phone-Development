package indi.yuanyuam.proj1.model;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

class OptionSet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Option> opts;
	private Option choice;

	// Constructor with parameters
	protected OptionSet(String name) {
		this.name = name;
		opts = new ArrayList<Option>();
	}

	// Constructor with no parameter
	protected OptionSet() {

	}

	// Getters and Setters for OptionSet name

	protected String getOptionSetName() {
		return name;
	}

	protected void setOptionSetName(String name) {
		this.name = name;
	}

	// Getter for option list size
	protected int getOptionListSize() {
		return opts.size();
	}

	// Getter for option
	protected Option getOption(String optionName) {
		for (Option opt : opts) {
			if (opt.getName().equals(optionName)) {
				return opt;
			}
		}
		return null;
	}

	// used for car configuration
	protected Option getOption(int index) {
		return opts.get(index);
	}

	// Getter for option price
	protected int getOptionPrice(String optionName) {
		for (Option opt : opts) {
			if (opt.getName() == optionName) {
				return opt.price;
			}
		}
		return -1;
	}

	// Setter for option
	protected void setOption(String optionName, int price) {
		opts.add(new Option(optionName, price));
	}

	// Method to delete option
	protected void deleteOption(String optionName) {
		for (Option opt : opts) {
			if (opt.getName().equals(optionName)) {
				opts.remove(opt);
			}
		}
	}

	// Method to update the option name according to option name
	protected void updateOptionName(String optionName, String newName) {
		if (getOption(optionName) == null) {
			return;
		} else {
			getOption(optionName).setName(newName);
		}
	}

	// Method to update the option price according to option name
	protected void updateOptionPrice(String optionName, int price) {
		if (getOption(optionName) == null) {
			return;
		} else {
			getOption(optionName).setPrice(price);
		}
	}

	// Method to print all options
	protected void printAllOptions() {
		for (int i = 0; i < opts.size(); i++) {
			System.out.println(i + " " + opts.get(i).getName() + ":Price "
					+ opts.get(i).getPrice());
		}

	}

	/****** Choice ******/
	// used for car configuration
	protected void setChoice(int index) {
		choice = getOption(index);
	}

	// Method to set choice
	protected void setChoice(String optionName) {
		choice = getOption(optionName);
	}

	// Method to get choice name
	protected String getChoiceName() {
		return choice.getName();
	}

	// Method to get choice price
	protected int getChoicePrice() {
		return choice.getPrice();
	}

	/********* Inner class Option **********/
	protected class Option implements Serializable {

		private static final long serialVersionUID = 1L;
		private String name;
		private int price;

		// Constructor with no parameter
		protected Option() {

		}

		// Constructor with parameters
		protected Option(String name, int price) {
			this.name = name;
			this.price = price;
		}

		// Getter and Setter for name
		protected String getName() {
			return name;
		}

		protected void setName(String name) {
			this.name = name;
		}

		// Getter and Setter for price
		protected int getPrice() {
			return price;
		}

		protected void setPrice(int price) {
			this.price = price;
		}

	}

}
