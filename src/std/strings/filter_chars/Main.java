package std.strings.filter_chars;

class Main {
    public static String filterChars(String text, String filter) {
        int[] M = new int[256];

        for (char ch : filter.toCharArray()) {
            M[ch] = 1;
        }

        char result[] = text.toCharArray();
        int j = 0;

        for (int i = 0; i < result.length; i++) {
            if (M[result[i]] != 1) {
                result[j++] = result[i];
            }
        }
        return new String(result, 0, j);
    }
}