package std.math.lcm_for_array;

public class Main {
    private static int gcd(int a, int b) {
       if (b == 0) {
           return a;
       }
       return gcd(b, a % b);
    }

    private static int lcm(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = (result * array[i]) / gcd(result, array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 4, 2};
        System.out.println(lcm(array));
    }
}
