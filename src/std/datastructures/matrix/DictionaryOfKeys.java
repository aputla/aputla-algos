package std.datastructures.matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DictionaryOfKeys {
    private static class Pair<First extends Comparable<First>, Second extends Comparable<Second>> implements Comparable<Pair<First, Second>> {
        private final First first;
        private final Second second;
        
        public Pair(First first, Second second) {
            this.first = first;
            this.second = second;
        }
        
        public First getFirst() {
            return first;
        }
        
        public Second getSecond() {
            return second;
        }
        
        @Override
        public String toString() {
            return "Pair {" +
                       "first=" + Objects.toString(first) + ", " +
                       "second=" + Objects.toString(second) +
                   "}";
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof Pair)) {
                return false;
            }

            @SuppressWarnings("unchecked")
            Pair<First, Second> other = (Pair<First, Second>) obj;
            return Objects.equals(first, other.first) &&
                   Objects.equals(second,  other.second);
        }

        @Override
        public int compareTo(Pair<First, Second> other) {
            if (!first.equals(other.first)) {
                return first.compareTo(other.first);
            }
            return second.compareTo(other.second);
        }
    }

    private static class Matrix<Value> {
        private final Map<Pair<Integer, Integer>, Value> map = new HashMap<>();
        
        public Value get(int row, int column) {
            return map.get(new Pair<>(row, column));
        }
        
        public void put(int row, int column, Value value) {
            map.put(new Pair<>(row, column), value);
        }
    }
    
    public static void main(String[] args) {
        Matrix<String> matrix = new Matrix<>();
        matrix.put(1, 1, "cat");
        matrix.put(2, 2, "dog");
        System.out.println(matrix.get(2,  2));
    }
}
