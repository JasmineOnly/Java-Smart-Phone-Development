package indi.yuanyuam.assign2.util;

import java.io.*;
import java.util.StringTokenizer;
import indi.yuanyuam.assign2.student.*;
import indi.yuanyuam.assign2.exception.*;

/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 */

public class Util {
	private static final int QUIZNUM = 5;// Instance variable represents the
											// number of quiz;
	private static final int MAXSTUDENTNUM = 40;// Instance variable the maximum
												// number of records.

	// Method to read the file and build student array.
	public static Student[] readFile(String filename, Student[] s) {	
		
		BufferedReader in = null;
		String line = null;
		int stuCount = 0;

		try {
			// Open the file using FileReader Object.
			File f = new File(filename);
			in = new BufferedReader(new FileReader(f));

			// Instance variable representing the end of file
			boolean eof = false;

			// Skip the first line as it's the chat title
			line = in.readLine();
			if (line == null) {
				eof = true;
			}

			// In a loop read a line using readLine method.
			while (!eof) {
				line = in.readLine();

				if (line == null) {
					eof = true;
					break;
				}

				int[] scores = new int[QUIZNUM];
				int count = 0;
				int id = 0;

				if (stuCount < MAXSTUDENTNUM) {
					// Tokenize each line using StringTokenizer Object
					StringTokenizer st = new StringTokenizer(line);

					// Get student ID
					id = Integer.parseInt(st.nextToken());

					// Get scores
					while (st.hasMoreElements()) {
						scores[count] = Integer.parseInt(st.nextToken());
						count++;
					}

					// Value is then saved in the right property of Student
					// Object.
					s[stuCount] = new Student();
					s[stuCount].setIdNum(id);
					s[stuCount].setScore(scores);

					stuCount++;
				} else {
					// Throw StudentNumExceedBoundException when input line
					// numbers > MAXSTUDENTNUM

					throw new StudentNumExceedBoundException(
							"The input has more than 40 records");

				}
			}

		} catch (StudentNumExceedBoundException sn) {
			System.out.println("The input has more than 40 records" + "\n");
			System.out.println("Error.. " + sn.toString() + "\n");
			// sn.printStackTrace();

		} catch (IOException e) {
			System.out.println("This is a IOException" + "\n");
			System.out.println("Error.. " + e.toString() + "\n");
			// e.printStackTrace();
		} finally {
			try {
				in.close();

			} catch (IOException ie) {
				System.out.println("The BufferedReader is not closed");
				System.out.println("Error.." + ie.toString());
				// ie.printStackTrace();
			}

		}

		return s;

	}
}
