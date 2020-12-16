package com.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalExample {

	public static void main(String[] args) {
		Supplier<Employee> supplier = () -> {
			return new Employee("Alex", 28, "LA", Arrays.asList("Ruby", "Scala", "Golang"));
		};

		Optional<Employee> optional = Optional.ofNullable(supplier.get());
		if (optional.isPresent()) {
			System.out.println(optional.map(Employee::getName).orElse("Default"));
			System.out
					.println(optional.map(Employee::getName).orElseThrow(() -> new RuntimeException("No data found.")));

		}

		Optional<String> optional2 = Optional.ofNullable("Something");
		optional2.ifPresent(System.out::println);
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