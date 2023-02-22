//Written By Evan Williams
// For CSE271 - E
// Date 2/18/22

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FileParser {

	
	
	
	public static String clean(String word) { //cleans up the given word removing all numbers, and special characters
		int length = word.length();
        boolean x = true;
        String s = "";
        String[] stringArray = word.split("\\W+"); //removes all nonletters and nonnumbers
        String result = "";
        for(int i = 0; i < stringArray.length;i++){
        	for(int j = 0; j<stringArray[i].length(); j++) {
        		
        		if(stringArray[i].charAt(j) == '1' ||stringArray[i].charAt(j) == '2' ||stringArray[i].charAt(j) == '3' ||stringArray[i].charAt(j) == '4' ||
        				stringArray[i].charAt(j) == '5' ||stringArray[i].charAt(j) == '6' ||stringArray[i].charAt(j) == '7' ||
        					stringArray[i].charAt(j) == '8' || stringArray[i].charAt(j) == '9' || stringArray[i].charAt(j) == '0') { //detects if character is
        																															// a number
        			char tempChar = stringArray[i].charAt(j);
        			String number = Character.toString(tempChar);
        			stringArray[i] = stringArray[i].replace(number, ""); //removes numbers
        		}
        	}
           result = result+ stringArray[i];
        }

        return result; //returns the cleaned word
	}
	
	//============================================================================================================================================
	
	public static void parse(File in, File out) { //read from one file and write results to another file
		Scanner file = null;
		ArrayList<String> lines = new ArrayList<String>();
		try { //tries to scan the input file and add lines to an array
    		file = new Scanner(in);	
    		for(int i = 0; file.hasNextLine(); i++) {
    			lines.add(file.nextLine());
    		}	
    	}catch(Exception e) { // if there are any other errors for any reason it will report it
    		e.printStackTrace();
    	}finally { 
    		try {
    			file.close(); // closes the scanner to prevent data loss
    		}catch(Exception f){ // if there is an error closing the scanner it will report it
    			f.printStackTrace();
    		}
    	}
		for(String s : lines) {
			String[] parts = s.split(" ");	
			FileWriter lineAppender = null;
			PrintWriter append = null;
			try {
				lineAppender = new FileWriter(out, true);
				append = new PrintWriter(lineAppender);	
				for(int i = 0; i<parts.length; i++) {
					append.println(parts[i]);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					lineAppender.close();
					append.close();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			}
		}
	}
	
	//=========================================================================================================================================
	
	public static boolean isPalindrome(String str) { // checks to see if the word is a palindrome if so it returns true if not it returns false
 
        int i = 0;
        int length = str.length() - 1;
        
       String tempStr = str.replaceAll("[^a-zA-Z]+","").toUpperCase();
      
        while (i < length) {
 
            if (tempStr.charAt(i) != tempStr.charAt(length)) {
                return false;
            }
           
            i++;
            length--;
        }
        return true;
    }
	
	//====================================================================================================================================
	
	
	public  static  void  parsePalindrome(File  in,  File  out) { // reads words from file and parses all words that are palindromes into the given output document
		Scanner file = null;									 // without printing duplicates
		ArrayList<String> Palindromes = new ArrayList<String>();
		try { //tries to scan the input file and add lines to an array
    		file = new Scanner(in);
    		for(int i = 0; file.hasNextLine(); i++) {
    			Palindromes.add(file.nextLine());
    		}
    	}catch(Exception e) { // if there are any other errors for any reason it will report it
    		e.printStackTrace();
    	}finally { 
    		try {
    			file.close(); // closes the scanner to prevent data loss
    		}catch(Exception f){ // if there is an error closing the scanner it will report it
    			f.printStackTrace();
    		}
    	}
		cleanArray(Palindromes);
		for(String s : Palindromes) {
			String[] lines = s.split(" ");
			FileWriter lineAppender = null;
			PrintWriter append = null;
			try {
				lineAppender = new FileWriter(out, true);
				append = new PrintWriter(lineAppender);
				for(int i = 0; i<lines.length; i++) {
					if(isPalindrome(clean(lines[i]))) {
						lines[i] = lines[i].replaceAll("[^a-zA-Z]+","").toUpperCase();
						append.println(clean(lines[i]));
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					lineAppender.close();
					append.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//==============================================================================================================================================
	
	public static int value(String word) { // gets the value of the word to be used in determining if word is a $100 word
		int value = 0;
		for(int i = 0; i<word.length(); i++) {
			char temp = word.charAt(i);
			value = value + (Character.getNumericValue(temp)-9);
		}
		return value;
	}
	
	//===============================================================================================================================================
	
	public  static  void  parseHundredDollarWord(File  in,  File  out) { // reads from input file and then prints out the $100 dollar words it finds into the output file
		Scanner file = null;
		ArrayList<String> hundred = new ArrayList<String>();	
		try { //tries to scan the input file and add lines to an array
    		file = new Scanner(in);
    		for(int i = 0; file.hasNextLine(); i++) {
    			hundred.add(file.nextLine());
    		}		
    	}catch(Exception e) { // if there are any other errors for any reason it will report it
    		e.printStackTrace();
    	}finally { 
    		try {
    			file.close(); // closes the scanner to prevent data loss
    		}catch(Exception f){ // if there is an error closing the scanner it will report it
    			f.printStackTrace();
    		}
    	}
		cleanArray(hundred);
		for(String s : hundred) {
			String[] lines = s.split(" ");
			FileWriter lineAppender = null;
			PrintWriter append = null;
			try {
				lineAppender = new FileWriter(out, true);
				append = new PrintWriter(lineAppender);
				for(int i = 0; i<lines.length; i++) {
					if(value(clean(lines[i])) == 100) {
						lines[i] = lines[i].replaceAll("[^a-zA-Z]+","").toUpperCase();
						append.println(clean(lines[i]));
					}			
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					lineAppender.close();
					append.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}		
		}
	}
	
	//======================================================================================================================================
	
	public static void cleanArray(ArrayList<String> lines) { // cleans array and removes duplicates, made because i kept repeating these lines of code
		for (int i = 0; i < lines.size(); i++) { 
			for (int j = i + 1 ; j < lines.size(); j++) { 
				lines.set(i, clean(lines.get(i).toUpperCase()));
				lines.set(j, clean(lines.get(j).toUpperCase()));
				if (lines.get(i).equals(lines.get(j))) { // got the duplicate element } } }
					lines.remove(j);
				}
			}
		}
		Collections.sort(lines);
	}
	
	//=========================================================================================================================================
	
	public static void clearText(File in) { // ran at the start of the code to clear the contents of the output files
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(in);
			writer.print("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			writer.close();
		}
	}
	
	//=======================================================================================================================================

	public static void main(String[] args) { //testing to see if it works/ just running it
		Scanner in = new Scanner(System.in);	
		File input = null;
		System.out.println("Enter input filename:");
		String fileName = in.next();
		System.out.println(fileName);
			input =new File(fileName);
			
		if(input.exists()) {
			System.out.println("Found. What do you want to output?");
			System.out.println("1. Raw word list");
			System.out.println("2. Palindromes");
			System.out.println("3. $100 words");
			System.out.println("Choose: ");

			int choice = in.nextInt();
			
			if(choice == 1) {
				System.out.println("Enter output filename:");
				String file = in.next();
				File out =new File(file);
				clearText(out);
				parse(input, out);
				System.out.println("Finished printing raw word list.");
			}else if(choice == 2) {
				System.out.println("Enter output filename:");
				String file = in.next();
				File out =new File("raw.txt");
				File palindrome = new File(file);
				clearText(out);
				clearText(palindrome);
				parse(input, out);
				parsePalindrome(out, palindrome);
				System.out.println("Finished printing palindromes.");
			}else if(choice == 3) {
				System.out.println("Enter output filename:");
				String file = in.next();
				File out =new File("raw.txt");
				File hundred = new File(file);
				clearText(out);
				clearText(hundred);
				parse(input, out);
				parseHundredDollarWord(out, hundred);
				System.out.println("Finished printing $100 words.");			
			}else {
				System.out.println("Not a valid choice");
				System.exit(0);
			}
		}else {
			System.out.println("File does not exist. Goodbye.");
		}
	}
}
