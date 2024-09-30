//Written By Evan Williams
//Date: 3/3/22
//For Lab 6
//Creates Employee Class
public class Employee extends Person{
	
	//================================================================================Instance Variable
	private double salary;
	
	//================================================================================Constructors
	Employee(){
		this("", 0, 0.0);
	}
	
	Employee(String name, int yearOfBirth, double salary){
		super(name, yearOfBirth);
		this.salary = salary;
	}
	
	//================================================================================Methods
	
	@Override
	public boolean equals(Object o){//compares this object and object o to see if they are equal then returns a boolean value
		if(o instanceof Employee) {
			Employee p = (Employee)o;
			
			if(super.equals(p) && p.salary == this.salary) {
				return true;
			}	
		}
		return false;
	}
	
	
	@Override
	public String toString() {//returns a built string
		String temp = String.format("I am an employee and have a salary of $%.2f.", salary) + super.toString();
		return temp;
	}

	

//==================================================================================getters/setters
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
