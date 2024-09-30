//Written By Evan Williams
//Date: 3/3/22
//For Lab 6
//Creates Person Class
public class Person {
	
//============================================================================Instance Variabels
	
	private String name;
	private int yearOfBirth;
	
//============================================================================Constructors
	
	Person(){
		this("", 0);
	}
	
	Person(String name, int yearOfBirth){
		this.name = name;
		this.yearOfBirth = yearOfBirth;
	}
	
	
//=============================================================================Methods
	
	public  boolean  equals(Object  o) {//compares this object and object o to see if they are equal then returns a boolean value
		if(o instanceof Person) {
			Person p = (Person)o;
			
			if(p.name == this.name && p.yearOfBirth == this.yearOfBirth) {
				return true;
			}
		}
		return false;
	}
	
	
	public  String  toString() {//returns a built string
		String temp = ("I am a person whose name is " + name + " and was born in " + yearOfBirth + ".");
		return temp;
	}
//=====================================================================================getters/setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	
	
}
