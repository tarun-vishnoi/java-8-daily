package com.streamapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamOperations {

	public static void main(String[] args) {

		/*
		 * Numeric Stream
		 * ======================================================================
		 */

		int sum = IntStream.rangeClosed(1, 10).sum();
		System.out.println(sum);

		IntStream.rangeClosed(1, 50).forEach(System.out::println);

		List<Integer> integers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
		System.out.println(integers);

		int summation = integers.stream().mapToInt(Integer::intValue).sum();
		System.out.println(summation);
	}

}
