package slidingwindow.twopointers;

public class ReverseStringII {
    public static void reverse(char[] chars,int start,int end){
        while(start<end){
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }
    public static String reverseStr(String s, int k) {
        int n=s.length();
        char[] chars=s.toCharArray();
        int ind=0;

        while(ind<chars.length){
            // System.out.println(ind);
            int end=Math.min(ind+k-1,n-1);
            reverse(chars,ind,end);
            ind+=(k*2);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s="abcdefg";
        System.out.println(reverseStr(s,2));
    }
}