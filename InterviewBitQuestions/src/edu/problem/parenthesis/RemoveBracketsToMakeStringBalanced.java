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
		String str1="()((";
		String str2="))((";
		System.out.println(doBalance(str));
		System.out.println();
		System.out.println(doBalance(str1));
		System.out.println(doBalance(str2));
	}

	public static String doBalance(String str){
		StringBuilder sb = new StringBuilder();
		int count=0;
		for(int i=0;i<str.length(); i++){
			if(str.charAt(i)=='('){
				sb.append(str.charAt(i));
				count++;
			}else if(str.charAt(i)==')'){
				if(count>0){
					sb.append(str.charAt(i));
					count--;
				}
			}
		}
		StringBuilder result = new StringBuilder();

		for(int i=sb.length()-1; i>=0; i--){
			if(sb.charAt(i)=='(' && count > 0){
				count--;
			}else{
				result.append(sb.charAt(i));
			}
		}
		return result.reverse().toString();
	}

}
