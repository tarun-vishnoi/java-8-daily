package com.methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerExample {

	private static List<Employee> employees = new ArrayList<Employee>();

	public static void main(String[] args) {
		getEmployees();
		Consumer<Employee> consumer = System.out::println;
		employees.forEach(consumer);

		Supplier<Employee> supplier = Employee::new;
		System.out.println(supplier.get());
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

class Employee {
	private String name;
	private int age;
	private String city;

	public Employee() {
	}

	public Employee(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

}
