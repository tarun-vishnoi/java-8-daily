package com.methodreference;

interface MyInterface {
	void m1();
}

public class MethodReference {

	public static void m2() {
		System.out.println("m2() method");
	}

	public static void main(String[] args) {
		MyInterface myInterface = MethodReference::m2;
		myInterface.m1(); // only one condition - both methods should have same argument type
	}

}
