package com.example.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerProgram1 {
	public static void main(String[] args) {
		Consumer<String> print = x -> System.out.println(x);
		print.accept("Hello World");

		List<Integer> listNumber = Arrays.asList(1, 2, 3, 4, 5);
		/* forEach(listNumber, item -> System.out.println(item)); */

		forEach(listNumber, System.out::println);
	}

	private static <T> void forEach(List<T> list, Consumer<T> consumer) {
		for (T t : list) {
			consumer.accept(t);
		}
	}

	/*
	 * private static void forEach(List<Integer> list, Consumer<Integer> consumer) {
	 * for(Integer item : list) { consumer.accept(item); } }
	 */
}
