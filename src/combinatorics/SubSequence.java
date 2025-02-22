package combinatorics;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {

//       Iterative approach for generating a subset
    public static ArrayList<String> generateSubSequence(String str){
        ArrayList<String> list=new ArrayList<>();
        list.add("");

        for(char ch : str.toCharArray()){
            int size=list.size();

            for (int i = 0; i < size; i++) {
                String temp=list.get(i)+ch;
                list.add(temp);
            }
        }
        return list;
    }

//    Recursive approach for generating the subsequence
    public static ArrayList<String> generateSubSequence(String str,String pStr){
        if(str.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(pStr);
            return list;
        }
        char ch=str.charAt(0);
//        instead of using a substring we can also use the index also because it takes space complexity for every recursive call
        ArrayList<String> left=generateSubSequence(str.substring(1),pStr+ch);
        ArrayList<String> right=generateSubSequence(str.substring(1),pStr);

        left.addAll(right);
        return left;
    }



    public static void main(String[] args) {
        String str="abcdef";

        List<String> list1=generateSubSequence(str);
        System.out.println(list1);

        List<String> list2=generateSubSequence(str,"");
        System.out.println(list2);


    }
}