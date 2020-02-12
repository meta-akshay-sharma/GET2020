package com.akshay;

import java.io.PrintWriter;

public class Triangle {

	public double area(double sideA, double sideB, double sideC) {
		
		//PrintWriter out = new PrintWriter(System.out);
		try {
			if((sideA > 0) && (sideB > 0) && (sideC > 0)&&(((sideA+sideB)>sideC)&&((sideB+sideC)>sideA)&&((sideC+sideA)>sideB)))
			{
				double s = (sideA + sideB + sideC)/2;
				double areaTriangle = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
				return areaTriangle;
			} else {
				System.out.println("Invalid Input");
				return -1;
			}
		}
		catch(NumberFormatException ex) {
			System.out.println("Number Format Exception");
			return 0;
		}
	}
}
