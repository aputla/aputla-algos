package std.linkedlists.cyclic;

class List {
    List next;
    int value;
    
    List(int value) {
        this.value = value;
    }
    
    List(int value, List next) {
        this.value = value;
        this.next = next;
    }
}

public class Solution {
    private static boolean isCyclic(List list) {
        List fast = list;
        List slow = list;

        while (true) {
            fast = (fast == null) ? fast : fast.next;
            fast = (fast == null) ? fast : fast.next;
            slow = (slow == null) ? slow : slow.next;
            if (fast == null || slow == null) {
                return false;
            }
            if (fast == slow) {
                return true;
            }
        }
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
        five.next = three;

        System.out.println(isCyclic(one));
    }
}
