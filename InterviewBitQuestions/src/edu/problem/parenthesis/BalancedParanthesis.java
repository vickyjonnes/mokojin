package edu.problem.parenthesis;

import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) {
		BalancedParanthesis bp=new BalancedParanthesis();
		String str="[()]{}{[()()]()}";
		String str1="[(])";
		String str2 = "abcd]";
		String str3 = ")(";
		
		System.out.println("String is balanced: "+bp.validateBalanced(str));
		System.out.println("String is balanced: "+bp.validateBalanced(str1));
		System.out.println("String is balanced: "+bp.validateBalanced(str2));
		System.out.println("String is balanced: "+bp.validateBalanced(str3));
	}
	
	//this is to just validate whether a string is balanced or not
	public boolean validateBalanced(String str) {
		Stack<String> stack=new Stack<>();
		for(int i=0;i<str.length();i++) {
			String curr=String.valueOf(str.charAt(i));
			if(isOpen(curr)) {
				stack.push(curr);
			}else {
				if(isClose(curr)) {
					String pop=stack.isEmpty()? "" :stack.pop();
					if(!openForClose(curr).equals(pop)) {
						return false;
					}
				}
			}
		}
		return stack.isEmpty()?true:false;
	}
	
	public boolean isOpen(String str) {
		if(str.equals("(") || str.equals("{") || str.equals("[")) {
			return true;
		}
		return false;
	}
	
	public boolean isClose(String str) {
		if(str.equals(")") || str.equals("}") || str.equals("]")) {
			return true;
		}
		return false;
	}
	
	public String openForClose(String str) {
		switch(str) {
		case ")": return "(";
		case "}" : return "{";
		case "]" : return "[";
		default: return "";
		}
	}
	
}
