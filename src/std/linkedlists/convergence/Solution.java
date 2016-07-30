package std.linkedlists.convergence;

class List {
    int value;
    List next;

    List(int value) {
        this.value = value;
    }
}

public class Solution {
    private static int length(List list) {
        int count = 0;
        while (list != null) {
            list = list.next;
            count++;
        }
        return count;
    }

    private static List advance(List list, int count) {
        while (count != 0) {
            count--;
            list = list.next;
        }
        return list;
    }

    private static int intersection(List one, List two) {
        int x = length(one);
        int y = length(two);

        if (x < y) {
            two = advance(two, y - x);
        } else {
            one = advance(one, y - x);
        }

        while (one != two) {
            one = one.next;
            two = two.next;
        }
        return one.value;
    }

    public static void main(String[] args) {
        List one = new List(1);
        List two = new List(2); one.next = two;
        List three = new List(3); two.next = three;
        List four = new List(4); three.next = four;
        List five = new List(5); four.next = five;
        List six = new List(6); five.next = six;

        List seven = new List(7);
        List eight = new List(8); seven.next = eight;
        List nine = new List(9); eight.next = nine;
        nine.next = four;

        System.out.println(intersection(one, seven));
    }
}
