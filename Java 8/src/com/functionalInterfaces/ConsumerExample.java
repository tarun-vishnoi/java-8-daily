package com.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Consumer Functional Interface : Accept an input and perform some operation on
 * the input.
 * 
 * @author Tarun Vishnoi
 *
 */
public class ConsumerExample {

	private static List<Employee> employees = new ArrayList<Employee>();

	private static Consumer<Employee> consumer = (emp) -> System.out.println(emp);
	private static Consumer<Employee> consumer1 = (emp) -> System.out.print(emp.getName() + " ");
	private static Consumer<Employee> consumer2 = (emp) -> System.out.print(emp.getCity() + " ");
	private static Consumer<Employee> consumer3 = (emp) -> System.out.println(emp.getAge() + " ");

	public static void main(String[] args) {
		Consumer<String> cons = (str) -> System.out.println(str.toUpperCase());
		cons.accept("This message came from Saturn.");

		getEmployees();

		employees.forEach(consumer);

		employees.forEach(employee -> {
			if (employee.getAge() >= 10) {
				consumer1.andThen(consumer2).andThen(consumer3).accept(employee); // consumer chaining
			}
		});
	}

	private static List<Employee> getEmployees() {
		Employee emp1 = new Employee("Jack", 5, "NYC");
		Employee emp2 = new Employee("Leo", 15, "Canada");
		Employee emp3 = new Employee("Burak", 10, "Istanbul");
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		return employees;
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