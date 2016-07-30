package std.trees.level_order;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static class Tree {
        Tree left;
        Tree right;
        int value;
        
        public Tree(int value, Tree left, Tree right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
        
        public Tree(int value) {
            this.value = value;
        }
    }

    private static void printByLevel(Tree root) {
        Queue<Tree> Q = new LinkedList<>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            Tree tree = Q.remove();
            System.out.println(tree.value);
            for (Tree child : new Tree[] {tree.left, tree.right}) {
                if (child != null) {
                    Q.offer(child);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree(1, new Tree(2), new Tree(3, new Tree(4), new Tree(5)));
        printByLevel(tree);
    }

}
