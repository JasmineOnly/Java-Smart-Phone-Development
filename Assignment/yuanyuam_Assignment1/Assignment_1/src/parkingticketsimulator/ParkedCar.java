package parkingticketsimulator;

/*
 * @Author:  Yuanyuan Ma
 * @Andrew ID : yuanyuam
 */

public class ParkedCar {
	/*
	 * Instance variables of  car's make, model, color, license number and number of minutes 
	 * the car has been parked.
	 */
	private String make = null;
	private String model = null;
	private String color = null;
	private String licenceNum = null;
	private int parkedTime = 0;

	/*
	 * Constructor with parameters to set the basic information of the parked car
	 */
	public ParkedCar(String make, String model, String color,
			String licenseNumber, int parkedTime) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.licenceNum = licenseNumber;
		if (parkedTime >= 0) {
			this.parkedTime = parkedTime;
		}
	}

	/*
	 * Getters and Setters: Methods to get and set the basic information of the parked car
	 */
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLicenceNum() {
		return licenceNum;
	}

	public void setlicenseNumber(String licenceNum) {
		this.licenceNum = licenceNum;
	}

	public int getParkedTime() {
		return parkedTime;
	}
	
	public void setParkedTime(int parkedTime) {
		if (parkedTime >= 0) {
			this.parkedTime = parkedTime;
		}
	}
}
