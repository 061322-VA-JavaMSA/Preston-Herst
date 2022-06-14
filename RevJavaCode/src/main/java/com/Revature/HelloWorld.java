package com.Revature;

public class HelloWorld {
	
	public static void main(String[] args) {
		
		System.out.println("Hello from Eclipse!");
		
		
		//widening casting
		byte a = 2;
		int b = a;
		
		//narrowing casting
		double d = 35.5;
		float f = (float)d;
		
		int wholeNumber = 11;
		//method 1
		//Integer intWrap = new Integer(wholeNumber);
		//method 2 
		Integer intWrap = wholeNumber;
		
		
	}
}
