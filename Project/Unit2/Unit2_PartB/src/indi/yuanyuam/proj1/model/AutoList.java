package indi.yuanyuam.proj1.model;

import java.util.LinkedHashMap;
import indi.yuanyuam.proj1.util.*;
import indi.yuanyuam.proj1.exception.*;

public class AutoList {
	private static LinkedHashMap<String, Automobile> autoList;

	// Constructor with no parameter
	public AutoList() {
		autoList = new LinkedHashMap<String, Automobile>();
	}

	/****** Automobile ******/
	// Setter for Automobile list
	public void setAutoList(Automobile auto) {
		autoList.put(auto.getName(), auto);
	}

	// Getter for Automobile
	public Automobile getAutomobile(String modelName) {
		return autoList.get(modelName);
	}

	// Setter for Automobile
	public void setAuto(String filename) throws AutoException {
		Automobile auto = new Util().buildAutoObject(filename);
		setAutoList(auto);
	}

	// Method to delete the Automobile
	public void deleteAutomoble(String modelName) {
		autoList.remove(modelName);
	}

	/****** OptionSet ******/
	// Method to update the OptionSetName
	public void updateOptionSetName(String modelName, String optionSetName,
			String newName) throws AutoException {
		Automobile auto = autoList.get(modelName);
		if (auto != null) {
			auto.updateOptionSetName(optionSetName, newName);
			autoList.put(modelName, auto);
		} else {
			throw new AutoException(ExceptionEnum.CarModelNotFound);
		}
	}

	/****** Option ******/
	// Method to update the Option Price
	public void updateOptionPrice(String ModelName, String setname,
			String optionname, int price) throws AutoException {
		Automobile auto = autoList.get(ModelName);
		if (auto != null) {
			auto.updateOptionPrice(setname, optionname, price);
			autoList.put(ModelName, auto);
		} else {
			throw new AutoException(ExceptionEnum.CarModelNotFound);
		}
	}

}
