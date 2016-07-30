package std.stacks_and_queues.pop_based_on_frequency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Stack {
    private Map<Integer, Integer> F = new HashMap<Integer, Integer>();
    private Map<Integer, Set<Integer>> R = new HashMap<Integer, Set<Integer>>();
    void push(int n) {
        ensureF(n);
        ensureR(F.get(n) + 1);

        removeR(F.get(n), n);
        addR(F.get(n) + 1, n);
        F.put(n, F.get(n) + 1);
    }

    int pop() {
        TreeSet<Integer> L = new TreeSet<Integer>(R.keySet());
        if (L.isEmpty()) {
            return -1;
        }
        int f = L.last();
        int n = R.get(f).iterator().next();
        removeR(f, n);
        F.remove(n);
        return n;
    }

    private void ensureF(int n) {
        if (!F.containsKey(n)) {
            F.put(n, 0);
        }
    }

    private void ensureR(int f) {
        if (!R.containsKey(f)) {
            R.put(f, new HashSet<Integer>());
        }
    }

    private void removeR(int f, int n) {
        if (f != 0) {
            Set<Integer> S = R.get(f);
            S.remove(n);
            if (S.isEmpty()) {
                R.remove(f);
            }
        }
    }

    private void addR(int f, int n) {
        Set<Integer> S = R.get(f);
        S.add(n);
    }
}

public class Main {
    public static void main(String[] args) {
        Stack S = new Stack();
        S.push(1);
        S.push(2);
        S.push(2);
        S.push(3);
        S.push(3);
        S.push(3);
        System.out.println(S.pop());
        System.out.println(S.pop());
        System.out.println(S.pop());
    }
}
