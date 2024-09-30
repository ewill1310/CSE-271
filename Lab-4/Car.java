//Evan Williams
//Garret Goodman
//CSE 271 - E
//Lab 4
//Contains all parts to the Car class that will be used in the CarDriver main method
/**
 * @author will1310
 *
 */
public class Car {//class we are making for lab
	
	private int yearModel;
	private String make;
	private String model;
	private String owner;
	private int speed;
	private double fuelLevel;
	private boolean start;	
	
	
	Car(){ //makes car when no info is given
		this("", "", "", 2022, 1.00, 0, false);
	}
	
	Car(String owner, String make, String model, int yearModel) {//makes car when some info is given
		this.owner = owner;
		this.make = make;
		this.model = model;
		this.yearModel = yearModel;
		this.speed = 0;
		this.fuelLevel = 1.00;
		this.start = false;
	}
	
	Car(String owner, String make,  String model, int yearModel, double fuelLevel) {//makes car when some info is given
		this.owner = owner;
		this.make = make;
		this.model = model;
		this.yearModel = yearModel;
		this.fuelLevel= fuelLevel;
		this.speed = 0;
		this.start = false;
	}
	Car(Car anotherCar) {//makes car from info from another car
		this.owner = anotherCar.owner;
		this.make = anotherCar.make;
		this.model = anotherCar.model;
		this.yearModel = anotherCar.yearModel;
		this.fuelLevel= anotherCar.fuelLevel;
		this.speed = anotherCar.speed; 
		this.start = anotherCar.start;
	}
	
	//Workhorse constructor
	Car(String  owner,  String  make,  String  model,  int  yearModel,  double  fuelLevel,  int speed, boolean start) {
		this.owner = owner;
		this.make = make;
		this.model = model;
		this.yearModel = yearModel;
		this.fuelLevel= fuelLevel;
		this.speed = speed; 
		this.start = start;
	}

	public boolean accelerate() {// methods to check if car can speed up and then speeds the car up and subtracts fuel 
	//	if(this.start) {//makes sure car is turned on first
		if(this.speed != 250 && fuelLevel >=0.05 && speed<246) {//check if car isn't at 250 and fuel level is above the required amount to move
			this.speed = this.speed +4; // accelerates the car
			fuelLevel = fuelLevel - 0.05;// removes some fuel
			return true;//returns true
		}else if(this.speed != 250 && this.speed > 246 && fuelLevel >= 0.05) { // checks if car is at 250 speed with more than 0.5 fuel left
			this.speed = 250;
			fuelLevel = fuelLevel - 0.05; // subtracts fuel 
			return true;//returns false
		}else if(this.speed == 250 && fuelLevel >= 0.05) { // checks if car is at 250 speed with more than 0.5 fuel left
			fuelLevel = fuelLevel - 0.05; // subtracts fuel 
			return false;
		}
		//System.out.println("Car has no gas");
		return false;//returns false
	//	}else {
		//	System.out.println("Car is off");
	//		return false;// if car is off it returns false
	//	}
	}
	
	public boolean brake() { // methods to slow the car down
		if(this.start) {//makes sure car is on first
		if(this.speed >=4){ // make sure speed wont go below zero when slowing down
			this.speed = this.speed-3;
			return true;
		}else { // if it will equal zero or go below zero after subtracting it sets it to zero
			this.speed = 0;
			return false;
		}
		}else{// if car is off it returns false
			return false;
		}
	}
	
	public boolean equals(Object o) {// method to check if the two objects are equal
		if(o instanceof Car) {// checks to see if the object being checked is of the Car Class
			Car p = (Car) o;//if it is it makes a new instance of Car to compare and see if they are equal
				if(this.speed == p.speed && this.make == p.make && this.yearModel == p.yearModel && // checks if its equal
						this.owner == p.owner && this.make == p.make && this.fuelLevel == p.fuelLevel) {
					return true;// if it is it returns true
				}else {
					return false; // if it isn't it returns false
				}
			
		}else {
			return false;
		}
	}
	
	
	
	public boolean isGasTankEmpty() {//checks if gas tank is empty or not
		if(this.fuelLevel < 0.05) {//if fuel is lower than amount needed to do a task it is deemed empty
			return true;//returns true
		}
		return false;//returns false
	}
	
	public  boolean  sameOwner(Car  anotherCar) {//checks to see if the owner of the car is the same as the owner of the given car
		if(this.owner == anotherCar.owner) {//checks to see if the owners are equal
			return true;
		}
		return false;
	}
	
	
	public String toString() { // method to print out the private variables as a string
		return String.format("Owner: %s, Make: %s, Model: %s, Year: %d, Speed: %d, Fuel Level: %.2f", 
								owner, make, model, yearModel, speed, fuelLevel); //returns a built and formatted string
	}

	
	
	
	
	public int getYearModel() {//gets the year model
		return yearModel;
	}

	public void setYearModel(int yearModel) {//sets the year model if given year is in the allowed range
		if(yearModel >= 1885 && yearModel<=2022) {
		this.yearModel = yearModel;
		}else {
			System.out.println("That year is invalid");
		}
	}

	public String getMake() {//gets the make
		return make;
	}

	public void setMake(String make) {//sets make to given make
		this.make = make;
	}

	public String getModel() {//gets the model
		return model;
	}

	public void setModel(String model) {//sets model to given model
		this.model = model;
	}

	public String getOwner() {//gets the owner
		return owner;
	}

	public void setOwner(String owner) {//sets owner to given owner
		this.owner = owner;
	}

	public int getSpeed() {//gets the speed
		return speed;
	}

	public void setSpeed(int speed) {//sets the speed if given year is in the allowed range
		if(speed >= 0 && speed <=250) {
		this.speed = speed;
		}else {
			System.out.println("Invalid Speed");
		}
	}

	public double getFuelLevel() {//gets the fuel level
		return fuelLevel;
	}

	public void setFuelLevel(double fuelLevel) {//sets the fuel if given year is in the allowed range
		if(fuelLevel >= 0.0 && fuelLevel <=1.0) {
		this.fuelLevel = fuelLevel;
		}else {
			System.out.println("Invalid fuel level");
		}
	}

	public boolean isStart() {//gets info to see if car is on or not
		return start;
	}

	public void setStart(boolean start) {//sets car status to given status
		this.start = start;
	}
	
	
	
	
}
