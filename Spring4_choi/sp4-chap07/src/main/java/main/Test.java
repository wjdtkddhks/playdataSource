package main;

import chap07.ExTimeCalculator;
import chap07.ImpeCalculator;
import chap07.RecCalculator;

public class Test {
	
	public static void main(String[] args) {
		ImpeCalculator im = new ImpeCalculator();
		RecCalculator re = new RecCalculator();
		ExTimeCalculator ex1 = new ExTimeCalculator(im);
		ExTimeCalculator ex2 = new ExTimeCalculator(re);
		
		ex1.factorial(4);
		ex2.factorial(4);
	}

}
