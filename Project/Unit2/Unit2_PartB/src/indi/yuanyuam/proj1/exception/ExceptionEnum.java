package indi.yuanyuam.proj1.exception;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public enum ExceptionEnum {
	FileNotFound(1), CarModelNotFound(2), FileMissBasePrice(3),  OptionSetNotFound(4), FileMissOptionPrice(5) ;
	private int num;
	
	// Constructor with parameter
	private ExceptionEnum(int num){
		this.num = num;
	}
	
	// Getter for num
	public int getNum() {
		return num;
	}

	// Setter for num
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
