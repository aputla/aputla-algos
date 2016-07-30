package std.linkedlists.lru_cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache<Key, Value> {
    private final Map<Key, Node> cache = new HashMap<>();
    private final Map<Key, Value> secondaryMap;
    private Node head;
    private Node rear;
    private final int maxSize;
    
    public LRUCache(int maxSize, Map<Key, Value> secondaryMap) {
        this.maxSize = maxSize;
        this.secondaryMap = secondaryMap;
    }
    
    public Value get(Key key) {
        Node node = cache.get(key);
        if (node == null) {
            System.out.println("cache miss");
            Value value = secondaryMap.get(key);
            if (value == null) {
                return null;
            }
            addNode(new Node(key, value));
            return value;
        } else {
            removeNode(node);
            addNode(node);
            return node.value;
        }
    }
    
    private void removeNode(Node node) {
        if (node == head) {
            head = node.next;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = null;
        node.prev = null;
        cache.remove(node.key);
    }
    
    private void addNode(Node node) {
        if (cache.size() == maxSize) {
            System.out.println("Evicting " + head.key);
            removeNode(head);
        }
        if (rear == null) {
            head = rear = node;
        } else {
            rear.next = node;
            node.prev = rear;
            rear = node;
        }
        cache.put(node.key, node);
    }
    
    private class Node {
        private Node next;
        private Node prev;
        private Key key;
        private Value value;
        
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        LRUCache<Integer, Integer> cache = new LRUCache<>(3, map);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));

        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
        
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
