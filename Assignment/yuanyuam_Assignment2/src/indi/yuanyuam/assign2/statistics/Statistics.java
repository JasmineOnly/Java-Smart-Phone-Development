package indi.yuanyuam.assign2.statistics;

import indi.yuanyuam.assign2.abstractclass.*;
import indi.yuanyuam.assign2.student.Student;
import indi.yuanyuam.assign2.interfaces.*;

/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 */

public class Statistics extends Stat implements Printer {
	// Instance variables
	private final int QUIZNUM = 5;// The number of quizs
	private int[] lowscores = new int[QUIZNUM];
	private int[] highscores = new int[QUIZNUM];
	private float[] avgscores = new float[QUIZNUM];

	/*
	 * Method to find the highest score over all students' scores
	 * @see indi.yuanyuam.assign2.abstractclass.Stat#findHigh(indi.yuanyuam.assign2.student.Student[])
	 */
	public void findHigh(Student[] s) {
		if (s[0] == null) {
			return;
		}

		// Initialize the array 
		int[] tempScore = new int[highscores.length];
		for (int i = 0; i < highscores.length; i++) {
			highscores[i] = s[0].getScore()[i];
			tempScore[i] = s[0].getScore()[i];
		}

		// Find the highest score for each quiz
		for (int j = 1; j < s.length; j++) {
			if (s[j] == null)
				return;
			for (int i = 0; i < QUIZNUM; i++) {
				tempScore[i] = s[j].getScore()[i];
				if (highscores[i] < tempScore[i]) {
					highscores[i] = tempScore[i];
				}
			}
		}

	}

	/*
	 * Method to find the lowest score over all students' scores
	 * @see indi.yuanyuam.assign2.abstractclass.Stat#findLow(indi.yuanyuam.assign2.student.Student[])
	 */
	public void findLow(Student[] s) {
		if (s[0] == null) {
			return;
		}

		// Initialize the array 
		int[] tempScore = new int[lowscores.length];
		for (int i = 0; i < lowscores.length; i++) {
			lowscores[i] = s[0].getScore()[i];
			tempScore[i] = s[0].getScore()[i];
		}

		// Find the lowest score for each quiz
		for (int j = 1; j < s.length; j++) {
			if (s[j] == null)
				return;
			for (int i = 0; i < QUIZNUM; i++) {
				tempScore[i] = s[j].getScore()[i];
				if (lowscores[i] > tempScore[i]) {
					lowscores[i] = tempScore[i];
				}
			}
		}

	}
	

	/*
	 * Method to find the average score over all students' scores
	 * @see indi.yuanyuam.assign2.abstractclass.Stat#findAvg(indi.yuanyuam.assign2.student.Student[])
	 */
	public void findAvg(Student[] s) {
		if (s[0] == null) {
			return;
		}

		for (int i = 0; i < avgscores.length; i++) {
			avgscores[i] = 0;
		}

		// Instance variable to record the number of students
		int count = 0;
		
		for (int i = 0; i < s.length; i++) {
			if (s[i] == null) {
				break;
			}
			for (int j = 0; j < QUIZNUM; j++) {
				avgscores[j] += s[i].getScore()[j];
			}
			
			count ++;
		}

		for (int i = 0; i < QUIZNUM; i++) {
			avgscores[i] = avgscores[i] / count;
		}

	}

	// Method to print the highest score, lowest score and average score
	// This method is overridden from the method in interface Printer
	public void toPrint() {
		System.out.print("High Score");
		for (int i = 0; i < highscores.length; i++) {
			System.out.print("\t" + highscores[i]);
		}
		System.out.println();

		System.out.print("Low Score");
		for (int i = 0; i < lowscores.length; i++) {
			System.out.print("\t" + lowscores[i]);
		}
		System.out.println();

		System.out.print("Average\t");
		for (int i = 0; i < avgscores.length; i++) {
			System.out.print("\t" + String.format("%.1f", avgscores[i]));
		}
		System.out.println();

	}

}
