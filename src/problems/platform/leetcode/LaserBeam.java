package problems.platform.leetcode;


//https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/

public class LaserBeam {
    public static int countBeams(String beams){
        int count=0;
        for(char beam : beams.toCharArray()){
            if(beam=='1')  count++;
        }
        return count;
    }
    public static int numberOfBeams(String[] bank) {
        int prevBeam=0;
        int totalBeams=0;
        for(String beams : bank){
            int currBeams=countBeams(beams);
            totalBeams+=prevBeam*currBeams;
            prevBeam=currBeams;
        }
        return totalBeams;
    }
    public static void main(String[] args) {
        String[] bank={"1000100","0000101","1111000"};
        System.out.println(numberOfBeams(bank));
    }
}