/**
 * Provided tester class for Car class.
 * 
 * @author Dr. Garrett Goodman
 */
public class CarDriver {
	
	public static void main(String[] args) {
		// Create two Car objects
		Car car1 = new Car();
		Car car2 = new Car();
		
		// Print the object's information using the toString method
		System.out.println("Car 1: " + car1.toString());
		System.out.println("Car 2: " + car2.toString());
		
		// Assign value to the car1 instance properties via the setters
		car1.setSpeed(188);
		car1.setMake("BMW");
		car1.setYearModel(2021);
		car1.setNumberOfWheels(4);
		car1.setFuelLevel(2.0);
		
		// Assign value to the car2 instance properties via the setters
		car2.setSpeed(200);
		car2.setMake("Tesla");
		car2.setYearModel(2021);
		car2.setNumberOfWheels(4);
		car2.setFuelLevel(5.0);
		
		// Print the object's information using the toString method
		System.out.println("\nCar 1: " + car1.toString());
		System.out.println("Car 2: " + car2.toString());
		
		// Accelerate car1 4 times
		car1.accelerate();
		car1.accelerate();
		car1.accelerate();
		car1.accelerate();

		// Brake car2 6 times
		car2.brake();
		car2.brake();
		car2.brake();
		car2.brake();
		car2.brake();
		car2.brake();
		
		// Print the object's information using the toString method
		System.out.println("\nAfter 4 accelerations for car1 and 6 brakes for car 4");
		System.out.println("Car 1: " + car1.toString());
		System.out.println("Car 2: " + car2.toString());
		
		// Create two more car objects
		Car car3 = new Car();
		Car car4 = new Car();

		// Assign value to the car3 instance properties via the setters
		car3.setSpeed(25);
		car3.setMake("Google");
		car3.setYearModel(2022);
		car3.setNumberOfWheels(4);
		car3.setFuelLevel(5.0);

		// Assign value to the car4 instance properties via the setters
		car4.setSpeed(20);
		car4.setMake("Apple");
		car4.setYearModel(2022);
		car4.setNumberOfWheels(2);
		car4.setFuelLevel(5.0);
		
		// Print the object's information using the toString method
		System.out.println("\nCar 3: " + car3.toString());
		System.out.println("Car 4: " + car4.toString());
		
		// Loop to accelerate car 3 and brake car4 the same amount of time
		for(int i = 1; i <= 12; i++) {
			car3.accelerate();
			car4.brake();
		}		
		
		// Print the object's information using the toString method
		System.out.println("\nAfter 12 accelerations for car3 and 12 brakes for car 4");
		System.out.println("Car 3: " + car3.toString());
		System.out.println("Car 4: " + car4.toString());
		
		// Test equality
		if(car3.equals(car4)) {
			System.out.println("The cars are equal");
		} else {
			System.out.println("The cars are not equal");
		}

		// Change the number of wheels car3 has
		car3.setNumberOfWheels(2);

		// Print the object's information using the toString method
		System.out.println("\nCar 3: " + car3.toString());
		System.out.println("Car 4: " + car4.toString());

		// Test equality again
		if(car3.equals(car4)) {
			System.out.println("The cars are equal");
		} else {
			System.out.println("The cars are not equal");
		}

		// Change the make of car4
		car4.setMake("Google");

		// Print the object's information using the toString method
		System.out.println("\nCar 3: " + car3.toString());
		System.out.println("Car 4: " + car4.toString());

		// Test equality again
		if(car3.equals(car4)) {
			System.out.println("The cars are equal");
		} else {
			System.out.println("The cars are not equal");
		}
	}

}
