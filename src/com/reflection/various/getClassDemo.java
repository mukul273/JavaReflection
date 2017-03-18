package com.reflection.various;

public class getClassDemo {

	public static void main(String[] args) {
		// In Order to inspect the class we have to get the class instance
		
		//Class<Person> personClass = Person.class; // This is one way to get the class
		Class personClass = null;
		try {
			personClass = Class.forName("com.reflection.various.Person"); // General way of getting a class
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(personClass.getName());
		System.out.println(personClass.getSimpleName());
	}
}

class Person {
	
}