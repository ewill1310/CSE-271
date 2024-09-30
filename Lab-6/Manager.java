//Written By Evan Williams
//Date: 3/3/22
//For Lab 6
//Creates Manager Class
public class Manager extends Employee{
	//==================================================================================Instance Variable
		private String department;
		
	//==================================================================================Constructors
		
		public  Manager() {
			this("", 0, 0.0, "");
		}
		
		public Manager(String name, int yearOfBirth, double salary, String department) {
			super(name, yearOfBirth, salary);
			this.department = department;
		}
		
	//===================================================================================Methods
		@Override
		public boolean equals(Object o) {//compares this object and object o to see if they are equal then returns a boolean value
			if(o instanceof Manager) {
				Manager m = (Manager) o;
				if(super.equals(m) && m.department == this.department) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public String toString() {//returns a built string
			String temp = ("I am a manager of the "+ department + " department. " + super.toString());
			return temp;
		}

		//================================================================================getters/setters

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}
		
		
}
