package edu.problem.general;

// you can also use imports, for example:
import java.util.*;

public class DecodeString {

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        System.out.println(getDecode("2[a3[bc]2[de]]"));

    }

    public static String getDecode(String str){
        Stack<String> s = new Stack<>();

        for(int i=str.length()-1; i>=0;i--){
            if(str.charAt(i)==']'){
                s.push(str.charAt(i)+"");
                //System.out.println(s.peek());
            }else if(str.charAt(i)!=']'){
                if(str.charAt(i)>='a' && str.charAt(i)<='z'){
                    String temp="";
                    int j=i;
                    while(j>=0 && (str.charAt(j)>='a' && str.charAt(j)<='z')){
                        temp = str.charAt(j)+temp;
                        j--;
                    }
                    s.push(temp);
                    //System.out.println(s.peek());
                    i=i-(temp.length());
                }else{
                    if(str.charAt(i)=='['){
                        String result="";
                        while(!s.isEmpty()){
                            String temp = s.pop();
                            if(temp.equals("]")){
                                break;
                            }
                            result = result+temp;
                        }
                        s.push(result);
                        // System.out.println(s.peek());
                    }else{
                        int num = Integer.valueOf(str.charAt(i)+"");
                        String result="";
                        while(!s.isEmpty()){
                            String temp = s.pop();
                            if(temp.equals("]")){
                                break;
                            }
                            result = result+temp;
                        }
                        int k=1;
                        String var=result;
                        while(k<num){
                            result = var+result;
                            k++;
                        }
                        s.push(result);
                        //System.out.println(s.peek());
                    }
                }
            }
        }
//         while(!s.isEmpty()){
//             System.out.println(s.pop());
//         }
        return s.pop();
    }
}
