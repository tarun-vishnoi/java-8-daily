package com.methodreference;

public class RunnableMethodReference {
	public static void main(String[] args) {

		// Using Lambda Expression.

		Runnable runnable1 = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(i);
			}
		};
		Thread t1 = new Thread(runnable1);
		t1.start();

		// Using Method Reference.

		RunnableMethodReference methodReference = new RunnableMethodReference();
		Runnable runnable2 = methodReference::method;
		Thread t2 = new Thread(runnable2);
		t2.start();
	}

	public void method() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
	}
}
