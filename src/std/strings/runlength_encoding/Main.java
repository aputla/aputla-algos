package std.strings.runlength_encoding;

class Main {
    public static String encode(String T) {
        T += ' ';
        StringBuffer buffer = new StringBuffer();
        int count = 0;
        char previous = ' ';
        for (char current : T.toCharArray()) {
            if (previous == ' ') {
                previous = current;
            }
            if (previous != current) {
                buffer.append(previous);
                buffer.append(count);
                previous = current;
                count = 1;
            }
            else {
                count++;
            }
        }
        return buffer.toString();
    }
    public static void main(String[] args) {
        System.out.println(encode("aaaabbbbccccdddddeeeffffaaaa"));
    }
}
