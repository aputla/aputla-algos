package std.math.pow;

public class Main {
    private static long pow(long a, long n) {
        if (n == 0 || n == 1) {
            return n == 0 ? 1 : a;
        }
        return n % 2 == 0 ? pow(a * a, n / 2) : a * pow(a * a, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 3));
    }
}
