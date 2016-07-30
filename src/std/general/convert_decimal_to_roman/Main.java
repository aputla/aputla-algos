package std.general.convert_decimal_to_roman;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Integer, String> M = new HashMap<>();
    static {
        M.put(0, "");
        M.put(1, "I");
        M.put(5, "V");
        M.put(10, "X");
        M.put(50, "L");
        M.put(100, "C");
        M.put(500, "D");
        M.put(1000, "M");
    }
    
    public static String convert(int x, int p) {
        switch (x) {
            case 0:
                return "";
            case 1:
                return M.get(p);
            case 2:
                return M.get(p) + M.get(p);
            case 3:
                return M.get(p) + M.get(p) + M.get(p);
            case 4:
                return M.get(p) + M.get(5 * p);
            case 5:
                return M.get(5 * p);
            case 6:
                return M.get(5 * p) + M.get(p);
            case 7:
                return M.get(5 * p) + M.get(p) + M.get(p);
            case 8:
                return M.get(5 * p) + M.get(p) + M.get(p) + M.get(p);
            case 9:
                return M.get(p) + M.get(10 * p);
        }
        return "";
    }
    
    public static String roman(int n) {
        StringBuffer buffer = new StringBuffer();
        int p = 1;
        while (n != 0) {
            int x = n % 10;
            buffer.insert(0, convert(x, p));
            n = n / 10;
            p = p * 10;
        }
        return buffer.toString();
    }
    
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println(roman(i));    
        }
    }
}
