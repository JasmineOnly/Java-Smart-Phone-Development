package ParkingTicketSimulator;

/*
 * @Author:  Yuanyuan Ma
 * @Andrew ID : yuanyuam
 */

public class ParkingMeter {
	/*
	 * Instance variable of purchased parking time 
	 */	
	private int purchasedTime = 0;
	
	/*
	 * Constructor with void input
	 */
	public ParkingMeter(){
		
	}
	
	/*
	 * Constructor with input to set purchased time
	 */
	public ParkingMeter(int purchasedTime){
		if (purchasedTime >= 0) {
			this.purchasedTime = purchasedTime;
		}
	}
	
	/*
	 * Getters and Setters: Methods to get and set purchased time
	 */
	public int getPurchasedTime(){
		return purchasedTime;
	}
	
	public void setPurchasedTime(int purchasedTime){
		if (purchasedTime >= 0) {
			this.purchasedTime = purchasedTime;
		}
	}
	

}
