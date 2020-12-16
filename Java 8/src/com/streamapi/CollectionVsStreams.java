package com.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionVsStreams {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("Jim");
		list.add("Tim");
		list.add("Kim");
		list.add("Yim");

		/*
		 * Collection can add and remove elements at any point of time but Streams can
		 * not do the same.
		 */

		list.remove(3);
		System.out.println(list);

		list.stream(); // no such methods for add and remove

		/*
		 * 1. Elements in Collection can be accessed in any order. Use appropriate
		 * methods based on collection but Elements in Stream can be accessed only in
		 * sequence.
		 * 
		 * 2. Collection is eagerly constructed but Streams are lazy constructed.
		 * 
		 * 3. Collections can be traversed n number of times but Streams can be
		 * traversed only once.
		 * 
		 * 4. Collections performs External Iteration to iterate through the element but
		 * Streams performs Internal Iteration to iterate through the element
		 */

		// Work fine
		for (String string : list) {
			System.out.println(string);
		}
		for (String string : list) {
			System.out.println(string);
		}
		list.remove(1);
		System.out.println(list);

		Stream<String> stream = list.stream();
		stream.forEach(System.out::println);
		// Exception in thread "main" java.lang.IllegalStateException: stream has
		// already been operated upon or closed
		stream.forEach(System.out::println);
	}

}
