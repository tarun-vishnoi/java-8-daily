package com.lambda;

public class RunnableLambda {

	public static void main(String[] args) {

		// Before Java 8

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 5; i++) {
					System.out.println(i);
				}
			}
		};
		new Thread(runnable).start();

		// Java 8 Lambda

		Runnable runnableLambda = () -> {
			for (int i = 6; i <= 10; i++) {
				System.out.println(i);
			}
		};
		new Thread(runnableLambda).start();

		// Java 8 Lambda

		new Thread(() -> {
			for (int i = 11; i <= 15; i++) {
				System.out.println(i);
			}
		}).start();
	}
}
