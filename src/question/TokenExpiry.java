package ServiceNowQuestions;

import java.util.HashMap;
import java.util.Map;

public class TokenExpiry {
    public static void main(String[] args) {
        int expiryLimit=3;
        int[] []commands = {  {0, 1, 1},
                {1, 1, 5} };
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int[] command : commands) {
            if (command[0] == 0) {
                map.put(command[1], command[2] + expiryLimit);
            } else if (command[0] == 1) {
                int t = map.get(command[1]);
                if (command[2] <= t) {
                    map.put(command[1], command[2] + expiryLimit);
                } else {
                    map.remove(command[1]);
                }
            }
        }

    int count=0;
    int maxTime=commands[commands.length-1][2];
    for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>=maxTime){
                count+=1;}
        }
        System.out.println(count);
    }

}


