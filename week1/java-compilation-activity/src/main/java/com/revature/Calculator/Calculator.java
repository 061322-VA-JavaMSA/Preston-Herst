package com.revature.Calculator;

import com.revature.CalcException.*;
import java.util.Arrays;

public class Calculator {

	/*
	 * - add(int a, int b)
	 * - subtract
	 * - multiply
	 * - sum of an array
	 * - divide
	 * 		- throw a custom exception if divided by 0
	 */
	
	public int add(int a, int b) {
		
		return (a + b);
	}
	
	public int subtract(int a, int b) {
		return (a - b);
	}
	
	public int sumOfAnArray(int[] intArr) {
		return Arrays.stream(intArr).sum();
	}
	
	public int divide(int a, int b) throws ArithmeticException{
		if((a / b) == 0) {
			throw new ArithmeticException();
		}
		return (a / b);
	}
}
