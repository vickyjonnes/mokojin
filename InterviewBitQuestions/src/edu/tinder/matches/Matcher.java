package edu.tinder.matches;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Matcher {

	private static List<User> userList=new ArrayList<>();
	
	private static void populateList() {
		userList.add(new User("faizan", "male", 26));
		userList.add(new User("uday", "male", 29));
		userList.add(new User("varun","male",28));
		userList.add(new User("ruchi", "female", 23));
		userList.add(new User("fiza", "female", 27));
		userList.add(new User("nikita", "female", 30));
	}
	
	public static void main(String[] args) {
		populateList();
		printMatchesForUser(userList.get(5));
		
	}
	
	public static void printMatchesForUser(User user) {
		List<User> l=userList.stream().filter((u)->!Objects.equals(user, u)).sorted(new UserComparator(user)).collect(Collectors.toList());
		System.out.println("Matches for User: "+user);
		l.forEach(System.out::println);
		
	}
	

}
