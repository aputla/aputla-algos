package std.strings.find_first_non_repeated_char;

class Main {
    public static char find(String text) {
        int[] M = new int[26];

        for (char ch : text.toCharArray()) {
            M[ch - 'a']++;
        }

        char result = text.charAt(0);
        for (char ch : text.toCharArray()) {
            if (M[ch - 'a'] == 1) {
                result = ch;
                break;
            }
        }
        return result;
    }
}

