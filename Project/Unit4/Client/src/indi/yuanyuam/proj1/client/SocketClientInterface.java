package indi.yuanyuam.proj1.client;

public interface SocketClientInterface {
	// Method to open socket
	boolean openConnection();

	// Method to handle session
	void handleSession();

	// Method to close this session
	void closeSession();

}
