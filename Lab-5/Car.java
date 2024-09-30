/**
 * Class Car for the Lab Assignment 5 Solution.
 * 
 * @author Dr. Garrett Goodman
 */
public class Car {
	// ============================================================================ Properties
	private String owner, make, model;
	private int yearModel, speed;
	private double fuelLevel;
	private boolean start;
	
	// ============================================================================ Constructors
	/**
	 * The default (empty) constructor. This constructor initializes the owner, make, and model
	 * as "", the yearModel as 2022, the speed as 0, the fuelLevel as 1.0d, and start as false.
	 */
	public Car() {
		this("", "", "", 2022, 1.0d, 0, false);
	}

	/**
	 * A partial constructor that takes the owner, make, model and yearModel instance properties 
	 * to initialize an object.
	 * 
	 * @param owner A String owner value which represents the name of the owner of the car.
	 * @param make A String make value which represents the make of the car.
	 * @param model A String model value which represents the model of the car.
	 * @param yearModel An int yearModel value which represents the year the car was manufactured. The
	 * yearModel cannot be less than 1885 or greater than 2022.
	 */
	public Car(String owner, String make, String model, int yearModel) {
		this(owner, make, model, yearModel, 1.0d, 0, false);
	}

	/**
	 * A partial constructor that takes the owner, make, model, year and fuelLevel instance 
	 * properties to initialize an object.
	 * 
	 * @param owner A String owner value which represents the name of the owner of the car.
	 * @param make A String make value which represents the make of the car.
	 * @param model A String model value which represents the model of the car.
	 * @param yearModel An int yearModel value which represents the year the car was manufactured. The
	 * yearModel cannot be less than 1885 or greater than 2022.
	 * @param fuelLevel A double fuelLevel value which represents the fuel of the car. The fuelLevel cannot
	 * be less than 0.0 or greater than 1.0.
	 */
	public Car(String owner, String make, String model, int yearModel, double fuelLevel) {
		this(owner, make, model, yearModel, fuelLevel, 0, false);
	}

	/**
	 * A workhorse constructor that receives values for all instance properties
	 * and initializes the object.
	 * 
	 * @param owner A String owner value which represents the name of the owner of the car.
	 * @param make A String make value which represents the make of the car.
	 * @param model A String model value which represents the model of the car.
	 * @param yearModel An int yearModel value which represents the year the car was manufactured. The
	 * yearModel cannot be less than 1885 or greater than 2022.
	 * @param fuelLevel A double fuelLevel value which represents the fuel of the car. The fuelLevel cannot
	 * be less than 0.0 or greater than 1.0.
	 * @param speed An int speed value which represents the speed of the car. The speed cannot be
	 * greater than 250 mph or less than 0 mph.
	 * @param start A boolean value which is true if the engine is on and false, otherwise.
	 */
	public Car(String owner, String make, String model, int yearModel, double fuelLevel, int speed, boolean start) {
		this.owner = owner;
		this.make = make;
		this.model = model;
		setYearModel(yearModel);
		setFuelLevel(fuelLevel);
		setSpeed(speed);
		this.start = start;
	}
	
	/**
	 * The copy constructor that copies the instance properties of another car object.
	 * 
	 * @param anotherCar An existing car to create a copy of.
	 */
	public Car(Car anotherCar) {
		this(anotherCar.owner, anotherCar.make, anotherCar.model, anotherCar.yearModel, anotherCar.fuelLevel, anotherCar.speed, anotherCar.start);
	}

	// ============================================================================ Methods
	
	/**
	 * Increases the speed by 4 miles/hour. It can increase the speed by
	 * that amount only if the engine is on, there is enough fuel, and it is running at 
	 * less than 250 miles/hour. No matter what, it burns 0.05 amount of fuel if the engine is on. 
	 * 
	 * @return True if it can increase the speed by some amount or false, otherwise.
	 */
	public boolean accelerate() {
		if(!isStart()) {
			return false;
		}
			
		if(isGasTankEmpty()) {
			return false;
		}

		setFuelLevel(fuelLevel - 0.05);
		
		if(speed == 250) {
			return false;
		}
			
		if(speed + 4 > 250) {
			setSpeed(250);
		} else {
			setSpeed(speed + 4);
		}

		return true;
	}
	
	/**
	 * Reduces the speed by 3 miles/hour. It cannot reduce the speed 
	 * if the speed is zero or the engine is turned off. 
	 * 
	 * @return True if it can reduce the speed by some amount or false, otherwise.
	 */
	public boolean brake() {
		if(!isStart()) {
			return false;
		}
			
		if(getSpeed() == 0) {
			return false;
		}
		
		if(speed > 3) {
			setSpeed(speed - 3);
		} else {
			setSpeed(0);
		}
		
		return true;		
	}
	
	/**
	 * Checks whether the tank is empty or not.
	 * 
	 * @return True if the tank is empty or false, otherwise.
	 */
	public boolean isGasTankEmpty() {
		if(fuelLevel < 0.05) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks whether two cars have the same owner.
	 * 
	 * @param anotherCar Another car object to compare owners with.
	 * @return True if two cars have same owner or false, otherwise.
	 */
	public boolean sameOwner(Car anotherCar) {
		if(owner.equals(anotherCar.owner)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Compares two car objects to determine if they are equal. Specifically,
	 * the make, model, and yearModel must be equal.
	 * 
	 * @param anotherCar Another car object to compare with.
	 * @return True if two cars are equal or false, otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Car)) {
			return false;
		}
		
		Car anotherCar = (Car) o;
		return make.equals(anotherCar.make) &&
			   model.equals(anotherCar.model) &&
			   yearModel == anotherCar.yearModel;
	}
	
	/**
	 * Returns a String representation of the car.
         *
         * @return The String representation of the car.
	 */
	@Override
	public String toString() {
		return String.format("Owner: %s, Make: %s, Model: %s, Year: %d, Speed: %d, Fuel Level: %.2f", owner, make, model, yearModel, speed, fuelLevel);
	}
	
	// ============================================================================ Getters / Setters
	/**
	 * Returns the owner of the car.
	 * 
	 * @return The String owner of the car.
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the owner of the car.
	 * 
	 * @param owner The String owner to set.
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Returns the make of the car.
	 * 
	 * @return The String make of the car.
	 */
	public String getMake() {
		return make;
	}

	/**
	 * Sets the make of the car.
	 * 
	 * @param make A String make of the car to set.
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * Returns the model of the car.
	 * 
	 * @return The String model of the car.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model of the car.
	 * 
	 * @param model The String model of the car to set.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Returns the yearModel of the car.
	 * 
	 * @return The int yearModel of the car.
	 */
	public int getYearModel() {
		return yearModel;
	}

	/**
	 * Sets the yearModel of the car.
	 * 
	 * @param yearModel The int yearModel of the car to set
	 * @exception InvalidParameterException If the value is not within the valid range of 
	 * greater than 1885 or less than 2022.
	 */
	public void setYearModel(int yearModel) {
		if(yearModel < 1885 || yearModel > 2022) {
			throw new IllegalArgumentException("The year model is not valid.");
		} else {
			this.yearModel = yearModel;
		}
	}

	/**
	 * Returns the fuelLevel of the car.
	 * 
	 * @return the double fuelLevel of the car.
	 */
	public double getFuelLevel() {
		return fuelLevel;
	}

	/**
	 * Sets the fuelLevel of the car.
	 * 
	 * @param fuelLevel The double fuelLevel of the car to set.
	 * @exception InvalidParameterException If the value is not within the valid range of
	 * greater than 0 or less than 1.0.
	 */
	public void setFuelLevel(double fuelLevel) {
		if(fuelLevel < 0 || fuelLevel > 1.0) {
			throw new IllegalArgumentException("The fuel level is not valid.");
		} else {
			this.fuelLevel = fuelLevel;
		}
	}

	/**
	 * Returns the speed of the car.
	 * 
	 * @return The int speed of the car.
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Sets the speed of the car.
	 * 
	 * @param speed The int speed of the car to set.
	 * @exception InvalidParameterException If the value is not within the valid range of
	 * greater than 0 or less than 250.
	 */
	public void setSpeed(int speed) {
		if(speed < 0 || speed > 250) {
			throw new IllegalArgumentException("The speed cannot be negative or more than 250 mph.");
		} else {
			this.speed = speed;
		}
	}

	/**
	 * Returns whether the engine is on (true) or off (false).
	 * 
	 * @return The boolean engine status of the car.
	 */
	public boolean isStart() {
		return start;
	}

	/**
	 * Sets the engine status of the car (true = on, false = off).
	 * 
	 * @param start The boolean start status of the car to set.
	 */
	public void setStart(boolean start) {
		this.start = start;
	}

}
