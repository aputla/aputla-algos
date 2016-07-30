package std.math.itoa;

class Main {
    public static String itoa(int n) {
        StringBuffer result = new StringBuffer();
        while (n != 0) {
            result = result.append((char) (n % 10 + '0'));
            n = n / 10;
        }
        return result.reverse().toString();
    }
}
