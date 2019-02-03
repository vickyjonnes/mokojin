package com.test.src;

import java.util.Arrays;
import java.util.List;

import com.test.intrfc.FunctionalInterface;

public class Stream1 {

	public static void main(String[] args) {
		FunctionalInterface<Integer> consume = new FunctionalInterface<Integer>() {
			
			@Override
			public void execute(Integer t) {
				System.out.println(t);
				
			}
		};
		
		List<Integer> list=Arrays.asList(1,2,3,4,5);
		//list.forEach(consume);
	}

}
