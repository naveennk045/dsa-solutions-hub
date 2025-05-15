package solvedproblems.companywise.tcs;

public class ChocolateDistribution {
    public static int countNoOfWaysToDistribute(int month,int day,int[] squares){
        int sum=0;
        int left=0;
        int right=0;
        for(;right<month;right++){
            sum+=squares[right];
        }
        int count=0;
        for(;right<squares.length;right++){
           if(sum==day) count++;
           sum+=squares[right];
           sum-=squares[left++];
        }
        return count;

    }
    public static void main(String[] args) {
        int[] squares={2,3,6,7,6};
        int result=countNoOfWaysToDistribute(3,2,squares);
        System.out.println(result);
    }
}