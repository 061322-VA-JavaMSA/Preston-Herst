package com.Revature.scopes;

public class MyClass {
	
	//method to reverse a String
	//takes in a string, and returns a reversed version
	public String reverseString(String stringReversed) {
		
		
		String reversed = "";
		char[] letters = stringReversed.toCharArray();
		
		for(int i = letters.length-1; i >= 0; i--) {
			reversed = reversed + letters[i];
		}
		return reversed;
	}

}
