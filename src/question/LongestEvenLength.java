package ServiceNowQuestions;

public class LongestEvenLength {
    public static void main(String[] args) {
        String sentence="I am good how are you Naveenkumar";
        String[] strArr=sentence.split(" ");
        int maxLength=0;
        int length;
        for (String s : strArr) {
            length = s.length();
            if (length % 2 == 0 && maxLength < length) {
                maxLength = length;
            }
        }
        System.out.println(maxLength);
    }
}
