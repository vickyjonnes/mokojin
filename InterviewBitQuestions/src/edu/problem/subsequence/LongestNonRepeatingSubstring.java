package edu.problem.subsequence;

import java.util.HashMap;

public class LongestNonRepeatingSubstring {

	//https://www.geeksforgeeks.org/print-longest-substring-without-repeating-characters/
	//idea is to maintain a hashmap<character, last index of occurence> and traverse the string. if any char is already
	//present in hashmap then check whether last index is greater than start if yes that means this char occcured in current
	//substring, so we have to check whether the curr lenght is greater than max length if yes then update max length
	//and then change start to next of previous index of char.
	public static void main(String[] args) {
		System.out.println(getMaxLengthOfNRCS("ababdefghiac"));
		System.out.println(getMaxLengthOfNRCS("geeksforgeeks"));
		System.out.println(getMaxLengthOfNRCS("aabbacdb"));
	}
	
	public static int getMaxLengthOfNRCS(String str) {
		HashMap<String, Integer> map=new HashMap<>();
		int maxLength=0;
		int currLength=0;
		int start=-1;
		
		for(int i=0;i<str.length();i++) {
			int prevIndex=map.get(String.valueOf(str.charAt(i)))==null?-1:map.get(String.valueOf(str.charAt(i)));
			if(prevIndex>=start) {
				maxLength=Math.max(currLength, maxLength);
				start=prevIndex+1;
				currLength = i-prevIndex;
			}else {
				currLength++;
			}
			map.put(String.valueOf(str.charAt(i)), i);
		}
		return Math.max(currLength, maxLength);
	}
}
