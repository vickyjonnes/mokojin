package edu.tinder.matches;

import java.util.Comparator;

public class UserComparator implements Comparator<User>{

	private User user;
	
	
	public UserComparator(User user) {
		this.user=user;
	}
	
	
	@Override
	public int compare(User u1, User u2) {
		int firstPreferred=0;
		int secondPrefered=0;
		if(user.getSex().equals(u1.getSex())) {
			firstPreferred--;
		}else {
			firstPreferred++;
		}
		if(user.getSex().equals(u2.getSex())) {
			secondPrefered--;
		}else {
			secondPrefered++;
		}
		if(agePreference(u1, u2)>0) firstPreferred++;
		else if(agePreference(u1, u2)<0) secondPrefered++;
		
		if(firstPreferred>secondPrefered) {
			return -1;
		}else if(firstPreferred<secondPrefered) {
			return 1;
		}else return 0;
	}
	
	private int agePreference(User u1, User u2) {
		int ageDiff1=Math.abs(user.getAge()-u1.getAge());
		int ageDiff2=Math.abs(user.getAge()-u2.getAge());
		if(ageDiff1<ageDiff2) {
			return 1;
		}else if(ageDiff1>ageDiff2) {
			return -1;
		}else return 0;
	}

}
