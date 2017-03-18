package com.reflection.various;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetPrivateMembersDemo {

	public static void main(String[] args) {
		// In Order to inspect the class we have to get the class instance

		// Class<Person> personClass = Person.class; // This is one way to get
		// the class
		Class<PersonGetPrivate> personClass = null;
		try {
			personClass = (Class<PersonGetPrivate>) Class.forName("com.reflection.various.PersonGetPrivate"); // General way of getting a class
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(personClass.getName());
		System.out.println(personClass.getSimpleName());
		System.out.println(personClass.getPackage());

		Field[] fields = personClass.getDeclaredFields();// to get the declared fields even if they are private

		for (Field f : fields)
			System.out.println(f.getName() + "- Type:" + f.getType());
		
		System.out.println();
		
		Method[] methods = personClass.getDeclaredMethods();
		
		for(Method method : methods)
			System.out.println(method.getName()+"-"+method.getReturnType());
	}
}

class PersonGetPrivate {
	
	 private String name;
	 private int age;
	 

	/*public String name;
	public int age;
*/
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

	private String returnName() {
		return this.name + " is the name";
	}
}