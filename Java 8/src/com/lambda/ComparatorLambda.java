package com.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorLambda {

	public static void main(String[] args) {

		Employee emp1 = new Employee("Jack", 5, "NYC");
		Employee emp2 = new Employee("Leo", 15, "Canada");
		Employee emp3 = new Employee("Burak", 10, "Istanbul");
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);

		Collections.sort(employees, (o1, o2) -> {
			return o1.getName().compareTo(o2.getName());
		});
		System.out.println("Sort by Name" + employees.toString());

		Collections.sort(employees, (o1, o2) -> {
			return o1.getAge() - o2.getAge();
		});
		System.out.println("Sort by Age" + employees.toString());

		Collections.sort(employees, (o1, o2) -> {
			return o1.getCity().compareTo(o2.getCity());
		});
		System.out.println("Sort by City" + employees.toString());
	}

}

class Employee {
	private String name;
	private int age;
	private String city;

	public Employee(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

}