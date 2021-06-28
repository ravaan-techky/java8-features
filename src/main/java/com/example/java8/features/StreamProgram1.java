package com.example.java8.features;

import java.util.HashMap;
import java.util.Map;

public class StreamProgram1 {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>(); 
        map.put("Effective Java", "Kathy Sierra");
        map.put("Spring in Action", "Craig Walls");
        map.put("Hibernate in Action", "Gavin King");
        map.put("Pro Angular", "Freeman");
        map.put("Pro Spring Boot", "Felipe Gutierrez");
		
        map.keySet().iterator().forEachRemaining(System.out::println);
	}

}
