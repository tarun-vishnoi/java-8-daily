package com.generics;

/**
 * 
 * Multiple Bound { Bound<T extends A & B>} - In this case A can be an interface
 * or class. If A is class then B and C should be interfaces. We can’t have more
 * than one class in multiple bounds.
 * 
 * @author Tarun Vishnoi
 *
 */
public class Bounded {

	public static void main(String[] args) {

		// Bounded
		BoundedClass<B> bClass = new BoundedClass<B>(new B());
		bClass.displayClass();

		// Bounded
		BoundedClass<C> cClass = new BoundedClass<C>(new C());
		cClass.displayClass();

		// Bounded
		BoundedClass<D> dClass = new BoundedClass<D>(new D());
		dClass.displayClass();

		// Not Bounded
		/*
		 * The type E is not a valid substitute for the bounded parameter <T extends A>
		 * of the type BoundedClass<T>
		 */
		// BoundedClass<E> eClass = new BoundedClass<E>(new E()); // ^ Compilation error
		// eClass.displayClass();

	}

}

class BoundedClass<T extends A> {
	private T t;

	public BoundedClass(T t) {
		this.t = t;
	}

	public void displayClass() {
		t.printClass();
	}
}

class A {
	public void printClass() {
		System.out.println(A.class);
	}
}

class B extends A {
	@Override
	public void printClass() {
		System.out.println(B.class);
	}
}

class C extends B {
	@Override
	public void printClass() {
		System.out.println(C.class);
	}
}

class D extends A {
	@Override
	public void printClass() {
		System.out.println(D.class);
	}
}

class E {
	public void printClass() {
		System.out.println(E.class);
	}
}