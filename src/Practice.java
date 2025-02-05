// You are using Java

import java.util.*;

public class Practice{
    public static void main(String[] args){

        Scanner scan=new Scanner(System.in);

        char[] letters=scan.nextLine().toCharArray();

        HashMap<Character,Integer> map=new HashMap<>();




        for(char ch: letters){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
//        System.out.println(map);

        int length=0;
        int ones=0;

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            int count=entry.getValue();
            char ch=entry.getKey();

            if(count>1 && count%2==0) length+=count;
            else if(count>1 && count%2!=0) length+=count-1;
            else ones++;
        }
        if(ones>0) length+=1;

        System.out.println(length);

    }
}