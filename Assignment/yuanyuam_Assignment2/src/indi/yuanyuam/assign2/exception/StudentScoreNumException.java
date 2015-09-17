package indi.yuanyuam.assign2.exception;

/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 **/

public class StudentScoreNumException extends Exception {
	/*
	 * StudentScoreNumException constructor passing error message to Exception constructor
	 **/
	private static final long serialVersionUID = 1L;

	public StudentScoreNumException() {
		super();
	}
	
	public StudentScoreNumException(String mes){
		super(mes);
		
	}
	
	

}
