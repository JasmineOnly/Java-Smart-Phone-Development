package indi.yuanyuam.proj1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import indi.yuanyuam.proj1.model.*;

public class SelectCarOption {
	/**
	 * Allows the user to select a model according to the list provided
	 * 
	 * @param autoNameList
	 * @return
	 */
	public String selectCar(ArrayList<String> autoNameList) {
		String fromUser = "";
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(
				System.in));

		// print all available list
		System.out.println("Auto Model Options :");
		for (int i = 0; i < autoNameList.size(); i++) {
			System.out.println("Model " + i + " : " + autoNameList.get(i));
		}

		// choose a car to configure
		System.out.println("Select a number of model to configure");
		try {
			// read in a automobile name index
			fromUser = stdIn.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (!fromUser.matches("[0-9]+") || Integer.parseInt(fromUser) < 0
				|| Integer.parseInt(fromUser) > autoNameList.size() - 1) {
			System.out.println("please input a legal number");
			try {
				fromUser = stdIn.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		int configureAutoIndex = Integer.parseInt(fromUser);
		String modelName = autoNameList.get(configureAutoIndex);

		return modelName;
	}

	/**
	 * allow the user to enter its respective options.
	 * Display the selected options for a class.
	 * 
	 * @param selectedAuto
	 */
	public void configureCarChoice(Automobile selectedAuto) {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(
				System.in));// for client input
		String fromUser = null;// for save client input
		for (int i = 0; i < selectedAuto.getOptionSetListSize(); i++) {
			String optionSetName = selectedAuto.printOptionSetName(i);
			System.out.println(optionSetName);
			selectedAuto.printOption(optionSetName);

			System.out.println("select your choice for " + "(" + optionSetName
					+ ")");

			try {
				fromUser = stdIn.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// filter illegal input
			while (!fromUser.matches("[0-9]+")
					|| Integer.parseInt(fromUser) < 0
					|| Integer.parseInt(fromUser) > selectedAuto
							.getOptionListSize(optionSetName) - 1) {
				System.out.println("please input a legal number");
				try {
					fromUser = stdIn.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			// get the legal index of this option choice in option array of
			// option
			// in option set
			int optionIndex = Integer.parseInt(fromUser);

			System.out.println();
			selectedAuto.setOptionChoice(optionSetName, optionIndex);

		}
	}

}
