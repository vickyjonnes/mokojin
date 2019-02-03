package com.test.src;

import com.test.intrfc.RunnableEx;

public class CheckedExceptionTest{

	public static void main(String[] args) {
		new Thread(
				uncheck(
						()->{
							Thread.sleep(600);
							System.out.println(Thread.currentThread().getName()+" Hello");
						}
						)
				)
		.start();
		System.out.println(Thread.currentThread().getName()+ " Main thread ends here");
	}
	
	public static Runnable uncheck(RunnableEx r) {
		return ()->{
			try {
				r.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}

}
