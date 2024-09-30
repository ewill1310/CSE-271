/**
 * Provided tester class for DateTime class.
 * 
 * @author Dr. Garrett Goodman
 */
public class DateTimeDriver{
	
	public static void main(String [] args){
		// Create two DateTime objects
		DateTime dateTime1 = new DateTime();
		DateTime dateTime2 = new DateTime();
		
		// Assign value to the dateTime1 instance properties via the setters
		dateTime1.setHour(12);
		dateTime1.setMinute(21);
		dateTime1.setSecond(59);
		dateTime1.setDay(25);
		dateTime1.setMonth("January");
		dateTime1.setYear(2021);

		// Assign value to the dateTime2 instance properties via the setters
		dateTime2.setHour(12);
		dateTime2.setMinute(43);
		dateTime2.setSecond(59);
		dateTime2.setDay(25);
		dateTime2.setMonth("January");
		dateTime2.setYear(2011);
		
		// Print the object's information using the toString method
		System.out.println("DateTime 1: " + dateTime1.toString());
		System.out.println("DateTime 2: " + dateTime2.toString());
		
		// Test equality
		if(dateTime1.equals(dateTime2)) {
			System.out.println("Two DateTime objects are equal.");
		} else {
		 	System.out.println("Two DateTime objects are not equal.");
		}
		
		// Change dateTime2 year and print the object's information using the toString method
		dateTime2.setYear(2021);
		System.out.println("\nDateTime 1: " + dateTime1.toString());
		System.out.println("DateTime 2: " + dateTime2.toString());

		// Test equality again
		if(dateTime1.equals(dateTime2)) {
			System.out.println("Two DateTime objects are equal.");
		} else {
			System.out.println("Two DateTime objects are not equal.");
		}
		
		// Change dateTime1 minute and print the object's information using the toString method
		dateTime1.setMinute(43);
		System.out.println("\nDateTime 1: " + dateTime1.toString());
		System.out.println("DateTime 2: " + dateTime2.toString());

		// Test equality again
		if(dateTime1.equals(dateTime2)) {
			System.out.println("Two DateTime objects are equal.");
		} else {
			System.out.println("Two DateTime objects are not equal.");
		}
	}
	
}

