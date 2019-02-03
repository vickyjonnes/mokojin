package com.test.src;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferencing {

	public static void main(String[] args) {
		Person[] pers=new Person[] {new Person("Noman", 26),new Person("Faizan", 25)};
		List<Person> persons=Arrays.asList(pers);
		
		//Arrays.sort(pers, (p1,p2)->p1.compareTo(p2));
		//Arrays.sort(pers, Person::compareTo);
		Arrays.asList(pers).forEach(System.out::println);
		
		persons.sort(Person::compareTo);
		List<Person> personList=persons.stream().sorted().collect(Collectors.toList());
		//persons.stream().sorted(Person::compareTo);
		persons.stream().sorted((p1,p2)->p1.getName().compareToIgnoreCase(p2.getName()));
		
		persons.forEach(System.out::println);
	}

}
