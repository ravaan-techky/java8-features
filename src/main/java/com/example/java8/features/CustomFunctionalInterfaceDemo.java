package com.example.java8.features;

@FunctionalInterface
interface AddtionalInterface {
	Integer addition(Integer num1, Integer num2);
	
	public default Double addition(Double num1, Double num2) {
		return num1 + num2;
	}
	
	public static String addition(String str1, String str2) {
		return str1 + str2;
	}
}

public class CustomFunctionalInterfaceDemo {
	public static void main(String[] args) {
		AddtionalInterface additionObject = (num1, num2) -> {return num1 + num2;};
		System.out.println("Addition of 2 Integer Number with Custom Functional Interface                 " + additionObject.addition(12, 10));
		System.out.println("Addition of 2 Double Number with Custom Functional Interface's Default method " + additionObject.addition(12.5D,  13.5D));
		/* additionObject.addition("Hello", "World!!!"); */
		System.out.println("Addition of 2 String with Custom Functional Interface's static method " + AddtionalInterface.addition("Hello", "World!!!")); 
	}
}
