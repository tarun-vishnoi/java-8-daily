package com.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {

		/*
		 * Streams are lazy, no intermediate operations (filter etc) will be invoked
		 * Until the terminal operation (Collectors) invoked.
		 * 
		 */
		/*
		 * peek() is for debugging
		 */

		Map<String, List<String>> empMap = getEmployees().stream().peek(System.out::println) // not filtered stream
				.filter(employee -> employee.getAge() > 5) // predicate
				.peek(employee -> System.out.println("Age Filter -- " + employee)) // filtered stream 1
				.filter(employee -> employee.getName().startsWith("L")) // predicate
				.peek(employee -> System.out.println("Name Filter -- " + employee)) // filtered stream 2
				.collect(Collectors.toMap(Employee::getName, Employee::getSkills));
		System.out.println(empMap);
	}

	private static List<Employee> getEmployees() {
		Employee emp1 = new Employee("Jack", 5, "NYC", Arrays.asList("Java", "Python", "R"));
		Employee emp2 = new Employee("Leo", 15, "Canada", Arrays.asList("C++", "C", "C#"));
		Employee emp3 = new Employee("Burak", 10, "Istanbul", Arrays.asList("Maths", "AI", "ML"));
		return Arrays.asList(emp1, emp2, emp3);
	}
}

class Employee {
	private String name;
	private int age;
	private String city;
	private List<String> skills;

	public Employee() {
	}

	public Employee(String name, int age, String city, List<String> skills) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.skills = skills;
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

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", city=" + city + ", skills=" + skills + "]";
	}

}
