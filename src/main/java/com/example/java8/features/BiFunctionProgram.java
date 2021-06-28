package com.example.java8.features;

import java.util.function.BiFunction;

public class BiFunctionProgram {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, String> function = (num1, num2) -> "" + num1 + num2;
		System.out.println("Result of function " + function.apply(12, 21));
	}
}
