package string;

import java.util.*;

public class AlmostMatching {

    public static int countAlmostMatching(String str, int k) {

        List<String> subStrList = new ArrayList<>();
        HashMap<Integer, List<String>> map = new HashMap<>();


        int n = str.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subStr = str.substring(i, j);

                if (subStr.length() > k) {
                    List<String> currList = map.getOrDefault(subStr.length(), new ArrayList<>());
                    currList.add(subStr);
                    map.put(subStr.length(), currList);
                }
            }
        }
        int count = 0;
        for (List<String> list : map.values()) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (i == j) continue;

                    if (isAlmostMatching(list.get(i), list.get(j), k)) {
                        System.out.println(list.get(i) + " --- " + list.get(j));
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean isAlmostMatching(String str1, String str2, int k) {
        if (str1.charAt(k) == str2.charAt(k)) return false;

        for (int i = 0; i < str1.length(); i++) {
            if (i == k) continue;
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(countAlmostMatching("abacaba", 1));
    }
}
