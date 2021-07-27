package com.example.java8.features;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Employee {
	private Integer empId;
	private String empName;

	public Employee(Integer empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Emp ID : " + this.empId + " Name : " + this.empName;
	}
}

public class ListManipulationWithStream {
	public static void main(String[] args) throws IOException {
		List<Integer> list = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
		List<Integer> sqList = list.stream().flatMap(item -> Stream.of(item * item)).collect(Collectors.toList());
		// System.out.println("Original List : " + list);
		// System.out.println("Square List : " + sqList);

		try (Stream<String> fileLines = Files.lines(Paths.get("D://temp.txt"), StandardCharsets.UTF_8);
				Stream<String> allWords = fileLines.flatMap(line -> Stream.of(line.split(" +")));) {

			// System.out.println("All Word from files - ");
			// allWords.forEach(System.out::println);

			Map<String, Integer> counts = allWords.collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
			// System.out.println("Word Count - ");
			// counts.entrySet().forEach(System.out::println);
			Optional<Entry<String, Integer>> findFirstResult = counts.entrySet().stream().sorted((entry1, entry2) -> {
				return entry2.getValue().compareTo(entry1.getValue());
			}).findFirst();
			if (findFirstResult.isPresent()) {
				// System.out.print("Max Count Result " + findFirstResult.get());
			}
		}

		List<Employee> empList = IntStream.range(0, 50).mapToObj(index -> {
			return new Employee(index + 1, "EmployeeName-" + (index + 1));
		}).collect(Collectors.toList());

		// empList.forEach(System.out::println);

		int input = 27;
		int i = input;
		String result = "No";
		while (i != 0) {
			int k = i % 10;
			if (input % k == 0) {
				System.out.println(input + " is divisible by " + k);
				result = "Yes";
			} else {
				System.out.println(input + " is not divisible by " + k);
			}
			i = i / 10;
		}
		System.out.println("Result => " + result);

		int palindrome = 12341;
		int temp = palindrome;
		int newNumber = 0;
		while (temp != 0) {
			int reminder = temp % 10;
			newNumber = (newNumber * 10) + reminder;
			temp = temp / 10;
		}
		if (palindrome == newNumber) {
			System.out.println("Number is Palindrome");
		} else {
			System.out.println("Number is not Palindrome");
		}
		
		
		//Stream.of("Bhushan".toCharArray()).collect(Collectors.toList()).re

	}
}
