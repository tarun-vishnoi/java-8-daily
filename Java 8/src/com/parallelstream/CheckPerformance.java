package com.parallelstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckPerformance {

	public static void main(String[] args) {
		System.out.println("Processors -> " + Runtime.getRuntime().availableProcessors());
		empSeqStream();
		empParallelStream();
	}

	public static List<String> empSeqStream() {
		long startTime = System.currentTimeMillis();
		List<String> skills = getEmployees().stream().map(Employee::getSkills).flatMap(List::stream).distinct().sorted()
				.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken in Sequential Stream -> " + (endTime - startTime));
		return skills;
	}

	public static List<String> empParallelStream() {
		long startTime = System.currentTimeMillis();
		List<String> skills = getEmployees().parallelStream().map(Employee::getSkills).flatMap(List::stream).distinct()
				.sorted().collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken in Parallel Stream -> " + (endTime - startTime));
		return skills;
	}

	private static List<Employee> getEmployees() {
		Employee emp1 = new Employee("Jack", 5, "NYC", Arrays.asList("Java", "Python", "R"));
		Employee emp2 = new Employee("Leo", 15, "Canada", Arrays.asList("C++", "C", "C#"));
		Employee emp3 = new Employee("Burak", 10, "Istanbul", Arrays.asList("Maths", "AI", "ML"));
		Employee emp4 = new Employee("Jack", 25, "NYC", Arrays.asList("Java", "AI", "DSA"));
		Employee emp5 = new Employee("Tarun", 55, "Toronto", Arrays.asList("Java", "Python", "R"));
		return Arrays.asList(emp1, emp2, emp3, emp4, emp5);
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
