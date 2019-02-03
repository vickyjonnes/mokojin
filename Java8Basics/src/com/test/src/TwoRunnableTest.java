package com.test.src;

public class TwoRunnableTest {

	public static void main(String[] args) {
		andThen(
				()->System.out.println("hello"),
				()->System.out.println("world")
				).run();

	}
	
	public static Runnable andThen(Runnable r1, Runnable r2) {
		return ()->{
			r1.run();
			r2.run();
		};
	}

}
