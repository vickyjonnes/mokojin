package com.test.src;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalStyle {

	public static void main(String[] args) {
		List<Integer> numbers =Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<String> names=Arrays.asList("Noman","Faizan","Shahroz", "Firoz");
		System.out.println(names); 
		//Collections.sort(names, (first,second)->first.compareTo(second));	
		Collections.sort(names, String::compareTo);	
		//if i want to chnage logic then
		Collections.sort(numbers, Integer::compare);
		Collections.sort(names, (first,second)->Integer.compare(first.length(),second.length()));
		Collections.sort(names,Comparator.comparing(String::length));
		System.out.println(names);
		
		//List<Person> persons=names.stream().map(Person::new).collect(Collectors.toList());
		//Collections.sort(persons, Comparator.comparing(Person::getName));
		//Comparator.comparing(persons::name);
//		persons.stream().forEach(p->System.out.print(p.getName()+" "));
//		EchoTime.timeIt(()->
//		System.out.println(
//				numbers.stream()
//				.filter(FunctionalStyle::isEven)
//				.mapToInt(FunctionalStyle::doubleIt)
//				.sum()
//				//.reduce(0, Integer::sum)
//				)
//		);
	}
	
	public static Integer doubleIt(Integer e) {
		return e*2;
	}
	
	public static boolean isEven(Integer e) {
		return (e%2==0)?true:false;
	}

}
