package arrays;


public class LargestNumber {
    public static void main(String[] args) {
        int[] nums={0,0,0,0};
        int count=0;
        for (int value : nums) {
            if (value == 0) {
                count++;
            }
        }
        if(count==nums.length){
//            return 0;
        }
        System.out.println(count);

        String[] strArr=new String[nums.length];
        int i=0;
        for(int num:nums){
            strArr[i]=String.valueOf(num) ;
            i++;
        }



        for (int j = 0; j < strArr.length ; j++) {
            for (int k = j+1; k < strArr.length; k++) {
                String s1=strArr[j]+strArr[k];
                String s2=strArr[k]+strArr[j];

                if(s2.compareTo(s1)>0){
                    String temp=strArr[k];
                    strArr[k]=strArr[j];
                    strArr[j]=temp;
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        for (String s:strArr) {
            sb.append(s);
        }
        System.out.println(sb);

    }

}