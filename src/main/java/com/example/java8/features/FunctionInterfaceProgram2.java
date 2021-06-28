package com.example.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class FunctionInterfaceProgram2 {

	public static void main(String[] args) {
		List<String> listData = Arrays.asList("Bhushan","Apple","Hi", "How are you?");
		Map<String, Integer> resultMap = convertToMapFromList(listData, item -> item.length());
		resultMap.entrySet().iterator().forEachRemaining(System.out::println);
	}

	
	public static Map<String, Integer> convertToMapFromList(List<String> list, Function<String, Integer> function){
		Map<String, Integer> resultMap = new ConcurrentHashMap<>();
		list.forEach(item -> {
			resultMap.put(item, function.apply(item));
		});
		return resultMap;
	}
}
