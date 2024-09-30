import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the methods in the Recursion Class
 * @author Evan Williams
 *
 */
public class RecursionTest extends Recursion{

	int[] one = {1,2,3,4,5,-1};
	int[] two = {1,2,-1};
	int[] three = {-1,-5,-9};
	int[] four = {1};
	int[] five = {};
	
	/**
	 * Tests the power method from the Recursion class
	 */
	@Test
	public void testPower() {
		assertEquals(4, power(2,2));
		assertEquals(4, power(-2,2));
		assertEquals(125, power(5,3));
	}
	
	/**
	 * Tests the sumDigits method from the Recursion class
	 */
	@Test
	public void testSumDigits() {
		assertEquals(6, sumDigits(222));
		assertEquals(10, sumDigits(154));
		assertEquals(18, sumDigits(864));
	}

	/**
	 * Tests the isPalindrome method from the Recursion class
	 */
	@Test
	public void testIsPalindrome() {
		assertEquals(isPalindrome("appa"), true);
		assertEquals(isPalindrome("alpa"), false);
		assertEquals(isPalindrome("apopa"), true);
		assertEquals(isPalindrome("APopa"), true);		
	}
	
	/**
	 * Tests the sumPositive method from the Recursion class
	 */
	@Test
	public void testSumPositive() {
		assertEquals(sumPositive(one), 15);
		assertEquals(sumPositive(two), 3);
		assertEquals(sumPositive(three), 0);
		assertEquals(sumPositive(four), 1);
		assertEquals(sumPositive(five), 0);
	}
	
	/**
	 * Tests the max method from the Recursion class
	 */
	@Test
	public void testMax() {
		assertEquals(max(one), 5);
		assertEquals(max(two), 2);
		assertEquals(max(three), -1);
		assertEquals(max(four), 1);
		assertEquals(max(five), 0);
	}
}
