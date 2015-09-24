package indi.yuanyuam.proj1.exception;

import java.io.*;
import java.util.*;
import java.sql.Timestamp;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public class AutoException extends Exception {

	private static final long serialVersionUID = 1L;

	private int errno;
	private String name;

	public AutoException(ExceptionEnum e) {
		errno = e.getNum();
		name = e.toString();
	}

	// Getter for errno
	public int getErrno() {
		return errno;
	}

	// Getter for name
	public String getName() {
		return name;
	}

	public String toString() {
		String s = errno + " " + name;
		return s;
	}

	
}
