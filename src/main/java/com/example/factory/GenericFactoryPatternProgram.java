package com.example.factory;

abstract class Animal {
	public Animal() {
	}
	
	public abstract void eat();
}

class Cow extends Animal {
	
	public Cow() {
		super();
		System.out.println("From Cow Class Constructor");
	}
	
	@Override
	public void eat() {
		System.out.println("From Cow eat grass");		
	}
}

class Tiger extends Animal {
	
	public Tiger() {
		super();
		System.out.println("From Tiger Class Constructor");
	}
	
	@Override
	public void eat() {
		System.out.println("From Tiger eat Meat");		
	}
}

public class GenericFactoryPatternProgram {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		System.out.println("In main application");
		Animal animal1 = createInstance(Tiger.class);
		animal1.eat();
		Animal animal2 = createInstance(Cow.class);
		animal2.eat();
	}

	private static <T> T createInstance(Class<? extends T> clazz)
			throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}

}
