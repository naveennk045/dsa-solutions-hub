package recursion;

import java.util.ArrayList;
import java.util.List;

public class Partitions {

    public static boolean isPalindrome(String str){
        int left=0,right=str.length()-1;

        while(left<right){
            if(str.charAt(left)!=str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static void generateAllPartitions(String str,int idx,List<String> partition ,List<List<String>> partitions){
        if(idx==str.length()){
            partitions.add(new ArrayList<>(partition));
            return;
        }
        for (int i = idx+1; i <=str.length() ; i++) {
            String part = str.substring(idx,i);
            if(!isPalindrome(part)) return;
            partition.add(part);

            generateAllPartitions(str,i,partition,partitions);
            partition.removeLast();
        }
    }
    public static void main(String[] args) {
        List<List<String>>  partitions = new ArrayList<>();
        generateAllPartitions("aabb",0,new ArrayList<>(),partitions);

        System.out.println(partitions);

    }
}