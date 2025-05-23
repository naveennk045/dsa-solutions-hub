package problems.platform.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> frequencyMap = new LinkedHashMap<>();
        for (char ch : s.toCharArray()){
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch,0)+1);
        }
        System.out.println(frequencyMap);
        for(char ch : frequencyMap.keySet()){
            if(frequencyMap.get(ch)==1) return s.indexOf(ch);
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}