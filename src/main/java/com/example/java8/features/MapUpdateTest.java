package com.example.java8.features;

import java.util.HashMap;
import java.util.Map;

public class MapUpdateTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Effective Java", "Kathy Sierra");
		map.put("Spring in Action", "Craig Walls");
		map.put("Hibernate in Action", "Gavin King");
		map.put("Pro Angular", "Freeman");
		map.put("Pro Spring Boot", "Felipe Gutierrez");
		
		map.entrySet().iterator().forEachRemaining(System.out::println);
		
		System.out.println("=========================");
		String result = map.compute("Effective Java", (key, value) -> key + "=" + value);
		System.out.println(result);
		map.computeIfAbsent("Core Java", (value) -> "Monaj Bajpey");
		map.computeIfPresent("Effective Java", (key, value) -> "Bhushan Patil");
		map.entrySet().iterator().forEachRemaining(System.out::println);
	}
}
