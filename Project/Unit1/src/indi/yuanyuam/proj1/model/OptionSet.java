package indi.yuanyuam.proj1.model;

import java.io.Serializable;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

class OptionSet implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Option opt[];
	
	// Constructor with parameters
	protected OptionSet(String name, int size){
		this.name = name;
		opt = new Option[size];
	}
	
	// Constructor with no parameter
	protected OptionSet(){
		
	}
	
	// Getters and Setters for OptionSet name
	
	protected String getOptionSetName(){
		return name;
	}
	
	protected void setOptionSetName(String name){
		this.name = name;
	}
	
	// Getter for option list size
	protected int getOptionListSize() {
		return opt.length;
	}
	
	// Getter for options
	protected Option getOption(String optionName) {
		for (int i = 0; i < opt.length; i++) {
			if (opt[i] != null) {
				if (opt[i].getName().equals(optionName)) {
					return opt[i];
				}
			}
		}
		return null;
	}
	
	
	protected Option getOption(int index) {
		if (index < opt.length && index >= 0) {
			if (opt[index] != null) {
				return opt[index];
			}
		}
		return null;
	}
	
	//Setters for option
	protected void setOption(int index, String optionName, float price) {
		if (index < opt.length && index >= 0) {
				opt[index] = new Option(optionName, price);
		}
	}
	
	protected void setOption(String optionName, float price) {
		for (int i = 0; i < opt.length; i++) {
			if (opt[i] == null) {
				opt[i] = new Option(optionName, price);
				return;
			}
		}
	}
	
	// Methods to delete option
	protected void deleteOption(String optionName) {
		for (int i = 0; i < opt.length; i++) {
			if (opt[i] != null) {
				if (opt[i].getName().equals(optionName)) {
					opt[i] = null;
				}
			}
		}
	}
	protected void deleteOption(int index) {
		if (index < opt.length && index >= 0) {
			if (opt[index] != null) {
				opt[index] = null;
			}
		}
	}
	
	// Method to update the option name according to option name or index
	protected void updateOptionName(String optionName,String newOptionName) {
		if (getOption(optionName) == null) {
			return;
		} else {
			getOption(optionName).setName(newOptionName);
		}
	}

	protected void updateOptionName(int index,String newOptionName) {
		if (getOption(index) == null) {
			return;
		} else {
			getOption(index).setName(newOptionName);
		}
	}
	
	// Method to update the option price according to option name or index
	protected void updateOptionPrice(String optionName,float price) {
		if (getOption(optionName) == null) {
			return;
		} else {
			getOption(optionName).setPrice(price);
		}
	}

	protected void updateOptionPrice(int index,float price) {
		if (getOption(index) == null) {
			return;
		} else {
			getOption(index).setPrice(price);
		}
	}
	
	// Method to print all options
	protected void printAllOptions(){
		for (int i = 0; i < opt.length; i++) {
			if (opt[i] != null) {
				System.out.println(opt[i].getName()+":Price "+String.format("%.2f", opt[i].getPrice()));
			}
			else{
				System.out.println("Option Not Exist or Deleted");
			}
			
		}
	}
	
	/********* Option **********/
	protected class Option implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String name;
		private float price;
		
		// Constructor with no parameter
		protected Option(){
			
		}
		// Constructor with parameters
		protected Option(String name, float price) {
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
		protected float getPrice() {
			return price;
		}
		protected void setPrice(float price) {
			this.price = price;
		}
		
		
		
		
	}
	
	
	

}
