package indi.yuanyuam.proj1.adapter;

import indi.yuanyuam.proj1.exception.*;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public interface CreateAuto{
	// Given a text file name a method called BuildAuto can be written to build
	// an instance of Automobile.
	public void buildAuto(String filename) throws AutoException;
	
	//This function searches and prints the properties of a given Automobile.
	public void printAuto(String Modelname);
	
	

}
