//Evan Williams
//Garret Goodman
//CSE 271 - E
//Contains all parts to the Car class that will be used in the CarDriver main method
public class Car {
	
	private int speed;
	private String make;
	private int yearModel;
	private int numberOfWheels;
	private double fuelLevel;
	
	Car(){
		
	}
	
	
	Car(int speed, String make,int yearModel, int numberOfWheels, double fuelLevel){
		this.speed = speed;
		this.make = make;
		this.yearModel = yearModel;
		this.numberOfWheels = numberOfWheels;
		this.fuelLevel = fuelLevel;
	}

	public void accelerate() {// methods to speed the car up and subtract fuel 
		if(this.speed != 200 && fuelLevel >=0.5) {//check if car isnt at 200 and fuel level is above the required amount to move
			this.speed = this.speed +4; // accelerates the car
			fuelLevel = fuelLevel - 0.5;// removes some fuel
		}else if(this.speed == 200 && fuelLevel >= 0.5) { // checks if car is at 200 speed with more than 0.5 fuel left
			fuelLevel = fuelLevel - 0.5; // subtracts fuel 
		}
	}
	
	public void brake() { // methods to slow the car down
		if(this.speed >=4){ // make sure speed wont go below zero when slowing down
			this.speed = this.speed-3;
		}else { // if it will equal zero or go below zero after subtracting it sets it to zero
			this.speed = 0;
		}
	}
	
	public boolean equals(Object o) {// method to check if the two objects are equal
		if(o instanceof Car) {// checks to see if the object being checked is of the Car Class
			Car p = (Car) o;//if it is it makes a new instance of Car to compare and see if they are equal
				if(this.speed == p.speed && this.make == p.make && this.yearModel == p.yearModel && // checks if its equal
						this.numberOfWheels == p.numberOfWheels && this.fuelLevel == p.fuelLevel) {
					return true;// if it is it returns true
				}else {
					return false; // if it isnt it returns false
				}
			
		}else {
			return false;
		}
	}
	
	public String toString() { // method to print out the private variables as a string
		String output = ("Make: " + make + ", Year: " + yearModel +", Wheels: " + numberOfWheels // builds the string
							+", Speed: " + speed+", Fuel Level: " + fuelLevel);
		return output; // returns the built string
	}
	
	
	public int getSpeed() {//gets value of speed
		return speed;
	}

	public void setSpeed(int speed) {//sets value of speed to the given value
		this.speed = speed;
	}

	public String getMake() {//gets make
		return make;
	}

	public void setMake(String make) { //sets make to given make
		this.make = make;
	}

	public int getYearModel() { // gets modelYear value
		return yearModel;
	}

	public void setYearModel(int yearModel) { //sets modelYear value to given value
		this.yearModel = yearModel;
	}

	public int getNumberOfWheels() { // gets value of numberOfWheels
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) { //sets value of numberOfWheels to given value
		this.numberOfWheels = numberOfWheels;
	}

	public double getFuelLevel() { // gets value of fuelLevel
		return fuelLevel;
	}

	public void setFuelLevel(double fuelLevel) { //sets value of fuelLevel to given value
		this.fuelLevel = fuelLevel;
	}
	
}
