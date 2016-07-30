package std.base.hexadecimal;

public class Main {
    private static final String CHARSET = "0123456789abcdef";
    private static String convert(int n) {
        String result = "";
        while (n != 0) {
            result = CHARSET.charAt(n % 16) + result;
            n = n / 16;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(convert(16));
    }
}
