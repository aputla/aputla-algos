package std.bitwise.find_ones;

public class Solution {
    public static void main(String[] args) {
        int a = 11, count = 0;
        for (; a != 0; count++) {
            a = a & (a - 1);
        }
        System.out.println(count);
    }
}
