package indi.yuanyuam.proj1.model;

import indi.yuanyuam.proj1.model.OptionSet.Option;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

import java.io.Serializable;

public final class Automobile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name; // name is the combination of make and model
	private String make;
	private String model;
	private float basePrice;
	private OptionSet[] optionSetList;
	
	// Constructor with no parameter
	public Automobile() {

	}
	
	// Constructor with parameters
	public Automobile(String make, String model, float basePrice,
			int OptionSetSize) {
		this.make = make;
		this.model = model;
		this.name = make + " " + model;
		this.basePrice = basePrice;
		this.optionSetList = new OptionSet[OptionSetSize];
	}

	// Getter for name
	public String getName() {
		name = make + " " + model;
		return name;
	}
	
	// Getter and Setter for make
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}

	// Getter and Setter for model
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	// Getter and Setter for basePrice
	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	
	// Method to print the basic information of the car
	public void printBaseInfo() {
		System.out.println(this.getName());
		System.out.println("Base Price :"
				+ String.format("%.2f", this.getBasePrice()));
		System.out.println();
	}
	
	
	/********************** OptionSet *************************/
	// Getter for OptionSet size
	public int getOptionSetListSize() {
		return optionSetList.length;
	}
	
	// Method to get the OptionSet according to the index
	protected OptionSet getOptionSet(int index) {
		if (index < optionSetList.length && index >= 0) {
			if (optionSetList[index] != null) {
				return optionSetList[index];
			}
		}
		return null;

	}
	
	// Method to get the Optionset according to the name
	protected OptionSet getOptionSet(String setName) {
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i] != null) {
				if (optionSetList[i].getOptionSetName().equals(setName)) {
					return optionSetList[i];
				}
			}
		}
		return null;
	}
	
	// Setter for OptionSet
	public void setOptionSet(String setName, int optionSize) {
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i] == null) {
				optionSetList[i] = new OptionSet(setName, optionSize);
				return;
			}
		}
	}

	public void setOptionSet(int index, String setName, int optionSize) {
		optionSetList[index] = new OptionSet(setName, optionSize);
	}

	// Method to delete the OptionSet
	public void deleteOptionSet(int index) {
		if (index < optionSetList.length && index >= 0) {
			if (optionSetList[index] != null) {
				optionSetList[index] = null;
			}
		}
	}

	public void deleteOptionSet(String setName) {
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i] != null) {
				if (optionSetList[i].getOptionSetName().equals(setName)) {
					optionSetList[i] = null;
				}
			}
		}
	}
	
	// Methods to update OptionSet
	public void updateOptionSet(String setName, int optionSize) {
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i] != null) {
				if (optionSetList[i].getOptionSetName().equals(setName)) {
					optionSetList[i] = new OptionSet(setName, optionSize);
					return;
				}
			}
		}
	}

	public void updateOptionSet(int index, String setName, int optionSize) {
		if (index < optionSetList.length && index >= 0) {
			optionSetList[index] = new OptionSet(setName, optionSize);
		}
	}

	public void updateOptionSetName(String setName, String newSetName) {
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i] != null) {
				if (optionSetList[i].getOptionSetName().equals(setName)) {
					optionSetList[i].setOptionSetName(newSetName);
					return;
				}
			}
		}
	}

	public void updateOptionSetName(int index, String newSetName) {
		if (index < optionSetList.length && index >= 0) {
			if (optionSetList[index] != null) {
				optionSetList[index].setOptionSetName(newSetName);
			}
		}
	}
	// Method to print optionSet
	public void printAllOptionSet() {
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i] != null) {
				System.out.println(optionSetList[i].getOptionSetName() + ":");
				optionSetList[i].printAllOptions();
				System.out.println();
			}
			else{
				System.out.println("Option Set Not Exist or Deleted");
				System.out.println();
			}
			
		}
	}
	/***************** Option ******************/
	
	/*
	 *  Methods to get Option based on different references, including (setName, optionName)
	 *  (setName, optionIndex), (setIndex, optionName), (setIndex, optionIndex)
	 */
	protected Option getOption(String setName, String optionName) {
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i] != null) {
				if (optionSetList[i].getOptionSetName().equals(setName)) {
					return optionSetList[i].getOption(optionName);
				}
			}
		}
		return null;
	}

	protected Option getOption(String setName, int optionIndex) {
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i] != null) {
				if (optionSetList[i].getOptionSetName().equals(setName)) {
					return optionSetList[i].getOption(optionIndex);
				}
			}
		}
		return null;
	}
	protected Option getOption(int setIndex, String optionName) {
		if (setIndex < optionSetList.length && setIndex >= 0) {
			if (optionSetList[setIndex] != null) {
				return optionSetList[setIndex].getOption(optionName);
			}
		}
		return null;
	}

	protected Option getOption(int setIndex, int optionIndex) {
		if (setIndex < optionSetList.length && setIndex >= 0) {
			if (optionSetList[setIndex] != null) {
				return optionSetList[setIndex].getOption(optionIndex);
			}
		}
		return null;
	}
	
	/*
	 *  Methods to get Option price based on different references, including (setName, optionName)
	 *  (setName, optionIndex), (setIndex, optionName), (setIndex, optionIndex)
	 */

	public float getOptionPrice(String setName, String optionName) {
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i] != null) {
				if (optionSetList[i].getOptionSetName().equals(setName)) {
					return optionSetList[i].getOption(optionName).getPrice();
				}
			}
		}
		return 0;
	}

	public float getOptionPrice(String setName, int optionIndex) {
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i] != null) {
				if (optionSetList[i].getOptionSetName().equals(setName)) {
					return optionSetList[i].getOption(optionIndex).getPrice();
				}
			}
		}
		return 0;
	}

	

	public float getOptionPrice(int setIndex, String optionName) {
		if (setIndex < optionSetList.length && setIndex >= 0) {
			if (optionSetList[setIndex] != null) {
				return optionSetList[setIndex].getOption(optionName).getPrice();
			}
		}
		return 0;
	}

	public float getOptionPrice(int setIndex, int optionIndex) {
		if (setIndex < optionSetList.length && setIndex >= 0) {
			if (optionSetList[setIndex] != null) {
				return optionSetList[setIndex].getOption(optionIndex)
						.getPrice();
			}
		}
		return 0;
	}
	
	//Setter for option
	public void setOption(String setName, String optionName, float price) {
		if (getOptionSet(setName) != null) {
			getOptionSet(setName).setOption(optionName, price);
		}

	}

	public void setOption(int setIndex, int optionIndex, String optionName,
			float price) {
		if (getOptionSet(setIndex) != null) {
			optionSetList[setIndex].setOption(optionIndex, optionName, price);
		}
	}

	// Method to delete option
	public void deleteOption(String setName, String optionName) {
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i] != null) {
				if (optionSetList[i].getOptionSetName().equals(setName)) {
					optionSetList[i].deleteOption(optionName);
				}
			}
		}
	}

	public void deleteOption(int setIndex, String optionName) {
		if (setIndex < optionSetList.length && setIndex >= 0) {
			if (optionSetList[setIndex] != null) {
				optionSetList[setIndex].deleteOption(optionName);
			}
		}
	}

	public void deleteOption(String setName, int optionIndex) {
		for (int i = 0; i < optionSetList.length; i++) {
			if (optionSetList[i] != null) {
				if (optionSetList[i].getOptionSetName().equals(setName)) {
					optionSetList[i].deleteOption(optionIndex);
				}
			}
		}
	}

	public void deleteOption(int setIndex, int optionIndex) {
		if (setIndex < optionSetList.length && setIndex >= 0) {
			if (optionSetList[setIndex] != null) {
				optionSetList[setIndex].deleteOption(optionIndex);
			}
		}
	}
	
	/*
	 * Method to update option name based on different references, including (setName, optionName)
	 *  (setName, optionIndex), (setIndex, optionName), (setIndex, optionIndex)
	 */
	public void updateOptionName(String setName, String optionName,
			String newOptionName) {
		if (getOptionSet(setName) != null) {
			getOptionSet(setName).updateOptionName(optionName, newOptionName);
		}
	}

	public void updateOptionName(String setName, int optionIndex,
			String newOptionName) {
		if (getOptionSet(setName) != null) {
			getOptionSet(setName).updateOptionName(optionIndex, newOptionName);
		}
	}

	public void updateOptionName(int setIndex, String optionName,
			String newOptionName) {
		if (getOptionSet(setIndex) != null) {
			getOptionSet(setIndex).updateOptionName(optionName, newOptionName);
		}
	}

	public void updateOptionName(int setIndex, int optionIndex,
			String newOptionName) {
		if (getOptionSet(setIndex) != null) {
			getOptionSet(setIndex).updateOptionName(optionIndex, newOptionName);
		}
	}
	
	/*
	 * Method to update option price based on different references, including (setName, optionName)
	 *  (setName, optionIndex), (setIndex, optionName), (setIndex, optionIndex)
	 */
	public void updateOptionPrice(String setName, String optionName, float price) {
		if (getOptionSet(setName) != null) {
			getOptionSet(setName).updateOptionPrice(optionName, price);
		}
	}

	public void updateOptionPrice(String setName, int optionIndex, float price) {
		if (getOptionSet(setName) != null) {
			getOptionSet(setName).updateOptionPrice(optionIndex, price);
		}
	}

	public void updateOptionPrice(int setIndex, String optionName, float price) {
		if (getOptionSet(setIndex) != null) {
			getOptionSet(setIndex).updateOptionPrice(optionName, price);
		}
	}

	public void updateOptionPrice(int setIndex, int optionIndex, float price) {
		if (getOptionSet(setIndex) != null) {
			getOptionSet(setIndex).updateOptionPrice(optionIndex, price);
		}
	}

	/******** Printer **********/
	public void print() {
		this.printBaseInfo();
		this.printAllOptionSet();
	}
	


}
