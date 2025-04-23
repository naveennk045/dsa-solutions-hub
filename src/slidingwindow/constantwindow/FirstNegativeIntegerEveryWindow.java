package slidingwindow.level1;

import java.util.ArrayList;

//https://www.naukri.com/code360/problems/first-negative-integer-in-every-window-of-size-k_1164406?leftPanelTabValue=PROBLEM

public class FirstNegativeIntegerEveryWindow {

    public static int findNegativeIndex(ArrayList<Integer> list, int start, int end){

        for (int i = start; i <end; i++) {
            if(list.get(i)<0) return i;
        }
        return -1;
    }

    public static ArrayList<Integer> firstNegativeInteger(ArrayList<Integer> arr, int k, int n) {
        ArrayList<Integer> negativeNums = new ArrayList<>();

        int prevNegativeIdx = - 1;

        for(int right = k; right <= n; right++){
            int left = right - k;
            System.out.printf("left : %d  -- right : %d%n",left,right);
            if (!(prevNegativeIdx >= left && prevNegativeIdx <= right)){
                prevNegativeIdx = findNegativeIndex(arr,left,right);
            }

            if (prevNegativeIdx!= -1){
                negativeNums.add(arr.get(prevNegativeIdx));
            }else{
                negativeNums.add(0);
            }
//            System.out.println(arr.get(prevNegativeIdx));
        }
        return negativeNums;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(14);
        list.add(-9);
        list.add(-18);
        list.add(-2);
        list.add(5);
        list.add(1);


        System.out.println( firstNegativeInteger(list,3,list.size()));
    }
}