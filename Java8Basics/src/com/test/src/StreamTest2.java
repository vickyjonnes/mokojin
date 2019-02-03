package com.test.src;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		String content="This is a test to count words and this is going to be cool";
		List<String> words=Arrays.asList(content.split("[\\P{L}]+"));
		//words.stream().limit(5).forEach(System.out::println);
		long startTime=System.currentTimeMillis();
		System.out.println(words.stream().count());
		System.out.println(System.currentTimeMillis()-startTime);
		
		startTime=System.currentTimeMillis();
		System.out.println(words.parallelStream().count());
		System.out.println(System.currentTimeMillis()-startTime);
		int ar[]= {1,3,4,5,2};
		IntStream.of(ar).forEach(System.out::println);
		
		String name="Shanti Priya";
		List<Character> charList=Stream.iterate(0, n->n+1).limit(name.length()).map(name::charAt).collect(Collectors.toList());
		System.out.println(charList);
		
		AtomicIntegerArray atomicArray=new AtomicIntegerArray(8);
		int array[]=new int[8];
		long count=words.stream().filter((x)->{return x.length()>2?true:false;}).count();
		words.parallelStream().forEach((x)->{
			array[x.length()]++;
		});
		words.parallelStream().forEach((x)->{
			atomicArray.getAndIncrement(x.length());
		});
		System.out.println(count);
		
		Stream.of(atomicArray).forEach(System.out::print);
		System.out.println();
		IntStream.of(array).forEach(System.out::print);
		//Arrays.asList(array).stream().forEach(System.out::print);
		
		System.out.println();
		Map<Integer, Long> wordFreq=words.stream().filter((x)->x.length()>=2).collect(Collectors.groupingBy(x->x.length(),Collectors.counting()));
		wordFreq.forEach((k,v)->System.out.println("Length: "+k+" Count: "+v));
	}
	
	public static <T> Object isFinite(Stream<T> stream){
		return null;
	}

}
