package com.reflection.various;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AnnotationsDemo {

	public static void main(String[] args) {

		Class<PersonAnnotate> personClass = null;
		try {
			personClass = (Class<PersonAnnotate>) Class.forName("com.reflection.various.PersonAnnotate");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Method[] methods = personClass.getDeclaredMethods();

		for (Method m : methods)
			if (m.isAnnotationPresent(myAnnotation.class))
				System.out.println(m.getName());
	}
}

@Retention(RetentionPolicy.RUNTIME) // Denotes how long the annotation is going
									// to survive
@Target(ElementType.METHOD) // Denotes that this annotation can be used on
							// methods like name() below
@interface myAnnotation {
	public String name();
}

class PersonAnnotate {

	private String name;
	private int age;

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

	@myAnnotation(name = "MoronAnnotation")
	private String returnName() {
		return this.name + " is the name";
	}
}