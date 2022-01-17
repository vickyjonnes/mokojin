package edu.problem.general;

import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/
// given arry has asteroids moving in left and right direction based on the sign of element in the array
// if a +ve and -ve asteroid collide then one with smaller size will explode
// if both are of same size then both will collide. two asteroids moving in same direction will never collide
// order of the numbers is also important if -ve comes first and +ve later then they will collide because both are moving in opp dir
public class Asteroids {
    public static void main(String[] args) {
        int a[] = {-5, 10, -5,-6, 10, -25, 20};
        printRemainingAsteroids(a);

    }

    //solution is stack based
    public static void printRemainingAsteroids(int a[]){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if(stack.isEmpty()){
                stack.push(a[i]);
                continue;
            }
            if(a[i]>0){
                stack.push(a[i]);
            }else{
                int top = stack.peek();
                if(top>0 && top>Math.abs(a[i])){

                }else if(top>0 && top<Math.abs(a[i])){
                    while(!stack.isEmpty() && top>0){
                        if(top<Math.abs(a[i])){
                            stack.pop();
                            top=stack.peek();
                        }else{
                            break;
                        }
                    }
                    if(stack.isEmpty() || top<0){
                        stack.push(a[i]);
                    }
                }else{
                    stack.push(a[i]);
                }
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
