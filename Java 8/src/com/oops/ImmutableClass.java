package com.oops;

/**
 * Immutable class and we added a new mutable field of type Age to our immutable
 * class and assign it as normal inside the constructor.
 * 
 * @author Tarun Vishnoi
 *
 */
final class ImmutableEmployee {
	private final int id;
	private final String name;
	private final Age age;

	// changing constructor implementation

	// Constructor performing Shallow Copy

	/*
	 * public ImmutableEmployee(int id, String name, Age age) { this.id = id;
	 * this.name = name; this.age = age; }
	 */

	/*
	 * Issue 1 : So we modify the constructor in order to clone the passed argument
	 * of Age and use a clone instance of it.
	 */

	// Constructor performing Deep Copy

	public ImmutableEmployee(int id, String name, Age age) {
		this.id = id;
		this.name = name;
		Age cloneAge = new Age();
		cloneAge.setDay(age.getDay());
		cloneAge.setMonth(age.getMonth());
		cloneAge.setYear(age.getYear());
		this.age = cloneAge;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/*
	 * Issue 2 : when returning mutable fields from immutable object, you should
	 * return a clone instance of them and not the real instance of the field.
	 */
	public Age getAge() {
		Age cloneAge = new Age();
		cloneAge.setDay(this.age.getDay());
		cloneAge.setMonth(this.age.getMonth());
		cloneAge.setYear(this.age.getYear());
		return cloneAge;
	}

	/*
	 * Now the class becomes fully immutable and provides no way or method for other
	 * objects to modify its state.
	 */
}

/**
 * Mutable class
 * 
 * @author Tarun Vishnoi
 *
 */

class Age {
	private int day;
	private int month;
	private int year;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}

public class ImmutableClass {

	public static void main(String[] args) {
		Age age = new Age();
		age.setDay(31);
		age.setMonth(3);
		age.setYear(1994);
		ImmutableEmployee employee = new ImmutableEmployee(1, "Dev", age);
		System.out.println("Dev's age before modification is " + employee.getAge().getDay() + "/"
				+ employee.getAge().getMonth() + "/" + employee.getAge().getYear() + "");
		/*
		 * Issue 1 : We claim that ImmutableEmployee is an immutable class whose state
		 * is never modified after construction, however in the below instruction we are
		 * able to modify the age of Dev even after constructing Dev object. If we go
		 * back to the implementation of ImmutableEmployee constructor, we find that age
		 * field is being assigned to the instance of the Age argument, so whenever the
		 * referenced Age is modified outside the class, the change is reflected
		 * directly on the state of Dev.
		 */
		age.setYear(1995);
		System.out.println("Dev's age after modification is " + employee.getAge().getDay() + "/"
				+ employee.getAge().getMonth() + "/" + employee.getAge().getYear() + "");

		// Issue 2 : our class still has a leak and is not fully immutable

		employee.getAge().setYear(1995);
		System.out.println("Dev's age after performing deep copr in constructor is  " + employee.getAge().getDay() + "/"
				+ employee.getAge().getMonth() + "/" + employee.getAge().getYear() + "");

		/*
		 * Now the class becomes fully immutable and provides no way or method for other
		 * objects to modify its state.
		 */
	}

}