package std.probability.rand_using_rand2;

import java.util.Random;

public class Main {
    private static int rand(int n) {
        Random random = new Random();
        int k = (int) Math.ceil(Math.log(n) / Math.log(2));
        while (true) {
            int x = 0;
            for (int i = 0; i < k; i++) {
                x = (x << 1) | (random.nextBoolean() ? 1 : 0); 
            }
            if (x < n) {
                return x;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(rand(10));    
    }
}
