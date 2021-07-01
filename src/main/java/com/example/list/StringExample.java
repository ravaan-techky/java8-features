package com.example.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * The Class StringExample.
 */
public class StringExample {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String str = "hello world";
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			map.computeIfPresent(str.charAt(i), (key, value) -> {
				return value + 1;
			});
			map.computeIfAbsent(str.charAt(i), (key) -> {
				return 1;
			});
		}

		/*
		 * map.entrySet().forEach((entry) -> { System.out.println(entry.getKey() +
		 * " => " + entry.getValue()); });
		 */ 

		/*
		 * Optional<Integer> maxNumberOptional = map.values().stream().max((num1, num2)
		 * -> num1.compareTo(num2)); if (maxNumberOptional.isPresent()) { final Integer
		 * maxNumber = maxNumberOptional.get(); map.entrySet().forEach((entry) -> { if
		 * (maxNumber == entry.getValue()) { System.out.println(entry.getKey() + " => "
		 * + entry.getValue()); } }); }
		 */
		
		Map<Integer, Character> newMap = new TreeMap<>((num1, num2) -> {return num2.compareTo(num1);});
		map.entrySet().forEach(entry -> {
			newMap.put(entry.getValue(), entry.getKey());
		});
		
		Entry<Integer, Character> entry = newMap.entrySet().iterator().next();
		System.out.println(entry.getKey() + " => " + entry.getValue());
	}

}
