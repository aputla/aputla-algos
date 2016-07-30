package std.linkedlists.swap;

class List {
    List next;
    int value;
}

public class Solution {
    private static List swapAdjacent(List list) {
        if (list == null || list.next == null) {
            return list;
        }

        List head = list.next;
        while (list != null && list.next != null) {
            List one = list; list = list.next;
            List two = list; list = list.next;

            two.next = one;
            one.next = (list != null) ? list.next : null;
        }
        return head;
    }
}
