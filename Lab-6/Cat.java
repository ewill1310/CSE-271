//Written By Evan Williams
//Date: 3/3/22
//For Lab 6
//Creates Cat Class
public class Cat extends Animal{
	//===========================================================================Instance Variable
	private int numberOfLives;
	
	//===========================================================================Constructors
	Cat(){
		this(0, "", 0);
	}
	
	Cat(int age, String size, int lives){
		super(age, size);
		this.numberOfLives = lives;
	}
	//===========================================================================Methods
	public  boolean  equals(Object o){//compares this object and object o to see if they are equal then returns a boolean value
		if(o instanceof Cat) {
			Cat a = (Cat) o;
			if(super.equals(a) && a.numberOfLives == this.numberOfLives) {
				return true;
			}
		}
		return false;
	}
	
	public String toString(){//returns a built string
		String temp = "I am a "+ super.getSize() + " cat that is " + super.getAge() + " years old and have " + numberOfLives + " lives left.";
		return temp;
	}
	
	public String speak(){ //returns what a cat says
		String spoke = "Meow";
		return spoke;
	}
	
//=============================================================================================================getters/setters
	public int getNumberOfLives() {
		return numberOfLives;
	}

	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}
	
}
