package com.methodreference;

public class ConstructorRefrence {
	public static void main(String[] args) {

		// Using Lambda Expression

		Interface1 i1 = () -> {
			Sample sample = new Sample();
			return sample;
		};
		i1.get();

		// using Method Reference

		Interface1 i2 = Sample::new;
		i2.get();
	}
}

class Sample {
	public Sample() {
		System.out.println("Sample Constructor");
	}
}

interface Interface1 {
	public Sample get();
}