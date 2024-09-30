//Written By Evan Williams
//Date: 3/3/22
//For Lab 6
//Creates Animal Class
public class Animal {
	//======================================================================================Instance Variables
	private int age;
	private String size;
	
	//=====================================================================================Constructors
	Animal(){
		this(0, "");
	}
	
	Animal(int age, String size){
		this.age = age;
		this.size = size;
	}
	//=====================================================================================Methods
	public  boolean  equals(Object o){//compares this object and object o to see if they are equal then returns a boolean value
		if(o instanceof Animal) {
			Animal a = (Animal) o;
			if(a.age == this.age && a.size == this.size) {
				return true;
			}
		}
		return false;
	}
	
	public String toString(){//returns a built string
		String temp = "I am an unknown " + size + " animal that is " + age + " years old.";
		return temp;
	}
	
	public String speak(){ //returns what a unknown animal says
		String spoke = "Unintelligible sound";
		return spoke;
	}
	//======================================================================================Get/Set

	public int getAge() {//gets animals age
		return age;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
