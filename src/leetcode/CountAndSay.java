package leetcode;
// Day - 1
//https://leetcode.com/problems/count-and-say/description/
public class CountAndSay {

    public static String count(String str){
        StringBuilder res=new StringBuilder();
        int count=1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i-1)==str.charAt(i)){
                count++;
            }else{
                res.append(count).append(str.charAt(i-1));
                count=1;
            }
        }
        res.append(count).append(str.charAt(str.length()-1));
        return res.toString();
    }
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String RLE="1";

        for (int i = 1; i < n; i++) {
            RLE=count(RLE);
        }

        return RLE;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1)); // Output: "1"
        System.out.println(countAndSay(2)); // Output: "11"
        System.out.println(countAndSay(3)); // Output: "21"
        System.out.println(countAndSay(4)); // Output: "1211"
        System.out.println(countAndSay(5)); // Output: "111221"
        System.out.println(countAndSay(6)); // Output: "312211"
        System.out.println(countAndSay(7)); // Output: "13112221"

    }
}