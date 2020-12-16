package com.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumerExample {

	private static List<Employee> employees = new ArrayList<Employee>();

	public static void main(String[] args) {

		getEmployees();

		Predicate<Employee> agePredicate = (emp) -> emp.getAge() > 5;
		Predicate<Employee> namePredicate = (emp) -> emp.getName().startsWith("L");

		BiConsumer<String, Integer> biConsumer = (name, age) -> System.out.println(name + " " + age);
		Consumer<Employee> consumer = (emp) -> {
			if (agePredicate.and(namePredicate).test(emp)) {
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
