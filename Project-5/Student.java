import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class creates the student object to be used for creating a student
 * record
 * 
 * @author will1310
 *
 */
public class Student implements Comparable<Student> {
	private int id, grade;
	private String firstName, lastName;

	/**
	 * empty constructor for Student class
	 */
	Student() {
		this(0, "", "", 0);
	}

	/**
	 * workhorse constructor for Student class
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param grade
	 */
	Student(int id, String firstName, String lastName, int grade) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
	}

	/**
	 * This method takes input from a file and converts it to a student array
	 * 
	 * @param filePath
	 * @return
	 */
	public static Student[] readFromFile(String filePath) throws IOException {
		Scanner in = null;
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<String> lines = new ArrayList<String>();
		int count = 0;
		try {
			in = new Scanner(new File(filePath));
			while (in.hasNextLine()) {
				lines.add(in.nextLine());
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Student[] studentes = new Student[count];
		for (String s : lines) {
			String[] parts = s.split(",");
			Student temp = new Student(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]));
			students.add(temp);		}
		for (int i = 0; i < students.size(); i++) {
			studentes[i] = students.get(i);
		}
		return studentes;
	}

	/**
	 * this method return a string of information from the student class
	 */
	public String toString() {
		return String.format("%d, %s, %s, %d", id, firstName, lastName, grade);
	}

	/**
	 * this method checks to see if the student objects are equal, checking only the
	 * ID instance variable
	 */
	public boolean equals(Object o) {
		if (o instanceof Student) {
			Student s = (Student) o;
			if (s.id == id) {
				return true;
			}
		}
		return false;
	}

	/**
	 * sorts the student array lexicographically
	 * 
	 * @param students
	 */
	public void sort(Student[] students) {
		if (students == null || students.length < 2) {
			return;
		}
		for (int i = 1; i < students.length; i++) {
			Student temp = students[i];
			int j = i;
			while (j > 0 && temp.compareTo(students[j-1]) > 0) {
				students[j] = students[--j];
			}
			students[j] = temp;	
		}
	}

	/**
	 * searched the student array for a specific student and returns the location in
	 * the array
	 * 
	 * @param students
	 * @param s
	 * @return
	 */
	public int search(Student[] students, Student s) {
		return search(students, s, 0);
	}

	/**
	 * helper for search method
	 * @param students
	 * @param s
	 * @param low
	 * @param high
	 * @return
	 */
	public int search(Student[] students, Student s, int index) {
		if (index > students.length - 1) {
			return -1;
		}
		if (s.equals(students[index])) {
			return index;
		} else {
			return search(students, s, index + 1);
		}
	}
	
	/**
	 * compares student objects grades and returns a -1 if the grade is lower
	 * and a 1 if it is higher
	 */
	@Override
	public int compareTo(Student o) {
		if (o.grade == grade) {
			return 0;
		}else if(o.grade < grade) {
			return 1;
		}
		return -1;
	}
	
	

}
