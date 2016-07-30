package std.bitwise.add_subtract;

public class Main {
    private static int add(int x, int y) {
        int z = 0;
        while (y != 0) {
            z = x ^ y;
            y = (x & y) << 1;
            x = z;
        }
        return z;
    }
    // subtraction is simply adding x to the 2's complement of y
    // 2's complement of a number is simple 1's complement plus 1
    private static int subtract(int x, int y) {
        return add(x, add(~y, 1));
    }
    
    private static int divide(int x, int y) {
        int count = 0;
        while (true) {
            x = subtract(x, y);
            if (x >= 0) {
                count = add(count, 1);
            } else {
                break;
            }
        }
        return count;
    }
    private static int multiply(int x, int y) {
        int z = 0;
        while (y > 0) {
            z = add(z, x);
            y = subtract(y, 1);
        }
        return z;
    }
    public static void main(String[] args) {
        System.out.println(multiply(9, 3));
    }
}
