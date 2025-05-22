package sandbox;

import java.util.*;
public class Solution {
    public static String getAlienLanguage(String []dictionary, int k) {
        int[] freq = new int[26];

        for(String word : dictionary ){
            for(char ch : word.toCharArray()){
                freq[ch-'a']++;
            }
        }
        System.out.println(Arrays.toString(freq));

        for(int i=0;i<k;i++){
            if(freq[i]<=0) return "false";
        }
        return "true";
    }

    public static void main(String[] args) {
        System.out.println(getAlienLanguage(new String[]{"bbbbc","bba","aaaaac"},3));
    }
}