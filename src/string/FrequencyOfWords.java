package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfWords {

    public static HashMap<String,Integer> countWords(String[] words){
        HashMap<String,Integer> map=new HashMap<>();

        for(String word:words){
            if (map.containsKey(word)){
                map.merge(word, 1, Integer::sum);
            }
            else{
                map.put(word,1);
            }
        }
        return map;
    }

    public static void display(HashMap<String,Integer> map){
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " "+entry.getValue());
        }
    }

    public static void main(String[] args) {

        String sentence="the day is sunny the the the sunny is is";


        String[] words=sentence.split(" ");

        HashMap<String , Integer> frequencyMap=countWords(words);
        display(frequencyMap);

    }

}