package com.interfacechanges;

public class InheritanceSample implements InterfaceA, InterfaceB, InterfaceC {

	public static void main(String[] args) {
		InheritanceSample sample = new InheritanceSample();
		sample.print();
	}

	public void print() {
		System.out.println(InheritanceSample.class);
		InterfaceC.super.print();
		// InterfaceA.super.print(); Compilation Error
		// InterfaceB.super.print(); Compilation Error
	}
}

interface InterfaceA {
	default void print() {
		System.out.println(InterfaceA.class);
	}
}

interface InterfaceB extends InterfaceA {
	default void print() {
		System.out.println(InterfaceB.class);
	}
}

interface InterfaceC extends InterfaceB {
	default void print() {
		System.out.println(InterfaceC.class);
	}
}