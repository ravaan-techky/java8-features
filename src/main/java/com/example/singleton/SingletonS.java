package com.example.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonS implements Serializable{
	
	public static SingletonS instance= new SingletonS();
	
	private SingletonS() {
		System.out.println("creating instance.....");
	}
	
	public static SingletonS getInstance() {
		return instance;
	}

	public static void main(String[] args) throws Exception{
		SingletonS s1 = SingletonS.getInstance();
		SingletonS s2 = SingletonS.getInstance();
		System.out.println("Hashcode of Object s1: " +s1.hashCode());
		System.out.println("Hashcode of Object s2: " +s2.hashCode());
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/s2.ser"));
		oos.writeObject(s2);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/s2.ser"));
		SingletonS s3= (SingletonS)ois.readObject();
		
		System.out.println("Hashcode of Object s3: " +s3.hashCode());
	}	
	
	private Object readResolve() {
		System.out.println("Applying ReadResolve Method....");
		return this.getInstance();
	}
}
