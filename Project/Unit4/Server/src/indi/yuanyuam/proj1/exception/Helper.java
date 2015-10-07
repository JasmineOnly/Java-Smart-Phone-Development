package indi.yuanyuam.proj1.exception;

import java.io.*;
import java.util.Scanner;
import indi.yuanyuam.proj1.util.*;
import indi.yuanyuam.proj1.model.*;

public class Helper {
	private static final String DEFAULTFILE = "FocusWagonZTW2.txt"; 

	// Method to fix FileMissBasePrice Exception
	public int fixFileMissBasePrice() {
		System.out
				.println("Missing the base price in test file ! Please enter the value.");
		int baseprice = 0;
		Scanner in = new Scanner(System.in);
		baseprice = in.nextInt();
		return baseprice;

	}

	// Method to fix FileMissPrice Exception
	public int fixFileMissOptionPrice() {
		System.out
				.println("Missing the option price! Please enter the value. ");
		int optionprice = 0;

		Scanner in = new Scanner(System.in);
		optionprice = in.nextInt();

		return optionprice;
	}

	// Method to fix OptionSetNotFound Exception
	public String fixOptionSetNotFound() {
		System.out.println("This option set is not found, please enter the option set name");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	// Method to fix FileNotFound Exception
	public String fixFileNotFound() {
		
			System.out.println(" File is not found! Default file has been load");
			
		return DEFAULTFILE;
	}

	// Method to fix CarModelNotFound Exception
	public String fixCarModelNotFound() {
		System.out
				.println("Missing the car model in test file ! Please enter the value.");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
