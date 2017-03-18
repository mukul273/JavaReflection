package com.reflection.various;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetMethodsDemo {

	public static void main(String[] args) {
		// In Order to inspect the class we have to get the class instance

		// Class<Person> personClass = Person.class; // This is one way to get
		// the class
		Class<PersonGetMethod> personClass = null;

		try {
			personClass = (Class<PersonGetMethod>) Class.forName("com.reflection.various.PersonGetMethod"); // General way of getting a class
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(personClass.getName());
		System.out.println(personClass.getSimpleName());
		System.out.println(personClass.getPackage());
		
		System.out.println();
		
		Method[] methods = personClass.getMethods();
		
		for(Method method : methods)
			System.out.println(method.getName()+"-"+method.getReturnType());
	}
}

class PersonGetMethod {
	/*
	 * private String name; // Private vars are not accessible outside so won't
	 * print. private int age;
	 */

	public String name;
	public int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String returnName() {
		return this.name+" is the name";
	}
}