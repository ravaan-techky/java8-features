package com.example.singleton;

public class SingletonC implements Cloneable {

	public static SingletonC instance = new SingletonC();

	private SingletonC() {
		System.out.println("creating instance.....");
	}

	public static SingletonC getInstance() {
		return instance;
	}

	public static void main(String[] args) throws Exception {
		SingletonC s1 = SingletonC.getInstance();
		SingletonC s2 = SingletonC.getInstance();
		System.out.println("Hashcode of Object s1: " + s1.hashCode());
		System.out.println("Hashcode of Object s2: " + s2.hashCode());

		SingletonC s3 = (SingletonC) s2.clone();
		System.out.println("Hashcode of Object s3: " + s3.hashCode());
	}

	protected Object clone() throws CloneNotSupportedException {
		if (instance != null) {
			throw new CloneNotSupportedException("Can't create instance. Please use getInsance() to create it.");
		}
		return super.clone();
	}
}
