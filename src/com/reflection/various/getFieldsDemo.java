package com.reflection.various;

import java.lang.reflect.Field;

public class getFieldsDemo {

	public static void main(String[] args) {

		// In Order to inspect the class we have to get the class instance

		// Class<Person> personClass = Person.class; // This is one way to get
		// the class
		Class<PersonGetField> personClass = null;
		try {
			personClass = (Class<PersonGetField>) Class.forName("com.reflection.various.PersonGetField"); // General way of getting a class
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(personClass.getName());
		System.out.println(personClass.getSimpleName());
		System.out.println(personClass.getPackage());
		
		Field[] fields = personClass.getFields();
		
		for(Field f : fields)
			System.out.println(f.getName()+ "- Type:"+f.getType());
	}
}

class PersonGetField {
	/*private String name; // Private vars are not accessible outside so won't print.
	private int age;*/
	
	public String name;
	public int age;
}