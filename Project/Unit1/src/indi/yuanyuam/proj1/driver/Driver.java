package indi.yuanyuam.proj1.driver;

import indi.yuanyuam.proj1.util.Util;
import indi.yuanyuam.proj1.model.Automobile;
/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public class Driver {
	public static void main(String[] args){
		//Build Automobile Object from a file.
		Util u = new Util();
        Automobile FordZTW = u.buildAutoObject("FordZTW.txt");
        
        System.out.println("********* Serialize Automobile ************" + "\n");
        FordZTW.print();
        
        // Serialize the automobile
        u.serializeAuto(FordZTW);
        
        Automobile newFordZTW = u.deserializeAuto("auto.ser");
		System.out.println("The result of deserialization" + "\n");
		newFordZTW.print();
	        
	}
	

}
