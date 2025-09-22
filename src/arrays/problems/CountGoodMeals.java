package arrays.problems;

public class CountGoodMeals {
    public static boolean isPowerOfTwo(int num){
        if(num<=0) return false;

        while(num%2==0) {
            num /= 2;
        }
        return num==1;
    }

    public static int countPairsI(int[] deliciousness) {
        int n=deliciousness.length;
        long count=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int sum=deliciousness[i]+deliciousness[j];
                if(isPowerOfTwo(sum)) count++;            }
        }
        return (int)(count%1000000007);
    }
    public static void main(String[] args) {
        int[] deliciousness={1,2,6,8,3,8};
        int ans=countPairsI(deliciousness);
        System.out.println(ans);
    }
}