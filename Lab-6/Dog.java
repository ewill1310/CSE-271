//Written By Evan Williams
//Date: 3/3/22
//For Lab 6
//Creates Dog Class
public class Dog extends Animal{
	//===========================================================================Instance Variable
	private String breed;
	
	//===========================================================================Constructors
	Dog(){
		this(0, "", "");
	}
	
	Dog(int age, String size, String breed){
		super(age, size);
		this.breed = breed;
	}
	//===========================================================================Methods
	public  boolean  equals(Object o){//compares this object and object o to see if they are equal then returns a boolean value
		if(o instanceof Dog) {
			Dog a = (Dog) o;
			if(super.equals(a) && a.breed == this.breed) {
				return true;
			}
		}
		return false;
	}
	
	public String toString(){//returns a built string
		String temp = "I am a/an " + super.getSize() + " " + breed + " breed dog that is " + super.getAge() + " years old.";
		return temp;
	}
	
	public String speak(){//returns what a dog says
		String spoke = "Bark";
		return spoke;
	}
	
	//=================================================================================getters/setters
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
}
