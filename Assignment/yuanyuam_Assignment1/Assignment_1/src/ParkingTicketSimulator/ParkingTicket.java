package ParkingTicketSimulator;

/*
 * @Author:  Yuanyuan Ma
 * @Andrew ID : yuanyuam
 */

public class ParkingTicket {
	/*
	 * Instance variables about fine
	 */
	private int fine = 0;
	private static final int BASEFINE = 25;
	private static final int EXTRAFINEPERHOUR = 10;


	/*
	 * Method to report the make, model, color and license number of an
	 * illegally parked car.
	 */
	public void reportCarInfo(ParkedCar pc) {
		System.out.println("Illegal Parking Car Information:");
		String parkedCarInfo = "Make: " + pc.getMake() + "\n" + "Model: "
				+ pc.getModel() + "\n" + "Color: " + pc.getColor() + "\n"
				+ "Licence Number: " + pc.getLicenceNum();
		System.out.println(parkedCarInfo + "\n");
	}

	/*
	 * Method to report the fine
	 */
	public void reportFine(ParkedCar pc, ParkingMeter pm) {
		this.fine = calculateFine(pc, pm);
		System.out.println("Illegal Parking Fine : $" + fine + "\n");
	}

	/*
	 * Method to calculate the fine which is $25.00 for first hour plus $10.00
	 * for each additional hour
	 */
	private int calculateFine(ParkedCar pc, ParkingMeter pm) {
		if (pc.getParkedTime() - pm.getPurchasedTime() <= 60) {
			this.fine = BASEFINE;
		} else {
			int addFine = (pc.getParkedTime() - pm.getPurchasedTime()) / 60;
			this.fine = BASEFINE + addFine * EXTRAFINEPERHOUR;
		}

		return fine;
	}

	/*
	 * Method to report the name and badge number of the police officer issuing the ticket.
	 */
	public void reportOfficerInfo(PoliceOfficer po) {
		System.out.println("Ticket Issued Officer:");
		String officerInfo = "Name : " + po.getName()
				+ "\n" + "Badge Number : " + po.getBadgeNum();
		System.out.println(officerInfo + "\n");
	}

}
