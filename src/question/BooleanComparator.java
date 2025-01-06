package ServiceNowQuestions;

public class BooleanComparator {
    public static void main(String[] args) {
        System.out.println(compare(6,5));
        System.out.println(compare("N","NK"));
        System.out.println(compare(new int[]{1,5,3},new int[]{1,2,3}));
    }
    public static boolean compare(int a,int b){
        return a == b;
    }
    public static boolean compare(String a,String b){
        return a.equalsIgnoreCase(b);

    }
    public static boolean compare(int[] a,int[] b){
        if(a.length==b.length){
            for(int i=0;i<a.length;i++){
                    if(a[i]!=b[i]){
                        return false;
                    }
            }
        }
    return true;}
}
