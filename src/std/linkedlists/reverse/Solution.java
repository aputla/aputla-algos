package std.linkedlists.reverse;


public class Solution {
    private static class Node {
        Node next;
        int value;
        
        Node(int value) {
            this.value = value;
        }
    }

    public static Node reverse(Node head) {
        Node result = null;
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            result = head;
            prev = head;
            head = next;
        }
        return result;
    }

    
    public static void main(String[] args) {
        Node list = new Node(1);
        list.next = new Node(2);
        reverse(list);
    }
}
