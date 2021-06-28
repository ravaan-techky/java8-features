package com.example.singleton;

import java.lang.reflect.Constructor;

public class SingletonR {

	private static SingletonR instance = new SingletonR();

	/*
	 * private SingletonR() { System.out.println("creating instance....."); }
	 */
	
	private SingletonR() {
		System.out.println("creating instance.....");
		if (instance != null) {
			throw new RuntimeException("Can't create instance. Please use getInsance() to create it.");
		}
	}

	public static SingletonR getInstance() {
		return instance;
	}

	public static void main(String[] args) throws Exception {
		SingletonR s1 = SingletonR.getInstance();
		SingletonR s2 = SingletonR.getInstance();
		System.out.println("Hashcode of Object s1: " + s1.hashCode());
		System.out.println("Hashcode of Object s2: " + s2.hashCode());

		@SuppressWarnings("rawtypes")
		Class clazz = Class.forName("com.example.singleton.SingletonR");
		@SuppressWarnings("unchecked")
		Constructor<SingletonR> ctr = clazz.getDeclaredConstructor();
		ctr.setAccessible(true);
		SingletonR s3 = ctr.newInstance();
		System.out.println("Hashcode of Object s3: " + s3.hashCode());

	}

}
