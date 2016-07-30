package std.math.permutations_without_repetition;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
    private static int total = 0;
    private static void permute(Map<Character, Integer> frequencyMap, String result, int n) {
        if (result.length() == n) {
            System.out.println(result);
            total++;
            return;
        }
        
        for (Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char key = entry.getKey();
            int count = entry.getValue();

            if (count != 0) {
                frequencyMap.put(key, count - 1);
                permute(frequencyMap, result + key, n);
                frequencyMap.put(key, count);
            }
        }
    }

    private static void permute(String str) {
        Map<Character, Integer> frequencyMap = new TreeMap<Character, Integer>();

        for (char ch : str.toCharArray()) {
            if (!frequencyMap.containsKey(ch)) {
                frequencyMap.put(ch, 0);
            }
            int count = frequencyMap.get(ch);
            frequencyMap.put(ch, count + 1);
        }
        permute(frequencyMap, "", str.length());
    }

    public static void main(String[] args) {
        permute("aaaabb");
        System.out.println("There are " + total + " number of possibilities");
    }
}
