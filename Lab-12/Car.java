import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the car class, it creates a car object and holds the methods the car
 * class can use
 * 
 * @author will1310
 *
 */
public class Car implements Comparable<Car> {

	private int id;
	private String carMake;
	private String carModel;
	private int year;

	/**
	 * Empty constructor for the Car Class
	 */
	public Car() {
		this(0, "","", 0);
	}
	
	/**
	 * Constructor for the Car class, builds the car and sets the cars parameters to
	 * the given values
	 * 
	 * @param id
	 * @param carMake
	 * @param carModel
	 * @param year
	 */
	public Car(int id, String carMake, String carModel, int year) {
		this.id = id;
		this.carMake = carMake;
		this.carModel = carModel;
		this.year = year;
	}

	/**
	 * Takes in a filePath and then reads the file from said filePath and then takes
	 * the cars from the file and puts them into an array
	 * 
	 * @param filePath
	 * @return an array of Car objects
	 */
	public static Car[] readFromFile(String filePath) {
		Scanner in = null;
		ArrayList<String> lines = new ArrayList<String>();
		int count = 0;
		try {
			in = new Scanner(new File(filePath));
			while (in.hasNextLine()) {
				count++;
				lines.add(in.nextLine());
			}
			Car[] cars = new Car[count];
			int i = 0;
			for (String s : lines) {
				String[] parts = s.split(",");
				cars[i] = new Car(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]));
				i++;
			}
			return cars;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * This method takes in an object and checks to see if it is a car, then if it
	 * is it compares it to the current car to see if they are equal
	 * 
	 * @param o
	 * @return true if the cars are the same and false if they are not
	 */
	public boolean equals(Object o) {
		if (o instanceof Car) {
			Car c = (Car) o;
			if (carMake.equals(c.carMake) && carModel.equals(c.carModel) && year == c.year) {
				return true;
			}
		}
		return  false;
	}

	/**
	 * This method compares the car objects and returns -1 if it comes after lexicographically,
	 * 1 if it comes before lexicographically and 0 if it is the same
	 * @param c
	 */
	public int compareTo(Car c) {
		if (c.carMake.equals(carMake)) {
			if (c.carModel.equals(carModel)) {
				return 0;
			}
			return c.carModel.compareTo(carModel);
		}
		return c.carMake.compareTo(carMake);
	}

	/**
	 * This sort method uses what is known as insertion sorting, to sort the array lexicographically by carMake and CarModel
	 * @param cars
	 */
	public static void sort(Car[] cars) {
		if (cars == null || cars.length < 2) {
			return;
		}

		for (int i = 1; i < cars.length; i++) {
			Car temp = cars[i];
			int j = i;

			while (j > 0 && temp.compareTo(cars[j-1]) > 0) {
				cars[j] = cars[--j];
			}
			cars[j] = temp;	
		}
	
		/*
		for(int o = 0; o <cars.length; o++) {
			cars[o].setID(o+1);
		}
		*/
	}

	/**
	 * linearly searches the array for a car in the car array to see if it matches
	 * the given car
	 * 
	 * @param cars
	 * @param car
	 * @return the position in the array the equaling car is at
	 */
	public static int linearSearch(Car[] cars, Car car) {
		return linearSearch(cars, car, 0);
	}

	/**
	 * This is a helper method for the linearSearch method, it takes in an index
	 * number to search through the correct positions and compares the cars to see
	 * if they are equal
	 * 
	 * @param cars
	 * @param car
	 * @param index
	 * @return the position in the array the car is at, but if there is no car that
	 *         matches it return -1
	 */
	public static int linearSearch(Car[] cars, Car car, int index) {
		if (index > cars.length - 1) {
			return -1;
		}
		if (car.compareTo(cars[index]) == 0) {
			return index;
		} else {
			return linearSearch(cars, car, index + 1);
		}
	}

	/**
	 * uses binary recursive searching to find a car in an array of cars that
	 * matches the given car
	 * 
	 * @param cars
	 * @param car
	 * @return the position in the array the equaling car is at
	 */
	public static int binaryRecursiveSearch(Car[] cars, Car car) {
		return binaryRecursiveSearch(cars, car, 0, cars.length-1);
	}

	/**
	 * Helper method for binaryRecursiveSearch
	 * @param cars
	 * @param car
	 * @param low
	 * @param high
	 * @return
	 */
	public static int binaryRecursiveSearch(Car[] cars, Car car, int low, int high) {
		if(low > high) {
			return -1;
		}
		
		int mid = (low + high) / 2;
		if(cars[mid].compareTo(car) == 0) {
			return mid;
		}
		if(cars[mid].compareTo(car) < 0) {
			return binaryRecursiveSearch(cars, car, low, mid - 1);
		} else {
			return binaryRecursiveSearch(cars, car, mid + 1, high);
		}
	}
	
	/**
	 * This method returns a string for the Car object by saying the Id, CarMake,
	 * CarModel, and Year in the correct way
	 */
	public String toString() {
		return String.format("%d, %s, %s, %d", id, carMake, carModel, year);
	}

	/**
	 * gets the cars ID
	 * @return int
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * sets the cars ID
	 * @param id
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * gets the cars Make
	 * @return String
	 */
	public String getCarMake() {
		return this.carMake;
	}
	
	/**
	 * sets the cars make
	 * @param make
	 */
	public void setCarMake(String make) {
		this.carMake = make;
	}
	
	/**
	 * gets the cars model
	 * @return String
	 */
	public String getCarModel() {
		return this.carModel;
	}
	
	/**
	 * Sets the cars model
	 * @param model
	 */
	public void setCarModel(String model) {
		this.carMake = model;
	}
	
	/**
	 * gets the cars year
	 * @return int
	 */
	public int getYear() {
		return this.year;
	}
	
	/**
	 * sets the cars year
	 * @param id
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	
	/**
	 * tests the car class
	 * @param args
	 */
	public static void main(String[] args) {
	/*	Car same = new Car(748,"Mercury","Villager",1999);
		Car[] cars = readFromFile("CarData.txt");
		for (int j = 0; j < cars.length; j++) {
			System.out.println(cars[j].toString());
		}
		sort(cars);
		for (int j = 0; j < cars.length; j++) {
			System.out.println(cars[j].toString());
		}
		System.out.println(linearSearch(cars, same));
		System.out.println(binaryRecursiveSearch(cars, same));
		System.out.println(cars[634].equal(same));
		System.out.println(cars[636].equal(same));
	*/
	}

}
