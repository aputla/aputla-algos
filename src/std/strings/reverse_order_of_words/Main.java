package std.strings.reverse_order_of_words;

import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
    public static void reverse(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text);
        LinkedList<String> stack = new LinkedList<>();
        
        while (tokenizer.hasMoreTokens()) {
            stack.push(tokenizer.nextToken());
        }
        
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
