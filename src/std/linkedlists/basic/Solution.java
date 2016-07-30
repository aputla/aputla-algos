package std.linkedlists.basic;

class List {
    List next;
    int value;
}

public class Solution {
    private static void print(List list) {
        while (list != null) {
            System.out.println(list.value);
            list = list.next;
        }
    }

    private static List create(int[] A) {
        if (A.length == 0) {
            return null;
        }

        List head = new List();
        head.value = A[0];
        List prev = head;

        for (int i = 1; i < A.length; i++) {
            List node = new List();
            node.value = A[i];
            prev.next = node;
            prev = node;
        }
        return head;
    }

    private static List find(List list, int key) {
        while (list != null) {
            if (list.value == key) {
                return list;
            }
            list = list.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        List list = create(A);
        list = find(list, 3);
        print(list);
    }
}

