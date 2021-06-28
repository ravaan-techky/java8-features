package com.example.java8.features;

import java.util.function.Function;

public class FunctionInterfaceProgram1 {

	public static void main(String[] args) {
		Function<String, Integer> function1 = string -> string.length();
		Function<Integer, Integer> function2 = num -> num * 2;
		Integer result = function1.andThen(function2).apply("Bhushan Patil");
		System.out.println(result);
	}
}
