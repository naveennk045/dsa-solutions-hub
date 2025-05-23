package ServiceNowQuestions;

import java.util.HashMap;

public class LogFile {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        String[] log={"88 99 200", "88 99 300", "99 32 100", " 12 12 15"};
        for (String str :log){
            String[] temp=str.split(" ");
            for (int i = 0; i < temp.length; i++) {
               if( map.containsKey(temp[i])) {
                   map.put(temp[i], map.get(temp[i])+1);
               }
               else{
                   map.put(temp[i],1);
               }
            }
        }
    }
}

