package cointoss;

/*
 * @Author:  Yuanyuan Ma
 * @Andrew ID : yuanyuam 
 * Toss 0 times 
 */

public class Simulation2 {
	public static void main(String[] args) {

		System.out.println("Simulation1:Toss the coin 0 Time (Not toss at all)" + "\n");

		/*
		 * Instances variables
		 */
		int tossTimes = 0; // total toss number
		int headsTimes = 0; // total number of heads
		int tailsTimes = 0; // total number of tails

		// Instance class of coin
		Coin testCoin = new Coin();

		// display the initial facing up
		System.out.println("The side that the coin is initially facing up: " + testCoin.getSideUp()
				+ "\n");

		// toss 0 times, display the facing up side each time
		for (int count = 0; count < tossTimes; count++) {
			testCoin.toss();
			System.out.println("The side of the coin that is facing up is : "
					+ testCoin.getSideUp());
			if (testCoin.getSideUp().equals("heads")) {
				headsTimes++;
			} else {
				tailsTimes++;
			}
		}
		
		System.out.println(" ");
		
		if (tossTimes == 0) {
			System.out.println("Not toss at all");
		} else if (tossTimes < 0) {
			System.out.println("Illegal toss times, Please reset!");
		} else {
			System.out.println("The number of times heads is facing up : " + headsTimes);
			System.out.println("the number of times tails is facing up : " + tailsTimes);
		}
	}

}
