package com.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TerminalOperations {

	public static void main(String[] args) {

		/*
		 * joining() collector
		 * ======================================================================
		 */

		String joinedName = getEmployees().stream().map(Employee::getName).collect(Collectors.joining(", ", "[", "]"));
		System.out.println(joinedName);

		/*
		 * counting() collector
		 * ======================================================================
		 */

		long countName = getEmployees().stream().filter(emp -> emp.getAge() > 10).collect(Collectors.counting());
		System.out.println(countName);

		/*
		 * mapping() collector
		 * ======================================================================
		 */

		Set<String> listName = getEmployees().stream().filter(emp -> emp.getAge() > 10)
				.collect(Collectors.mapping(Employee::getName, Collectors.toSet()));
		System.out.println(listName);

		/*
		 * minBy() and maxBy() collector
		 * ======================================================================
		 */

		Optional<Employee> employee = getEmployees().stream()
				.collect(Collectors.minBy(Comparator.comparing(Employee::getAge)));
		System.out.println(employee);

		/*
		 * sum() and avg() collector
		 * ======================================================================
		 */

		int totalAge = getEmployees().stream().collect(Collectors.summingInt(Employee::getAge));
		System.out.println(totalAge);

		/*
		 * groupingBy() collector
		 * ======================================================================
		 */

		Map<String, List<Employee>> map = getEmployees().stream().collect(Collectors.groupingBy(Employee::getCity));
		System.out.println(map);

		Map<String, List<Employee>> map1 = getEmployees().stream() // custom grouping
				.collect(Collectors.groupingBy(emp -> emp.getCity().equals("Istanbul") ? "Aggressive" : "Normal"));
		System.out.println(map1);

		Map<String, Map<String, List<Employee>>> map2 = getEmployees().stream() // two level grouping
				.collect(Collectors.groupingBy(emp -> emp.getCity().equals("Istanbul") ? "Aggressive" : "Normal",
						Collectors.groupingBy(Employee::getCity)));
		System.out.println(map2);

		Map<Object, Integer> map3 = getEmployees().stream() // two level grouping
				.collect(Collectors.groupingBy(emp -> emp.getCity().equals("Istanbul") ? "Aggressive" : "Normal",
						Collectors.summingInt(Employee::getAge)));
		System.out.println(map3);

		LinkedHashMap<String, Set<Employee>> empLinkedHashMap = getEmployees().stream() // three level grouping
				.collect(Collectors.groupingBy(Employee::getName, LinkedHashMap::new, Collectors.toSet()));
		System.out.println(empLinkedHashMap);

		Map<String, Employee> empMap = getEmployees().stream().collect(Collectors.groupingBy(Employee::getName,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getAge)), Optional::get)));
		System.out.println(empMap);

		/*
		 * partitioningBy() collector
		 * ======================================================================
		 */

		Map<Boolean, Set<Employee>> partitioningMap = getEmployees().stream()
				.collect(Collectors.partitioningBy(emp -> emp.getAge() > 10, Collectors.toSet()));
		System.out.println(partitioningMap);
	}

	private static List<Employee> getEmployees() {
		Employee emp1 = new Employee("Jack", 5, "NYC", Arrays.asList("Java", "Python", "R"));
		Employee emp2 = new Employee("Leo", 15, "Toronto", Arrays.asList("C++", "C", "C#"));
		Employee emp3 = new Employee("Burak", 10, "Istanbul", Arrays.asList("Maths", "AI", "ML"));
		Employee emp4 = new Employee("Jack", 25, "NYC", Arrays.asList("Java", "AI", "DSA"));
		Employee emp5 = new Employee("Tarun", 55, "Toronto", Arrays.asList("Java", "Python", "R"));
		return Arrays.asList(emp1, emp2, emp3, emp4, emp5);
	}
}
