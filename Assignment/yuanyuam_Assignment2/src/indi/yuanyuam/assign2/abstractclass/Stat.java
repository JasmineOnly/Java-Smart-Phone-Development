package indi.yuanyuam.assign2.abstractclass;

import indi.yuanyuam.assign2.student.*;

/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * The is the abstract class for statistic
 */

public abstract class Stat extends Student{
	// Method to find the highest score
	public abstract void findHigh(Student[] s);
	
	//Method to find the lowest score
	public abstract void findLow(Student[] s);
	
	//Method to find the average score
	public abstract void findAvg(Student[] s);
	
	
	

}
