package com.Revature;

public class Calculator {

	
	public static void main(String[] args) {
		System.out.println(divide(5, 0));
	}
	public static int divide(int a, int b) {
		
		try {
			
			if(a / b ==0) {
				throw new ArithmeticException("hi");
				}
		}catch(ArithmeticException e) {
			System.out.println(e.toString());
		}
		return (a / b);
	}
}


