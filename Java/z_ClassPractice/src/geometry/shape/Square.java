package geometry.shape;
import geometry.common.Polygon;
public class Square extends Polygon {
	
	Square obj1 = new Square(4, 10, 10);
	
	public Square(int x, int y, int sideLength) {
	super(4);
	setPoint(0, x, y);
	setPoint(1, x+sideLength, y);
	setPoint(2, x+sideLength, y+sideLength);
	setPoint(3, x, y+sideLength);
	
	}
	public int getX(int index) {
		return x[index];
	}
	
	public int getY(int index) {
		return y[index];		
	}

}

