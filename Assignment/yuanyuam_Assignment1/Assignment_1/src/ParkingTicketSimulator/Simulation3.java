package ParkingTicketSimulator;

/*
 * @Author:  Yuanyuan Ma
 * @Andrew ID : yuanyuam
 * 
 * Simulate the case that parked car is out of the  parking time purchased 
 * Ticketing under 1 hour
 * If the program runs correctly, it will prompt the illegal parking ticket
 * and the fine should be $25
 */

public class Simulation3 {
	public static void main(String[] args) {
		System.out
				.println("Simulation 3 : Parked car is out of  the parking time purchased "
						+ "(Ticketing under an hour)"
						+ "\n");

		/*
		 * Instance class of ParkedCar
		 */
		ParkedCar pc = new ParkedCar("Audi", "A8", "Black", "JSP18641", 90);

		/*
		 * Instance class of ParkingMeter
		 */
		ParkingMeter pm = new ParkingMeter(60);

		System.out.println("Parking Time: " + pc.getParkedTime() + " Minutes");
		System.out.println("Purchased Time: " + pm.getPurchasedTime()
				+ " Minutes" + "\n");

		/*
		 * Instance class of PoliceOfficer
		 */
		PoliceOfficer po = new PoliceOfficer("Mike", "007");

		/*
		 * If the car's time has expired, the police officer will issue a ticket
		 */
		if (po.examineParkingExpire(pc, pm)) {
			po.issueTicket(pc, pm);
		} else {
			System.out.println("This car is legally Parking");
		}
	}
}
