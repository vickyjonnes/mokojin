package com.test.src;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class RecursiveLambda {

	public static void main(String[] args) {
		RecursiveLambda r=new RecursiveLambda();
		Stream.iterate(0, i->++i).limit(5).forEach(r::factorial); 
		System.out.println();
		Stream.iterate(0, i->++i).limit(5).forEach(r::fibonacci);
	}

	public void factorial(int num) {
		Function<Integer, Integer> fact = x -> {
		    BiFunction<BiFunction, Integer, Integer> factHelper =
		        (f, d) -> (d == 0) ? 1 : d*(Integer)f.apply(f,d-1);
		    return factHelper.apply(factHelper, x);
		};
		
		System.out.print(fact.apply(num)+" ");
	}
	
	public void fibonacci(int num) {
		Function<Integer,Integer> fib=x->{
			BiFunction<BiFunction, Integer, Integer> fibHelper=
					(f, i) -> (i==0 || i==1) ? 1: (Integer)f.apply(f, i-1)+(Integer)f.apply(f, i-2);
			return fibHelper.apply(fibHelper, x);
		};
		
		System.out.print(fib.apply(num)+" ");
	}

}
