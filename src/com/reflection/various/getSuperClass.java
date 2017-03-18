package com.reflection.various;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class getSuperClass {

	public static void main(String[] args) {
		// In Order to inspect the class we have to get the class instance

				// Class<Person> personClass = Person.class; // This is one way to get
				// the class
				Class<PersonEmployee> personClass = null;
				try {
					personClass = (Class<PersonEmployee>) Class.forName("com.reflection.various.PersonEmployee"); // General way of getting a class
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				System.out.println(personClass.getName());
				System.out.println(personClass.getSimpleName());
				System.out.println(personClass.getPackage());
				System.out.println(personClass.getSuperclass());

				Field[] fields = personClass.getDeclaredFields();// to get the declared fields even if they are private

				for (Field f : fields)
					System.out.println(f.getName() + "- Type:" + f.getType());
				
				System.out.println("Access Methods...");
				
				Method[] methods = personClass.getDeclaredMethods();
				
				for(Method method : methods)
					System.out.println(method.getName()+"-"+method.getReturnType());
				
				System.out.println("Access implemented interfaces...");
				
				Class[] interfaces = personClass.getInterfaces();
				
				for(Class c : interfaces)
					System.out.println(c.getName());
				
				
			}
		}

class Employee {
	
}

class PersonEmployee extends Employee implements Comparable<PersonEmployee> {
	
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

	@Override
	public int compareTo(PersonEmployee o) {
		return 0;
	}
}