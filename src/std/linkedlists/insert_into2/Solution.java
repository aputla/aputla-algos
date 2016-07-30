package std.linkedlists.insert_into2;

public class Solution {
    private static class Node {
        Node prev;
        Node next;
        int data;
    }
    
    private static Node sortedInsert(Node head, int data) {
        Node current = head;
        Node node = new Node();
        node.data = data;
        if (head == null) {
            return node;
        } 
        
        while (current != null) {
            Node next = current.next;
            if (next == null) {
                current.next = node;
                node.prev = current;
                return head;
            } else if (data > current.data && data <= next.data) {
                current.next = node;
                node.prev = current;
                node.next = next;
                next.prev = node;
                return head;
            } else if (data < current.data) {
                node.next = current;
                current.prev = node;
                return node;
            }
            current = next;
        }
        return head;
    }
    
    public static void main(String[] args) {
    }
}

