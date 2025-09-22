package arrays.problems;

public class StringCompression {
    public static String compress(String word){
        char[] chars=word.toCharArray();
        StringBuilder sb=new StringBuilder();
        String s=new String(chars);
        int count=1;
        for (int i = 1; i < chars.length; i++) {
            if(chars[i]==chars[i-1]) count++;
            else {
                sb.append(chars[i-1]);
                if(count>1) sb.append(count);
                count = 1;
            }
            if(i== chars.length-1){
                sb.append(chars[i-1]+""+count);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String word="abbbbbbbbbbbb";
        System.out.println(compress(word));
    }
}