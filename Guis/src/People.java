//abstract means i can no longer make objects of this class
public abstract class People {

	private int id;
	private String name, email;

	//======================================================================Constructors

	People(){ //empty constructor
		this(0, "", "");
	}

	People(int id, String name){
		this(id, name, "");
	}

	People(int id, String name, String email){
		this.id = id;
		this.name = name;
		this.email = email;
	}

	//======================================================================Getters/Setters

	public String eat() {
		return "I really love steak";
	}
	
	public abstract void work();
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean equals(Object s) {

		if(!(s instanceof People)) {
			return false;
		}

		People o = (People) s;

		if(this.id == o.getId() && this.name == o.getName() && this.email == o.getEmail()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public String toString() {
		return String.format("ID: %d , Name: %-20s , Email: %-20s", getId(), getName(), getEmail());
	}

}
