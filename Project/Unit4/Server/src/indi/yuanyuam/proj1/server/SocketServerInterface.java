package indi.yuanyuam.proj1.server;

/*
 * Author: Yuanyuam Ma
 * Andrew ID: yuanyuam
 */

public interface SocketServerInterface {
	// Method to open socket
	boolean openConnection();

	// Method to handle session
	void handleSession();

	// Method to close this session
	void closeSession();
}
