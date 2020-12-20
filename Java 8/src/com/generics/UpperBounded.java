package com.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. The question mark (?) is known as the wildcard in generic programming . It
 * represents an unknown type.
 * 
 * 2. Upper Bounded Wildcards: These wildcards can be used when you want to
 * relax the restrictions on a variable. For example, say you want to write a
 * method that works on List < integer >, List < double >, and List < number > ,
 * you can do this using an upper bounded wildcard. To declare an upper-bounded
 * wildcard, use the wildcard character (‘?’), followed by the extends keyword,
 * followed by its upper bound.
 * 
 * @author Tarun Vishnoi
 *
 */

public class UpperBounded {

	public static void main(String[] args) {

		// Integer List
		List<Integer> list1 = Arrays.asList(4, 5, 6, 7);
		System.out.println("Total sum is:" + sum(list1));

		// Double list
		List<Double> list2 = Arrays.asList(4.1, 5.1, 6.1);
		System.out.println("Total sum is:" + sum(list2));

		List<Y> xs = new ArrayList<Y>();
		// xs.add(new X()); // compilation error
		xs.add(new Y());
		xs.add(new Z());
		// xs.add(new O()); // compilation error
		displayClass(xs);

	}

	public static double sum(List<? extends Number> list) {
		double sum = 0.0;
		for (Number i : list) {
			sum += i.doubleValue();
		}
		return sum;
	}

	public static void displayClass(List<? extends Y> list) {
		for (Y y : list) {
			y.printClass();
		}
	}
}

class X {
	public void printClass() {
		System.out.println(X.class);
	}
}

class Y extends X {
	@Override
	public void printClass() {
		System.out.println(Y.class);
	}
}

class Z extends Y {
	@Override
	public void printClass() {
		System.out.println(Z.class);
	}
}

class O extends X {
	@Override
	public void printClass() {
		System.out.println(O.class);
	}
}
