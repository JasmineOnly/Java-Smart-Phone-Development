package ParkingTicketSimulator;

public class PoliceOfficer {
	/*
	 * Instance variables of police officer
	 */
	private String name;
	private String badgeNum;

	/*
	 * Constructor with parameters to set the basic information of the police
	 * officer
	 */
	public PoliceOfficer(String name, String badgeNum) {
		this.name = name;
		this.badgeNum = badgeNum;
	}

	/*
	 * Getters and Setters to get and set the basic information of the police
	 * officer
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBadgeNum() {
		return badgeNum;
	}

	public void setBadgeNum(String badgeNum) {
		this.badgeNum = badgeNum;
	}

	/*
	 * Method to determines whether the car's time has expired.
	 */
	public boolean examineParkingExpire(ParkedCar pc, ParkingMeter pm) {
		if (pc.getParkedTime() > pm.getPurchasedTime()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Method to issue a parking ticket if the car time has expired.
	 */
	public void issueTicket(ParkedCar pc, ParkingMeter pm) {
		ParkingTicket pt = new ParkingTicket();
		System.out.println("****** Illegal Parking Fine Ticket ******" + "\n");
		pt.reportCarInfo(pc);
		System.out.println("The car's time has expired for "
				+ (pc.getParkedTime() - pm.getPurchasedTime()) + " Minutes"
				+ "\n");
		pt.reportFine(pc,pm);
		System.out.println();
		pt.reportOfficerInfo(this);
	}
}
