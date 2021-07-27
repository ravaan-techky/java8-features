package com.example.java8.features.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Customer {
	private final Integer id;
	
	private final String name;
	
	private final String emailAddress;
	
	private final List<String> phoneNumbers;
	
	private final Double bankBalance;
	
	public Customer(Integer id, String name, String emailAddress, List<String> phoneNumbers, Double bankBalance) {
		this.id = id;
		this.name = name;
		this.emailAddress = emailAddress;
		this.phoneNumbers = phoneNumbers;
		this.bankBalance = bankBalance;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public Double getBankBalance() {
		return bankBalance;
	}
}

public class FlatMapAndMapFunctionExample {

	private static final List<Customer> customerList = new ArrayList();
	
	static {
		customerList.add(new Customer(1, "John Smith", "jsmith@xyz.com", Arrays.asList("242545344", "43544345"), 10000.00));
		customerList.add(new Customer(2, "Deniel Kotch", "dkotch@xyz.com", Arrays.asList("642545344"), 250000.00));
	}
	
	public static void main(String[] args) {
		List<String> emailAddresses = customerList.stream().map(customer -> customer.getEmailAddress()).collect(Collectors.toList());
		System.out.println("Customer List has below email address " + emailAddresses);
		
		List<String> phoneNumbers = customerList.stream().flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList());
		System.out.println("Phone Number List " + phoneNumbers);
		
		Double sum = customerList.stream().map(customer -> customer.getBankBalance()).collect(Collectors.summingDouble(Double::doubleValue));
		System.out.println("Summation of Balance of all customers " + sum);
		
		Double averageValue = customerList.stream().map(customer -> customer.getBankBalance()).collect(Collectors.averagingDouble(Double::doubleValue));
		System.out.println("Average Value " + averageValue);
		
		
		Integer sumInt1 = IntStream.rangeClosed(1, 50).sum();
		System.out.println(sumInt1);
		
		Integer sumInt2 = IntStream.range(1, 50).boxed().collect(Collectors.summingInt(Integer::intValue));
		System.out.println(sumInt2);		
		
	}
}
