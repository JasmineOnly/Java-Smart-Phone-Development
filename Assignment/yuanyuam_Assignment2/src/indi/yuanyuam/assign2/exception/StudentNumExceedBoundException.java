package indi.yuanyuam.assign2.exception;

import java.io.IOException;

/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 */

public class StudentNumExceedBoundException extends IOException{
	/*
	 * StudentNumExceedBoundException constructor passing error message to IOException constructor
	 **/
	private static final long serialVersionUID = 1L;

	public StudentNumExceedBoundException() {
		super();
	}
	
	public StudentNumExceedBoundException(String mes){
		super(mes);
		
	}
}
