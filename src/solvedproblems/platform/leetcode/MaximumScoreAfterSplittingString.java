package solvedproblems.platform.leetcode;

public class MaximumScoreAfterSplittingString {
    public static int maxScore(char[] chars) {
        int zeroCount=0;
        int oneCount=0;
        int max=Integer.MIN_VALUE;
        for(char ch : chars){
            if(ch=='1') oneCount++;
        }
        for(int i=0;i<chars.length-1;i++){
            char ch=chars[i];
            if(ch=='0') zeroCount++;
            else oneCount--;

            max=Math.max(max,zeroCount+oneCount);
        }
        return max;
    }
    public static void main(String[] args) {
        String str="011101";
        System.out.println(maxScore(str.toCharArray()));
    }
}