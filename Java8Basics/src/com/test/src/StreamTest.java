package com.test.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		Function<Person,String> getpersonName=Person::getName;
		BiFunction<String,Integer,Person> getPersonObj=(name,age)->new Person(name,age);
		List<Person> persons=new ArrayList<>();
		List<String> names=Arrays.asList("faizan","faraz","faizan");
		List<Integer> ages=Arrays.asList(25,26,25);
		//Stream<Integer> itr=Stream.iterate(0, n->n+1);
		
		Stream
		.iterate(0, n->n+1)
		.limit(names.size())
		.map((i)->getPersonObj.apply(names.get(i), ages.get(i)))
		.forEach(persons::add);
		
		
		Stream
		.iterate(0, n->n+1)
		.limit(names.size())
		.map((i)->new Person(names.get(i),ages.get(i)))
		.forEach(persons::add);
		
		//names.stream().map((name)->new Person(name,23)).forEach(persons::add);
		Optional<String> name=Optional.of(names.get(0));
		//name.ifPresentOrElse((v->names.add(v)),()->System.out.println("Not present"));
		Optional<Person> added=name.map((n)->new Person(n,26));
		
		persons.stream()
		.map(getpersonName::apply)
		.forEach(System.out::println);
		upperCase(name.get()).flatMap(StreamTest::lowerCase).ifPresent(System.out::println);
		
		//ages.stream().reduce((x,y)->x+y).ifPresent(System.out::println);
		ages.stream().reduce(Integer::sum).ifPresent(System.out::println);
		Integer ageSum=ages.stream().reduce(20, Integer::sum);
		Integer nameSum=names.stream().reduce(30,
				(total,words)->total+words.length(),
				(total1,total2)->total1+total2);
		
		System.out.println(ageSum+" :: "+nameSum);
		String nameAr[]=names.stream().toArray(String[]::new);
		Set<String> nameSet=names.stream().collect(Collectors.toSet());
		nameSet.stream().forEach(System.out::println); 
		Map<String,Person> pMap=persons.stream().collect(Collectors.toMap(Person::getName, Function.identity(),(a,b)->b));
		pMap.forEach((k,v)->System.out.println("key: "+k+" value: "+v));
		
		Map<String,Integer> nameFreq=names.stream().collect(Collectors.toMap(
				n->n,
				n->1,
				(a,b)->a+b
				));
		
		nameFreq.forEach((k,v)->System.out.println(k+" = "+v));
		
		Map<String, Long> nameF=names.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
		nameF.forEach((k,v)->System.out.println(k+" = "+v));
		
	}
	
	public static Optional<String> upperCase(String str){
		return Optional.ofNullable(str.toUpperCase());
	}
	
	public static Optional<String> lowerCase(String str){
		return Optional.ofNullable(str.toLowerCase());
	}

}
