package std.math.expression_evaluator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static final String OPERATORS = "+-*/()";
    private static final Map<Character, Integer> PRECEDENCE = new HashMap<Character, Integer>();

    static {
        PRECEDENCE.put('+', 1);
        PRECEDENCE.put('-', 1);
        PRECEDENCE.put('*', 2);
        PRECEDENCE.put('/', 2);
    }

    private static long evaluate(char operator, long a, long b) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    private static void evaluate(LinkedList<Character> operatorStack, LinkedList<Long> valueStack) {       
        char operator = operatorStack.pop();
        long a = valueStack.pop();
        long b = valueStack.pop();
        long c = evaluate(operator, a, b);
        valueStack.push(c);
    }
    
    private static long solve(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line, "+-*/", true);
        
        LinkedList<Character> operatorStack = new LinkedList<Character>();
        LinkedList<Long> valueStack = new LinkedList<Long>();
        
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            
            if (token.length() == 1) {
                char ch = token.charAt(0);
                char operator;
                if (OPERATORS.indexOf(ch) != -1) {
                    switch (ch) {
                    case '(':
                        operatorStack.push(ch);
                        break;
                    case ')':
                        operator = operatorStack.peekFirst();
                        while (operator != '(') {
                            evaluate(operatorStack, valueStack);
                        }
                        break;
                    default:
                        if (!operatorStack.isEmpty()) {
                            operator = operatorStack.peekFirst();
                            while (!operatorStack.isEmpty() && PRECEDENCE.get(ch) <= PRECEDENCE.get(operator)) {               
                                evaluate(operatorStack, valueStack);
                            }
                        }
                        operatorStack.push(ch);
                        break;
                    }
                } else {
                    valueStack.push(Long.parseLong(token));
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            evaluate(operatorStack, valueStack);
        }
        return valueStack.pop();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < t; i++) {
            String line = bufferedReader.readLine();
            System.out.println(solve(line));
        }
    }

}
