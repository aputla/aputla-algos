package std.math.fibonacci;

public class Recursive {
    private static int f(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return f(n - 1) + f(n - 2);
    }

    public static void main(String[] args) {
        int n = 20;
        for (int i = 1; i < n; i++) {
            System.out.println(f(i));
        }
    }
}
