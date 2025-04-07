package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class FindOriginalArray {
    public static int[] findOriginalArray(int[] changed) {

        int n = changed.length;
        boolean isOdd = n % 2 != 0;
        int[] original = new int[n / 2];
        int idx = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.sort(changed);

        for (int num : changed) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        for (int num : changed) {
            int val = num * 2;
            if (num == 0) {
                if (map.get(0) >= 2) {
                    original[idx++] = 0;
                    map.put(0, map.get(0) - 2);
                }
            } else if (map.containsKey(val) && map.containsKey(num)) {
                original[idx++] = num;
                map.put(val, map.get(val) - 1);

                map.put(num, map.get(num) - 1);
                if (map.get(val) == 0) {
                    map.remove(val);
                }
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
            if (idx == n / 2)
                break;
        }

        // System.out.println(Arrays.toString(original));
        // System.out.println(isOdd);

        if (isOdd || idx != n / 2)
            return new int[]{};

        return original;
    }

    public static void main(String[] args) {

        int[] doubled = {1, 3, 4, 2, 6, 8};
        int[] original = findOriginalArray(doubled);
        System.out.println(Arrays.toString(original));

    }
}
