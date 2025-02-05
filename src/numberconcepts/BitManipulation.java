package numberconcepts;

public class BitManipulation {

    public static boolean isOdd(int num){
        return (num & 1)==1;
    }

    public static int countSetBit(int num){
        int count=0;

        while(num>0){
            count+=num&1;
            num>>=1;
        }
        return count;
    }
    public static boolean powerOfTwo(int num){
        int val=num & (num-1);
        return val==0;
    }



    public static int findUnique(int[] nums ){
        int unique=0;
        for (int num : nums){
            unique^=num;
        }
        return unique;
    }

    public static int ithBit(int num,int i){
        return num>>(i) & 1;
    }

    public static void main(String[] args) {
        System.out.println(countSetBit(7));
        System.out.println(powerOfTwo(8));
        System.out.println(findUnique(new int[]{1,1,2,3,3,3,8,6,6,2}));
        System.out.println(isOdd(9));
        System.out.println(ithBit(10,2));


    }
}