
public class Rectangle implements Shape{
//===================================Instance Variable
	int x;
	int y;
	double length;
	double width;

//===================================Constructor	
	/**
	 * Constructor to build rectangle object
	 * @param x
	 * @param y
	 * @param length
	 * @param width
	 */
	Rectangle(int x, int y, double length, double width){
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
	}

//===================================Methods
	/**
	 * getArea take the rectangles length and width to calculate the rectangles area and return it as a double
	 */
	public double getArea() {	
		double area = (length * width);
		return area;
	}
	
	/**
	 * scales the length and width by multiplying the length and width by the instance factor
	 */
	public void scale(double factor) {
		length = length * factor;
		width = width * factor;
	}
	
	/**
	 * checks to see if the two objects are the same after checking if the objects are both rectangles
	 */
	public boolean equals(Object o) {
		if(o instanceof Rectangle) {
			Rectangle r = (Rectangle) o;
			if(r.length == length && r.width == width && r.x == x && r.y == y) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * returns a string that is formatted a certain way
	 */
	public String toString() {
		String temp = String.format("Rectangle [x = %d, y = %d, length = %.1f, width = %.1f]", x, y, length, width);
		return temp;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	
}
