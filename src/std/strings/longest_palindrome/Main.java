package std.strings.longest_palindrome;

class Main {
    private static String solve(String text) {
        int n = text.length();
        char T[] = text.toCharArray();
        int size = 0;
        String result = "";
        for (int k = 0; k < n; k++) {
            for (int x = 0; x < 2; x++) {
                for (int i = k, j = k + x; i >= 0 && j < n && T[i] == T[j]; i--, j++) {
                    if (j - i + 1 > size) {
                        size = j - i + 1;
                        result = text.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve("a quick brown fox jumped over the wall again+abcba|and again"));
    }
}
