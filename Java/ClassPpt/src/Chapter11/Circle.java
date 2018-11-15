package Chapter11;

public class Circle {

		int radius;
		
		Circle(int radius){
			
			this.radius = radius;
		}
		
		public boolean equals(Object obj) {
			
			if(!(obj instanceof Circle))
				return false;
			
			Circle circle = (Circle) obj;
			if(radius == circle.radius)
				return true;
			else
				return false;
			
		}
}
