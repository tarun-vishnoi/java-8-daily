package com.interfacechanges;

public class Inheritance implements Interface1, Interface2 {

	public static void main(String[] args) {
		Inheritance inheritance = new Inheritance();
		inheritance.print();
	}

	@Override
	public void print() {
		System.out.println(Inheritance.class);
		Interface1.super.print();
		Interface2.super.print();
	}

}

interface Interface1 {
	default void print() {
		System.out.println(Interface1.class);
	}
}

interface Interface2 {
	default void print() {
		System.out.println(Interface2.class);
	}
}