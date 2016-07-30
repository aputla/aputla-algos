package std.binary_search.main;

public class Recursive {
    public static int bsearch(int[] A, int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (A[mid] == key) {
            return mid;
        } else if (A[mid] > key) {
            return bsearch(A, key, low, mid - 1);
        } else {
            return bsearch(A, key, mid + 1, high);
        }
    }
    
    public static void main(String[] args) {
        int A[] = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println(bsearch(A, 15, 0, A.length - 1));
    }
}
