package SlidingWindow;

public class MinimumWindow {
    public static void main(String[] args) {
        String s="AB";
        String t="A";
        int maxLength=Integer.MIN_VALUE;
        String res="";

        for (int i = 0; i < s.length(); i++) {
            String temp;
            for (int j = i; j < s.length(); j++) {
                temp=s.substring(i,j);
                if(isContains(t,temp)){
                    if(maxLength<temp.length()){
                        res=temp;
                    }

                }
            }
        }
        System.out.println(res);
    }
    static boolean isContains(String t,String temp){
        boolean flag=false;
        char[] tArr=t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            char c=t.charAt(i);
            if(temp.indexOf(c)==-1){
                return false;
            }
        }
        return  true;
    }
}