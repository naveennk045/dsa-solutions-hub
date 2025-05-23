package ServiceNowQuestions;

public class RangeSum {
    public static void main(String[] args) {
        int[] array={2,3,4,5,6,-1,2,3};
        int low=2;
        int high=3;
        for (int j : array) {
            if (low <= j && j <=high) {
                System.out.print(j + " ");
            }
        }
    }
}
