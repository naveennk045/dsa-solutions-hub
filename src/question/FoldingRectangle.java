package ServiceNowQuestions;

public class FoldingRectangle {
    public static void main(String[] args) {

        int h=8;
        int w=4;
        int h1=6;
        int w1=1;
        System.out.println(calculateFolds(h,h1)+calculateFolds(w,w1));

    }
    static int calculateFolds(int dimension,int target){
        int fold=0;
        while (dimension>target){
            dimension=(dimension+1)/2;
            fold++;
        }
    return fold;}
}
