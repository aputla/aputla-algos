package std.strings.anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    private static String sort(String text) {
        char[] array = text.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    private static List<String> solve(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text);

        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            String key = sort(token);

            if (!map.containsKey(key)) {
                map.put(key, new HashSet<String>());
            }
            Set<String> values = map.get(key);
            values.add(token);
        }

        List<String> result = new LinkedList<String>();
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.addAll(entry.getValue());
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "the rat fell in the tar";
        System.out.println(solve(str));
    }
}