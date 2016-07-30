package std.binary_search.main;

public class Iterative {
    public static int bsearch(int[] A, int key) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == key) {
                return mid;
            } else if (A[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int A[] = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println(bsearch(A, 15));
    }
}
