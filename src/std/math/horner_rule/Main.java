package std.math.horner_rule;

public class Main {
    private static int atoi(String str) {
        int result = 0;
        for (char ch : str.toCharArray()) {
            result = result * 10 + (ch - '0');
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(atoi("123"));
    }
}
