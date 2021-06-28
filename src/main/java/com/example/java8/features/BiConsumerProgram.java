package com.example.java8.features;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerProgram {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("Effective Java", "Kathy Sierra");
		map.put("Spring in Action", "Craig Walls");
		map.put("Hibernate in Action", "Gavin King");
		map.put("Pro Angular", "Freeman");
		map.put("Pro Spring Boot", "Felipe Gutierrez");
		
		map.forEach((key, value) -> System.out.println("Book " + key + " author is " + value));
		
		BiConsumer<Integer, Integer> addNumber = (num1, num2) -> System.out.println(num1 + num2);
		addNumber.accept(10, 12);
		
		add(10,13, (a, b) -> System.out.println(a + b));
		add(10.00,13.50, (a, b) -> System.out.println(a + b));
		add("Bhushan ","Patil", (a, b) -> System.out.println(a + b));
		
		
	}
	
	private static <T, U> void add(T t, U u, BiConsumer<T, U> consumer) {
		consumer.accept(t, u);
	}

}
