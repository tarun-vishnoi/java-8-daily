package com.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * BiConsumer Functional Interface : Accept two inputs and perform some
 * operation on the inputs.
 * 
 * @author Tarun Vishnoi
 *
 */
public class BiConsumerExample {

	private static List<Employee> employees = new ArrayList<Employee>();

	public static void main(String[] args) {

		BiConsumer<String, String> biConsumer = (a, b) -> System.out.println(a.toUpperCase() + " - " + b.toLowerCase());
		biConsumer.accept("Mars", "Saturn");

		BiConsumer<Integer, Integer> multiply = (a, b) -> System.out.println("Multiplication " + (a * b));
		BiConsumer<Integer, Integer> division = (a, b) -> System.out.println("Division " + (a / b));

		multiply.andThen(division).accept(10, 5);

		getEmployees();

		BiConsumer<String, Integer> emp = (name, age) -> System.out.println(name + " " + age);
		employees.forEach(employee -> emp.accept(employee.getName(), Integer.valueOf(employee.getAge())));
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
