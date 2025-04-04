package slidingwindow.twopointers;

public class MaxEnemyForts {
    public static int captureForts(int[] forts) {
        int left=0,right=forts.length-1,maxForts=0;


        int fort=0;
        while (left<forts.length){
            if(forts[left]==0) fort++;
            else if (forts[left]==-1){
                maxForts=Math.max(maxForts,fort);
                fort=0;
            }else fort=0;
            left++;
        }
        fort=0;

        while(right>=0){
            if(forts[right]==0) fort++;
            else if (forts[right]==-1){
                maxForts=Math.max(maxForts,fort);
                fort=0;
            }else fort=0;
            right--;
        }

        return maxForts;

    }
    public static void main(String[] args) {

        int[] forts={1,0,0,0,-1,1,0,0,0,0,0,0,0,0,0,-1,1,0,0,0,};
        int fort=captureForts(forts);
        System.out.println(fort);
    }
}