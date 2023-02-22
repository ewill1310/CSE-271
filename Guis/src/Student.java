
public class Student extends People {
	//========================================================================================Instance Variables

	private double midtermGrade, finalGrade;
	private String university = "Miami University";

	//========================================================================================Constructors

	Student(int id, String name, String email, double midtermGrade, double finalGrade){
		super(id, name, email);
		setmidTerm(midtermGrade);
		setfinalGrade(finalGrade);
	}

	Student(int id, String name, String email){
		super(id, name, email);
	}

	Student(int id, String name){
		super(id, name);
	}

	Student(String s){
		this(s.split("\t"));
	}

	Student(String[] parts){
		this(Integer.parseInt(parts[0]), parts[1], parts[2], 
				Double.parseDouble(parts[3]), Double.parseDouble(parts[4]));
	}

	//Copy Constructor
	Student(Student e){
		this(e.getId(), e.getName(), e.getEmail(), e.getmidTerm(), e.getfinalGrade());
	}

	Student(){

	}


	//=========================================================================================Methods
	
	@Override
	public String eat() {
		return "I really love pizza";
	}
	
	@Override
	public void work() {
		System.out.println("Doing homework and studying");
	}

	
	@Override
	protected Student clone() {
		return new Student(this);
	}


	public char calcFinalGrade() {
		double grade = (midtermGrade+finalGrade)/2;
		if(grade>=90.0) {
			return 'A';
		}else if(grade>=80.0) {
			return 'B';
		}else if(grade>=70){
			return 'C';
		}else if(grade>=60.0){
			return 'D';
		}else{
			return 'F';
		}

	}
	public char calcFinalGrade(double bonus) {
		double grade = (midtermGrade+finalGrade)/2;
		grade += bonus;
		if(grade>=90.0) {
			return 'A';
		}else if(grade>=80.0) {
			return 'B';
		}else if(grade>=70){
			return 'C';
		}else if(grade>=60.0){
			return 'D';
		}else{
			return 'F';
		}
	}


	public String toString() {
		return String.format("%-20s %10.2f", getName(), ((midtermGrade+finalGrade)/2));
	}

	
	public String getUni() {
		return university; 
	}
	
	public void setUni(String s){
		this.university = s;
	}
	
	
	public double getmidTerm() {
		return midtermGrade;
	}

	public double getfinalGrade() {
		return finalGrade;
	}



	public void setmidTerm(double midtermGrade) {
		if(midtermGrade>=0) {
			this.midtermGrade = midtermGrade;
		}else {
			throw new IllegalArgumentException("Value cannot be negative");
		}

	}

	public void setfinalGrade(double finalGrade) {
		if(finalGrade>=0) {
			this.finalGrade = finalGrade;
		}else {
			throw new IllegalArgumentException("Value cannot be negative");
		}
	}


	public boolean equals(Object s) {
		
		if(!(s instanceof Student)) {
			return false;
		}
		
		Student o = (Student) s;
		
		if(super.equals(o) && midtermGrade == o.getmidTerm() && finalGrade == o.getfinalGrade()) {
			return true;
		}else {
			return false;
		}
	}

	

}
