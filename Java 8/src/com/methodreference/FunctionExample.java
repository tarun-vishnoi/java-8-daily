package com.methodreference;

import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {
		Function<String, String> function = (value) -> value.toUpperCase();
		System.out.println(function.apply("This message came from Saturn."));

		Function<String, String> functionMethodReference = String::toUpperCase;
		System.out.println(functionMethodReference.apply("This message came from Saturn."));
	}

}
