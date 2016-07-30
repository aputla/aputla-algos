package std.arrays.find_duplicate;

class Main {
    private static int find(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = A[a];

            if (i != a) {
                if (a == b) {
                    return a;
                } else {
                    swap(A, i, a);
                }
            }
        }
        return -1;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {0, 5, 2, 1, 4, 3, 2};
        System.out.println(find(A));
    }
}
