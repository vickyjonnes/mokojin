package edu.problem;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		List<Integer> l=new ArrayList<>();
		l.add(2); l.add(-3); l.add(-6); l.add(-7);l.add(20);
		System.out.println(requiredAmountAtStart(l));
	}
	
	public static int requiredAmountAtStart(List<Integer> netSaving) {
        int sum=0;
        int x=0;
        for(int i=0;i<netSaving.size();i++){
            sum=sum+netSaving.get(i);
            if(sum<0){
                x=Math.max(x, (sum*(-1)+1));
            }
        }
        return x;
    }
	
	
}
