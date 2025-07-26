package sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {


    public static List<Integer> grayCode(int n) {
        List<String> grayCode = new ArrayList<>(Arrays.asList("0", "1"));

        for (int i = 2; i <= n; i++) {

            List<String> tempGrayCode = new ArrayList<>();

            for (String code : grayCode) {
                tempGrayCode.add("0" + code);
            }

            Collections.reverse(grayCode);

            for (String code : grayCode) {
                tempGrayCode.add("1" + code);
            }

            grayCode = tempGrayCode;
        }

        List<Integer> graySequence = new ArrayList<>();
        for (String code : grayCode) {
            graySequence.add(Integer.parseInt(code, 2));
        }

        return graySequence;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }
}