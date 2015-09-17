package indi.yuanyuam.assign2.test;

import indi.yuanyuam.assign2.statistics.*;
import indi.yuanyuam.assign2.student.*;

/*
 * Author : Yuanyuan Ma
 * Andrew ID : yuanyuam
 */

public class TestStatistic {
	public static void main(String[] args) {

		// In this test, the number of records is less than Student array length
		// The input of Statistics method is the Student[10]
		// actually there only 3 records in Student[], the rest of it is equal to null.

		Statistics s = new Statistics();
		// Populate the Student array
		Student[] stu = new Student[10];

		for (int i = 0; i < 3; i++) {
			stu[i] = new Student();
		}

		stu[0].setIdNum(1234);
		int[] scores = { 10, 20, 30, 40, 50 };
		stu[0].setScore(scores);

		stu[1].setIdNum(2345);
		int[] scores1 = { 20, 30, 40, 50, 60 };
		stu[1].setScore(scores1);

		stu[2].setIdNum(3456);
		int[] scores2 = { 30, 40, 50, 60, 70 };
		stu[2].setScore(scores2);

		System.out.println("Stud\t" + "Q1\t" + "Q2\t" + "Q3\t" + "Q4\t" + "Q5");
		for (int i = 0; i < 3; i++) {
			stu[i].toPrint();
		}
		System.out.println();

		// Test the Statistics class by checking the outputs whether are as
		// expected
		s.findHigh(stu);
		s.findLow(stu);
		s.findAvg(stu);
		s.toPrint();

	}

}
