package indi.yuanyuam.assign2.test;

import java.io.IOException;
import indi.yuanyuam.assign2.util.Util;
import indi.yuanyuam.assign2.exception.StudentNumExceedBoundException;
import indi.yuanyuam.assign2.exception.StudentScoreNumException;
import indi.yuanyuam.assign2.student.Student;

/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 */
public class TestUtil {
	public static void main(String[] args) {

		Student[] lab = new Student[40];

		// Test1: Input data has 15 records
		System.out.println("Test1: Input data has 15 records" + "/n");
		// Populate the student array
		lab = Util.readFile("StudentData.txt", lab);
		//If the input data is not empty, there will print the scores
		//If the input data has more than 40 records, there will only print the top 40 records
		if (lab[0] != null) {
			System.out.println("Stud\t" + "Q1\t" + "Q2\t" + "Q3\t" + "Q4\t"
					+ "Q5");
			for (int i = 0; i < lab.length; i++) {
				if (lab[i] == null)
					break;
				lab[i].toPrint();
			}
		} else {
			System.out.println("There is no record!");
		}
		System.out.println(" ");
		

		// Test2 : Input data has 0 record
		lab = new Student[40];// reset Student array
		System.out.println("Test2 : Input data has 0 record" + "/n");
		lab = Util.readFile("StudentData1.txt", lab);
		//If the input data is not empty, there will print the scores
		//If the input data has more than 40 records, there will only print the top 40 records
		if (lab[0] != null) {
			System.out.println("Stud\t" + "Q1\t" + "Q2\t" + "Q3\t" + "Q4\t"
					+ "Q5");
			for (int i = 0; i < lab.length; i++) {
				if (lab[i] == null)
					break;
				lab[i].toPrint();
			}
		} else {
			System.out.println("There is no record!");
		}
		System.out.println(" ");
		

		// Test3: Input data has more than 40 records
		lab = new Student[40];
		System.out.println("Test3: Input data has more than 40 records" + "\n");
		lab = Util.readFile("StudentData2.txt", lab);
		//If the input data is not empty, there will print the scores
		//If the input data has more than 40 records, there will only print the top 40 records
		if (lab[0] != null) {
			System.out.println("Stud\t" + "Q1\t" + "Q2\t" + "Q3\t" + "Q4\t"
					+ "Q5");
			for (int i = 0; i < lab.length; i++) {
				if (lab[i] == null)
					break;
				lab[i].toPrint();
			}
		} else {
			System.out.println("There is no record!");
		}
		System.out.println(" ");
	
		// Test4: Input data has 40 records
		lab = new Student[40];
		System.out.println("Test4: Input data has 40 records" + "\n");
		lab = Util.readFile("StudentData3.txt", lab);
		//If the input data is not empty, there will print the scores
		//If the input data has more than 40 records, there will only print the top 40 records
		if (lab[0] != null) {
			System.out.println("Stud\t" + "Q1\t" + "Q2\t" + "Q3\t" + "Q4\t"
					+ "Q5");
			for (int i = 0; i < lab.length; i++) {
				if (lab[i] == null)
					break;
				lab[i].toPrint();
			}
		} else {
			System.out.println("There is no record!");
		}

	}

}
