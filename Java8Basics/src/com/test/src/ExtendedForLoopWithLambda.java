package com.test.src;

import java.util.ArrayList;
import java.util.List;

public class ExtendedForLoopWithLambda {

	public static void main(String[] args) {
		String names[]= {"noman","faizan","faraz"};
		List<Runnable> runners=new ArrayList<>();
		for(String name:names) {
			runners.add(()->System.out.println(name));
		}
		runners.stream().forEach((r)->
			new Thread(r).start()
		);
	}

}
