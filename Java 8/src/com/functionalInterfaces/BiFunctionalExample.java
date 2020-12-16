package com.functionalInterfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * Function Functional Interface : Accept two inputs and returns an output but
 * have to pass three types when define a function interface.
 * 
 * @author Tarun Vishnoi
 *
 */
public class BiFunctionalExample {

	private static List<Employee> employees = new ArrayList<Employee>();

	public static void main(String[] args) {

		getEmployees();

		BiFunction<List<Employee>, Predicate<Employee>, Map<String, Integer>> biFunction = (employee, empPredicate) -> {
			Map<String, Integer> map = new HashMap<String, Integer>();
			employee.forEach(emp -> {
				if (empPredicate.test(emp)) {
					map.put(emp.getName(), emp.getAge());
				}
			});
			return map;
		};

		Predicate<Employee> agePredicate = (emp) -> emp.getAge() > 5;

		System.out.println(biFunction.apply(employees, agePredicate));
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
