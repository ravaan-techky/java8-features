package com.example.string;

public class StringEqualityDemo {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Hello";
		System.out.println("Hashcode of s1       " + s1.hashCode());
		System.out.println("Hashcode of s2       " + s2.hashCode());
		System.out.println("Equality of s1 & s2  " + s1.equals(s2));
		System.out.println("Equality of s1 == s2 " + (s1 == s2));
		String s3 = new String("Hello");
		System.out.println("Hashcode of s3       " + s3.hashCode());
		System.out.println("Equality of s1 & s3  " + s1.equals(s3));
		System.out.println("Equality of s1 == s3 " + (s1 == s3));
		/*intern method call - adding string into String pool */
		System.out.println("Equality of s1 == s3 " + (s1 == s3.intern()));
	}

}
