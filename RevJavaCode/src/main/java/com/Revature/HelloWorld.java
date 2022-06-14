package com.Revature;

import java.util.Arrays;

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
		
		//converts string "5" to int 5
		int i = Integer.parseInt("5");
		
		//-----------------------------------------
		
		//declaring an array of size 5
		int[] numbers = new int[5];
		
		//assigning values to elements in array
		numbers[0] = 1;
		numbers[1] = 2;
		numbers[3] = 7;
		
		//printing each element using for loop
		for (int j = 0; j < numbers.length; j++) {
			System.out.println(numbers[j]);
		}
		System.out.println();
		
		//enhanced for loop
		for(int nums: numbers) {
			System.out.println(nums);
		}
		
		//turning string into character array
		String p = "Preston";
		char[] chars = p.toCharArray();
		
		for(char c: chars) {
			System.out.println(c);
		}
		
		//sorting numbers array using Arrays.sort()
		Arrays.sort(numbers);
		
	}
}
