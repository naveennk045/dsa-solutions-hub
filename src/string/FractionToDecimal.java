package string;

import java.util.HashMap;

public class FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {

        StringBuilder result = new StringBuilder();

        if (numerator == 0) {
            return "0";
        }
        // to handle the negative value
        if ((numerator > 0) ^ (denominator > 0)) {
            result.append("-");
        }
        long num = Math.abs(numerator);
        long den = Math.abs(denominator);

        result.append(num / den);

        long remainder = num % den;

        if (remainder == 0) return result.toString();

        result.append(".");


        HashMap<Long, Integer> seen = new HashMap<>();

        while (remainder != 0) {

            if (seen.containsKey(remainder)) {
                int idx = seen.get(remainder);
                result.insert(idx, "(");
                result.append(")");
                break;
            }
            seen.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / den);

            remainder %= den;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(4,333));
    }
}