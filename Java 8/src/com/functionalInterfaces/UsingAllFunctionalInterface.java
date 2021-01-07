package com.functionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class UsingAllFunctionalInterface {

	private static List<Employee> employees = Arrays.asList(new Employee("Jack", 5, "NYC"),
			new Employee("Leo", 15, "Canada"), new Employee("Burak", 10, "Istanbul"), new Employee("Denis", 20, "NYC"),
			new Employee("Rob", 2, "NYC"));

	public static void main(String[] args) {

		Predicate<Employee> predicate = emp -> emp.getCity().equals("NYC");

		Function<Employee, List<String>> function = emp -> {
			List<String> list = new ArrayList<String>();
			if (emp.getAge() > 5)
				list.add(emp.getName());
			return list;
		};

		Consumer<Employee> consumer = emp -> {
			System.out.println(emp.getName());
		};

		Consumer<String> strConsumer = str -> System.out.print(str);

		System.out.println("Predicate & Consumer");
		for (Employee emp : employees) {
			if (predicate.test(emp)) {
				consumer.accept(emp);
			}
		}

		System.out.println();
		System.out.println("Predicate, Function & Consumer");
		employees.forEach(emp -> {
			if (predicate.test(emp)) {
				List<String> list = function.apply(emp);
				list.forEach(strConsumer);
			}
		});
	}
}
