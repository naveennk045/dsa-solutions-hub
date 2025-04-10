import java.util.*;

import static java.util.Collections.*;

public class Solution {

    public static int getKthLargest(ArrayList<Integer> arr, int k) {

        // Write your code here
        ArrayList<Integer>  list = new ArrayList<>();

        for(int i=0;i<arr.size();i++){
            int sum=0;
            for(int j=i;j<arr.size();j++){
                sum+=arr.get(j);
                list.add(sum);
            }
        }
        list.sort(reverseOrder());
        System.out.println(list);

        return list.get(k-1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<>();

        list.add(3);
        list.add(-2);
        list.add(5);

        System.out.println(getKthLargest(list,3));
    }
}