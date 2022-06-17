package com.revature.Calculator;

import com.revature.CalcException.DivisionException;

public class CalcTester {
	
	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		
		try {
			System.out.println(cal.divide(5, 0));
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

	}
}
