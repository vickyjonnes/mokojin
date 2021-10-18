package edu.problem.general;

//https://www.youtube.com/watch?v=QtEtcXPqRPk
public class BinaryStringAddition {
    public static void main(String[] args) {
        System.out.println(binSum("101","10"));
    }

    public static String binSum(String first, String second){
        if(first.isEmpty()){
            return second;
        }else if(second.isEmpty()){
            return first;
        }else if(first.isEmpty() && second.isEmpty()){
            return "0";
        }
        String longest=first.length()>second.length() ? first : second;
        String smallest = longest.equals(second) ? first :second;
        int carry=0;
        int sItr = smallest.length()-1;
        String result = "";
        for(int i=longest.length()-1; i>=0; i--){
            int f = Integer.valueOf(String.valueOf(longest.charAt(i)));
            int s = 0;
            if(sItr>=0){
                s = Integer.valueOf(String.valueOf(smallest.charAt(sItr)));
                sItr--;
            }
            if(f+s+carry==0){
                result = "0"+result;
                carry=0;
            }else if(f+s+carry==1){
                result = "1"+result;
                carry=0;
            }else if(f+s+carry==2){
                result = "0"+result;
                carry=1;
            }else if(f+s+carry==3){
                result = "1"+result;
                carry=1;
            }else{
                throw new RuntimeException("Invalid binary String");
            }
        }
        if(carry>0)
            result = "1"+result;

        return result;
    }
}
