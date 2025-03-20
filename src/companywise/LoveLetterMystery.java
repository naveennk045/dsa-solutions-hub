package companywise;

public class LoveLetterMystery {
    public static int minOperation(char[] chars) {
        int start = 0;
        int end = chars.length - 1;
        int operation = 0;
        while (start <= end) {
//            if(chars[start]<chars[end]){
            operation +=Math.abs(chars[end] - chars[start]);
//            }
            start++;
            end--;

        }
        return operation;
    }
    public static void main(String[] args) {
        System.out.println(minOperation("cba".toCharArray()));
    }
}