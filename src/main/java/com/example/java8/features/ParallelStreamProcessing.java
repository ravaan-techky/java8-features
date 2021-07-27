package com.example.java8.features;

import java.util.stream.Stream;

public class ParallelStreamProcessing {
	public static void main(String[] args) {
		System.out.println("In main method");
		/*
		 * Stream.of(5, 10, 15, 20, 25).parallel().forEach(item -> { for(int i = item; i
		 * > item - 5; i --) { try { Thread.sleep(1000); }catch(InterruptedException
		 * exception) { exception.printStackTrace(); } System.out.println(i); } });
		 */
		
		Stream.of(5, 10, 15, 20, 25).parallel().forEachOrdered(item -> {
			for(int i = item; i > item - 5; i --) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException exception) {
					exception.printStackTrace();
				}
				System.out.println(i);
			}
		});
	}
}
