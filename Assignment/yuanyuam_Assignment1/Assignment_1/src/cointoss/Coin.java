package cointoss;

/*
 * @Author:  Yuanyuan Ma
 * @Andrew ID : yuanyuam
 */

public class Coin {
	/*
	 * Instance variable represents the side of the coin that is facing up 
	 */
	private String sideUp;
	
	/*
	 * Coin()
	 * void constructor for initialize the side of the coin is facing up
	 */

	public Coin(){
		toss();
	}
	
	/*
	 * toss()
	 * Method that randomly determines the side of the coin that is facing up 
	 */
	public void toss(){
		double random = Math.random();
		if (random > 0.5) {
			this.sideUp = "heads";
		}else {
			this.sideUp = "tails";
		}
	}
	
	
	/*
	 * Method that shows the side of the coin that is facing up 
	 */
	public String getSideUp(){
		return sideUp;
	}
}
