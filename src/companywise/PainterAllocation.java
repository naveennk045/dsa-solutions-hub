package companywise;

/*
Given 2 integers A & B and an array of integers C of size N. Elements C[I] represents the length of
I th board.

You have to paint all N boards [C0, C1, C2, C3, ........, CN-1]. There are A painters available and
each of them takes B unit of time to paint 1 unit of board.

Calculate and return the minimum time required to paint all the boards under the constraint that
any painter will only pain continuous selection of board.

2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by
one painter, and partially by another.

A painter will only paint continuous boards. Which means configuration where painter 1 paints
boards 1 and 3 but not 2 is invalid.

In this scenario similar to the book allocation question, the allocation is made in a continuous
manner and hence we can use the binary search.
*/

public class PainterAllocation {
    public static boolean isPossible(int painters,int[] walls,int target){
        int sum=0;
        for(int i=0;i<walls.length;i++){
            sum+=walls[i];
            if(sum>target){
                sum=walls[i];
                painters--;
            }
            if(painters <=0 ){
                return false;
            }
//            System.out.print(sum+" ");
        }
        return true;
    }
    public static int allocateWithMinimumTime(int a,int b,int[] walls) {
        int start = 0;
        int end = 0;

        for (int wall : walls) {
            end += wall;
        }
        int min=end;
        while (start <= end) {

            int mid = start + (end - start) / 2;

//            System.out.println("mid : " + mid);
//            System.out.println(isPossible(a, walls, mid));

            if(isPossible(a, walls, mid)){
                min=Math.min(min,mid);
                end=mid-1;
            }else{
                start = mid + 1;
            }
        }
        return min*b;
    }
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int[] walls = {100, 200, 300, 400};
        int result = allocateWithMinimumTime(a, b, walls);
        System.out.println(result);

//        Partition: (2,4,6) | (8,10) | (12)



    }
}