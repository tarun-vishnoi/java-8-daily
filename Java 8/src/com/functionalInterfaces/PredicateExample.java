package com.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate Functional Interface : Accept an input, perform some operation on
 * the input and return a boolean result.
 * 
 * @author Tarun Vishnoi
 *
 */
public class PredicateExample {

	private static List<Employee> employees = new ArrayList<Employee>();

	public static void main(String[] args) {
		Predicate<Integer> predicate = (i) -> {
			return i % 2 == 0;
		};

		System.out.println(predicate.test(10));

		Predicate<Integer> predicate1 = (i) -> i % 5 == 0; // applicable only for a single line instruction.

		System.out.println(predicate.and(predicate1).test(20)); // predicate chaining

		System.out.println(predicate.or(predicate1).test(11));

		System.out.println(predicate.or(predicate1).negate().test(11)); // negate will reverse the result

		getEmployees();

		Predicate<Employee> agePredicate = (emp) -> emp.getAge() > 5;
		employees.forEach(employee -> {
			if (agePredicate.test(employee)) {
				System.out.println("agePredicate - " + employee);
			}
		});

		Predicate<Employee> namePredicate = (emp) -> emp.getName().startsWith("L");
		employees.forEach(employee -> {
			if (namePredicate.test(employee)) {
				System.out.println("namePredicate - " + employee);
			}
		});

		employees.forEach(employee -> {
			if (namePredicate.and(namePredicate).test(employee)) {
				System.out.println("agePredicate and namePredicate - " + employee);
			}
		});

		employees.forEach(employee -> {
			if (namePredicate.and(namePredicate).negate().test(employee)) {
				System.out.println("agePredicate and namePredicate (Negate)- " + employee);
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
