package com.test.src;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalInterfaceTest {

	public static void main(String[] args) {
		sayHello("Faizan",(par)->"Say Hi to "+par).ifPresent(System.out::println);
		sayHello1("Faizan",(par)->"Say Hi to "+par).ifPresent(System.out::println);
		generatFibonacci(new int[] {0,1}).forEach(System.out::println);
	}
	
	public static Optional<String> sayHello(String name, Function<String,String> greet) {
		return Optional.of(greet.apply(name));
	}
	
	public static Optional<String> sayHello1(String name, UnaryOperator<String> greet) {
		return Optional.of(greet.apply(name));
	}
	
	public static IntStream generatFibonacci(int ar[]){
		return IntStream.iterate(0, i->i+1)
				.limit(10)
				.map((i)->{
					if(i==0 || i==1) return ar[i];
					int fib=ar[0]+ar[1];
					ar[0]=ar[1];
					ar[1]=fib;
					return fib;
				});
	}

}
