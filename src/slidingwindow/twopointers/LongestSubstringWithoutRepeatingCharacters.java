package slidingwindow.twopointers;

import java.util.Arrays;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class LongestSubstringWithoutRepeatingCharacters {
    public static int  findLongestSubstring(String str){

        int length=str.length();
        int left=0, right=0 ,maxLength=-1;
        int[] freqMap=new int[256];
        Arrays.fill(freqMap, -1);

        while(right<length){
            char ch=str.charAt(right);
            if(freqMap[ch]!=-1){
                if(freqMap[ch]>=left){
                    left=freqMap[ch]+1;
                }
            }
            maxLength=Math.max(maxLength,right-left+1);
            freqMap[ch]=right;
            right++;
        }
        return  maxLength;
    }
    public static void main(String[] args) {
        String str="aaaaaaaaaaaabbbbbbbbbbbbbbbbbbbcccccccccccccccc";
        System.out.println(findLongestSubstring(str));
    }
}