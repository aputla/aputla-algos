package std.trees.lca_bst;

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

    private static Tree leastCommonAncestor(Tree tree, int a, int b) {
        if (tree == null) {
            return null;
        }
        
        if (a > b) {
            return leastCommonAncestor(tree, b, a);
        }

        if (tree.value >= a && tree.value <= b) {
            return tree;
        } else if (tree.value <= a && tree.value <= b){
            return leastCommonAncestor(tree.right, a, b);
        } else {
            return leastCommonAncestor(tree.left, a, b);
        }
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree(2, new Tree(1), new Tree(4, new Tree(3), new Tree(5)));
        System.out.println(leastCommonAncestor(tree, 1, 3));
    }

}
