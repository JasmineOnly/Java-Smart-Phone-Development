package indi.yuanyuam.assign2.test;

import indi.yuanyuam.assign2.student.Student;

/*
 * Author : Yuanyuan Ma
 * Andrew ID : yuanyuam
 */


public class TestStudent {
	public static void main (String[] args){
		Student s = new Student();
		
		// Test the getter and setter for idNum
		System.out.println("**** Test1: Getter and Setter for student ID number (Input: 1234) ****");
		s.setIdNum(1234);
		System.out.println("Test output : ");
		System.out.println("This student ID Number is : " + s.getIdNum() + "\n");
		
		// Test the getter and setter for scores
		System.out.println("**** Test2: Getter and Setter for scores (Input:{10,20,30,40,50}) ****");
		int[] score = {10,20,30,40,50};
		s.setScore(score);
		int[] score_re = s.getScore();
		System.out.println("Test output : ");
		System.out.print("This student scores are : " );
		for(int i = 0; i< score_re.length; i++){
			System.out.print(score_re[i] + " ");
		}
		
		System.out.println("\n");
		
		// Test the method - toPrint
		System.out.println("**** Test3: Method toPrint ****");
		System.out.println("Test output : ");
		s.toPrint();
		System.out.println("\n");
		
		// Test the case that the input idnum is below 4 digits
		System.out.println("**** Test4: Student ID number is below 4 digits (Input: 123)  ****");
		s.setIdNum(123);
		System.out.println("Test output : ");
		s.toPrint();
		System.out.println("\n");
		
		// Test the case that the number of input scores is less 5
		System.out.println("**** Test5: The number of input scores is less 5 (Input: {11,21,31,41})  ****");
		s = new Student();
		int[] score1 = {11,21,31,41};
		s.setScore(score1);
		System.out.println("Test output : ");
		s.toPrint();
		System.out.println("\n");
		
		// Test the case that the number of input scores is more than 5
		System.out.println("**** Test6: The number of input scores is more than 5 (Input: {11,21,31,41,51,61,71}) ");
		s = new Student();
		int[] score2 = {11,21,31,41,51,61,71};
		s.setScore(score2);
		System.out.println("Test output : ");
		s.toPrint();
		
		
		
	}

}
