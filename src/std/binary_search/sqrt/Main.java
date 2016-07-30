package std.binary_search.sqrt;

public class Main {
    private static int sqrt(int n) {
        int low = 1;
        int high = n;
        
        while (true) {
            int mid = (low + high) / 2;
            
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(sqrt(81));
    }
}
