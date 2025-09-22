package arrays.problems;

import java.util.ArrayList;

public class ReverseList {
    public static void reverseI(ArrayList<Integer> list){
        int left=0,right= list.size()-1;

        while(left<right){
            int temp=list.get(left);
            list.set(left,list.get(right));
            list.set(right,temp);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        reverseI(list);
        System.out.println(list);


    }
}