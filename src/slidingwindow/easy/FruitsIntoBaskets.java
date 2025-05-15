package slidingwindow.easy;

import java.util.HashMap;

public class FruitsIntoBaskets {
    public static int totalFruit(int[] fruits){
        int left=0 ,right=0 ,maxLength=0;

        HashMap<Integer,Integer> fruitFreq=new HashMap<>();

        while(right < fruits.length){
            int count=fruitFreq.getOrDefault(fruits[right],0)+1;
            fruitFreq.put(fruits[right], count);

            if(fruitFreq.size()>2){
                fruitFreq.put(fruits[left],fruitFreq.get(fruits[left])-1);
                left++;
                if(fruitFreq.get(fruits[left])==0) fruitFreq.remove(fruits[left]);
            }
            if(fruitFreq.size()<=2){
                maxLength=Math.max(maxLength,right-left+1);
            }
            right++;
        }
        return maxLength;
    }
    public static void main(String[] args) {

        int[] fruits={1,3,3,3,1,1,3,3,1,1,3,6,4,3,4,1,4,1,3};
        System.out.println(totalFruit(fruits));
    }
}