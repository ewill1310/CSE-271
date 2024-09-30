import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GradeStatistics {

	public static Scanner in = new Scanner(System.in);
	public static double[] grades = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		populateGrades();
		sortGrades(grades);
		getMean(grades);
		getMinMax(grades);
		printGrades(grades);
		printStatistics(getMean(grades), getMinMax(grades));
	}
	
	public static double[] populateGrades() { // It asks the user to input how many students they are inputing grades for
											  // It then asks to user to input the amount of requested grades
		System.out.print("How many students do you have in the class:"); //then prints the unsorted grades and returns the grades array
		int amount = in.nextInt();
		grades = new double[amount];
		
		for(int i = 0; i<amount; i++) {
			System.out.print("Enter grade of Student " + (i+1) + ":");	
			grades[i] = in.nextDouble();
		}

		
		String showGrades = "The grades are: ";
			for(int i = 0; i<grades.length; i++) {
				if(i!=grades.length-1) {
					showGrades = (showGrades + grades[i] + ", ");
				}else {
				showGrades = (showGrades + grades[i]);
			}
		}
		
		System.out.println(showGrades);
		
			return grades;
	}
	
	public static void sortGrades(double[] grades) { //uses the Arrays.sort() method to sort the array then returns the sorted array 
		Arrays.sort(grades);
		return;
	}
	
	public static double getMean(double[] grades) {//adds up all parts of the array and then divides by total number of parts 
		double mean = 0;						   // which gives the raw mean, I then truncate the double to only return up 
		double total = 0;						   // until the first decimal point
		double arraySize = 0;
			for(int i = 0; i<grades.length; i++) {
				total = total + grades[i];
				arraySize++;
			}
		mean = (total/arraySize);
		double forRounding = mean*10;
		forRounding = Math.round(forRounding);
		mean = (forRounding/10);
		//System.out.println("The mean of the grades is " + mean);
		return mean;
	}
	
	public static double[] getMinMax(double[] grades) { // goes through the entire array of grades and sets the base values of min and max
		double min = grades[0];							// to the first value of the array and then compares to see if the current array
		double max = grades[0];							// value is higher or lower than the previously found min and maxes then puts them
		double[] minMax = new double[2];				// into an array for use in the printStatistics method as well as returning grades
		
		for(int i = 0; i<grades.length; i++) {
			if(grades[i] < min) {
				min = grades[i];
			}
		}
		
		for(int i = 0; i<grades.length; i++) {
			if(grades[i] > max) {
				max = grades[i];
			}else {
				max = max;
			}		
		}
		
		//System.out.println("The minimum of the grades is " + min);
	//	System.out.println("The maximum of the grades is " + max);
		return grades;
	}
	
	public static void printGrades(double[] grades) {	// loops through the entire array and builds a string which is then printed
		String showGrades = "The sorted grades are: ";
			for(int i = 0; i<grades.length; i++) {
				if(i!=grades.length-1) {
					showGrades = (showGrades + grades[i] + ", ");
				}else {
					showGrades = (showGrades + grades[i]);
				}
			}
			
			System.out.println(showGrades);
		return;
	}
	
	public static void printStatistics(double mean, double[] minMax) { // prints the mean and min and maxes found from the called methods
		
		System.out.println("Mean = " + mean);
		System.out.print("Min = " + minMax[0] + " Max = " + minMax[minMax.length-1]);
		
		return;
	}

}
