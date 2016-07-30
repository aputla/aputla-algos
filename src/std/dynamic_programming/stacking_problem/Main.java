package std.dynamic_programming.stacking_problem;

import java.util.Arrays;

class Person implements Comparable<Person> {
    Integer weight;
    Integer height;

    Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Person other) {
        return weight.equals(other.weight) ? height.compareTo(other.height) : weight.compareTo(other.weight);
    }
}

class Main {
    private static int solve(Person[] list) {
        int result = 1;
        int[] D = new int[list.length];
        D[0] = 1;
        for (int i = 1; i < list.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (list[j].height < list[i].height) {
                    D[i] = Math.max(D[i], D[j] + 1);
                    result = Math.max(result, D[i]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Person[] list = {new Person(65, 100), new Person(70,150),
                         new Person(56, 90), new Person(75, 190),
                         new Person(60, 95), new Person(68, 110)};
        Arrays.sort(list);
        System.out.println(solve(list));
    }
}

