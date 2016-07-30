package std.strings.remove_duplicate_slashes;

public class Main {
    private static String remove(char[] text) {
        int j = 0;
        for (int i = 0; i < text.length;) {
            if (text[i] == '/') {
                text[j] = '/';
                j++;
                while (i < text.length && text[i] == '/') {
                    i++;
                }
            } else if (i != j) {
                text[j] = text[i];
                j++;
                i++;
            } else {
                i++;
                j++;
            }
        }
        return new String(text, 0, j);
    }
 
    public static void main(String[] args) {
        String text = "/root//foo///bar";
        System.out.println(remove(text.toCharArray()));
    }
}
