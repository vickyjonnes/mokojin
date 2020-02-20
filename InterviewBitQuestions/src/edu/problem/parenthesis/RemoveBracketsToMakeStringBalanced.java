package edu.problem.parenthesis;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/remove-invalid-parentheses/
//bfs way to solve it. order n square.
public class RemoveBracketsToMakeStringBalanced {

	public static void main(String[] args) {
		RemoveBracketsToMakeStringBalanced bpr=new RemoveBracketsToMakeStringBalanced();
		String str="()())()";
		String str1="(()(";
		bpr.removeBracketsAndPrintBalancedString(str);
		System.out.println();
		bpr.removeBracketsAndPrintBalancedString(str1);
	}
	
	public boolean isValidString(String str) {
		if(str=="" || str ==null)
			return false;
		int count=0;
		for(int i=0;i<str.length();i++) {
			if("(".equals(str.charAt(i)+"")) {
				count++;
			}else {
				count--;
			}
			if(count<0)
				return false;
		}
		return count==0?true:false;
	}
	
	public void removeBracketsAndPrintBalancedString(String str) {
		HashSet<String> visited=new HashSet<>();
		Queue<String> q=new LinkedList<>();
		q.add(str);
		visited.add(str);
		String temp;
		boolean level=false;
		while(!q.isEmpty()) {
			String s=q.poll();
			if(isValidString(s)) {
				System.out.println(s);
				level=true;
			}
			if(level)
				continue;
			else {
				for(int i=0;i<s.length();i++) {
					if(s.charAt(i)=='(' || s.charAt(i)==')') {
						temp=s.substring(0, i)+s.substring(i+1);
						if(!visited.contains(temp)) {
							q.add(temp);
							visited.add(temp);
						}
					}
				}
			}
		}
		
	}

}
