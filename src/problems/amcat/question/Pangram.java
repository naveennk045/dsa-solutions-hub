package ServiceNowQuestions;

import java.util.HashSet;

public class Pangram {
    public static void main(String[] args) {
        String s="This is good book";
        HashSet<Integer> set=new HashSet<>();
        s=s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=' '){
                set.add((int)s.charAt(i));
            }
        }
        if(set.size()==26){
            System.out.println("It is Pangram");
        }
        else {
            System.out.println("This is not Pangram");
        }
    }
}
