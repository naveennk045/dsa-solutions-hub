package slidingwindow.variablewindow;


// https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/
public class MaxConsecutiveAnswers {

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int trueCount = 0, falseCount = 0, maxCount = 0, maxConsecutiveAnswer = 0;
        int n = answerKey.length(), left = 0;

        for (int right = 0; right < n; right++) {
            if (answerKey.charAt(right) == 'T') trueCount++;
            else falseCount++;

            maxCount = Math.max(trueCount, falseCount);

            while ((right - left + 1) - maxCount > k) {
                if (answerKey.charAt(left) == 'T') trueCount--;
                else falseCount--;
                left++;
            }
            maxConsecutiveAnswer = Math.max(right - left + 1, maxConsecutiveAnswer);
        }

        return maxConsecutiveAnswer;

    }

    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTFF", 2));
    }
}