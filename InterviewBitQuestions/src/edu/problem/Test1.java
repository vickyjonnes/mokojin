package edu.problem;

import java.util.HashMap;

public class Test1 {

	public static void main(String[] args) {
		HashMap<String,String> map=new HashMap<>();
		map.put("n", "noman");
		map.put("fai", "faizan");
		map.put("faz", "fazil");
		
		map.entrySet().stream().sorted((a,b)->a.getValue().compareTo(b.getValue())).forEach(a->System.out.print(a.getValue()+" "));
		
		//map.entrySet().stream().forEach(a->System.out.print(a.getValue()+" "));
	}
	
	
	
}
