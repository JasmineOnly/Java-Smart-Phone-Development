package indi.yuanyuam.assign2.student;

import indi.yuanyuam.assign2.abstractclass.People;
import indi.yuanyuam.assign2.exception.*;
import indi.yuanyuam.assign2.interfaces.*;

/*
 * Author : Yuanyuan Ma
 * Andrew ID : yuanyuam
 */

public class Student extends People implements Printer {
	// Instance variables for the information of one student
	private static final int QUIZNUM = 5;
	private int idNum;
	private int[] score = new int[QUIZNUM];

	// Getters and Setters for idNum
	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	// Getters and Setters for score
	public int[] getScore() {
		return score;
	}

	public void setScore(int[] score) {
		try {
			if (score.length != this.score.length) {
				throw new StudentScoreNumException("ID Number: "
						+ String.format("%04d", this.idNum) + "\n");
			} else {
				for (int i = 0; i < QUIZNUM; i++) {
					this.score[i] = score[i];
				}
			}

		} catch (StudentScoreNumException s) {
			System.out.println("Error -- " + s.toString());
			if (score.length < QUIZNUM) {
				for (int i = 0; i < score.length; i++) {
					this.score[i] = score[i];
				}
			} else {
				for (int i = 0; i < this.score.length; i++) {
					this.score[i] = score[i];
				}
			}
		}

	}

	// Method to print the student ID number and scores
	// This method is overridden from the method in interface Printer
	public void toPrint() {
		System.out.print(String.format("%04d", this.idNum));

		for (int i = 0; i < this.score.length; i++) {
			System.out.print("\t" + String.format("%03d", this.score[i]));
		}

		System.out.println(" ");

	}

}
