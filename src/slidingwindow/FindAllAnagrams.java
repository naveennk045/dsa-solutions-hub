package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        int k=p.length();
        int[] actualCount = new int[256];
        for(char ch : p.toCharArray()) actualCount[ch]++;
        int[] windowCount = new int[256];
        for (int right = 0 , left=0; right < s.length(); right++) {
            if (right<p.length()){
                windowCount[s.charAt(right)]++;
                continue;
            }
            windowCount
            if(Arrays.equals(windowCount,actualCount)) indices.add(left);
            windowCount[s.charAt(left++)]--;


        }
    }
    public static void main(String[] args) {

    }


}