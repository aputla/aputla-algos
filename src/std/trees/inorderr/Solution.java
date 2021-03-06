package std.trees.inorderr;

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
    
    private static void inorder(Tree tree) {
        if (tree == null) {
            return;
        }
        inorder(tree.left);
        System.out.println(tree.value);
        inorder(tree.right);
    }

    public static void main(String[] args) {
        Tree tree = new Tree(1, new Tree(2), new Tree(3, new Tree(4), new Tree(5)));
        inorder(tree);
    }
}
