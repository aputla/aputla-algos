package std.trees.is_it_balanced;

import java.util.ArrayList;
import java.util.List;

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
        
        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    private static int minDepth(Tree tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(tree.left), minDepth(tree.right));
    }

    private static int maxDepth(Tree tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(tree.left), maxDepth(tree.right));
    }

    private static boolean isBalanced(Tree tree) {
        return maxDepth(tree) - minDepth(tree) <= 1;
    }

    public static void main(String[] args) {
        Tree tree = new Tree(2, new Tree(1), new Tree(4, new Tree(3), new Tree(5)));
        System.out.println(isBalanced(tree));
    }
}
