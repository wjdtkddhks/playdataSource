package chapter8;

class Fraction {

		private int numerator;
		private int denominator;
		
		Fraction(int numerator, int denominator){
			
			this.numerator = numerator;
			this.denominator = denominator;
		}
		
		private double getDouble() {
			
			return (double) numerator/denominator;
		}
		protected int getInt() {
			
			return (int) getDouble();
		}
		
}
