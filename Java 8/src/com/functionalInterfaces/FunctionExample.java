/**
 * 
 */
package com.functionalInterfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Function Functional Interface : Accept an input and returns an output but
 * have to pass two types when define a function interface.
 * 
 * @author Tarun Vishnoi
 *
 */
public class FunctionExample {

	private static List<Employee> employees = new ArrayList<Employee>();

	public static void main(String[] args) {
		Function<String, String> function = (name) -> name.toLowerCase();
		System.out.println(function.apply("This message came from Saturn."));

		Function<String, String> function1 = (name) -> name.toUpperCase().concat(" and Mars");
		System.out.println(function.andThen(function1).apply("This message came from Saturn"));

		Function<String, String> function2 = (name) -> name.toUpperCase().concat(" and Mars");
		System.out.println(function.compose(function2).apply("This message came from Saturn"));

		getEmployees();

		// Fetch all employee's name and age

		Function<List<Employee>, Map<String, Integer>> empFunction = (employee) -> {
			Map<String, Integer> map = new HashMap<String, Integer>();
			employee.forEach(emp -> map.put(emp.getName(), emp.getAge()));
			return map;
		};
		System.out.println(empFunction.apply(employees));

		// Fetch only those whose age is greater than 5

		Predicate<Employee> agePredicate = (emp) -> emp.getAge() > 5;

		Function<List<Employee>, Map<String, Integer>> empFilterFunction = (employee) -> {
			Map<String, Integer> map = new HashMap<String, Integer>();
			employee.forEach(emp -> {
				if (agePredicate.test(emp)) {
					map.put(emp.getName(), emp.getAge());
				}
			});
			return map;
		};
		System.out.println(empFilterFunction.apply(employees));
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
