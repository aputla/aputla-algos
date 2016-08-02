package std.trees.height;

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

    private static int height(Tree tree) {
        if (tree == null || (tree.left == null && tree.right == null)) {
            return 0;
        }
        return 1 + Math.max(height(tree.left), height(tree.right));
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree(1, new Tree(2), new Tree(3, new Tree(4), new Tree(5)));
        System.out.println(height(tree));
    }
}
