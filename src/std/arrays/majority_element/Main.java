package std.arrays.majority_element;

public class Main {
    public static int findMajority(int[] A) {
        int result = 0;
        int count = 0;
        for (int value : A) {
            if (result == value) {
                count++;
            } else if (count == 0) {
                result = value;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3, 4, 5, 3, 3, 3};
        System.out.println(findMajority(A));
    }
}
