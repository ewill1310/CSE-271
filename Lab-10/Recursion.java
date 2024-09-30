/**
 * This class contains all the methods created for Lab 10, which is due 4/10/22
 * @author Evan Williams
 */
public class Recursion {

	/**
	 * runs and tests the methods I have made
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(power(5, 3));
		System.out.println(sumDigits(257));
		printBackwards("pog");
		System.out.println("\n" + isPalindrome("appa"));
		int[] nums = { 1, 2, 3, 8, 5, 6, 3 };
		System.out.println(sumPositive(nums));
		System.out.println(max(nums));
	}

	
	/**
	 * This method multiples x by itself an n amount of times by use of recursion
	 * @param x - number being multiplied
	 * @param n - how many times x is being multiplied by itself
	 * @return value of x^n
	 */
	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		} else {
			return x * power(x, n - 1);
		}
	}

	/**
	 * This method adds all digits of integer n
	 * @param n
	 * @return added values of n's digits
	 */
	public static int sumDigits(int n) {
		if (n == 0) {
			return 0;
		} else {
			return n % 10 + sumDigits(n / 10);
		}
	}

	/**
	 * This method recursively goes through the word and prints out the inputed string backwards
	 * @param word - the word to be reversed
	 */
	public static void printBackwards(String word) {
		if (word.equals("")) {
			System.out.print("");
		} else {
			System.out.print(word.charAt(word.length() - 1));
			printBackwards(word.substring(0, word.length() - 1));
		}
	}

	/**
	 * This method checks to see if the word is a palindrome
	 * @param word - the word being checked
	 * @return a boolean value for if the word is a palindrome
	 */
	public static boolean isPalindrome(String word) {
		word = word.toUpperCase();
		if (word.length() > 1) {
			if (word.charAt(0) == word.charAt(word.length() - 1)) {
				return isPalindrome(word.substring(1, word.length() - 1));
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	/**
	 * Recursively loops through the array and adds all positive numbers in it
	 * @param array - the array being looped for values
	 * @return the total of all positive numbers in array
	 */
	public static int sumPositive(int[] array) {
		if (array.length == 0) {
			return 0;
		} else {
			int[] array2 = new int[array.length - 1];
			for (int i = 1; i < array.length; i++) {
				array2[i - 1] = array[i];
			}
			if (array[0] > 0) {
				return array[0] + sumPositive(array2);
			} else {
				return 0 + sumPositive(array2);
			}
		}
	}

	/**
	 * Recursively loops through an array and finds the maximum value in it
	 * @param array - the array being looped through
	 * @return an Integer of the highest value in the array
	 */
	public static int max(int[] array) {
		if(array.length == 0) {
			return 0;
		}else if (array.length == 1) {
			return array[0];
		} else {
			int[] array2 = new int[array.length - 1];
			for (int i = 1; i < array.length; i++) {
				array2[i - 1] = array[i];
			}
			if (array[0] > max(array2)) {
				return array[0];
			} else {
				return max(array2);
			}
		}
	}

}
