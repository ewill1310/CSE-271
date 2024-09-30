
public class Triangle {
	//===================================Instance Variable
		double base;
		double height;

	//===================================Constructor	
		/**
		 * Constructor to build triangle object
		 * @param base
		 * @param height
		 */
		Triangle(double base, double height){
			this.base = base;
			this.height = height;
		}

	//===================================Methods
		/**
		 * getArea take the triangles base and height to calculate the triangles area and return it as a double
		 */
		public double getArea() {	
			double area = (0.5*(base * height));
			return area;
		}
		
		/**
		 * scales the base and height by multiplying the base and height by the instance factor
		 */
		public void scale(double factor) {
			base = base * factor;
			height = height * factor;
		}
		
		/**
		 * checks to see if the two objects are the same after checking if the objects are both triangles
		 */
		public boolean equals(Object o) {
			if(o instanceof Triangle) {
				Triangle t = (Triangle) o;
				if(t.base == base && t.height == height) {
					return true;
				}
			}
			return false;
		}
		/**
		 * returns a string that is formatted a certain way
		 */
		public String toString() {
			String temp = String.format("Triangle [base = %.1f, height = %.1f]", base, height);
			return temp;
		}

		public double getBase() {
			return base;
		}

		public void setBase(double base) {
			this.base = base;
		}

		public double getHeight() {
			return height;
		}

		public void setHeight(double height) {
			this.height = height;
		}
		
		
}
