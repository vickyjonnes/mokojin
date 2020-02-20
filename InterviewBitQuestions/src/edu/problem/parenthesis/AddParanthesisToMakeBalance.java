package edu.problem.parenthesis;

//https://www.geeksforgeeks.org/minimum-number-of-parentheses-to-be-added-to-make-it-valid/
public class AddParanthesisToMakeBalance {

	public static void main(String[] args) {
		makeValid("()((");
		makeValid("))()");
		makeValid(")(");
		makeValid("))");
		makeValid("(((");
	}
	
	public static void makeValid(String str) {
		int count=0;
		String result=str;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				count++;
			}else {
				count--;
			}
			if(count<0) {
				result="("+result;
				count++;
			}
		}
		while(count>0) {
			result=result+")";
			count--;
		}
		System.out.println(result);
	}

}
