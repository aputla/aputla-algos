package std.datastructures.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ListOfLists {
    
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

    private static class Matrix<Value extends Comparable<Value>> {
        
        private final List<Set<Pair<Integer, Value>>> list;
        
        public Matrix(int rows) {
            list = new ArrayList<>(rows);
            for (int i = 0; i < rows; i++) {
                list.add(new TreeSet<>());
            }
        }
        
        public void put(int row, int column, Value value) {
            Set<Pair<Integer, Value>> columnList = list.get(row);
            columnList.add(new Pair<>(column, value));
        }
        
        public Value get(int row, int column) {
            Set<Pair<Integer, Value>> columnList = list.get(row);
            for (Pair<Integer, Value> pair : columnList) {
                if (pair.getFirst() == column) {
                    return pair.getSecond();
                }
            }
            return null;
        }
    }
    
    public static void main(String[] args) {
        Matrix<String> matrix = new Matrix<>(3);
        matrix.put(1, 1, "cat");
        matrix.put(2, 2, "dog");
        System.out.println(matrix.get(2,  2));
    }
}
