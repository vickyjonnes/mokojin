package com.test.src;

import com.test.intrfc.Collection2;

public class Collection2Test {

	public static void main(String[] args) {
		ArrayList2<Integer> num=new ArrayList2<>();
		num.add(1);
		num.add(2);
		num.add(3);
		num.add(4);
		num.forEachIf(System.out::println, e->e%2==0);
	}

}
