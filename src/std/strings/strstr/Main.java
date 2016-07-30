package std.strings.strstr;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<String> strstr(String text, String delim) {
        List<String> list = new ArrayList<String>();

        int start = 0;
        int pos = text.indexOf(delim, start);

        while (pos != -1) {
            list.add(text.substring(start, pos));
            start = pos + delim.length();
            pos = text.indexOf(delim, start);
        }

        if (start < text.length()) {
            list.add(text.substring(start, text.length()));
        }

        return list;
    }

    public static void main(String[] args) {
        String text = "a quick brown fox jumped over the wall";
        System.out.println(strstr(text, " jumped "));
    }
}
