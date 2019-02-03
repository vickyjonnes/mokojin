package com.test.src;

public class EchoTime {
	public static void timeIt(Runnable block) {
		long time=System.nanoTime();
		try {
			block.run();
		}finally {
			long finalTime=System.nanoTime();
			System.out.println((finalTime-time)%60);
		}
	}
}
