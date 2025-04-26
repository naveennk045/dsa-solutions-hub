package leveloneproblems;

public class TitleToNumber {

    public static int titleToNumber(String columnTitle) {
        int n=columnTitle.length();
        if(n==1) return (columnTitle.charAt(0)-'A')+1;


        return 0;
    }

    public static void main(String[] args) {
        String columnTitle="ABA";
        System.out.println(titleToNumber(columnTitle));
    }
}