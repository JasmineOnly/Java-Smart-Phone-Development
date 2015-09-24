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
	 * As I had started part b when I saw the submission requirement (submit part A and part b separately
	 * ), should I redo the part A?
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
