package edu.problem.general;

import java.util.stream.IntStream;

public class KMPAlgo {
 
	//https://www.youtube.com/watch?v=V5-7GzOfADQ
	//https://www.youtube.com/watch?v=GTJr8OvyEVQ&t=262s
	//https://www.youtube.com/watch?v=KG44VoDtsAA
	//https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
	public static void main(String[] args) {
		String text="ababcabcabababd";
		String pattern="ababd";
		patternMatchIndex(text, pattern, createLPS(pattern)); // this run in o(n+m)
		
		String text1="aaaab";
		String pattern1="aa";
		patternMatchIndex(text1, pattern1, createLPS(pattern1));
		
		String text2="abcabc";
		System.out.println("Substring present: "+isSubstringPresent(text2));
		
		String text3="ababab";
		System.out.println("Substring present: "+isSubstringPresent(text3));
	}
	
	//to create a lps array for largest prifix and suffix in the pattern itself o(m)
	public static int[] createLPS(String pattern) {
		int lps[]=new int[pattern.length()];
		int i=1,j=0;lps[0]=0;
		while(i<pattern.length()) {
			if(pattern.charAt(j)==pattern.charAt(i)) {
				lps[i]=j+1;
				i++;j++;
			}else {
				if(j==0) {
					lps[i]=0;
					i++;
				}else {
					j=lps[j-1];
				}
			}
		}
		IntStream.range(0, pattern.length()).forEach((t)->System.out.print(lps[t]+" "));
		System.out.println();
		return lps;
	}

	//this is tp find pattern in the text o(n)
	public static void patternMatchIndex(String text, String pattern, int[] lps) {
		int i=0,j=0;
		while(i<text.length()) {
			if(text.charAt(i)==pattern.charAt(j)) {
				if(j==pattern.length()-1) {
					System.out.println("Pattern Matched at: "+(i-j));
					j=0;
				}else {
					i++;j++;
				}
			}else {
				if(j==0) {
					i++;
				}else {
					j=lps[j-1];
				}
			}
		}
	}
	
	//this is another question, which asks to find if there is any substring present which  
	//can be concatenated n times to create parent string, this will use lps array, so complexity will be o(n)
	public static boolean isSubstringPresent(String s) {
		int lps[]=createLPS(s);
		int n=lps.length;
		int prefix=0;
		for(int i=0;i<n;i++) {
			if(prefix<lps[i]) {
				prefix=lps[i];
			}
		}
		
		if(n%(n-prefix)==0) {
			System.out.println("Substring: "+s.substring(0,n-prefix)+" of length "+(n-prefix));
			return true;
		}
		return false;
	}
}
