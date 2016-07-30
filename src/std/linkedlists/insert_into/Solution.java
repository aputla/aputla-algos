package std.linkedlists.insert_into;

class List {
    int value;
    List next;

    List(int value) {
        this.value = value;
    }
}

public class Solution {
    private static List insert(List list, int value) {
        List head = list;

        if (value < list.value) {
            List node = new List(value);
            node.next = list;
            while (list.next != null) {
                list = list.next;
            }
            list.next = node;
            return node;
        }
        while (true) {
            if (list.value <= value && value <= list.next.value) {
                break;
            } else if (list.value > list.next.value) {
                break;
            }
            list = list.next;
        }

        List next = list.next;
        list.next = new List(value);
        list.next.next = next;
        return head;
    }

    public static void main(String[] args) {
        List one = new List(1);
        List two = new List(2);
        List three = new List(3);
        List four = new List(4);
        List five = new List(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = one;

        List list = insert(one, 7);
        List prev = null;
        while (prev == null || prev.value < list.value) {
            System.out.println(list.value);
            prev = list;
            list = list.next;
        }
    }
}
