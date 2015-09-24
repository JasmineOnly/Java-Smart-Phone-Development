package indi.yuanyuam.proj1.driver;

import indi.yuanyuam.proj1.adapter.*;
import indi.yuanyuam.proj1.exception.AutoException;
import indi.yuanyuam.proj1.util.*;
import indi.yuanyuam.proj1.model.*;
;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public class Driver{
	public static void main(String[] args) throws AutoException{
		BuildAuto ba = new BuildAuto();
		
		ba.buildAuto("FocusWagonZTW.txt");		
		ba.printAuto("Focus Wagon ZTW");	
		
		System.out.println("********  Test Update Methods *********\n" );

		ba.updateOptionSetName("Focus Wagon ZTW", "Color","New Color");
		ba.updateOptionPrice("Focus Wagon ZTW", "Transmission",
				"Automatic", 1000);
		ba.printAuto("Focus Wagon ZTW");
		
		System.out.println("********  Test Choice *********\n" );
		Automobile auto = new Util().buildAutoObject("FocusWagonZTW.txt");
		auto.setOptionChoice("Color", "Fort Knox Gold Clearcoat Metallic");
		auto.setOptionChoice("Transmission", "Standard");
		auto.setOptionChoice("Brakes/Traction Control", "ABS");
		auto.setOptionChoice("Side Impact Airbags", "Selected");
		auto.setOptionChoice("Power Moonroof", "Selected");
		System.out.println("Base price is : " + auto.getBasePrice());
		auto.printChoice();
		System.out.println("The total price is " + auto.getTotalPrice());
		System.out.println(" ");
		
		
		
		
		
		
		
		
	}
	

}
