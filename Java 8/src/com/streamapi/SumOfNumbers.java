package com.streamapi;

import java.util.stream.IntStream;

public class SumOfNumbers {

	public static void main(String[] args) {
		// Imperative Programming --- problems with multithreaded environment

		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		System.out.println("Imperative -- " + sum);

		// Declarative Programming --- okay with multithreaded environment

		int sum1 = IntStream.rangeClosed(0, 100).sum();
		System.out.println("Declarative -- " + sum1);
	}

}
