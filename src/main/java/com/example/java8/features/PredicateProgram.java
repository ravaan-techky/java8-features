package com.example.java8.features;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PredicateProgram {

	public static void main(String[] args) {
		List<Integer> listData = Arrays.asList(1, 6, 7, 2, 9, 3, 11, 21, 24, 25, 5);
		System.out.println("List Data Count " + listData.stream().count());
		long filterListCount = listData.stream().filter(x -> x > 5).count();
		System.out.println("Filtered List Data Count " + filterListCount);
		Collections.sort(listData, (arg1, arg2) -> arg1 > arg2 ? 1 : -1);
		System.out.println(listData);
		Collections.sort(listData, (arg1, arg2) -> arg2 > arg1 ? 1 : -1);
		System.out.println(listData);
		List<LocalDate> dateList = Arrays.asList(LocalDate.parse("2020-01-12"), LocalDate.parse("2022-01-12"),
				LocalDate.parse("2020-11-12"), LocalDate.parse("2021-02-12"),LocalDate.now());
		Collections.sort(dateList, (arg1, arg2) -> arg1.compareTo(arg2));
		dateList.forEach(System.out::println);
		Collections.sort(dateList, (arg1, arg2) -> arg2.compareTo(arg1));
		dateList.forEach(System.out::println);
		
		listData.stream().filter(x -> x > 5).collect(Collectors.toList()).forEach(System.out::println);
		
		Map<Boolean, List<Integer>> resultData = listData.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
		resultData.forEach((key, value) -> System.out.println(key + " = " + value));
		
		Map<Integer, Object> map = listData.stream().collect(Collectors.toMap(Integer::intValue, Integer::intValue));
		map.forEach((key, value) -> System.out.println(key + "=" + value));
		
		AtomicInteger total = new AtomicInteger(0);
		listData.forEach(item -> total.addAndGet(item));
		System.out.println("List total value sum - " + total.get());
		
		System.out.println("Total value of list by other method - " + listData.stream().reduce(0, (a, b) -> a + b));
	}

}
