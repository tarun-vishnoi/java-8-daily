package com.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9, 9, 10, 10, 10 };
		List<Integer> integers = Arrays.asList(arr);
		System.out.println(integers);

		// Imperative Programming

		List<Integer> uniqueIntegers = new ArrayList<Integer>();
		for (Integer integer : integers) {
			if (!uniqueIntegers.contains(integer)) {
				uniqueIntegers.add(integer);
			}
		}
		System.out.println("Imperative --- " + uniqueIntegers);

		// Declarative Programming

		List<Integer> uniqueInts = integers.stream().distinct().collect(Collectors.toList());
		System.out.println("Declarative --- " + uniqueInts);
	}
}
