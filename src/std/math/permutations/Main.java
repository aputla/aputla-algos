package std.math.permutations;

class Main {
    private static void permute(char[] A, int a, int b, int r) {
        if (r == 0) {
            System.out.println(new String(A));
            return;
        }
        for (int i = a; i <= b; i++) {
            swap(A, i, a);
            permute(A, a + 1, b, r - 1);
            swap(A, i, a);
        }
    }

    private static void swap(char[] A, int i, int j) {
        char ch = A[i];
        A[i] = A[j];
        A[j] = ch;
    }

    private static void permute(String text) {
        int n = text.length();
        permute(text.toCharArray(), 0, n - 1, n);
    }

    public static void main(String[] args) {
        permute("abc");
    }
}

