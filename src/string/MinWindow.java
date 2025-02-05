package string;

import java.sql.SQLOutput;
import java.util.HashMap;

public class MinWindow {

    public static String minWindow(String s, String t) {
        HashMap<Integer,String> map=new HashMap<>();
        int min=s.length()+1;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String subString=s.substring(i,j+1);
//                System.out.println(subString);
//                if(contains(subString,t) ) {
//                    min=Math.min(min,subString.length());
//                    map.put(subString.length(),subString);
//
//                }
            }
        }
        return map.get(min);
    }
    public static void main(String[] args) {
        System.out.println();
        String res=minWindow("ADOBECODEBANC","ABC");
        System.out.println(res);

    }
}