package slidingwindow.twopointers;

/*
Problem description

Given a binary string S consisting of only 0s and 1s, write an algorithm
 to find the number of different ways to get the longest consecutive sub-segment
 of 1s only. You are allowed to change any k number of 0s to 1s. Note that two
 ways are similar if they lead to the same string.

Example

Input

7 1

1010101

Output

3

Explanation

Since only one change is allowed the different combinations possible
 are 1110101 1011101 and 1010111. In all the possible combinations the
 maximum reading with consecutive is 1011101 i.e 111 so 3 is the output.
 */

public class
ConsecutiveSubSegments {
    public static void main(String[] args) {
        char[] s="1010101".toCharArray();
        int k=2;
        int left=0;
        int right=0;
        int max=0;
        int count=0;
        while(right<s.length){

            if(s[right]=='1'){
                max=Math.max(max,(right-left)+1);
//                System.out.println(d.substring(left,right+1));
                right++;

            }
            else if(s[right]=='0' && count<k){
                max=Math.max(max,(right-left)+1);
//                System.out.println(d.substring(left,right+1));
                count++;
                right++;
            }
            else{
                left=right;
                right++;
            }
        }
        System.out.println(max);

    }
}