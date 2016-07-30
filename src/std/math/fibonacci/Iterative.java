package std.math.fibonacci;

public class Iterative {
    public static void main(String[] args) {
        int n = 20;
        int a = 0;
        int b = 1;
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }
}
