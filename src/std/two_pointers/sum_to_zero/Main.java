package std.two_pointers.sum_to_zero;

public class Main {
    public static void main(String[] args) {
        int A[] = {-3, -2, -1, 0, 1, 2, 3};
        
        int j = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            for (; j > i; j--) {
                int sum = A[i] + A[j];
                if (sum == 0) {
                    System.out.println(A[i] + " " + A[j]);
                } else if (sum < 0) {
                    break;
                }
            }
        }
    }
}
