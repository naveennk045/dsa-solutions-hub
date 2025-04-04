package combinatorics;

import java.util.ArrayList;

public class Subset {

//    Iterative approach for generating a subset
    public static ArrayList<ArrayList<Integer>> generateSubset(int[] nums){
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>());

        for(int num : nums){
            int size=list.size();

            for (int i = 0; i < size; i++) {

//                System.out.printf("num : %d  ,  size : %d%n",num,size);

                ArrayList<Integer> temp=new ArrayList<>(list.get(i));
                temp.add(num);
                list.add(temp);
            }
        }
        return list;
    }

    public static void generateSubset(int [] nums,int
            index,ArrayList<Integer> current,ArrayList<ArrayList<Integer>> subsets) {

        if(index==nums.length){
            subsets.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);

        generateSubset(nums,index+1,current,subsets);

        current.removeLast();
        generateSubset(nums,index+1,current,subsets);

    }
        public static void main(String[] args) {
        int[] nums={1,2,3,4};
        ArrayList<ArrayList<Integer>> list1=generateSubset(nums);
        System.out.println(list1);

        ArrayList<ArrayList<Integer>> list2=new ArrayList<>();

        generateSubset(nums,0,new ArrayList<>(),list2);

        System.out.println(list2);

    }
}