package std.linkedlists.reverse_dll;

import java.util.Scanner;

public class Solution {
    private static class Node {
        Node prev;
        Node next;
        int data;
    }
    
    private static Node reverse(Node head) {
        Node result = null;
        while (head != null) {
            Node prev = head.prev;
            Node next = head.next;
            head.next = prev;
            head.prev = next;
            result = head;
            head = next;
        }
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
        }
    }
}