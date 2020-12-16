package com.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * BiPredicate Functional Interface : Accept two inputs, perform some operation
 * on the inputs and return a boolean result.
 * 
 * @author Tarun Vishnoi
 *
 */
public class BiPredicateExample {

	private static List<Employee> employees = new ArrayList<Employee>();

	public static void main(String[] args) {

		getEmployees();

		BiPredicate<String, Integer> biPredicate = (name, age) -> name.startsWith("L") && age > 5;

		BiConsumer<String, Integer> biConsumer = (name, age) -> System.out.println(name + " " + age);
		Consumer<Employee> consumer = (emp) -> {
			if (biPredicate.test(emp.getName(), emp.getAge())) {
				biConsumer.accept(emp.getName(), emp.getAge());
			}
		};
		employees.forEach(consumer);
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
