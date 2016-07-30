package std.trees.contains;

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
    
    private static boolean contains(Tree tree, int key) {
        while (tree != null) {
            int value = tree.value;

            if (value == key) {
                return true;
            } else if (key < value) {
                tree = tree.left;
            } else {
                tree = tree.right;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree(2, new Tree(1), new Tree(3));
        System.out.println(contains(tree, 3));
    }
}
