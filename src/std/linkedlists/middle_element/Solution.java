package std.linkedlists.middle_element;

class List {
    int value;
    List next;

    List(int value) {
        this.value = value;
    }
}

public class Solution {
    private static int findMid(List list) {
        List slow = list;
        List fast = list;

        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow.value;
    }
    public static void main(String[] args) {
        List one = new List(1);
        List two = new List(2); one.next = two;
        List three = new List(3); two.next = three;
        List four = new List(4); three.next = four;
        List five = new List(5); four.next = five;
        List six = new List(6); five.next = six;

        System.out.println(findMid(one));
    }
}
