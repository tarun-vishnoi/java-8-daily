package com.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperation {

	public static void main(String[] args) {

		/*
		 * map() for list
		 * ======================================================================
		 */

		List<String> names = getEmployees().stream().map(Employee::getName) // Emp as an i/p and names as an o/p
				.map(String::toUpperCase) // perform some operation on names
				.collect(Collectors.toList());
		System.out.println(names);

		/*
		 * map() for set *
		 * ======================================================================
		 */
		Set<String> uniqueNames = getEmployees().stream().map(Employee::getName) // Empl as an i/p and names as an o/p
				.map(String::toUpperCase) // perform some operation on names
				.collect(Collectors.toSet());
		System.out.println(uniqueNames);

		/*
		 * map() and flatMap() for List
		 * ======================================================================
		 */

		List<String> skills = getEmployees().stream().map(Employee::getSkills) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.collect(Collectors.toList());
		System.out.println(skills);

		/*
		 * unique skills
		 * ======================================================================
		 */

		List<String> uniqueSkills = getEmployees().stream().map(Employee::getSkills) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.distinct().collect(Collectors.toList());
		System.out.println(uniqueSkills);

		/*
		 * total number of skills
		 * ======================================================================
		 */

		long totalSkills = getEmployees().stream().map(Employee::getSkills) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.distinct().count();
		System.out.println(totalSkills);

		/*
		 * sorted skills
		 * ======================================================================
		 */

		List<String> sortedSkills = getEmployees().stream().map(Employee::getSkills) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedSkills);

		/*
		 * custom sort by name
		 * ======================================================================
		 */

		List<Employee> sortByName = getEmployees().stream().sorted(Comparator.comparing(Employee::getName))
				.collect(Collectors.toList());
		System.out.println(sortByName);

		/*
		 * custom sort by age descending
		 * ======================================================================
		 */

		List<Employee> sortByAge = getEmployees().stream().sorted(Comparator.comparing(Employee::getAge).reversed())
				.collect(Collectors.toList());
		System.out.println(sortByAge);

		/*
		 * Filter Employee whose age is greater than 10
		 * ======================================================================
		 */

		List<Employee> filterByAge = getEmployees().stream().filter(employee -> employee.getAge() > 10)
				.collect(Collectors.toList());
		System.out.println(filterByAge);

		/*
		 * reduce()
		 * ======================================================================
		 */

		List<Integer> nums = Arrays.asList(1, 5, 10, 100);
		int result = nums.stream()
				/*
				 * a=1(identity) b=1(from Stream) => result=1 --------------------------
				 * a=1(from stream) b=5(from Stream) => result=5 -----------------------
				 * a=5(from stream) b=10(from Stream) => result=50 ---------------------
				 * a=50(from stream) b=100(from Stream) => result=5000 -----------------
				 */
				.reduce(1, (a, b) -> a * b);
		System.out.println(result);

		/*
		 * reduce() with optional
		 * ======================================================================
		 */

		List<Integer> emptyNums = Arrays.asList();

		Optional<Integer> optional = nums.stream().reduce((a, b) -> a * b);
		System.out.println(optional.isPresent());
		System.out.println(optional.get());

		Optional<Integer> emptyOptional = emptyNums.stream().reduce((a, b) -> a * b);
		System.out.println(emptyOptional.isPresent());
		// System.out.println(emptyOptional.get()); java.util.NoSuchElementException: No
		// value present

		Optional<Employee> highestAge = getEmployees().stream()
				.reduce((emp1, emp2) -> emp1.getAge() > emp2.getAge() ? emp1 : emp2);
		System.out.println(highestAge.get());

		/*
		 * map() + filter() + reduce()
		 * ======================================================================
		 */

		int totalAge = getEmployees().stream() // Stream<Employee>
				.filter(emp -> emp.getName().contains("a")).map(Employee::getAge) // Stream<Integer>
				.reduce(0, Integer::sum);
		System.out.println(totalAge);

		/*
		 * allMatch() anyMatch() noneMatch() return boolean
		 * ======================================================================
		 */

		boolean res = getEmployees().stream().anyMatch(emp -> emp.getName().contains("a"));
		System.out.println(res);

		/*
		 * findFirst() findAny() return value
		 * ======================================================================
		 */

		Optional<Employee> res1 = getEmployees().stream().filter(emp -> emp.getSkills().contains("Java")).findAny();
		System.out.println(res1);

		/*
		 * Stream API short circuit( and & or) functions (These function does not have
		 * to iterate the whole stream to evaluate the result)- limit(), findFirst(),
		 * findAny(), allMatch(), anyMatch(), noneMatch()
		 * ======================================================================
		 */

		/*
		 * Stream API factory method of(), iterate(), generate()
		 * ======================================================================
		 */

		Stream<String> stream = Stream.of("Jack", "Kim", "Carlos", "John", "Tim");
		stream.forEach(System.out::println);

		Stream.iterate(1, x -> x * 2).limit(10).forEach(System.out::println);

		Supplier<Integer> supplier = new Random()::nextInt;
		Stream.generate(supplier).limit(10).forEach(System.out::println);

		/*
		 * END ======================================================================
		 */
	}

	private static List<Employee> getEmployees() {
		Employee emp1 = new Employee("Jack", 5, "NYC", Arrays.asList("Java", "Python", "R"));
		Employee emp2 = new Employee("Leo", 15, "Canada", Arrays.asList("C++", "C", "C#"));
		Employee emp3 = new Employee("Burak", 10, "Istanbul", Arrays.asList("Maths", "AI", "ML"));
		Employee emp4 = new Employee("Jack", 25, "NYC", Arrays.asList("Java", "AI", "DSA"));
		Employee emp5 = new Employee("Tarun", 55, "Toronto", Arrays.asList("Java", "Python", "R"));
		return Arrays.asList(emp1, emp2, emp3, emp4, emp5);
	}
}
