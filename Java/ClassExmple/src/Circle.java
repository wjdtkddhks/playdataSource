
public class Circle {
	
	private double radius;
	
	Circle(double radius)
	{
		this.radius = radius;
	}
	
	double getArea()
	{
		double area;
		area = radius*radius*3.14;
		return area;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}
