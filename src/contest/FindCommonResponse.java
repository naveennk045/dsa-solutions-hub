package contest;

import java.util.*;

public class FindCommonResponse {

    public static String findCommonResponse(List<List<String>> responses) {
        Set<String> set = new TreeSet<>();
        Map<String, Integer> map = new TreeMap<>();

        for (List<String> list : responses) {
            set.addAll(list);
            for (String str : set) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            set.clear();
        }

        int max = Integer.MIN_VALUE;
        String result = "";
        for (String str : map.keySet()) {
            if (max < map.get(str)) {
                max = map.get(str);
                result = str;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> responses = new ArrayList<>();
        responses.add(Arrays.asList("good", "ok", "good"));
        responses.add(Arrays.asList("ok", "bad"));
        responses.add(Arrays.asList("bad", "notsure"));
        responses.add(Arrays.asList("great", "good"));
        System.out.println(findCommonResponse(responses));

    }

}