package indi.yuanyuam.assign2.driver;

import indi.yuanyuam.assign2.util.Util;
import indi.yuanyuam.assign2.student.Student;
import indi.yuanyuam.assign2.statistics.Statistics;

public class Run {
	public static void main(String[] args) {
		Student lab2[] = new Student[40];
		// Populate the student array
		lab2 = Util.readFile("StudentData.txt", lab2);
		Statistics statlab2 = new Statistics();
		statlab2.findLow(lab2);
		statlab2.findHigh(lab2);
		statlab2.findAvg(lab2);
		
		//Print the data 
		System.out.println("Stud\t" + "Q1\t" + "Q2\t" + "Q3\t" + "Q4\t" + "Q5");
		for (int i = 0; i < lab2.length && lab2[i] != null; i++) {
			lab2[i].toPrint();
		}
		System.out.println("\n");
		
		//Print the statistics
		statlab2.toPrint();
	}

}
