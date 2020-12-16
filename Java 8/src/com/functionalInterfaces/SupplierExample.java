package com.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Supplier Functional Interface : Doesn't take any input but returns output.
 * 
 * @author Tarun Vishnoi
 *
 */
public class SupplierExample {

	private static List<Employee> employees = new ArrayList<Employee>();

	public static void main(String[] args) {
		getEmployees();
		Supplier<List<Employee>> supplier = () -> employees;
		System.out.println(supplier.get());

		Supplier<Employee> supplier1 = () -> new Employee("Tarun", 26, "Noida");
		System.out.println(supplier1.get());
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
