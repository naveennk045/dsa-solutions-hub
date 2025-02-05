package string;

import java.util.HashMap;
import java.util.Scanner;

public class RomenIntegers {
    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);
        String s=scan.next();
        scan.close();


        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);


        long sum=0;
        for (int i = 0; i < s.length();i++) {
            char c1=s.charAt(i);

            if(i<s.length()-1) {
                char c2 = s.charAt(i + 1);
                if (map.get(c1) >= map.get(c2)) {
                    sum += map.get(c1);

                } else {
                    sum += (map.get(c2) - map.get(c1));
                    i++;
                }
            }
            else{
                    sum+= map.get(c1);
            }
        }
        System.out.println(sum);
    }

}