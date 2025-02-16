package arrays;
import java.util.*;

public class InfiniteArrays {

    public static List<Integer> sumInRanges(int[] nums,  List<List<Long>> queries) {
        int sum=0;
        for(int num : nums){
            sum+=num;
        }
//         System.out.println(sum);
        HashSet<Integer> set=new HashSet<>();
        long length=nums.length;
        List<Integer>  result=new ArrayList<>();

        for(List<Long> query : queries ){
            long start= query.get(0)-1;
            long end= query.get(1)-1;
            int val=0;
//            for(long i=start;i<=end;i++){
//                int ind=(int) (i%length);
//                System.out.println(ind);
//                val+= nums[ind];
//            }
//            System.out.println();
            long mul=(end-start)/length;

            if(mul==0){
                for (int i = (int) (start%length); i <= end%length; i++) {
                    val+=nums[i];
                }
            }
            else{
                val+=sum*mul;
                for (int i = (int) (start%length); i <= end%length; i++) {
                    val+=nums[i];
                }
            }
            result.add((int)val);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={98 ,7 ,985, 65 ,5};
        List<List<Long>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1L, 3L));
        queries.add(Arrays.asList(1L, 33L));
        queries.add(Arrays.asList(4L, 6L));



        System.out.println(sumInRanges(nums,queries));
    }
}