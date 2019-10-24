package edu.problem;

import java.util.Stack;

//https://www.geeksforgeeks.org/find-maximum-in-a-stack-in-o1-time-and-o1-extra-space/
//only trick is to save derived number in stack not the original no.
public class StackToGetMaxNumber {

	public static void main(String[] args) {
		StackToGetMaxNumber s=new StackToGetMaxNumber();
		s.push(2);
		s.push(5);
		s.push(7);
		System.out.println(s.getMax());
		s.push(1);
		s.push(3);
		System.out.println(s.getMax());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.getMax());
		System.out.println(s.pop());
		System.out.println(s.getMax());
	}
	
	public Stack<Integer> stack=new Stack<>();
	public int max;
	
	public void push(int x) {
		if(stack.empty()) {
			stack.push(x);
			max=x;
			return;
		}
		if(x<=max)
			stack.push(x);
		else {
			stack.push(2*x-max);
			max=x;
		}
			
	}
	
	public int pop() {
		if(stack.empty())
			return Integer.MIN_VALUE;
		int element=stack.pop();
		if(element>max) {
			int temp=max;
			max=2*max-element;
			return temp;
		}
		else
			return element;
	}
	
	public int getMax() {
		return max;
	}

}
