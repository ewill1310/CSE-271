
public class Circle extends Shape implements Area{

	double radius;
	
	Circle(double radius, String name) {
		super(name);
		this.radius = radius;
	}

	public boolean equals(Object o) {
		
		return false;
	}
	
	public String toString() {
		String temp = "";
		return temp;
	}
	
	@Override
	public String getName() {
		return null;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

}
