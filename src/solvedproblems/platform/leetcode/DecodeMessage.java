package solvedproblems.platform.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

//https://leetcode.com/problems/decode-the-message/description/

public class DecodeMessage {
    public static String decodedMessageII(String key,String message){
        char[] asciiTable=new char[256];
        boolean[] isOccurred =new boolean[256];
        char alphabet='a';
        StringBuilder decodedMessage=new StringBuilder();

        for (char ch : key.toCharArray()){
            if(ch!=' ' && !isOccurred[ch]){
                isOccurred[ch]=true;
                asciiTable[ch]=alphabet++;
            }
        }

        for (char ch : message.toCharArray()){
            if(ch!=' '){
                decodedMessage.append(asciiTable[ch]);
            }else{
                decodedMessage.append(' ');
            }
        }
        System.out.println(Arrays.toString(asciiTable));
        return decodedMessage.toString();

    }

    public static String decodeMessageI(String key, String message) {

        StringBuilder decodedMessage=new StringBuilder();
        HashMap<Character,Character> map=new LinkedHashMap<>();
        char alphabet='a';

        System.out.println(Arrays.toString(key.toCharArray()));

        for(char ch : key.toCharArray()){
            if(ch!=' ' &&  !map.containsKey(ch)){
                map.put(ch,alphabet);
                alphabet++;
            }
        }

        for(char ch : message.toCharArray()){
            if(ch!= ' '){
                decodedMessage.append(map.get(ch));
            }else{
                decodedMessage.append(' ');
            }
        }
        System.out.println(map.size());
        System.out.println(map);

        return decodedMessage.toString();
    }
    public static void main(String[] args) {
        String key="the quick brown fox jumps over the lazy dog";
        String message="vkbs bs t suepuv";

        System.out.println(decodeMessageI(key,message));
        System.out.println(decodedMessageII(key,message));


    }
}