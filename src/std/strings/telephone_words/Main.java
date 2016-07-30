package std.strings.telephone_words;

public class Main {
    private static String[] M = new String[10];
    private static StringBuffer buffer = new StringBuffer();
    static {
        M[0] = "0";
        M[1] = "1";
        M[2] = "ABC";
        M[3] = "DEF";
        M[4] = "GHI";
        M[5] = "JKL";
        M[6] = "MNO";
        M[7] = "PRS";
        M[8] = "TUV";
        M[9] = "WXY";
    }

    private static void solve(char[] T, int i, int n) {
        if (i == n) {
            System.out.println(buffer);
            return;
        }

        if (Character.isDigit(T[i])) {
            int c = T[i] - '0';

            for (char ch : M[c].toCharArray()) {
                String temp = buffer.toString();
                buffer.append(ch);
                solve(T, i + 1, n);
                buffer = new StringBuffer(temp);
            }
        } else {
            solve(T, i + 1, n);
        }
    }

    private static void solve(String T) {
        solve(T.toCharArray(), 0, T.length());
    }

    public static void main(String[] args) {
        solve("497-1927");
    }
}
